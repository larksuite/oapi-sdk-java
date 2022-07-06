// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Body;
import com.larksuite.oapi.core.annotation.Path;
import com.larksuite.oapi.core.annotation.Query;

public class UpdateChatModerationReq {
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    @Path
    @SerializedName("chat_id")
    private String chatId;
    @Body
    private UpdateChatModerationReqBody body;

    // builder 开始
    public UpdateChatModerationReq() {
    }

    public UpdateChatModerationReq(Builder builder) {
        this.userIdType = builder.userIdType;
        this.chatId = builder.chatId;
        this.body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUserIdType() {
        return this.userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType;
    }

    public String getChatId() {
        return this.chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public UpdateChatModerationReqBody getUpdateChatModerationReqBody() {
        return this.body;
    }

    public void setUpdateChatModerationReqBody(UpdateChatModerationReqBody body) {
        this.body = body;
    }

    public static class Builder {
        private String userIdType;
        private String chatId;
        private UpdateChatModerationReqBody body;

        public Builder userIdType(String userIdType) {
            this.userIdType = userIdType;
            return this;
        }

        public Builder userIdType(com.larksuite.oapi.service.im.v1.enums.UserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        public Builder chatId(String chatId) {
            this.chatId = chatId;
            return this;
        }

        public UpdateChatModerationReqBody getUpdateChatModerationReqBody() {
            return this.body;
        }

        public Builder updateChatModerationReqBody(UpdateChatModerationReqBody body) {
            this.body = body;
            return this;
        }

        public UpdateChatModerationReq build() {
            return new UpdateChatModerationReq(this);
        }
    }
}