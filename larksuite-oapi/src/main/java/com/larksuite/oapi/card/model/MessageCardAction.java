package com.larksuite.oapi.card.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.card.enums.MessageCardActionLayoutEnum;

public class MessageCardAction extends MessageCardElement implements IMessageCardElement {
    @SerializedName("actions")
    private IMessageCardActionElement[] actions;
    @SerializedName("layout")
    private MessageCardActionLayoutEnum layout;

    private MessageCardAction(Builder builder) {
        actions = builder.actions;
        layout = builder.layout;
        tag = "action";
    }

    public MessageCardAction() {
        tag = "action";
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private IMessageCardActionElement[] actions;
        private MessageCardActionLayoutEnum layout;

        private Builder() {
        }

        public Builder actions(IMessageCardActionElement[] actions) {
            this.actions = actions;
            return this;
        }

        public Builder layout(MessageCardActionLayoutEnum layout) {
            this.layout = layout;
            return this;
        }

        public MessageCardAction build() {
            return new MessageCardAction(this);
        }
    }
}
