// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.mail.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;

public class ClearPublicMailboxMemberReq {
    @Path
    @SerializedName("public_mailbox_id")
    private String publicMailboxId;

    // builder 开始
    public ClearPublicMailboxMemberReq() {
    }

    public ClearPublicMailboxMemberReq(Builder builder) {
        this.publicMailboxId = builder.publicMailboxId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getPublicMailboxId() {
        return this.publicMailboxId;
    }

    public void setPublicMailboxId(String publicMailboxId) {
        this.publicMailboxId = publicMailboxId;
    }

    public static class Builder {

        private String publicMailboxId;

        public Builder publicMailboxId(String publicMailboxId) {
            this.publicMailboxId = publicMailboxId;
            return this;
        }

        public ClearPublicMailboxMemberReq build() {
            return new ClearPublicMailboxMemberReq(this);
        }
    }
}
