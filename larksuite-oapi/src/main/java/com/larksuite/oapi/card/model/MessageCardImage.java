package com.larksuite.oapi.card.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.card.enums.MessageCardImageModelEnum;

public class MessageCardImage extends MessageCardElement implements IMessageCardElement {
    @SerializedName("alt")
    private MessageCardPlainText alt;
    @SerializedName("title")
    private IMessageCardTextElement title;
    @SerializedName("img_key")
    private String imgKey;
    @SerializedName("custom_width")
    private Integer customWidth;
    @SerializedName("compact_width")
    private Boolean compactWidth;
    @SerializedName("mode")
    private MessageCardImageModelEnum mode;
    @SerializedName("preview")
    private Boolean preview;

    public MessageCardImage() {
        this.tag = "img";
    }

    public MessageCardImage(Builder builder) {
        this.tag = "img";
        this.alt = builder.alt;
        this.compactWidth = builder.compactWidth;
        this.title = builder.title;
        this.imgKey = builder.imgKey;
        this.customWidth = builder.customWidth;
        this.mode = builder.mode;
        this.preview = builder.preview;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private MessageCardPlainText alt;
        private IMessageCardTextElement title;
        private String imgKey;
        private Integer customWidth;
        private Boolean compactWidth;
        private MessageCardImageModelEnum mode;
        private Boolean preview;

        public Builder alt(MessageCardPlainText alt) {
            this.alt = alt;
            return this;
        }

        public Builder title(IMessageCardTextElement title) {
            this.title = title;
            return this;
        }

        public Builder imgKey(String imgKey) {
            this.imgKey = imgKey;
            return this;
        }

        public Builder customWidth(Integer customWidth) {
            this.customWidth = customWidth;
            return this;
        }

        public Builder compactWidth(Boolean compactWidth) {
            this.compactWidth = compactWidth;
            return this;
        }

        public Builder mode(MessageCardImageModelEnum mode) {
            this.mode = mode;
            return this;
        }

        public Builder preview(Boolean preview) {
            this.preview = preview;
            return this;
        }

        public MessageCardImage build() {
            return new MessageCardImage(this);
        }
    }
}
