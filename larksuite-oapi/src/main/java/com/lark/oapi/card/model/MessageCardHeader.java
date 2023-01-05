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
import com.lark.oapi.card.enums.MessageCardHeaderTemplateEnum;

public class MessageCardHeader {

    @SerializedName("template")
    private String template;
    @SerializedName("title")
    private MessageCardPlainText title;

    public MessageCardHeader(Builder builder) {
        this.template = builder.template;
        this.title = builder.title;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private String template;
        private MessageCardPlainText title;

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder template(MessageCardHeaderTemplateEnum template) {
            this.template = template.getValue();
            return this;
        }

        public Builder title(MessageCardPlainText title) {
            this.title = title;
            return this;
        }

        public MessageCardHeader build() {
            return new MessageCardHeader(this);
        }
    }
}
