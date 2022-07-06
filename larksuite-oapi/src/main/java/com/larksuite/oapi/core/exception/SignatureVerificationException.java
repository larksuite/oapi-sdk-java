package com.larksuite.oapi.core.exception;

public class SignatureVerificationException extends RuntimeException {
    public SignatureVerificationException() {
        super("The result of signature verification failed");
    }
}
