// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class ExternalApproval {
    @SerializedName("approval_name")
    private String approvalName;
    @SerializedName("approval_code")
    private String approvalCode;
    @SerializedName("group_code")
    private String groupCode;
    @SerializedName("group_name")
    private String groupName;
    @SerializedName("description")
    private String description;
    @SerializedName("external")
    private ApprovalCreateExternal external;
    @SerializedName("viewers")
    private ApprovalCreateViewers[] viewers;
    @SerializedName("i18n_resources")
    private I18nResource[] i18nResources;

    // builder 开始
    public ExternalApproval() {
    }

    public ExternalApproval(Builder builder) {
        this.approvalName = builder.approvalName;
        this.approvalCode = builder.approvalCode;
        this.groupCode = builder.groupCode;
        this.groupName = builder.groupName;
        this.description = builder.description;
        this.external = builder.external;
        this.viewers = builder.viewers;
        this.i18nResources = builder.i18nResources;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getApprovalName() {
        return this.approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    public String getApprovalCode() {
        return this.approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getGroupCode() {
        return this.groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ApprovalCreateExternal getExternal() {
        return this.external;
    }

    public void setExternal(ApprovalCreateExternal external) {
        this.external = external;
    }

    public ApprovalCreateViewers[] getViewers() {
        return this.viewers;
    }

    public void setViewers(ApprovalCreateViewers[] viewers) {
        this.viewers = viewers;
    }

    public I18nResource[] getI18nResources() {
        return this.i18nResources;
    }

    public void setI18nResources(I18nResource[] i18nResources) {
        this.i18nResources = i18nResources;
    }

    public static class Builder {
        private String approvalName;
        private String approvalCode;
        private String groupCode;
        private String groupName;
        private String description;
        private ApprovalCreateExternal external;
        private ApprovalCreateViewers[] viewers;
        private I18nResource[] i18nResources;

        public Builder approvalName(String approvalName) {
            this.approvalName = approvalName;
            return this;
        }

        public Builder approvalCode(String approvalCode) {
            this.approvalCode = approvalCode;
            return this;
        }

        public Builder groupCode(String groupCode) {
            this.groupCode = groupCode;
            return this;
        }

        public Builder groupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder external(ApprovalCreateExternal external) {
            this.external = external;
            return this;
        }

        public Builder viewers(ApprovalCreateViewers[] viewers) {
            this.viewers = viewers;
            return this;
        }

        public Builder i18nResources(I18nResource[] i18nResources) {
            this.i18nResources = i18nResources;
            return this;
        }


        public ExternalApproval build() {
            return new ExternalApproval(this);
        }
    }
}
