package com.larksuite.oapi.core.exception;

public class TenantKeyEmptyException extends RuntimeException {
    public TenantKeyEmptyException() {
        super("tenant key is empty");
    }
}
