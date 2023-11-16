package com.lark.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.card.model.IMessageCardElement;
import com.lark.oapi.card.model.MessageCardElement;
import com.lark.oapi.service.ext.enums.MessageCardColumnVerticalAlignEnum;
import com.lark.oapi.service.ext.enums.MessageCardColumnWidthEnum;

/**
 * 消息卡片多列布局子容器
 */
public class MessageCardLayoutColumn extends MessageCardElement implements IMessageCardElement {

    @SerializedName("width")
    private String width;

    @SerializedName("weight")
    private Integer weight;

    @SerializedName("vertical_align")
    private String verticalAlign;

    @SerializedName("elements")
    private MessageCardElement[] elements;

    public MessageCardLayoutColumn() {
        this.tag = "column";
    }
    public MessageCardLayoutColumn(Builder builder) {
        this.tag = "column";
        this.width = builder.width;
        this.weight = builder.weight;
        this.verticalAlign = builder.verticalAlign;
        this.elements = builder.elements;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String width;
        private Integer weight;
        private String verticalAlign;
        private MessageCardElement[] elements;

        public Builder width(String width) {
            this.width = width;
            return this;
        }

        public Builder width(MessageCardColumnWidthEnum width) {
            this.width = width.getValue();
            return this;
        }

        public Builder weight(Integer weight) {
            this.weight = weight;
            return this;
        }

        public Builder verticalAlign(String verticalAlign) {
            this.verticalAlign = verticalAlign;
            return this;
        }

        public Builder verticalAlign(MessageCardColumnVerticalAlignEnum verticalAlign) {
            this.verticalAlign = verticalAlign.getValue();
            return this;
        }

        public Builder columns(MessageCardElement[] elements) {
            this.elements = elements;
            return this;
        }

        public MessageCardLayoutColumn build() {
            return new MessageCardLayoutColumn(this);
        }
    }
}
