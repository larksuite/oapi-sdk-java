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

package com.lark.oapi.service.baike.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.baike.v1.enums.*;
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

public class Phrase {
    /**
     * 识别到的关键词
     * <p> 示例值：企业百科
     */
    @SerializedName("name")
    private String name;
    /**
     * 对应的词条 ID
     * <p> 示例值：
     */
    @SerializedName("entity_ids")
    private String[] entityIds;
    /**
     * 词条所在位置
     * <p> 示例值：
     */
    @SerializedName("span")
    private Span span;

    // builder 开始
    public Phrase() {
    }

    public Phrase(Builder builder) {
        /**
         * 识别到的关键词
         * <p> 示例值：企业百科
         */
        this.name = builder.name;
        /**
         * 对应的词条 ID
         * <p> 示例值：
         */
        this.entityIds = builder.entityIds;
        /**
         * 词条所在位置
         * <p> 示例值：
         */
        this.span = builder.span;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getEntityIds() {
        return this.entityIds;
    }

    public void setEntityIds(String[] entityIds) {
        this.entityIds = entityIds;
    }

    public Span getSpan() {
        return this.span;
    }

    public void setSpan(Span span) {
        this.span = span;
    }

    public static class Builder {
        /**
         * 识别到的关键词
         * <p> 示例值：企业百科
         */
        private String name;
        /**
         * 对应的词条 ID
         * <p> 示例值：
         */
        private String[] entityIds;
        /**
         * 词条所在位置
         * <p> 示例值：
         */
        private Span span;

        /**
         * 识别到的关键词
         * <p> 示例值：企业百科
         *
         * @param name
         * @return
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }


        /**
         * 对应的词条 ID
         * <p> 示例值：
         *
         * @param entityIds
         * @return
         */
        public Builder entityIds(String[] entityIds) {
            this.entityIds = entityIds;
            return this;
        }


        /**
         * 词条所在位置
         * <p> 示例值：
         *
         * @param span
         * @return
         */
        public Builder span(Span span) {
            this.span = span;
            return this;
        }


        public Phrase build() {
            return new Phrase(this);
        }
    }
}
