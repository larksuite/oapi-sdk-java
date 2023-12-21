package com.lark.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.card.model.IMessageCardElement;
import com.lark.oapi.card.model.MessageCardElement;
import com.lark.oapi.card.model.MessageCardURL;
import com.lark.oapi.service.im.v1.enums.ext.MessageCardLayoutTextAlignEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * 多列布局Markdown
 */
public class MessageCardLayoutMarkdown extends MessageCardElement implements IMessageCardElement {

    @SerializedName("text_align")
    private String textAlign;
    @SerializedName("content")
    private String content;
    @SerializedName("href")
    private Map<String, MessageCardURL> href = new HashMap<>();

    public MessageCardLayoutMarkdown() {
        this.tag = "markdown";
    }

    public MessageCardLayoutMarkdown(Builder builder) {
        this.tag = "markdown";
        this.textAlign = builder.textAlign;
        this.content = builder.content;
        this.href = builder.href;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private String textAlign;
        private String content;
        private Map<String, MessageCardURL> href = new HashMap<>();

        public Builder textAlign(String textAlign) {
            this.textAlign = textAlign;
            return this;
        }

        public Builder textAlign(MessageCardLayoutTextAlignEnum textAlign) {
            this.textAlign = textAlign.getValue();
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder href(Map<String, MessageCardURL> href) {
            this.href = href;
            return this;
        }

        public MessageCardLayoutMarkdown build() {
            return new MessageCardLayoutMarkdown(this);
        }

    }
}
