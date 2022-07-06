package com.larksuite.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;

public class MessagePostA extends MessagePostElement {
    @SerializedName("text")
    private String text;
    @SerializedName("href")
    private String href;

    public MessagePostA() {
        tag = "a";
    }

    public MessagePostA(Builder builder) {
        tag = "a";
        this.href = builder.href;
        this.text = builder.text;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    String getTag() {
        return this.tag;
    }

    public static class Builder {
        private String text;
        private String href;

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder href(String href) {
            this.href = href;
            return this;
        }

        public MessagePostA build() {
            return new MessagePostA(this);
        }
    }
}
