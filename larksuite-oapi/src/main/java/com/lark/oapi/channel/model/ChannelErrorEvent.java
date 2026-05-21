package com.lark.oapi.channel.model;

/**
 * Structured error event emitted when normalization, safety processing or a
 * user handler fails.
 */
public class ChannelErrorEvent {
    private final String eventName;
    private final Throwable error;
    private final Object event;

    public ChannelErrorEvent(String eventName, Throwable error, Object event) {
        this.eventName = eventName;
        this.error = error;
        this.event = event;
    }

    /** Event name being processed when the error happened. */
    public String getEventName() {
        return eventName;
    }

    /** Original exception. */
    public Throwable getError() {
        return error;
    }

    /** Event payload associated with the failure. */
    public Object getEvent() {
        return event;
    }
}
