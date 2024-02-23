package com.lark.oapi.ws.exception;

public class HeaderNotFoundException extends RuntimeException {
    private String key;

    public HeaderNotFoundException(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return String.format("HeaderNotFoundException: %s not found", this.key);
    }
}
