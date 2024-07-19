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

package com.lark.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;

public class MessagePostEmotion extends MessagePostElement {

    @SerializedName("emoji_type")
    private String emoji_type;

    public MessagePostEmotion() {
        tag = "emotion";
    }

    public MessagePostEmotion(Builder builder) {
        tag = "emotion";
        this.emoji_type = builder.emoji_type;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getEmojiType() {
        return emoji_type;
    }

    public void setEmojiType(String emoji_type) {
        this.emoji_type = emoji_type;
    }

    @Override
    String getTag() {
        return this.tag;
    }

    public static class Builder {

        private String emoji_type;

        public Builder emoji_type(String emoji_type) {
            this.emoji_type = emoji_type;
            return this;
        }

        public MessagePostEmotion build() {
            return new MessagePostEmotion(this);
        }
    }
}
