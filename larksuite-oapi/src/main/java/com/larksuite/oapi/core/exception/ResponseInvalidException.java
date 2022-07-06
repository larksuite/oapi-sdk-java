package com.larksuite.oapi.core.exception;

public class ResponseInvalidException extends RuntimeException {
    public ResponseInvalidException(String message) {
        super(message);
    }
}
