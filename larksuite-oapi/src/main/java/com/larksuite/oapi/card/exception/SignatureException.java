package com.larksuite.oapi.card.exception;

public class SignatureException extends RuntimeException {
    public SignatureException() {
        super("card, signature error");
    }
}
