package com.larksuite.oapi.core.exception;

public class AuthChallengeException extends RuntimeException {
    public AuthChallengeException() {
        super("The result of auth by challenge failed");
    }
}
