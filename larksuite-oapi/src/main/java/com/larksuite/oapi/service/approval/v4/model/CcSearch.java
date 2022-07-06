// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class CcSearch {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("approval_code")
    private String approvalCode;
    @SerializedName("instance_code")
    private String instanceCode;
    @SerializedName("instance_external_id")
    private String instanceExternalId;
    @SerializedName("group_external_id")
    private String groupExternalId;
    @SerializedName("cc_title")
    private String ccTitle;
    @SerializedName("read_status")
    private String readStatus;
    @SerializedName("cc_create_time_from")
    private Long ccCreateTimeFrom;
    @SerializedName("cc_create_time_to")
    private Long ccCreateTimeTo;
    @SerializedName("locale")
    private String locale;

    // builder 开始
    public CcSearch() {
    }

    public CcSearch(Builder builder) {
        this.userId = builder.userId;
        this.approvalCode = builder.approvalCode;
        this.instanceCode = builder.instanceCode;
        this.instanceExternalId = builder.instanceExternalId;
        this.groupExternalId = builder.groupExternalId;
        this.ccTitle = builder.ccTitle;
        this.readStatus = builder.readStatus;
        this.ccCreateTimeFrom = builder.ccCreateTimeFrom;
        this.ccCreateTimeTo = builder.ccCreateTimeTo;
        this.locale = builder.locale;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApprovalCode() {
        return this.approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getInstanceCode() {
        return this.instanceCode;
    }

    public void setInstanceCode(String instanceCode) {
        this.instanceCode = instanceCode;
    }

    public String getInstanceExternalId() {
        return this.instanceExternalId;
    }

    public void setInstanceExternalId(String instanceExternalId) {
        this.instanceExternalId = instanceExternalId;
    }

    public String getGroupExternalId() {
        return this.groupExternalId;
    }

    public void setGroupExternalId(String groupExternalId) {
        this.groupExternalId = groupExternalId;
    }

    public String getCcTitle() {
        return this.ccTitle;
    }

    public void setCcTitle(String ccTitle) {
        this.ccTitle = ccTitle;
    }

    public String getReadStatus() {
        return this.readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }

    public Long getCcCreateTimeFrom() {
        return this.ccCreateTimeFrom;
    }

    public void setCcCreateTimeFrom(Long ccCreateTimeFrom) {
        this.ccCreateTimeFrom = ccCreateTimeFrom;
    }

    public Long getCcCreateTimeTo() {
        return this.ccCreateTimeTo;
    }

    public void setCcCreateTimeTo(Long ccCreateTimeTo) {
        this.ccCreateTimeTo = ccCreateTimeTo;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public static class Builder {
        private String userId;
        private String approvalCode;
        private String instanceCode;
        private String instanceExternalId;
        private String groupExternalId;
        private String ccTitle;
        private String readStatus;
        private Long ccCreateTimeFrom;
        private Long ccCreateTimeTo;
        private String locale;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder approvalCode(String approvalCode) {
            this.approvalCode = approvalCode;
            return this;
        }

        public Builder instanceCode(String instanceCode) {
            this.instanceCode = instanceCode;
            return this;
        }

        public Builder instanceExternalId(String instanceExternalId) {
            this.instanceExternalId = instanceExternalId;
            return this;
        }

        public Builder groupExternalId(String groupExternalId) {
            this.groupExternalId = groupExternalId;
            return this;
        }

        public Builder ccTitle(String ccTitle) {
            this.ccTitle = ccTitle;
            return this;
        }

        public Builder readStatus(String readStatus) {
            this.readStatus = readStatus;
            return this;
        }

        public Builder readStatus(com.larksuite.oapi.service.approval.v4.enums.ReadStatusEnum readStatus) {
            this.readStatus = readStatus.getValue();
            return this;
        }

        public Builder ccCreateTimeFrom(Long ccCreateTimeFrom) {
            this.ccCreateTimeFrom = ccCreateTimeFrom;
            return this;
        }

        public Builder ccCreateTimeTo(Long ccCreateTimeTo) {
            this.ccCreateTimeTo = ccCreateTimeTo;
            return this;
        }

        public Builder locale(String locale) {
            this.locale = locale;
            return this;
        }

        public Builder locale(com.larksuite.oapi.service.approval.v4.enums.LocaleEnum locale) {
            this.locale = locale.getValue();
            return this;
        }


        public CcSearch build() {
            return new CcSearch(this);
        }
    }
}
