// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;

public class Meta {
    @SerializedName("doc_token")
    private String docToken;
    @SerializedName("doc_type")
    private String docType;
    @SerializedName("title")
    private String title;
    @SerializedName("owner_id")
    private String ownerId;
    @SerializedName("create_time")
    private Long createTime;
    @SerializedName("latest_modify_user")
    private String latestModifyUser;
    @SerializedName("latest_modify_time")
    private Long latestModifyTime;
    @SerializedName("url")
    private String url;

    // builder 开始
    public Meta() {
    }

    public Meta(Builder builder) {
        this.docToken = builder.docToken;
        this.docType = builder.docType;
        this.title = builder.title;
        this.ownerId = builder.ownerId;
        this.createTime = builder.createTime;
        this.latestModifyUser = builder.latestModifyUser;
        this.latestModifyTime = builder.latestModifyTime;
        this.url = builder.url;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getDocToken() {
        return this.docToken;
    }

    public void setDocToken(String docToken) {
        this.docToken = docToken;
    }

    public String getDocType() {
        return this.docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
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

    public Long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getLatestModifyUser() {
        return this.latestModifyUser;
    }

    public void setLatestModifyUser(String latestModifyUser) {
        this.latestModifyUser = latestModifyUser;
    }

    public Long getLatestModifyTime() {
        return this.latestModifyTime;
    }

    public void setLatestModifyTime(Long latestModifyTime) {
        this.latestModifyTime = latestModifyTime;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static class Builder {
        private String docToken;
        private String docType;
        private String title;
        private String ownerId;
        private Long createTime;
        private String latestModifyUser;
        private Long latestModifyTime;
        private String url;

        public Builder docToken(String docToken) {
            this.docToken = docToken;
            return this;
        }

        public Builder docType(String docType) {
            this.docType = docType;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder ownerId(String ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public Builder createTime(Long createTime) {
            this.createTime = createTime;
            return this;
        }

        public Builder latestModifyUser(String latestModifyUser) {
            this.latestModifyUser = latestModifyUser;
            return this;
        }

        public Builder latestModifyTime(Long latestModifyTime) {
            this.latestModifyTime = latestModifyTime;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }


        public Meta build() {
            return new Meta(this);
        }
    }
}