// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Body;
import com.larksuite.oapi.core.annotation.Path;

public class BatchDeleteAppTableRecordReq {
    @Path
    @SerializedName("app_token")
    private String appToken;
    @Path
    @SerializedName("table_id")
    private String tableId;
    @Body
    private BatchDeleteAppTableRecordReqBody body;

    // builder 开始
    public BatchDeleteAppTableRecordReq() {
    }

    public BatchDeleteAppTableRecordReq(Builder builder) {
        this.appToken = builder.appToken;
        this.tableId = builder.tableId;
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

    public String getTableId() {
        return this.tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public BatchDeleteAppTableRecordReqBody getBatchDeleteAppTableRecordReqBody() {
        return this.body;
    }

    public void setBatchDeleteAppTableRecordReqBody(BatchDeleteAppTableRecordReqBody body) {
        this.body = body;
    }

    public static class Builder {

        private String appToken;
        private String tableId;
        private BatchDeleteAppTableRecordReqBody body;

        public Builder appToken(String appToken) {
            this.appToken = appToken;
            return this;
        }

        public Builder tableId(String tableId) {
            this.tableId = tableId;
            return this;
        }

        public BatchDeleteAppTableRecordReqBody getBatchDeleteAppTableRecordReqBody() {
            return this.body;
        }

        public Builder batchDeleteAppTableRecordReqBody(BatchDeleteAppTableRecordReqBody body) {
            this.body = body;
            return this;
        }

        public BatchDeleteAppTableRecordReq build() {
            return new BatchDeleteAppTableRecordReq(this);
        }
    }
}
