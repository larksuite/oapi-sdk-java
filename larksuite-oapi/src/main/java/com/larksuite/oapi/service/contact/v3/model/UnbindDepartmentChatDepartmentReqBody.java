// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;

public class UnbindDepartmentChatDepartmentReqBody {
    @SerializedName("department_id")
    private String departmentId;

    // builder 开始
    public UnbindDepartmentChatDepartmentReqBody() {
    }

    public UnbindDepartmentChatDepartmentReqBody(Builder builder) {
        this.departmentId = builder.departmentId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public static class Builder {
        private String departmentId;

        public Builder departmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }


        public UnbindDepartmentChatDepartmentReqBody build() {
            return new UnbindDepartmentChatDepartmentReqBody(this);
        }
    }
}
