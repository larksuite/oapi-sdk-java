// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Body;
import com.larksuite.oapi.core.annotation.Path;
import com.larksuite.oapi.core.annotation.Query;

public class BatchCreateAppTableRecordReq {
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    @Path
    @SerializedName("app_token")
    private String appToken;
    @Path
    @SerializedName("table_id")
    private String tableId;
    @Body
    private BatchCreateAppTableRecordReqBody body;

    // builder 开始
    public BatchCreateAppTableRecordReq() {
    }

    public BatchCreateAppTableRecordReq(Builder builder) {
        this.userIdType = builder.userIdType;
        this.appToken = builder.appToken;
        this.tableId = builder.tableId;
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

    public String getAppToken() {
        return this.appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public String getTableId() {
        return this.tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public BatchCreateAppTableRecordReqBody getBatchCreateAppTableRecordReqBody() {
        return this.body;
    }

    public void setBatchCreateAppTableRecordReqBody(BatchCreateAppTableRecordReqBody body) {
        this.body = body;
    }

    public static class Builder {
        private String userIdType;
        private String appToken;
        private String tableId;
        private BatchCreateAppTableRecordReqBody body;

        public Builder userIdType(String userIdType) {
            this.userIdType = userIdType;
            return this;
        }

        public Builder userIdType(com.larksuite.oapi.service.bitable.v1.enums.UserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        public Builder appToken(String appToken) {
            this.appToken = appToken;
            return this;
        }

        public Builder tableId(String tableId) {
            this.tableId = tableId;
            return this;
        }

        public BatchCreateAppTableRecordReqBody getBatchCreateAppTableRecordReqBody() {
            return this.body;
        }

        public Builder batchCreateAppTableRecordReqBody(BatchCreateAppTableRecordReqBody body) {
            this.body = body;
            return this;
        }

        public BatchCreateAppTableRecordReq build() {
            return new BatchCreateAppTableRecordReq(this);
        }
    }
}
