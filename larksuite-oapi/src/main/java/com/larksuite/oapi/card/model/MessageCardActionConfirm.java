package com.larksuite.oapi.card.model;

import com.google.gson.annotations.SerializedName;

public class MessageCardActionConfirm {
    @SerializedName("title")
    private MessageCardPlainText title;
    @SerializedName("text")
    private MessageCardPlainText text;

    public MessageCardActionConfirm(Builder builder) {
        this.title = builder.title;
        this.text = builder.text;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private MessageCardPlainText title;
        private MessageCardPlainText text;

        public Builder title(MessageCardPlainText title) {
            this.title = title;
            return this;
        }

        public Builder text(MessageCardPlainText text) {
            this.text = text;
            return this;
        }

        public MessageCardActionConfirm build() {
            return new MessageCardActionConfirm(this);
        }
    }
}
