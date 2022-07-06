// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;
import com.larksuite.oapi.core.annotation.Query;

public class DeleteDepartmentReq {
    @Query
    @SerializedName("department_id_type")
    private String departmentIdType;
    @Path
    @SerializedName("department_id")
    private String departmentId;

    // builder 开始
    public DeleteDepartmentReq() {
    }

    public DeleteDepartmentReq(Builder builder) {
        this.departmentIdType = builder.departmentIdType;
        this.departmentId = builder.departmentId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getDepartmentIdType() {
        return this.departmentIdType;
    }

    public void setDepartmentIdType(String departmentIdType) {
        this.departmentIdType = departmentIdType;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public static class Builder {
        private String departmentIdType;
        private String departmentId;

        public Builder departmentIdType(String departmentIdType) {
            this.departmentIdType = departmentIdType;
            return this;
        }

        public Builder departmentIdType(com.larksuite.oapi.service.contact.v3.enums.DepartmentIdTypeEnum departmentIdType) {
            this.departmentIdType = departmentIdType.getValue();
            return this;
        }

        public Builder departmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public DeleteDepartmentReq build() {
            return new DeleteDepartmentReq(this);
        }
    }
}
