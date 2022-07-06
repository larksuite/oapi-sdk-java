// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Body;
import com.larksuite.oapi.core.annotation.Path;

public class BatchCreateAppRoleMemberReq {
    @Path
    @SerializedName("app_token")
    private String appToken;
    @Path
    @SerializedName("role_id")
    private String roleId;
    @Body
    private BatchCreateAppRoleMemberReqBody body;

    // builder 开始
    public BatchCreateAppRoleMemberReq() {
    }

    public BatchCreateAppRoleMemberReq(Builder builder) {
        this.appToken = builder.appToken;
        this.roleId = builder.roleId;
        this.body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getAppToken() {
        return this.appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public BatchCreateAppRoleMemberReqBody getBatchCreateAppRoleMemberReqBody() {
        return this.body;
    }

    public void setBatchCreateAppRoleMemberReqBody(BatchCreateAppRoleMemberReqBody body) {
        this.body = body;
    }

    public static class Builder {

        private String appToken;
        private String roleId;
        private BatchCreateAppRoleMemberReqBody body;

        public Builder appToken(String appToken) {
            this.appToken = appToken;
            return this;
        }

        public Builder roleId(String roleId) {
            this.roleId = roleId;
            return this;
        }

        public BatchCreateAppRoleMemberReqBody getBatchCreateAppRoleMemberReqBody() {
            return this.body;
        }

        public Builder batchCreateAppRoleMemberReqBody(BatchCreateAppRoleMemberReqBody body) {
            this.body = body;
            return this;
        }

        public BatchCreateAppRoleMemberReq build() {
            return new BatchCreateAppRoleMemberReq(this);
        }
    }
}
