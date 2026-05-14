package com.lark.oapi.channel;

import com.lark.oapi.channel.model.ChannelErrorEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

final class ChannelEventBus {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelEventBus.class);

    private final ConcurrentHashMap<String, ChannelEventHandler<?>> handlers =
            new ConcurrentHashMap<>();

    <T> ChannelSubscription on(String eventName, ChannelEventHandler<T> handler) {
        if (handlers.containsKey(eventName)) {
            LOGGER.warn("channel: handler for \"{}\" is being overwritten", eventName);
        }
        handlers.put(eventName, handler);
        final ChannelEventHandler<T> finalHandler = handler;
        return () -> {
            handlers.remove(eventName, finalHandler);
        };
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
        ChannelEventHandler<?> handler = handlers.get(eventName);
        if (handler == null) {
            return;
        }
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

    boolean hasHandler(String eventName) {
        return handlers.containsKey(eventName);
    }

    void emitError(String eventName, Throwable error, Object event) {
        if (!hasHandler("error")) {
            LOGGER.warn("unhandled channel error on event {}", eventName, error);
            return;
        }
        emit("error", new ChannelErrorEvent(eventName, error, event));
    }

    void logUnhandledError(String eventName, Throwable error) {
        if (!hasHandler("error")) {
            LOGGER.warn("unhandled channel error on event {}", eventName, error);
        }
    }
}
