// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.application.v6.model;

import com.google.gson.annotations.SerializedName;

public class ApplicationFeedback {
    @SerializedName("feedback_id")
    private Long feedbackId;
    @SerializedName("app_id")
    private String appId;
    @SerializedName("feedback_time")
    private String feedbackTime;
    @SerializedName("tenant_name")
    private String tenantName;
    @SerializedName("feedback_type")
    private Integer feedbackType;
    @SerializedName("status")
    private Integer status;
    @SerializedName("fault_type")
    private Integer[] faultType;
    @SerializedName("fault_time")
    private String faultTime;
    @SerializedName("source")
    private Integer source;
    @SerializedName("contact")
    private String contact;
    @SerializedName("update_time")
    private String updateTime;
    @SerializedName("description")
    private String description;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("operator_id")
    private String operatorId;
    @SerializedName("images")
    private String[] images;

    // builder 开始
    public ApplicationFeedback() {
    }

    public ApplicationFeedback(Builder builder) {
        this.feedbackId = builder.feedbackId;
        this.appId = builder.appId;
        this.feedbackTime = builder.feedbackTime;
        this.tenantName = builder.tenantName;
        this.feedbackType = builder.feedbackType;
        this.status = builder.status;
        this.faultType = builder.faultType;
        this.faultTime = builder.faultTime;
        this.source = builder.source;
        this.contact = builder.contact;
        this.updateTime = builder.updateTime;
        this.description = builder.description;
        this.userId = builder.userId;
        this.operatorId = builder.operatorId;
        this.images = builder.images;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getFeedbackId() {
        return this.feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getFeedbackTime() {
        return this.feedbackTime;
    }

    public void setFeedbackTime(String feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public String getTenantName() {
        return this.tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public Integer getFeedbackType() {
        return this.feedbackType;
    }

    public void setFeedbackType(Integer feedbackType) {
        this.feedbackType = feedbackType;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer[] getFaultType() {
        return this.faultType;
    }

    public void setFaultType(Integer[] faultType) {
        this.faultType = faultType;
    }

    public String getFaultTime() {
        return this.faultTime;
    }

    public void setFaultTime(String faultTime) {
        this.faultTime = faultTime;
    }

    public Integer getSource() {
        return this.source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String[] getImages() {
        return this.images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public static class Builder {
        private Long feedbackId;
        private String appId;
        private String feedbackTime;
        private String tenantName;
        private Integer feedbackType;
        private Integer status;
        private Integer[] faultType;
        private String faultTime;
        private Integer source;
        private String contact;
        private String updateTime;
        private String description;
        private String userId;
        private String operatorId;
        private String[] images;

        public Builder feedbackId(Long feedbackId) {
            this.feedbackId = feedbackId;
            return this;
        }

        public Builder appId(String appId) {
            this.appId = appId;
            return this;
        }

        public Builder feedbackTime(String feedbackTime) {
            this.feedbackTime = feedbackTime;
            return this;
        }

        public Builder tenantName(String tenantName) {
            this.tenantName = tenantName;
            return this;
        }

        public Builder feedbackType(Integer feedbackType) {
            this.feedbackType = feedbackType;
            return this;
        }

        public Builder feedbackType(com.larksuite.oapi.service.application.v6.enums.OpenFeedbackTypeEnum feedbackType) {
            this.feedbackType = feedbackType.getValue();
            return this;
        }

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder status(com.larksuite.oapi.service.application.v6.enums.OpenMarkStatusEnum status) {
            this.status = status.getValue();
            return this;
        }

        public Builder faultType(Integer[] faultType) {
            this.faultType = faultType;
            return this;
        }

        public Builder faultTime(String faultTime) {
            this.faultTime = faultTime;
            return this;
        }

        public Builder source(Integer source) {
            this.source = source;
            return this;
        }

        public Builder source(com.larksuite.oapi.service.application.v6.enums.OpenFeedbackSourceEnum source) {
            this.source = source.getValue();
            return this;
        }

        public Builder contact(String contact) {
            this.contact = contact;
            return this;
        }

        public Builder updateTime(String updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder operatorId(String operatorId) {
            this.operatorId = operatorId;
            return this;
        }

        public Builder images(String[] images) {
            this.images = images;
            return this;
        }


        public ApplicationFeedback build() {
            return new ApplicationFeedback(this);
        }
    }
}
