package com.larksuite.oapi.core.api.exception;

public class UserAccessTokenKeyEmptyException extends RuntimeException {
    public UserAccessTokenKeyEmptyException() {
        super("user access token is empty");
    }
}
