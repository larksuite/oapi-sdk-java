// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class CcSearchNode {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("create_time")
    private Long createTime;
    @SerializedName("read_status")
    private String readStatus;
    @SerializedName("title")
    private String title;
    @SerializedName("extra")
    private String extra;
    @SerializedName("link")
    private InstanceSearchLink link;

    // builder 开始
    public CcSearchNode() {
    }

    public CcSearchNode(Builder builder) {
        this.userId = builder.userId;
        this.createTime = builder.createTime;
        this.readStatus = builder.readStatus;
        this.title = builder.title;
        this.extra = builder.extra;
        this.link = builder.link;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getReadStatus() {
        return this.readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public InstanceSearchLink getLink() {
        return this.link;
    }

    public void setLink(InstanceSearchLink link) {
        this.link = link;
    }

    public static class Builder {
        private String userId;
        private Long createTime;
        private String readStatus;
        private String title;
        private String extra;
        private InstanceSearchLink link;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder createTime(Long createTime) {
            this.createTime = createTime;
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

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder extra(String extra) {
            this.extra = extra;
            return this;
        }

        public Builder link(InstanceSearchLink link) {
            this.link = link;
            return this;
        }


        public CcSearchNode build() {
            return new CcSearchNode(this);
        }
    }
}
