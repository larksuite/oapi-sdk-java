package com.larksuite.oapi.core.api.exception;

public class ResponseInvalidException extends RuntimeException {
    public ResponseInvalidException(String message) {
        super(message);
    }
}
