package com.lark.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class MessageTemplateData {

    @SerializedName("template_id")
    private String templateId;

    @SerializedName("template_version_name")
    private String templateVersionName;

    @SerializedName("template_variable")
    private Map<String, Object> templateVariable;

    public MessageTemplateData(Builder builder) {
        this.templateId = builder.templateId;
        this.templateVersionName = builder.templateVersionName;
        this.templateVariable = builder.templateVariable;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private String templateId;

        private String templateVersionName;

        private Map<String, Object> templateVariable;

        public Builder templateId(String templateId) {
            this.templateId = templateId;
            return this;
        }

        public Builder templateVersionName(String templateVersionName) {
            this.templateVersionName = templateVersionName;
            return this;
        }

        public Builder templateVariable(Map<String, Object> templateVariable) {
            this.templateVariable = templateVariable;
            return this;
        }

        public MessageTemplateData build() {
            return new MessageTemplateData(this);
        }
    }
}
