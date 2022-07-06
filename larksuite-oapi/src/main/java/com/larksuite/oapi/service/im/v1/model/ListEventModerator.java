// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class ListEventModerator {
    @SerializedName("tenant_key")
    private String tenantKey;
    @SerializedName("user_id")
    private UserId userId;

    // builder 开始
    public ListEventModerator() {
    }

    public ListEventModerator(Builder builder) {
        this.tenantKey = builder.tenantKey;
        this.userId = builder.userId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getTenantKey() {
        return this.tenantKey;
    }

    public void setTenantKey(String tenantKey) {
        this.tenantKey = tenantKey;
    }

    public UserId getUserId() {
        return this.userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public static class Builder {
        private String tenantKey;
        private UserId userId;

        public Builder tenantKey(String tenantKey) {
            this.tenantKey = tenantKey;
            return this;
        }

        public Builder userId(UserId userId) {
            this.userId = userId;
            return this;
        }


        public ListEventModerator build() {
            return new ListEventModerator(this);
        }
    }
}
