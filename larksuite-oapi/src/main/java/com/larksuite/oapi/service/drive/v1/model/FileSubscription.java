// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;

public class FileSubscription {
    @SerializedName("subscription_id")
    private String subscriptionId;
    @SerializedName("subscription_type")
    private String subscriptionType;
    @SerializedName("is_subcribe")
    private Boolean isSubcribe;
    @SerializedName("file_type")
    private String fileType;

    // builder 开始
    public FileSubscription() {
    }

    public FileSubscription(Builder builder) {
        this.subscriptionId = builder.subscriptionId;
        this.subscriptionType = builder.subscriptionType;
        this.isSubcribe = builder.isSubcribe;
        this.fileType = builder.fileType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getSubscriptionId() {
        return this.subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriptionType() {
        return this.subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Boolean getIsSubcribe() {
        return this.isSubcribe;
    }

    public void setIsSubcribe(Boolean isSubcribe) {
        this.isSubcribe = isSubcribe;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public static class Builder {
        private String subscriptionId;
        private String subscriptionType;
        private Boolean isSubcribe;
        private String fileType;

        public Builder subscriptionId(String subscriptionId) {
            this.subscriptionId = subscriptionId;
            return this;
        }

        public Builder subscriptionType(String subscriptionType) {
            this.subscriptionType = subscriptionType;
            return this;
        }

        public Builder subscriptionType(com.larksuite.oapi.service.drive.v1.enums.SubscriptionTypeEnum subscriptionType) {
            this.subscriptionType = subscriptionType.getValue();
            return this;
        }

        public Builder isSubcribe(Boolean isSubcribe) {
            this.isSubcribe = isSubcribe;
            return this;
        }

        public Builder fileType(String fileType) {
            this.fileType = fileType;
            return this;
        }

        public Builder fileType(com.larksuite.oapi.service.drive.v1.enums.FileTypeEnum fileType) {
            this.fileType = fileType.getValue();
            return this;
        }


        public FileSubscription build() {
            return new FileSubscription(this);
        }
    }
}
