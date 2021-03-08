package com.larksuite.oapi.core.exception;

public class DecryptException extends RuntimeException {

    public DecryptException() {
    }

    public DecryptException(String message) {
        super(message);
    }

    public DecryptException(String message, Throwable cause) {
        super(message, cause);
    }

    public DecryptException(Throwable cause) {
        super(cause);
    }

    public DecryptException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
