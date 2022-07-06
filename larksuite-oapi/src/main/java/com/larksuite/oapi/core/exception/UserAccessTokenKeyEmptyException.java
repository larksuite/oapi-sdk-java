package com.larksuite.oapi.core.exception;

public class UserAccessTokenKeyEmptyException extends RuntimeException {
    public UserAccessTokenKeyEmptyException() {
        super("user access token is empty");
    }
}
