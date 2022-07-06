package com.larksuite.oapi.card.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.card.enums.MessageCardButtonTypeEnum;

import java.util.HashMap;
import java.util.Map;

public class MessageCardEmbedButton extends MessageCardElement implements IMessageCardActionElement, IMessageCardExtraElement {
    @SerializedName("text")
    private IMessageCardTextElement text;
    @SerializedName("url")
    private String url;
    @SerializedName("multi_url")
    private MessageCardURL multiUrl;
    @SerializedName("type")
    private MessageCardButtonTypeEnum buttonType;
    @SerializedName("value")
    private Map<String, Object> value = new HashMap<>();
    @SerializedName("confirm")
    private MessageCardActionConfirm confirm;

    public MessageCardEmbedButton() {
        this.tag = "button";
    }

    private MessageCardEmbedButton(Builder builder) {
        text = builder.text;
        url = builder.url;
        multiUrl = builder.multiUrl;
        buttonType = builder.buttonType;
        value = builder.value;
        confirm = builder.confirm;
        tag = "button";
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private String tag;
        private IMessageCardTextElement text;
        private String url;
        private MessageCardURL multiUrl;
        private MessageCardButtonTypeEnum buttonType;
        private Map<String, Object> value;
        private MessageCardActionConfirm confirm;

        private Builder() {
        }

        public Builder tag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder text(IMessageCardTextElement text) {
            this.text = text;
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

        public Builder value(Map<String, Object> value) {
            this.value = value;
            return this;
        }

        public Builder confirm(MessageCardActionConfirm confirm) {
            this.confirm = confirm;
            return this;
        }

        public MessageCardEmbedButton build() {
            return new MessageCardEmbedButton(this);
        }
    }
}
