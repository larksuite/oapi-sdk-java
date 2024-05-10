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

package com.lark.oapi.service.im.v2.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.im.v2.enums.*;
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

public class OpenFeedStatusLabel {
    /**
     * 标签文字
     * <p> 示例值：标签文字
     */
    @SerializedName("text")
    private String text;
    /**
     * 标签类型
     * <p> 示例值：primary
     */
    @SerializedName("type")
    private String type;

    // builder 开始
    public OpenFeedStatusLabel() {
    }

    public OpenFeedStatusLabel(Builder builder) {
        /**
         * 标签文字
         * <p> 示例值：标签文字
         */
        this.text = builder.text;
        /**
         * 标签类型
         * <p> 示例值：primary
         */
        this.type = builder.type;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class Builder {
        /**
         * 标签文字
         * <p> 示例值：标签文字
         */
        private String text;
        /**
         * 标签类型
         * <p> 示例值：primary
         */
        private String type;

        /**
         * 标签文字
         * <p> 示例值：标签文字
         *
         * @param text
         * @return
         */
        public Builder text(String text) {
            this.text = text;
            return this;
        }


        /**
         * 标签类型
         * <p> 示例值：primary
         *
         * @param type
         * @return
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * 标签类型
         * <p> 示例值：primary
         *
         * @param type {@link com.lark.oapi.service.im.v2.enums.OpenFeedStatusLabelTypeEnum}
         * @return
         */
        public Builder type(com.lark.oapi.service.im.v2.enums.OpenFeedStatusLabelTypeEnum type) {
            this.type = type.getValue();
            return this;
        }


        public OpenFeedStatusLabel build() {
            return new OpenFeedStatusLabel(this);
        }
    }
}
