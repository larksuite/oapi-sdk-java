// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.bot.v3.model;
import com.google.gson.annotations.SerializedName;

public class BotInfo {
    @SerializedName("activate_status")
    private Integer activateStatus;
    @SerializedName("app_name")
    private String appName;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("ip_white_list")
    private String[] ipWhiteList;
    @SerializedName("open_id")
    private String openId;

    public Integer getActivateStatus() {
        return this.activateStatus;
    }

    public void setActivateStatus(Integer activateStatus) {
        this.activateStatus = activateStatus;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String[] getIpWhiteList() {
        return this.ipWhiteList;
    }

    public void setIpWhiteList(String[] ipWhiteList) {
        this.ipWhiteList = ipWhiteList;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

}
