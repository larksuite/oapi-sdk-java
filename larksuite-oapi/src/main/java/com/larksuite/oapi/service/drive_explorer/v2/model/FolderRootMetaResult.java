// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive_explorer.v2.model;
import com.google.gson.annotations.SerializedName;

public class FolderRootMetaResult {
    @SerializedName("token")
    private String token;
    @SerializedName("id")
    private String id;
    @SerializedName("user_id")
    private String userId;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}