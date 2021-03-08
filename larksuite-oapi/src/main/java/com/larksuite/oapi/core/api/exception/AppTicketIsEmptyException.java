package com.larksuite.oapi.core.api.exception;

public class AppTicketIsEmptyException extends RuntimeException {
    public AppTicketIsEmptyException() {
        super("app ticket is empty");
    }
}
