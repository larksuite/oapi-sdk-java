package com.larksuite.oapi.core.exception;

public class HttpStatusCodeIllegalException extends RuntimeException {
    public HttpStatusCodeIllegalException(int statusCode) {
        super(String.format("The status code %s of custom response is illegal", statusCode));
    }
}
