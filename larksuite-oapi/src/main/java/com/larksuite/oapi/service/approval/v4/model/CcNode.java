// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class CcNode {
    @SerializedName("cc_id")
    private String ccId;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("open_id")
    private String openId;
    @SerializedName("links")
    private ExternalInstanceLink links;
    @SerializedName("read_status")
    private String readStatus;
    @SerializedName("extra")
    private String extra;
    @SerializedName("title")
    private String title;
    @SerializedName("create_time")
    private Long createTime;
    @SerializedName("update_time")
    private Long updateTime;
    @SerializedName("display_method")
    private String displayMethod;

    // builder 开始
    public CcNode() {
    }

    public CcNode(Builder builder) {
        this.ccId = builder.ccId;
        this.userId = builder.userId;
        this.openId = builder.openId;
        this.links = builder.links;
        this.readStatus = builder.readStatus;
        this.extra = builder.extra;
        this.title = builder.title;
        this.createTime = builder.createTime;
        this.updateTime = builder.updateTime;
        this.displayMethod = builder.displayMethod;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCcId() {
        return this.ccId;
    }

    public void setCcId(String ccId) {
        this.ccId = ccId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public ExternalInstanceLink getLinks() {
        return this.links;
    }

    public void setLinks(ExternalInstanceLink links) {
        this.links = links;
    }

    public String getReadStatus() {
        return this.readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getDisplayMethod() {
        return this.displayMethod;
    }

    public void setDisplayMethod(String displayMethod) {
        this.displayMethod = displayMethod;
    }

    public static class Builder {
        private String ccId;
        private String userId;
        private String openId;
        private ExternalInstanceLink links;
        private String readStatus;
        private String extra;
        private String title;
        private Long createTime;
        private Long updateTime;
        private String displayMethod;

        public Builder ccId(String ccId) {
            this.ccId = ccId;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder openId(String openId) {
            this.openId = openId;
            return this;
        }

        public Builder links(ExternalInstanceLink links) {
            this.links = links;
            return this;
        }

        public Builder readStatus(String readStatus) {
            this.readStatus = readStatus;
            return this;
        }

        public Builder readStatus(com.larksuite.oapi.service.approval.v4.enums.ReadStatusEnum readStatus) {
            this.readStatus = readStatus.getValue();
            return this;
        }

        public Builder extra(String extra) {
            this.extra = extra;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder createTime(Long createTime) {
            this.createTime = createTime;
            return this;
        }

        public Builder updateTime(Long updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public Builder displayMethod(String displayMethod) {
            this.displayMethod = displayMethod;
            return this;
        }

        public Builder displayMethod(com.larksuite.oapi.service.approval.v4.enums.DisplayMethodEnum displayMethod) {
            this.displayMethod = displayMethod.getValue();
            return this;
        }


        public CcNode build() {
            return new CcNode(this);
        }
    }
}