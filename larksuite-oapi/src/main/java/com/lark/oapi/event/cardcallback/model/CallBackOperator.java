package com.lark.oapi.event.cardcallback.model;

import com.google.gson.annotations.SerializedName;

public class CallBackOperator {

    @SerializedName("tenant_key")
    private String tenantKey;

    @SerializedName("user_id")
    private String userId;

    @SerializedName("open_id")
    private String openId;

    public String getTenantKey() {return this.tenantKey;}

    public void setTenantKey(String tenantKey) {this.tenantKey = tenantKey;}

    public String getUserId() {return this.userId;}

    public void setUserId(String userId) {this.userId = userId;}

    public String getOpenId() {return this.openId;}

    public void setOpenId(String openId) {this.openId = openId;}
}
