// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class Message {
    @SerializedName("id")
    private String id;
    @SerializedName("receive_id")
    private String receiveId;
    @SerializedName("content")
    private String content;
    @SerializedName("msg_type")
    private String msgType;
    @SerializedName("config")
    private String config;
    @SerializedName("extra")
    private String extra;
    @SerializedName("uuid")
    private String uuid;

    // builder 开始
    public Message() {
    }

    public Message(Builder builder) {
        this.id = builder.id;
        this.receiveId = builder.receiveId;
        this.content = builder.content;
        this.msgType = builder.msgType;
        this.config = builder.config;
        this.extra = builder.extra;
        this.uuid = builder.uuid;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReceiveId() {
        return this.receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMsgType() {
        return this.msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getConfig() {
        return this.config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public static class Builder {
        private String id;
        private String receiveId;
        private String content;
        private String msgType;
        private String config;
        private String extra;
        private String uuid;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder receiveId(String receiveId) {
            this.receiveId = receiveId;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder msgType(String msgType) {
            this.msgType = msgType;
            return this;
        }

        public Builder config(String config) {
            this.config = config;
            return this;
        }

        public Builder extra(String extra) {
            this.extra = extra;
            return this;
        }

        public Builder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }


        public Message build() {
            return new Message(this);
        }
    }
}
