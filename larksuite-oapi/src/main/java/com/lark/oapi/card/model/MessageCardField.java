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

public class MessageCardField {

    @SerializedName("is_short")
    private Boolean isShort;
    @SerializedName("text")
    private IMessageCardTextElement text;

    public MessageCardField(Builder builder) {
        this.isShort = builder.isShort;
        this.text = builder.text;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private Boolean isShort;
        private IMessageCardTextElement text;

        public Builder isShort(Boolean isShort) {
            this.isShort = isShort;
            return this;
        }

        public Builder text(IMessageCardTextElement text) {
            this.text = text;
            return this;
        }

        public MessageCardField build() {
            return new MessageCardField(this);
        }
    }

}
