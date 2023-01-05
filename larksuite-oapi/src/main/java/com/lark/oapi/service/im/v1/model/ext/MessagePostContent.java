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

import java.util.ArrayList;
import java.util.List;

public class MessagePostContent {

    @SerializedName("title")
    private String title;
    @SerializedName("content")
    private MessagePostElement[][] content;

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private String title;
        private List<List<MessagePostElement>> content = new ArrayList();

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder segment(List<MessagePostElement> segment) {
            content.add(segment);
            return this;
        }

        public MessagePostContent build() {
            MessagePostContent postContent = new MessagePostContent();
            postContent.title = this.title;
            postContent.content = new MessagePostElement[content.size()][];
            int i = 0;
            for (List<MessagePostElement> list : content) {
                postContent.content[i++] = list.toArray(new MessagePostElement[0]);
            }

            return postContent;
        }
    }
}
