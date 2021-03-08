package com.larksuite.oapi.core.api.token;

import com.google.gson.annotations.SerializedName;

public class AppAccessToken {
    @SerializedName("expire")
    private int expire;
    @SerializedName("app_access_token")
    private String appAccessToken;

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public String getAppAccessToken() {
        return appAccessToken;
    }

    public void setAppAccessToken(String appAccessToken) {
        this.appAccessToken = appAccessToken;
    }
}
