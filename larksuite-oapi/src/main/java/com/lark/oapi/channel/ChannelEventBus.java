package com.lark.oapi.channel;

import com.lark.oapi.channel.model.ChannelErrorEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class ChannelEventBus {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelEventBus.class);

    private final ConcurrentHashMap<String, CopyOnWriteArrayList<ChannelEventHandler<?>>> handlers =
            new ConcurrentHashMap<String, CopyOnWriteArrayList<ChannelEventHandler<?>>>();

    <T> ChannelSubscription on(String eventName, ChannelEventHandler<T> handler) {
        final CopyOnWriteArrayList<ChannelEventHandler<?>> eventHandlers = new CopyOnWriteArrayList<ChannelEventHandler<?>>();
        eventHandlers.add(handler);
        handlers.put(eventName, eventHandlers);
        final ChannelEventHandler<T> finalHandler = handler;
        return new ChannelSubscription() {
            @Override
            public void unsubscribe() {
                CopyOnWriteArrayList<ChannelEventHandler<?>> current = handlers.get(eventName);
                if (current == eventHandlers && current.remove(finalHandler)) {
                    handlers.remove(eventName, current);
                }
            }
        };
    }

    <T> ChannelSubscription onMany(String eventName, ChannelEventHandler<T> handler) {
        CopyOnWriteArrayList<ChannelEventHandler<?>> eventHandlers = handlers.get(eventName);
        if (eventHandlers == null) {
            eventHandlers = new CopyOnWriteArrayList<ChannelEventHandler<?>>();
            CopyOnWriteArrayList<ChannelEventHandler<?>> previous = handlers.putIfAbsent(eventName, eventHandlers);
            if (previous != null) {
                eventHandlers = previous;
            }
        }
        eventHandlers.add(handler);
        final CopyOnWriteArrayList<ChannelEventHandler<?>> finalHandlers = eventHandlers;
        final ChannelEventHandler<T> finalHandler = handler;
        return new ChannelSubscription() {
            @Override
            public void unsubscribe() {
                finalHandlers.remove(finalHandler);
            }
        };
    }

    ChannelSubscription on(Map<String, ChannelEventHandler<?>> batchHandlers) {
        final List<ChannelSubscription> subscriptions = new ArrayList<ChannelSubscription>();
        for (Map.Entry<String, ChannelEventHandler<?>> entry : batchHandlers.entrySet()) {
            subscriptions.add(on(entry.getKey(), entry.getValue()));
        }
        return new ChannelSubscription() {
            @Override
            public void unsubscribe() {
                for (ChannelSubscription subscription : subscriptions) {
                    subscription.unsubscribe();
                }
            }
        };
    }

    @SuppressWarnings("unchecked")
    <T> void emit(String eventName, T event) {
        CopyOnWriteArrayList<ChannelEventHandler<?>> eventHandlers = handlers.get(eventName);
        if (eventHandlers == null) {
            return;
        }
        for (ChannelEventHandler<?> handler : eventHandlers) {
            try {
                ((ChannelEventHandler<T>) handler).handle(event);
            } catch (Throwable error) {
                if ("error".equals(eventName)) {
                    LOGGER.warn("channel error handler failed", error);
                } else {
                    emitError(eventName, error, event);
                }
            }
        }
    }

    boolean hasHandlers(String eventName) {
        CopyOnWriteArrayList<ChannelEventHandler<?>> eventHandlers = handlers.get(eventName);
        return eventHandlers != null && !eventHandlers.isEmpty();
    }

    void emitError(String eventName, Throwable error, Object event) {
        if (!hasHandlers("error")) {
            LOGGER.warn("unhandled channel error on event {}", eventName, error);
            return;
        }
        emit("error", new ChannelErrorEvent(eventName, error, event));
    }

    void logUnhandledError(String eventName, Throwable error) {
        if (!hasHandlers("error")) {
            LOGGER.warn("unhandled channel error on event {}", eventName, error);
        }
    }
}
