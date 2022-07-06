// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class TaskSearchNode {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("start_time")
    private Long startTime;
    @SerializedName("end_time")
    private Long endTime;
    @SerializedName("status")
    private String status;
    @SerializedName("title")
    private String title;
    @SerializedName("extra")
    private String extra;
    @SerializedName("link")
    private InstanceSearchLink link;

    // builder 开始
    public TaskSearchNode() {
    }

    public TaskSearchNode(Builder builder) {
        this.userId = builder.userId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.status = builder.status;
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

    public Long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        private Long startTime;
        private Long endTime;
        private String status;
        private String title;
        private String extra;
        private InstanceSearchLink link;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder startTime(Long startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(Long endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder status(com.larksuite.oapi.service.approval.v4.enums.StatusEnum status) {
            this.status = status.getValue();
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


        public TaskSearchNode build() {
            return new TaskSearchNode(this);
        }
    }
}