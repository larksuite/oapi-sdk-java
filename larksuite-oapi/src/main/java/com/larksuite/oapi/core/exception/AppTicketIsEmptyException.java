package com.larksuite.oapi.core.exception;

public class AppTicketIsEmptyException extends RuntimeException {
    public AppTicketIsEmptyException() {
        super("app ticket is empty");
    }
}
