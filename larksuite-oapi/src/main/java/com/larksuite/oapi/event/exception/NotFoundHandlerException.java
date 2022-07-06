package com.larksuite.oapi.event.exception;

public class NotFoundHandlerException extends RuntimeException {

    private final String eventType;

    public NotFoundHandlerException(String eventType) {
        this.eventType = eventType;
    }

    @Override
    public String getMessage() {
        return "event type:" + this.eventType + ", not found handler";
    }
}
