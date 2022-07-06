// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class ApprovalCreateViewers {
    @SerializedName("viewer_type")
    private String viewerType;
    @SerializedName("viewer_user_id")
    private String viewerUserId;
    @SerializedName("viewer_department_id")
    private String viewerDepartmentId;

    // builder 开始
    public ApprovalCreateViewers() {
    }

    public ApprovalCreateViewers(Builder builder) {
        this.viewerType = builder.viewerType;
        this.viewerUserId = builder.viewerUserId;
        this.viewerDepartmentId = builder.viewerDepartmentId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getViewerType() {
        return this.viewerType;
    }

    public void setViewerType(String viewerType) {
        this.viewerType = viewerType;
    }

    public String getViewerUserId() {
        return this.viewerUserId;
    }

    public void setViewerUserId(String viewerUserId) {
        this.viewerUserId = viewerUserId;
    }

    public String getViewerDepartmentId() {
        return this.viewerDepartmentId;
    }

    public void setViewerDepartmentId(String viewerDepartmentId) {
        this.viewerDepartmentId = viewerDepartmentId;
    }

    public static class Builder {
        private String viewerType;
        private String viewerUserId;
        private String viewerDepartmentId;

        public Builder viewerType(String viewerType) {
            this.viewerType = viewerType;
            return this;
        }

        public Builder viewerType(com.larksuite.oapi.service.approval.v4.enums.ViewerTypeEnum viewerType) {
            this.viewerType = viewerType.getValue();
            return this;
        }

        public Builder viewerUserId(String viewerUserId) {
            this.viewerUserId = viewerUserId;
            return this;
        }

        public Builder viewerDepartmentId(String viewerDepartmentId) {
            this.viewerDepartmentId = viewerDepartmentId;
            return this;
        }


        public ApprovalCreateViewers build() {
            return new ApprovalCreateViewers(this);
        }
    }
}
