// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;

public class BitableTableRecordActionField {
    @SerializedName("field_id")
    private String fieldId;
    @SerializedName("field_value")
    private String fieldValue;

    // builder 开始
    public BitableTableRecordActionField() {
    }

    public BitableTableRecordActionField(Builder builder) {
        this.fieldId = builder.fieldId;
        this.fieldValue = builder.fieldValue;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getFieldId() {
        return this.fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldValue() {
        return this.fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public static class Builder {
        private String fieldId;
        private String fieldValue;

        public Builder fieldId(String fieldId) {
            this.fieldId = fieldId;
            return this;
        }

        public Builder fieldValue(String fieldValue) {
            this.fieldValue = fieldValue;
            return this;
        }


        public BitableTableRecordActionField build() {
            return new BitableTableRecordActionField(this);
        }
    }
}