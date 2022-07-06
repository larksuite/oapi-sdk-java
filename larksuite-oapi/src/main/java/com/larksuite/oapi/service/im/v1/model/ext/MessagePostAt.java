package com.larksuite.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;

public class MessagePostAt extends MessagePostElement {

    @SerializedName("user_id")
    private String userId;
    @SerializedName("user_name")
    private String userName;

    public MessagePostAt() {
        tag = "at";
    }

    public MessagePostAt(Builder builder) {
        tag = "at";
        this.userId = builder.userId;
        this.userName = builder.userName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    String getTag() {
        return tag;
    }

    public static class Builder {
        private String userId;
        private String userName;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public MessagePostAt build() {
            return new MessagePostAt(this);
        }
    }
}
