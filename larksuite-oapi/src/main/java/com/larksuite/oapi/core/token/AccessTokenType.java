package com.larksuite.oapi.core.token;

public enum AccessTokenType {
    None("none_access_token"), App("app_access_token"), Tenant("tenant_access_token"), User("user_access_token");

    private final String value;

    AccessTokenType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
