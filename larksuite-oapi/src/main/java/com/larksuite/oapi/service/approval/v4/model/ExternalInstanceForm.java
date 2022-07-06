// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class ExternalInstanceForm {
    @SerializedName("name")
    private String name;
    @SerializedName("value")
    private String value;

    // builder 开始
    public ExternalInstanceForm() {
    }

    public ExternalInstanceForm(Builder builder) {
        this.name = builder.name;
        this.value = builder.value;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static class Builder {
        private String name;
        private String value;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder value(String value) {
            this.value = value;
            return this;
        }


        public ExternalInstanceForm build() {
            return new ExternalInstanceForm(this);
        }
    }
}
