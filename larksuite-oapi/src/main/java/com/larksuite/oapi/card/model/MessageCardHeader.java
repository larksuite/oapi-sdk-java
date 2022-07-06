package com.larksuite.oapi.card.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.card.enums.MessageCardHeaderTemplateEnum;

public class MessageCardHeader {
    @SerializedName("template")
    private String template;
    @SerializedName("title")
    private MessageCardPlainText title;

    public MessageCardHeader(Builder builder) {
        this.template = builder.template;
        this.title = builder.title;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String template;
        private MessageCardPlainText title;

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder template(MessageCardHeaderTemplateEnum template) {
            this.template = template.getValue();
            return this;
        }

        public Builder title(MessageCardPlainText title) {
            this.title = title;
            return this;
        }

        public MessageCardHeader build() {
            return new MessageCardHeader(this);
        }
    }
}
