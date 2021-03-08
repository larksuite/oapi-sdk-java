package com.larksuite.oapi.core.api.token;

import com.google.gson.annotations.SerializedName;

public class ISVAppAccessTokenReq {
    @SerializedName("app_id")
    private String appId;
    @SerializedName("app_secret")
    private String appSecret;
    @SerializedName("app_ticket")
    private String appTicket;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAppTicket() {
        return appTicket;
    }

    public void setAppTicket(String appTicket) {
        this.appTicket = appTicket;
    }
}
