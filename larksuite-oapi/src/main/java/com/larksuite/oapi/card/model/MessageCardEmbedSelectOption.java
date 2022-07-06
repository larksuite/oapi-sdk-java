package com.larksuite.oapi.card.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.card.enums.MessageCardButtonTypeEnum;

public class MessageCardEmbedSelectOption {
    @SerializedName("text")
    private MessageCardPlainText text;
    @SerializedName("value")
    private String value;
    @SerializedName("url")
    private String url;
    @SerializedName("multi_url")
    private MessageCardURL multiUrl;
    @SerializedName("type")
    private MessageCardButtonTypeEnum buttonType;

    private MessageCardEmbedSelectOption(Builder builder) {
        text = builder.text;
        value = builder.value;
        url = builder.url;
        multiUrl = builder.multiUrl;
        buttonType = builder.buttonType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private MessageCardPlainText text;
        private String value;
        private String url;
        private MessageCardURL multiUrl;
        private MessageCardButtonTypeEnum buttonType;

        private Builder() {
        }

        public Builder text(MessageCardPlainText text) {
            this.text = text;
            return this;
        }

        public Builder value(String value) {
            this.value = value;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder multiUrl(MessageCardURL multiUrl) {
            this.multiUrl = multiUrl;
            return this;
        }

        public Builder buttonType(MessageCardButtonTypeEnum buttonType) {
            this.buttonType = buttonType;
            return this;
        }

        public MessageCardEmbedSelectOption build() {
            return new MessageCardEmbedSelectOption(this);
        }
    }
}
