package com.larksuite.oapi.core.exception;

public class EventDecryptionException extends RuntimeException {
    public EventDecryptionException() {
        super("The result of event decryption failed");
    }
}
