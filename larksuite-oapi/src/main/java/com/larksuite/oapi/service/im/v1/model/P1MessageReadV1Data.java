package com.larksuite.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class P1MessageReadV1Data {
    @SerializedName("app_id")
    private String appId;
    @SerializedName("open_chat_id")
    private String openChatId;
    @SerializedName("open_id")
    private String openId;
    @SerializedName("tenant_key")
    private String tenantKey;
    @SerializedName("type")
    private String type;
    @SerializedName("message_id_list")
    private String[] messageIdList;

    public String[] getMessageIdList() {
        return messageIdList;
    }

    public void setMessageIdList(String[] messageIdList) {
        this.messageIdList = messageIdList;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getOpenChatId() {
        return openChatId;
    }

    public void setOpenChatId(String openChatId) {
        this.openChatId = openChatId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTenantKey() {
        return tenantKey;
    }

    public void setTenantKey(String tenantKey) {
        this.tenantKey = tenantKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
