// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class ApprovalViewerInfo {
    @SerializedName("type")
    private String type;
    @SerializedName("id")
    private String id;
    @SerializedName("user_id")
    private String userId;

    // builder 开始
    public ApprovalViewerInfo() {
    }

    public ApprovalViewerInfo(Builder builder) {
        this.type = builder.type;
        this.id = builder.id;
        this.userId = builder.userId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static class Builder {
        private String type;
        private String id;
        private String userId;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder type(com.larksuite.oapi.service.approval.v4.enums.TypeEnum type) {
            this.type = type.getValue();
            return this;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }


        public ApprovalViewerInfo build() {
            return new ApprovalViewerInfo(this);
        }
    }
}