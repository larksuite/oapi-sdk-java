// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;

public class BatchCreateUserFlowReqBody {
    @SerializedName("flow_records")
    private UserFlow[] flowRecords;

    // builder 开始
    public BatchCreateUserFlowReqBody() {
    }

    public BatchCreateUserFlowReqBody(Builder builder) {
        this.flowRecords = builder.flowRecords;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public UserFlow[] getFlowRecords() {
        return this.flowRecords;
    }

    public void setFlowRecords(UserFlow[] flowRecords) {
        this.flowRecords = flowRecords;
    }

    public static class Builder {
        private UserFlow[] flowRecords;

        public Builder flowRecords(UserFlow[] flowRecords) {
            this.flowRecords = flowRecords;
            return this;
        }


        public BatchCreateUserFlowReqBody build() {
            return new BatchCreateUserFlowReqBody(this);
        }
    }
}
