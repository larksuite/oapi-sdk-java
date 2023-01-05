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

public class MessageCardPlainText extends MessageCardElement implements IMessageCardNoteElement,
        IMessageCardTextElement, IMessageCardExtraElement {

    @SerializedName("content")
    private String content;
    @SerializedName("lines")
    private Integer lines;
    @SerializedName("i18n")
    private MessageCardPlainTextI18n i18n;

    public MessageCardPlainText(Builder builder) {
        this.content = builder.content;
        this.lines = builder.lines;
        this.i18n = builder.i18n;
        this.tag = "plain_text";
    }

    public MessageCardPlainText() {
        this.tag = "plain_text";
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private String content;
        private Integer lines;
        private MessageCardPlainTextI18n i18n;

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder lines(Integer lines) {
            this.lines = lines;
            return this;
        }

        public Builder i18n(MessageCardPlainTextI18n i18n) {
            this.i18n = i18n;
            return this;
        }

        public MessageCardPlainText build() {
            return new MessageCardPlainText(this);
        }
    }
}
