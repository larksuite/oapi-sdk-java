// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class ApprovalEvent {
    @SerializedName("approval_id")
    private String approvalId;
    @SerializedName("approval_code")
    private String approvalCode;
    @SerializedName("version_id")
    private String versionId;
    @SerializedName("widget_group_type")
    private Integer widgetGroupType;
    @SerializedName("form_definition_id")
    private String formDefinitionId;
    @SerializedName("process_obj")
    private String processObj;
    @SerializedName("timestamp")
    private String timestamp;
    @SerializedName("extra")
    private String extra;

    // builder 开始
    public ApprovalEvent() {
    }

    public ApprovalEvent(Builder builder) {
        this.approvalId = builder.approvalId;
        this.approvalCode = builder.approvalCode;
        this.versionId = builder.versionId;
        this.widgetGroupType = builder.widgetGroupType;
        this.formDefinitionId = builder.formDefinitionId;
        this.processObj = builder.processObj;
        this.timestamp = builder.timestamp;
        this.extra = builder.extra;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getApprovalId() {
        return this.approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId;
    }

    public String getApprovalCode() {
        return this.approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public Integer getWidgetGroupType() {
        return this.widgetGroupType;
    }

    public void setWidgetGroupType(Integer widgetGroupType) {
        this.widgetGroupType = widgetGroupType;
    }

    public String getFormDefinitionId() {
        return this.formDefinitionId;
    }

    public void setFormDefinitionId(String formDefinitionId) {
        this.formDefinitionId = formDefinitionId;
    }

    public String getProcessObj() {
        return this.processObj;
    }

    public void setProcessObj(String processObj) {
        this.processObj = processObj;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public static class Builder {
        private String approvalId;
        private String approvalCode;
        private String versionId;
        private Integer widgetGroupType;
        private String formDefinitionId;
        private String processObj;
        private String timestamp;
        private String extra;

        public Builder approvalId(String approvalId) {
            this.approvalId = approvalId;
            return this;
        }

        public Builder approvalCode(String approvalCode) {
            this.approvalCode = approvalCode;
            return this;
        }

        public Builder versionId(String versionId) {
            this.versionId = versionId;
            return this;
        }

        public Builder widgetGroupType(Integer widgetGroupType) {
            this.widgetGroupType = widgetGroupType;
            return this;
        }

        public Builder formDefinitionId(String formDefinitionId) {
            this.formDefinitionId = formDefinitionId;
            return this;
        }

        public Builder processObj(String processObj) {
            this.processObj = processObj;
            return this;
        }

        public Builder timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder extra(String extra) {
            this.extra = extra;
            return this;
        }


        public ApprovalEvent build() {
            return new ApprovalEvent(this);
        }
    }
}
