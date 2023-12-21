package com.lark.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.card.model.IMessageCardActionElement;
import com.lark.oapi.card.model.IMessageCardElement;
import com.lark.oapi.card.model.MessageCardElement;
import com.lark.oapi.service.im.v1.enums.ext.MessageCardBackgroundStyleEnum;
import com.lark.oapi.service.im.v1.enums.ext.MessageCardHorizontalSpacingEnum;
import com.lark.oapi.service.im.v1.enums.ext.MessageCardLayoutFlexModeEnum;

/**
 * 消息卡片多列布局
 */
public class MessageCardLayout extends MessageCardElement implements IMessageCardElement {

    @SerializedName("flex_mode")
    private String flexMode;

    @SerializedName("background_style")
    private String backgroundStyle;

    @SerializedName("horizontal_spacing")
    private String horizontalSpacing;

    @SerializedName("columns")
    private MessageCardLayoutColumn[] columns;

    @SerializedName("action")
    private IMessageCardActionElement action;

    public MessageCardLayout() {
        this.tag = "column_set";
    }

    public MessageCardLayout(Builder builder) {
        this.tag = "column_set";
        this.flexMode = builder.flexMode;
        this.backgroundStyle = builder.backgroundStyle;
        this.horizontalSpacing = builder.horizontalSpacing;
        this.columns = builder.columns;
        this.action = builder.action;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private String flexMode;
        private String backgroundStyle;
        private String horizontalSpacing;
        private MessageCardLayoutColumn[] columns;
        private IMessageCardActionElement action;

        public Builder flexMode(String flexMode) {
            this.flexMode = flexMode;
            return this;
        }

        public Builder flexMode(MessageCardLayoutFlexModeEnum flexMode) {
            this.flexMode = flexMode.getValue();
            return this;
        }

        public Builder backgroundStyle(String backgroundStyle) {
            this.backgroundStyle = backgroundStyle;
            return this;
        }

        public Builder backgroundStyle(MessageCardBackgroundStyleEnum backgroundStyle) {
            this.backgroundStyle = backgroundStyle.getValue();
            return this;
        }

        public Builder horizontalSpacing(String horizontalSpacing) {
            this.horizontalSpacing = horizontalSpacing;
            return this;
        }

        public Builder horizontalSpacing(MessageCardHorizontalSpacingEnum horizontalSpacing) {
            this.horizontalSpacing = horizontalSpacing.getValue();
            return this;
        }

        public Builder columns(MessageCardLayoutColumn[] columns) {
            this.columns = columns;
            return this;
        }

        public Builder action(IMessageCardActionElement action) {
            this.action = action;
            return this;
        }

        public MessageCardLayout build() {
            return new MessageCardLayout(this);
        }
    }
}
