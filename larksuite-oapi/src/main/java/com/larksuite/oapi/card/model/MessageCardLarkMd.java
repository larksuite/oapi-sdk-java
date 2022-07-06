package com.larksuite.oapi.card.model;

import com.google.gson.annotations.SerializedName;

public class MessageCardLarkMd extends MessageCardElement implements IMessageCardTextElement, IMessageCardExtraElement, IMessageCardNoteElement {
    @SerializedName("content")
    private String content;

    public MessageCardLarkMd() {
        this.tag = "lark_md";
    }

    public MessageCardLarkMd(Builder builder) {
        this.tag = "lark_md";
        this.content = builder.content;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String content;

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public MessageCardLarkMd build() {
            return new MessageCardLarkMd(this);
        }

    }
}
