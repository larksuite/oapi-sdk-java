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

import java.util.HashMap;
import java.util.Map;

public class MessageCardEmbedSelectMenuStatic extends MessageCardElement implements
        IMessageCardActionElement, IMessageCardExtraElement {

    @SerializedName("placeholder")
    protected MessageCardPlainText placeholder;
    @SerializedName("initial_option")
    protected String initialOption;
    @SerializedName("options")
    protected MessageCardEmbedSelectOption[] options;
    @SerializedName("value")
    protected Map<String, Object> value = new HashMap<>();
    @SerializedName("confirm")
    protected MessageCardActionConfirm confirm;

    private MessageCardEmbedSelectMenuStatic(Builder builder) {
        placeholder = builder.placeholder;
        initialOption = builder.initialOption;
        options = builder.options;
        value = builder.value;
        confirm = builder.confirm;
        tag = "select_static";
    }

    public MessageCardEmbedSelectMenuStatic() {
        tag = "select_static";
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private MessageCardPlainText placeholder;
        private String initialOption;
        private MessageCardEmbedSelectOption[] options;
        private Map<String, Object> value;
        private MessageCardActionConfirm confirm;

        private Builder() {
        }

        public Builder placeholder(MessageCardPlainText placeholder) {
            this.placeholder = placeholder;
            return this;
        }

        public Builder initialOption(String initialOption) {
            this.initialOption = initialOption;
            return this;
        }

        public Builder options(MessageCardEmbedSelectOption[] options) {
            this.options = options;
            return this;
        }

        public Builder value(Map<String, Object> value) {
            this.value = value;
            return this;
        }

        public Builder confirm(MessageCardActionConfirm confirm) {
            this.confirm = confirm;
            return this;
        }

        public MessageCardEmbedSelectMenuStatic build() {
            return new MessageCardEmbedSelectMenuStatic(this);
        }
    }
}
