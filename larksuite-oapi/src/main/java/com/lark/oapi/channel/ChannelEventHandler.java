package com.lark.oapi.channel;

public interface ChannelEventHandler<T> {
    void handle(T event);
}
