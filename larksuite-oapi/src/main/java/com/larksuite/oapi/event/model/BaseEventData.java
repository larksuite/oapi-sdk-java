package com.larksuite.oapi.event.model;

import com.google.gson.annotations.SerializedName;

public class BaseEventData {
    @SerializedName("app_id")
    private String appId;
    @SerializedName("type")
    private String type;
    @SerializedName("tenant_key")
    private String tenantKey;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTenantKey() {
        return tenantKey;
    }

    public void setTenantKey(String tenantKey) {
        this.tenantKey = tenantKey;
    }
}
