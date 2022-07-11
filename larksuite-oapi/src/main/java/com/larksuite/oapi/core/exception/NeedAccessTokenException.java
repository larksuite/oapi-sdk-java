package com.larksuite.oapi.core.exception;

// TODO 这个异常命名可读性不太好
public class NeedAccessTokenException extends RuntimeException {
    public NeedAccessTokenException() {
        super("Need pass an access token value");
    }
}
