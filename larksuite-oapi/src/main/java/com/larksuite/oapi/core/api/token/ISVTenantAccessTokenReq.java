package com.larksuite.oapi.core.api.token;

import com.google.gson.annotations.SerializedName;

public class ISVTenantAccessTokenReq {
    @SerializedName("app_access_token")
    private String appAccessToken;
    @SerializedName("tenant_key")
    private String tenantKey;

    public String getAppAccessToken() {
        return appAccessToken;
    }

    public void setAppAccessToken(String appAccessToken) {
        this.appAccessToken = appAccessToken;
    }

    public String getTenantKey() {
        return tenantKey;
    }

    public void setTenantKey(String tenantKey) {
        this.tenantKey = tenantKey;
    }
}
