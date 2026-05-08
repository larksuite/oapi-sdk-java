package com.lark.oapi.channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

final class ChannelEventBus {
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<ChannelEventHandler<?>>> handlers =
            new ConcurrentHashMap<String, CopyOnWriteArrayList<ChannelEventHandler<?>>>();

    <T> ChannelSubscription on(String eventName, ChannelEventHandler<T> handler) {
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

    void on(Map<String, ChannelEventHandler<?>> batchHandlers) {
        for (Map.Entry<String, ChannelEventHandler<?>> entry : batchHandlers.entrySet()) {
            on(entry.getKey(), entry.getValue());
        }
    }

    @SuppressWarnings("unchecked")
    <T> void emit(String eventName, T event) {
        CopyOnWriteArrayList<ChannelEventHandler<?>> eventHandlers = handlers.get(eventName);
        if (eventHandlers == null) {
            return;
        }
        for (ChannelEventHandler<?> handler : eventHandlers) {
            ((ChannelEventHandler<T>) handler).handle(event);
        }
    }
}
