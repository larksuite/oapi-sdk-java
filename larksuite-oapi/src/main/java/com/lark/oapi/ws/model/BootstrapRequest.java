package com.lark.oapi.ws.model;

import com.google.gson.annotations.SerializedName;

public class BootstrapRequest {
    @SerializedName("AppID")
    private String appId;
    @SerializedName("AppSecret")
    private String appSecret;
    @SerializedName("ClientAssertion")
    private String clientAssertion;

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

    public String getClientAssertion() {
        return clientAssertion;
    }

    public void setClientAssertion(String clientAssertion) {
        this.clientAssertion = clientAssertion;
    }
}
