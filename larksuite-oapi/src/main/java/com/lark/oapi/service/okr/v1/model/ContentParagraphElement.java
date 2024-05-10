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

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.okr.v1.enums.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.response.BaseResponse;

public class ContentParagraphElement {
    /**
     * 元素类型
     * <p> 示例值：textRun
     */
    @SerializedName("type")
    private String type;
    /**
     * 文本
     * <p> 示例值：
     */
    @SerializedName("textRun")
    private ContentTextRun textRun;
    /**
     * 飞书云文档
     * <p> 示例值：
     */
    @SerializedName("docsLink")
    private ContentDocsLink docsLink;
    /**
     * 艾特用户
     * <p> 示例值：
     */
    @SerializedName("person")
    private ContentPerson person;

    // builder 开始
    public ContentParagraphElement() {
    }

    public ContentParagraphElement(Builder builder) {
        /**
         * 元素类型
         * <p> 示例值：textRun
         */
        this.type = builder.type;
        /**
         * 文本
         * <p> 示例值：
         */
        this.textRun = builder.textRun;
        /**
         * 飞书云文档
         * <p> 示例值：
         */
        this.docsLink = builder.docsLink;
        /**
         * 艾特用户
         * <p> 示例值：
         */
        this.person = builder.person;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ContentTextRun getTextRun() {
        return this.textRun;
    }

    public void setTextRun(ContentTextRun textRun) {
        this.textRun = textRun;
    }

    public ContentDocsLink getDocsLink() {
        return this.docsLink;
    }

    public void setDocsLink(ContentDocsLink docsLink) {
        this.docsLink = docsLink;
    }

    public ContentPerson getPerson() {
        return this.person;
    }

    public void setPerson(ContentPerson person) {
        this.person = person;
    }

    public static class Builder {
        /**
         * 元素类型
         * <p> 示例值：textRun
         */
        private String type;
        /**
         * 文本
         * <p> 示例值：
         */
        private ContentTextRun textRun;
        /**
         * 飞书云文档
         * <p> 示例值：
         */
        private ContentDocsLink docsLink;
        /**
         * 艾特用户
         * <p> 示例值：
         */
        private ContentPerson person;

        /**
         * 元素类型
         * <p> 示例值：textRun
         *
         * @param type
         * @return
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * 元素类型
         * <p> 示例值：textRun
         *
         * @param type {@link com.lark.oapi.service.okr.v1.enums.ContentParagraphElementTypeEnum}
         * @return
         */
        public Builder type(com.lark.oapi.service.okr.v1.enums.ContentParagraphElementTypeEnum type) {
            this.type = type.getValue();
            return this;
        }


        /**
         * 文本
         * <p> 示例值：
         *
         * @param textRun
         * @return
         */
        public Builder textRun(ContentTextRun textRun) {
            this.textRun = textRun;
            return this;
        }


        /**
         * 飞书云文档
         * <p> 示例值：
         *
         * @param docsLink
         * @return
         */
        public Builder docsLink(ContentDocsLink docsLink) {
            this.docsLink = docsLink;
            return this;
        }


        /**
         * 艾特用户
         * <p> 示例值：
         *
         * @param person
         * @return
         */
        public Builder person(ContentPerson person) {
            this.person = person;
            return this;
        }


        public ContentParagraphElement build() {
            return new ContentParagraphElement(this);
        }
    }
}
