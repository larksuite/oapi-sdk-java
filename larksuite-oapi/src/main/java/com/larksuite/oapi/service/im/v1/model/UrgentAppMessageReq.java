// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Body;
import com.larksuite.oapi.core.annotation.Path;
import com.larksuite.oapi.core.annotation.Query;

public class UrgentAppMessageReq {
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    @Path
    @SerializedName("message_id")
    private String messageId;
    @Body
    private UrgentReceivers body;

    // builder 开始
    public UrgentAppMessageReq() {
    }

    public UrgentAppMessageReq(Builder builder) {
        this.userIdType = builder.userIdType;
        this.messageId = builder.messageId;
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

    public String getMessageId() {
        return this.messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public UrgentReceivers getUrgentReceivers() {
        return this.body;
    }

    public void setUrgentReceivers(UrgentReceivers body) {
        this.body = body;
    }

    public static class Builder {
        private String userIdType;
        private String messageId;
        private UrgentReceivers body;

        public Builder userIdType(String userIdType) {
            this.userIdType = userIdType;
            return this;
        }

        public Builder userIdType(com.larksuite.oapi.service.im.v1.enums.UserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        public Builder messageId(String messageId) {
            this.messageId = messageId;
            return this;
        }

        public UrgentReceivers getUrgentReceivers() {
            return this.body;
        }

        public Builder urgentReceivers(UrgentReceivers body) {
            this.body = body;
            return this;
        }

        public UrgentAppMessageReq build() {
            return new UrgentAppMessageReq(this);
        }
    }
}
