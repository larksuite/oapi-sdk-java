// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;

public class DeleteBatchMessageReq {
    @Path
    @SerializedName("batch_message_id")
    private String batchMessageId;

    // builder 开始
    public DeleteBatchMessageReq() {
    }

    public DeleteBatchMessageReq(Builder builder) {
        this.batchMessageId = builder.batchMessageId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getBatchMessageId() {
        return this.batchMessageId;
    }

    public void setBatchMessageId(String batchMessageId) {
        this.batchMessageId = batchMessageId;
    }

    public static class Builder {

        private String batchMessageId;

        public Builder batchMessageId(String batchMessageId) {
            this.batchMessageId = batchMessageId;
            return this;
        }

        public DeleteBatchMessageReq build() {
            return new DeleteBatchMessageReq(this);
        }
    }
}
