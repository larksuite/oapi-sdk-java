package com.larksuite.oapi.core.exception;

public class ServerTimeoutException extends RuntimeException {
    public ServerTimeoutException() {
        super("server time out");
    }
}
