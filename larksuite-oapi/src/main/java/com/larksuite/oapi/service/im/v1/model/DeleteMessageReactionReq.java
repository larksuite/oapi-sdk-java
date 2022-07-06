// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;

public class DeleteMessageReactionReq {
    @Path
    @SerializedName("message_id")
    private String messageId;
    @Path
    @SerializedName("reaction_id")
    private String reactionId;

    // builder 开始
    public DeleteMessageReactionReq() {
    }

    public DeleteMessageReactionReq(Builder builder) {
        this.messageId = builder.messageId;
        this.reactionId = builder.reactionId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getMessageId() {
        return this.messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getReactionId() {
        return this.reactionId;
    }

    public void setReactionId(String reactionId) {
        this.reactionId = reactionId;
    }

    public static class Builder {

        private String messageId;
        private String reactionId;

        public Builder messageId(String messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder reactionId(String reactionId) {
            this.reactionId = reactionId;
            return this;
        }

        public DeleteMessageReactionReq build() {
            return new DeleteMessageReactionReq(this);
        }
    }
}
