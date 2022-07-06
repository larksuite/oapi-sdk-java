package com.larksuite.oapi.core.exception;

public class NeedAccessTokenException extends RuntimeException {
    public NeedAccessTokenException() {
        super("Need pass an access token value");
    }
}
