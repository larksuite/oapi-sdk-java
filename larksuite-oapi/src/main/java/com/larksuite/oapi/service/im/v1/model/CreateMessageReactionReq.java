// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Body;
import com.larksuite.oapi.core.annotation.Path;

public class CreateMessageReactionReq {
    @Path
    @SerializedName("message_id")
    private String messageId;
    @Body
    private CreateMessageReactionReqBody body;

    // builder 开始
    public CreateMessageReactionReq() {
    }

    public CreateMessageReactionReq(Builder builder) {
        this.messageId = builder.messageId;
        this.body = builder.body;
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

    public CreateMessageReactionReqBody getCreateMessageReactionReqBody() {
        return this.body;
    }

    public void setCreateMessageReactionReqBody(CreateMessageReactionReqBody body) {
        this.body = body;
    }

    public static class Builder {

        private String messageId;
        private CreateMessageReactionReqBody body;

        public Builder messageId(String messageId) {
            this.messageId = messageId;
            return this;
        }

        public CreateMessageReactionReqBody getCreateMessageReactionReqBody() {
            return this.body;
        }

        public Builder createMessageReactionReqBody(CreateMessageReactionReqBody body) {
            this.body = body;
            return this;
        }

        public CreateMessageReactionReq build() {
            return new CreateMessageReactionReq(this);
        }
    }
}