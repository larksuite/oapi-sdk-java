/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.card.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.card.enums.MessageCardActionLayoutEnum;

public class MessageCardAction extends MessageCardElement implements IMessageCardElement {

    @SerializedName("actions")
    private IMessageCardActionElement[] actions;
    @SerializedName("layout")
    private String layout;

    private MessageCardAction(Builder builder) {
        actions = builder.actions;
        if (builder.layout != null) {
            layout = builder.layout.getValue();
        }
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
