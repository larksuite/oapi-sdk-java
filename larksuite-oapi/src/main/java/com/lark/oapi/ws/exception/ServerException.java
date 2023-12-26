package com.lark.oapi.ws.exception;

public class ServerException extends RuntimeException {
    private int code;

    public ServerException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ServerException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    @Override
    public String toString() {
        return String.format("ServerException: %d: %s", this.code, getMessage());
    }
}
