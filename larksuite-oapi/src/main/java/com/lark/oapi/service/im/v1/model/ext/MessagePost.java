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
import com.lark.oapi.core.utils.Jsons;

import java.util.List;

public class MessagePost {

    public static Builder newBuilder() {
        return new Builder();
    }

    public static void main(String arg[]) {
        MessagePostA postA1 = MessagePostA.newBuilder().href("www.baidu").text("text1").build();
        MessagePostA postA2 = MessagePostA.newBuilder().href("www.baidu").text("text2").build();

        MessagePostAt at = new MessagePostAt();
        at.setUserId("userid1");
        at.setUserName("userName");

        List<MessagePostElement> segment1 = MessagePostSegment.newBuilder()
                .element(MessagePostA.newBuilder()
                        .href("www.baidu")
                        .text("text1")
                        .build())
                .element(postA2)
                .build();

        List<MessagePostElement> segment2 = MessagePostSegment
                .newBuilder()
                .element(postA1)
                .element(postA2).
                build();

        List<MessagePostElement> segment3 = MessagePostSegment
                .newBuilder()
                .element(at)
                .element(postA2)
                .build();

        String post = MessagePost.newBuilder()
                .zhCn(MessagePostContent.newBuilder()
                        .title("zhcn")
                        .segment(segment1)
                        .segment(segment2)
                        .build())
                .enUs(MessagePostContent.newBuilder()
                        .title("enUs")
                        .segment(segment1)
                        .segment(segment3)
                        .build())
                .build();
        System.out.println(post);

    }

    public static final class Builder {

        @SerializedName("zh_cn")
        private MessagePostContent zhCn;
        @SerializedName("en_us")
        private MessagePostContent enUs;
        @SerializedName("ja_jp")
        private MessagePostContent jaJp;

        public Builder zhCn(MessagePostContent content) {
            this.zhCn = content;
            return this;
        }

        public Builder enUs(MessagePostContent content) {
            this.enUs = content;
            return this;
        }

        public Builder jaJp(MessagePostContent content) {
            this.jaJp = content;
            return this;
        }

        public String build() {
            return Jsons.DEFAULT.toJson(this);
        }

    }

}
