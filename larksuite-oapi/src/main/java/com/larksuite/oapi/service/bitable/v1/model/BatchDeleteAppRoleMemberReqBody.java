// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;

public class BatchDeleteAppRoleMemberReqBody {
    @SerializedName("member_list")
    private AppRoleMemberId[] memberList;

    // builder 开始
    public BatchDeleteAppRoleMemberReqBody() {
    }

    public BatchDeleteAppRoleMemberReqBody(Builder builder) {
        this.memberList = builder.memberList;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public AppRoleMemberId[] getMemberList() {
        return this.memberList;
    }

    public void setMemberList(AppRoleMemberId[] memberList) {
        this.memberList = memberList;
    }

    public static class Builder {
        private AppRoleMemberId[] memberList;

        public Builder memberList(AppRoleMemberId[] memberList) {
            this.memberList = memberList;
            return this;
        }


        public BatchDeleteAppRoleMemberReqBody build() {
            return new BatchDeleteAppRoleMemberReqBody(this);
        }
    }
}
