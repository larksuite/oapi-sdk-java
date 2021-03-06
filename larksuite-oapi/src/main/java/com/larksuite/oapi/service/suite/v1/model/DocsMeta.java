// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.suite.v1.model;
import com.google.gson.annotations.SerializedName;

public class DocsMeta {
    @SerializedName("docs_token")
    private String docsToken;
    @SerializedName("docs_type")
    private String docsType;
    @SerializedName("title")
    private String title;
    @SerializedName("owner_id")
    private String ownerId;
    @SerializedName("create_time")
    private Integer createTime;
    @SerializedName("latest_modify_user")
    private String latestModifyUser;
    @SerializedName("latest_modify_time")
    private Integer latestModifyTime;

    public String getDocsToken() {
        return this.docsToken;
    }

    public void setDocsToken(String docsToken) {
        this.docsToken = docsToken;
    }

    public String getDocsType() {
        return this.docsType;
    }

    public void setDocsType(String docsType) {
        this.docsType = docsType;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public String getLatestModifyUser() {
        return this.latestModifyUser;
    }

    public void setLatestModifyUser(String latestModifyUser) {
        this.latestModifyUser = latestModifyUser;
    }

    public Integer getLatestModifyTime() {
        return this.latestModifyTime;
    }

    public void setLatestModifyTime(Integer latestModifyTime) {
        this.latestModifyTime = latestModifyTime;
    }

}
