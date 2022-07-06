package com.larksuite.oapi.core.exception;

public class EventTypeAlreadyHasHandlerException extends RuntimeException {
    public EventTypeAlreadyHasHandlerException(String eventType) {
        super(String.format("The event type  of %s already has handler", eventType));
    }
}
