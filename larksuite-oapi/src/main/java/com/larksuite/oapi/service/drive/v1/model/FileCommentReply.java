// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;

public class FileCommentReply {
    @SerializedName("reply_id")
    private String replyId;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("create_time")
    private Integer createTime;
    @SerializedName("update_time")
    private Integer updateTime;
    @SerializedName("content")
    private ReplyContent content;

    // builder 开始
    public FileCommentReply() {
    }

    public FileCommentReply(Builder builder) {
        this.replyId = builder.replyId;
        this.userId = builder.userId;
        this.createTime = builder.createTime;
        this.updateTime = builder.updateTime;
        this.content = builder.content;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getReplyId() {
        return this.replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public ReplyContent getContent() {
        return this.content;
    }

    public void setContent(ReplyContent content) {
        this.content = content;
    }

    public static class Builder {
        private String replyId;
        private String userId;
        private Integer createTime;
        private Integer updateTime;
        private ReplyContent content;

        public Builder replyId(String replyId) {
            this.replyId = replyId;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder createTime(Integer createTime) {
            this.createTime = createTime;
            return this;
        }

        public Builder updateTime(Integer updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public Builder content(ReplyContent content) {
            this.content = content;
            return this;
        }


        public FileCommentReply build() {
            return new FileCommentReply(this);
        }
    }
}
