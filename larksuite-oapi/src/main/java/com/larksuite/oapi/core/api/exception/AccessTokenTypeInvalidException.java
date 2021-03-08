package com.larksuite.oapi.core.api.exception;

public class AccessTokenTypeInvalidException extends RuntimeException {
    public AccessTokenTypeInvalidException() {
        super("access token type is invalid");
    }
}
