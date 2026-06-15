package com.lark.oapi.core.exception;

public class ClientAssertionException extends RuntimeException {
    private final int code;

    public ClientAssertionException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ClientAssertionException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return String.format("ClientAssertionException: %d: %s", code, getMessage());
    }
}
