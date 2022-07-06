// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;
import com.larksuite.oapi.core.annotation.Query;

public class GetUserFlowReq {
    @Query
    @SerializedName("employee_type")
    private String employeeType;
    @Path
    @SerializedName("user_flow_id")
    private String userFlowId;

    // builder 开始
    public GetUserFlowReq() {
    }

    public GetUserFlowReq(Builder builder) {
        this.employeeType = builder.employeeType;
        this.userFlowId = builder.userFlowId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getEmployeeType() {
        return this.employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getUserFlowId() {
        return this.userFlowId;
    }

    public void setUserFlowId(String userFlowId) {
        this.userFlowId = userFlowId;
    }

    public static class Builder {
        private String employeeType;
        private String userFlowId;

        public Builder employeeType(String employeeType) {
            this.employeeType = employeeType;
            return this;
        }

        public Builder employeeType(com.larksuite.oapi.service.attendance.v1.enums.EmployeeTypeEnum employeeType) {
            this.employeeType = employeeType.getValue();
            return this;
        }

        public Builder userFlowId(String userFlowId) {
            this.userFlowId = userFlowId;
            return this;
        }

        public GetUserFlowReq build() {
            return new GetUserFlowReq(this);
        }
    }
}