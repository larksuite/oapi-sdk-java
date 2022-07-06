// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.vc.v1.model;

import com.google.gson.annotations.SerializedName;

public class MeetingInviteStatus {
    @SerializedName("id")
    private String id;
    @SerializedName("user_type")
    private Integer userType;
    @SerializedName("status")
    private Integer status;

    // builder 开始
    public MeetingInviteStatus() {
    }

    public MeetingInviteStatus(Builder builder) {
        this.id = builder.id;
        this.userType = builder.userType;
        this.status = builder.status;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserType() {
        return this.userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static class Builder {
        private String id;
        private Integer userType;
        private Integer status;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder userType(Integer userType) {
            this.userType = userType;
            return this;
        }

        public Builder userType(com.larksuite.oapi.service.vc.v1.enums.UserTypeEnum userType) {
            this.userType = userType.getValue();
            return this;
        }

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder status(com.larksuite.oapi.service.vc.v1.enums.InviteStatusEnum status) {
            this.status = status.getValue();
            return this;
        }


        public MeetingInviteStatus build() {
            return new MeetingInviteStatus(this);
        }
    }
}
