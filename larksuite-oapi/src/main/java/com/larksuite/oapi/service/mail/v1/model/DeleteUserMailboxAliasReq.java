// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.mail.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;

public class DeleteUserMailboxAliasReq {
    @Path
    @SerializedName("user_mailbox_id")
    private String userMailboxId;
    @Path
    @SerializedName("alias_id")
    private String aliasId;

    // builder 开始
    public DeleteUserMailboxAliasReq() {
    }

    public DeleteUserMailboxAliasReq(Builder builder) {
        this.userMailboxId = builder.userMailboxId;
        this.aliasId = builder.aliasId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUserMailboxId() {
        return this.userMailboxId;
    }

    public void setUserMailboxId(String userMailboxId) {
        this.userMailboxId = userMailboxId;
    }

    public String getAliasId() {
        return this.aliasId;
    }

    public void setAliasId(String aliasId) {
        this.aliasId = aliasId;
    }

    public static class Builder {

        private String userMailboxId;
        private String aliasId;

        public Builder userMailboxId(String userMailboxId) {
            this.userMailboxId = userMailboxId;
            return this;
        }

        public Builder aliasId(String aliasId) {
            this.aliasId = aliasId;
            return this;
        }

        public DeleteUserMailboxAliasReq build() {
            return new DeleteUserMailboxAliasReq(this);
        }
    }
}
