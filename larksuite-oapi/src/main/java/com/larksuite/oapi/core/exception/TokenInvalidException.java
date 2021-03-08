package com.larksuite.oapi.core.exception;

public class TokenInvalidException extends RuntimeException {
    public TokenInvalidException(String token) {
        super(String.format("AppSettings.VerificationToken not equal token(%s)", token));
    }
}
