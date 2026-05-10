package com.lark.oapi.channel.model;

public class ChannelErrorEvent {
    private final String eventName;
    private final Throwable error;
    private final Object event;

    public ChannelErrorEvent(String eventName, Throwable error, Object event) {
        this.eventName = eventName;
        this.error = error;
        this.event = event;
    }

    public String getEventName() {
        return eventName;
    }

    public Throwable getError() {
        return error;
    }

    public Object getEvent() {
        return event;
    }
}
