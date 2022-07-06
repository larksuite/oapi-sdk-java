package com.larksuite.oapi.card.exception;

public class NotFoundHandlerException extends RuntimeException {
    public NotFoundHandlerException() {
        super("not found card action handler");
    }
}
