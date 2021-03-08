package com.larksuite.oapi.core.api.token;

import com.google.gson.annotations.SerializedName;

public class TenantAccessToken {
    @SerializedName("expire")
    private int expire;
    @SerializedName("tenant_access_token")
    private String tenantAccessToken;

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getTenantAccessToken() {
        return tenantAccessToken;
    }

    public void setTenantAccessToken(String tenantAccessToken) {
        this.tenantAccessToken = tenantAccessToken;
    }
}
