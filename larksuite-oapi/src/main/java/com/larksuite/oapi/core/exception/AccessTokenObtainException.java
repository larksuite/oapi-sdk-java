package com.larksuite.oapi.core.exception;


public class AccessTokenObtainException extends RuntimeException {

    public AccessTokenObtainException(String messagePrefix, String msg) {
        super(messagePrefix + msg);
    }
}
