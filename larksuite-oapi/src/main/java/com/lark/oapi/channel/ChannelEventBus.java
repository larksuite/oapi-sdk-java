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
            new ConcurrentHashMap<>();

    <T> ChannelSubscription on(String eventName, ChannelEventHandler<T> handler) {
        final String canonicalEventName = canonicalEventName(eventName);
        final CopyOnWriteArrayList<ChannelEventHandler<?>> eventHandlers = new CopyOnWriteArrayList<>();
        eventHandlers.add(handler);
        handlers.put(canonicalEventName, eventHandlers);
        final ChannelEventHandler<T> finalHandler = handler;
        return () -> {
            CopyOnWriteArrayList<ChannelEventHandler<?>> current = handlers.get(canonicalEventName);
            if (current == eventHandlers && current.remove(finalHandler)) {
                handlers.remove(canonicalEventName, current);
            }
        };
    }

    <T> ChannelSubscription onMany(String eventName, ChannelEventHandler<T> handler) {
        final String canonicalEventName = canonicalEventName(eventName);
        CopyOnWriteArrayList<ChannelEventHandler<?>> eventHandlers = handlers.get(canonicalEventName);
        if (eventHandlers == null) {
            eventHandlers = new CopyOnWriteArrayList<>();
            CopyOnWriteArrayList<ChannelEventHandler<?>> previous = handlers.putIfAbsent(canonicalEventName, eventHandlers);
            if (previous != null) {
                eventHandlers = previous;
            }
        }
        eventHandlers.add(handler);
        final CopyOnWriteArrayList<ChannelEventHandler<?>> finalHandlers = eventHandlers;
        final ChannelEventHandler<T> finalHandler = handler;
        return () -> finalHandlers.remove(finalHandler);
    }

    ChannelSubscription on(Map<String, ChannelEventHandler<?>> batchHandlers) {
        final List<ChannelSubscription> subscriptions = new ArrayList<>();
        for (Map.Entry<String, ChannelEventHandler<?>> entry : batchHandlers.entrySet()) {
            subscriptions.add(on(entry.getKey(), entry.getValue()));
        }
        return () -> {
            for (ChannelSubscription subscription : subscriptions) {
                subscription.unsubscribe();
            }
        };
    }

    @SuppressWarnings("unchecked")
    <T> void emit(String eventName, T event) {
        String canonicalEventName = canonicalEventName(eventName);
        CopyOnWriteArrayList<ChannelEventHandler<?>> eventHandlers = handlers.get(canonicalEventName);
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
                    emitError(canonicalEventName, error, event);
                }
            }
        }
    }

    boolean hasHandlers(String eventName) {
        CopyOnWriteArrayList<ChannelEventHandler<?>> eventHandlers = handlers.get(canonicalEventName(eventName));
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

    private String canonicalEventName(String eventName) {
        // The public event name is "cardAction". The raw Feishu event type is
        // "card.action.trigger", and early Java discussions used
        // "card.action" as shorthand. Accept the shorthand as an alias but
        // keep "cardAction" as the single canonical handler key.
        return "card.action".equals(eventName) ? "cardAction" : eventName;
    }
}
