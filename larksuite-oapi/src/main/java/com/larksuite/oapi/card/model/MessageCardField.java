package com.larksuite.oapi.card.model;

import com.google.gson.annotations.SerializedName;

public class MessageCardField {
    @SerializedName("is_short")
    private Boolean isShort;
    @SerializedName("text")
    private IMessageCardTextElement text;

    public MessageCardField(Builder builder) {
        this.isShort = builder.isShort;
        this.text = builder.text;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Boolean isShort;
        private IMessageCardTextElement text;

        public Builder isShort(Boolean isShort) {
            this.isShort = isShort;
            return this;
        }

        public Builder text(IMessageCardTextElement text) {
            this.text = text;
            return this;
        }

        public MessageCardField build() {
            return new MessageCardField(this);
        }
    }

}
