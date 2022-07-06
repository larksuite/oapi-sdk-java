// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class CommentAtInfo {
    @SerializedName("user_id")
    private Long userId;
    @SerializedName("name")
    private String name;
    @SerializedName("offset")
    private Long offset;

    // builder 开始
    public CommentAtInfo() {
    }

    public CommentAtInfo(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.offset = builder.offset;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOffset() {
        return this.offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public static class Builder {
        private Long userId;
        private String name;
        private Long offset;

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder offset(Long offset) {
            this.offset = offset;
            return this;
        }


        public CommentAtInfo build() {
            return new CommentAtInfo(this);
        }
    }
}