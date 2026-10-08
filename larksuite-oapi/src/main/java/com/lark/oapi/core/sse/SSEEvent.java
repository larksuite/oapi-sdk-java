package com.lark.oapi.core.sse;

/** A raw SSE protocol event. Data is never decoded as business JSON. */
public final class SSEEvent {
    private final String event;
    private final String data;
    private final String id;

    public SSEEvent(String event, String data, String id) {
        this.event = event;
        this.data = data;
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public String getData() {
        return data;
    }

    /** Null means no id field; an empty string means an explicit cursor reset. */
    public String getId() {
        return id;
    }
}
