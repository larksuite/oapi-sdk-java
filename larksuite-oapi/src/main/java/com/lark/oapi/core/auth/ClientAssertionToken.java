package com.lark.oapi.core.auth;

public class ClientAssertionToken {
    private String value;
    private TargetInfo targetInfo;

    public ClientAssertionToken() {
    }

    public ClientAssertionToken(String value) {
        this.value = value;
    }

    public ClientAssertionToken(String value, TargetInfo targetInfo) {
        this.value = value;
        this.targetInfo = targetInfo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TargetInfo getTargetInfo() {
        return targetInfo;
    }

    public void setTargetInfo(TargetInfo targetInfo) {
        this.targetInfo = targetInfo;
    }
}
