package com.lark.oapi.ws.exception;

public class ClientException extends RuntimeException{
    private int code;

    public ClientException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ClientException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    @Override
    public String toString() {
        return String.format("ClientException: %d: %s", this.code, getMessage());
    }
}
