// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.mail.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Body;
import com.larksuite.oapi.core.annotation.Path;
import com.larksuite.oapi.core.annotation.Query;

public class CreateMailgroupMemberReq {
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    @Query
    @SerializedName("department_id_type")
    private String departmentIdType;
    @Path
    @SerializedName("mailgroup_id")
    private String mailgroupId;
    @Body
    private MailgroupMember body;

    // builder 开始
    public CreateMailgroupMemberReq() {
    }

    public CreateMailgroupMemberReq(Builder builder) {
        this.userIdType = builder.userIdType;
        this.departmentIdType = builder.departmentIdType;
        this.mailgroupId = builder.mailgroupId;
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

    public String getDepartmentIdType() {
        return this.departmentIdType;
    }

    public void setDepartmentIdType(String departmentIdType) {
        this.departmentIdType = departmentIdType;
    }

    public String getMailgroupId() {
        return this.mailgroupId;
    }

    public void setMailgroupId(String mailgroupId) {
        this.mailgroupId = mailgroupId;
    }

    public MailgroupMember getMailgroupMember() {
        return this.body;
    }

    public void setMailgroupMember(MailgroupMember body) {
        this.body = body;
    }

    public static class Builder {
        private String userIdType;
        private String departmentIdType;
        private String mailgroupId;
        private MailgroupMember body;

        public Builder userIdType(String userIdType) {
            this.userIdType = userIdType;
            return this;
        }

        public Builder userIdType(com.larksuite.oapi.service.mail.v1.enums.UserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        public Builder departmentIdType(String departmentIdType) {
            this.departmentIdType = departmentIdType;
            return this;
        }

        public Builder departmentIdType(com.larksuite.oapi.service.mail.v1.enums.DepartmentIdTypeEnum departmentIdType) {
            this.departmentIdType = departmentIdType.getValue();
            return this;
        }

        public Builder mailgroupId(String mailgroupId) {
            this.mailgroupId = mailgroupId;
            return this;
        }

        public MailgroupMember getMailgroupMember() {
            return this.body;
        }

        public Builder mailgroupMember(MailgroupMember body) {
            this.body = body;
            return this;
        }

        public CreateMailgroupMemberReq build() {
            return new CreateMailgroupMemberReq(this);
        }
    }
}
