package com.larksuite.oapi.core.api.exception;

public class TenantKeyEmptyException extends RuntimeException {
    public TenantKeyEmptyException() {
        super("tenant key is empty");
    }
}
