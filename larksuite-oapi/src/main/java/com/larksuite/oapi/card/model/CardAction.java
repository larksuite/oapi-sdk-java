package com.larksuite.oapi.card.model;

import com.google.gson.annotations.SerializedName;

public class CardAction {
    @SerializedName("open_id")
    private String openId;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("open_message_id")
    private String openMessageId;
    @SerializedName("tenant_key")
    private String tenantKey;
    @SerializedName("token")
    private String token;
    @SerializedName("timezone")
    private String timezone;
    @SerializedName("action")
    private Action action;
    @SerializedName("challenge")
    private String challenge;
    @SerializedName("type")
    private String type;

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpenMessageId() {
        return openMessageId;
    }

    public void setOpenMessageId(String openMessageId) {
        this.openMessageId = openMessageId;
    }

    public String getTenantKey() {
        return tenantKey;
    }

    public void setTenantKey(String tenantKey) {
        this.tenantKey = tenantKey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Card{" +
                "openId='" + openId + '\'' +
                ", userId='" + userId + '\'' +
                ", openMessageId='" + openMessageId + '\'' +
                ", tenantKey='" + tenantKey + '\'' +
                ", token='" + token + '\'' +
                ", timezone='" + timezone + '\'' +
                ", action=" + action + '\'' +
                ", type=" + type + '\'' +
                ", challenge=" + challenge + '\'' +
                '}';
    }
}
