// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;

public class CreateGroupReqBody {
    @SerializedName("group")
    private Group group;
    @SerializedName("operator_id")
    private String operatorId;

    // builder 开始
    public CreateGroupReqBody() {
    }

    public CreateGroupReqBody(Builder builder) {
        this.group = builder.group;
        this.operatorId = builder.operatorId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Group getGroup() {
        return this.group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public static class Builder {
        private Group group;
        private String operatorId;

        public Builder group(Group group) {
            this.group = group;
            return this;
        }

        public Builder operatorId(String operatorId) {
            this.operatorId = operatorId;
            return this;
        }


        public CreateGroupReqBody build() {
            return new CreateGroupReqBody(this);
        }
    }
}
