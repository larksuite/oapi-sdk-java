// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive_explorer.v2.model;
import com.google.gson.annotations.SerializedName;

public class OperatorId {
    @SerializedName("open_id")
    private String openId;
    @SerializedName("union_id")
    private String unionId;
    @SerializedName("user_id")
    private String userId;

    public String getOpenId() {
        return this.openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return this.unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}