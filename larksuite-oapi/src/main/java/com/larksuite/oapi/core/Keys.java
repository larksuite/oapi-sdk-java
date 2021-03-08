package com.larksuite.oapi.core;

public class Keys {
    private static final String appTicketKeyPrefix = "app_ticket";
    private static final String appAccessTokenKeyPrefix = "app_access_token";
    private static final String tenantAccessTokenKeyPrefix = "tenant_access_token";

    public static String appTicketKey(String appID) {
        return appTicketKeyPrefix + "-" + appID;
    }

    public static String appAccessTokenKey(String appID) {
        return appAccessTokenKeyPrefix + "-" + appID;
    }

    public static String tenantAccessTokenKey(String appID, String tenantKey) {
        return tenantAccessTokenKeyPrefix + "-" + appID + "-" + tenantKey;
    }
}
