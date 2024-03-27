// Code generated by lark suite oapi sdk gen
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

package com.lark.oapi.service.okr.v1.model;

import com.google.gson.annotations.SerializedName;

public class UpdateProgressRecordReqBody {
    /**
     * 进展详情 富文本格式
     * <p> 示例值：
     */
    @SerializedName("content")
    private ContentBlock content;

    // builder 开始
    public UpdateProgressRecordReqBody() {
    }

    public UpdateProgressRecordReqBody(Builder builder) {
        /**
         * 进展详情 富文本格式
         * <p> 示例值：
         */
        this.content = builder.content;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public ContentBlock getContent() {
        return this.content;
    }

    public void setContent(ContentBlock content) {
        this.content = content;
    }

    public static class Builder {
        /**
         * 进展详情 富文本格式
         * <p> 示例值：
         */
        private ContentBlock content;

        /**
         * 进展详情 富文本格式
         * <p> 示例值：
         *
         * @param content
         * @return
         */
        public Builder content(ContentBlock content) {
            this.content = content;
            return this;
        }


        public UpdateProgressRecordReqBody build() {
            return new UpdateProgressRecordReqBody(this);
        }
    }
}
