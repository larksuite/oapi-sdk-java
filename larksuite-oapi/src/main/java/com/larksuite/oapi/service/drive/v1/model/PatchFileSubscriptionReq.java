// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Body;
import com.larksuite.oapi.core.annotation.Path;

public class PatchFileSubscriptionReq {
    @Path
    @SerializedName("file_token")
    private String fileToken;
    @Path
    @SerializedName("subscription_id")
    private String subscriptionId;
    @Body
    private PatchFileSubscriptionReqBody body;

    // builder 开始
    public PatchFileSubscriptionReq() {
    }

    public PatchFileSubscriptionReq(Builder builder) {
        this.fileToken = builder.fileToken;
        this.subscriptionId = builder.subscriptionId;
        this.body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getFileToken() {
        return this.fileToken;
    }

    public void setFileToken(String fileToken) {
        this.fileToken = fileToken;
    }

    public String getSubscriptionId() {
        return this.subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public PatchFileSubscriptionReqBody getPatchFileSubscriptionReqBody() {
        return this.body;
    }

    public void setPatchFileSubscriptionReqBody(PatchFileSubscriptionReqBody body) {
        this.body = body;
    }

    public static class Builder {

        private String fileToken;
        private String subscriptionId;
        private PatchFileSubscriptionReqBody body;

        public Builder fileToken(String fileToken) {
            this.fileToken = fileToken;
            return this;
        }

        public Builder subscriptionId(String subscriptionId) {
            this.subscriptionId = subscriptionId;
            return this;
        }

        public PatchFileSubscriptionReqBody getPatchFileSubscriptionReqBody() {
            return this.body;
        }

        public Builder patchFileSubscriptionReqBody(PatchFileSubscriptionReqBody body) {
            this.body = body;
            return this;
        }

        public PatchFileSubscriptionReq build() {
            return new PatchFileSubscriptionReq(this);
        }
    }
}