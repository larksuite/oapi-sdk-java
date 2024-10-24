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

package com.lark.oapi.service.document_ai.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.document_ai.v1.enums.*;
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

public class ImageDetail {
    /**
     * 图片完整内容base64字符串
     * <p> 示例值：MTEx
     */
    @SerializedName("base64")
    private String base64;
    /**
     * 图片描述，目前为当前图片的前一段和后一段\n拼接
     * <p> 示例值：这是一个示例
     */
    @SerializedName("caption")
    private String caption;
    /**
     * 图片url
     * <p> 示例值：
     */
    @SerializedName("links")
    private String[] links;

    // builder 开始
    public ImageDetail() {
    }

    public ImageDetail(Builder builder) {
        /**
         * 图片完整内容base64字符串
         * <p> 示例值：MTEx
         */
        this.base64 = builder.base64;
        /**
         * 图片描述，目前为当前图片的前一段和后一段\n拼接
         * <p> 示例值：这是一个示例
         */
        this.caption = builder.caption;
        /**
         * 图片url
         * <p> 示例值：
         */
        this.links = builder.links;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getBase64() {
        return this.base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getCaption() {
        return this.caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String[] getLinks() {
        return this.links;
    }

    public void setLinks(String[] links) {
        this.links = links;
    }

    public static class Builder {
        /**
         * 图片完整内容base64字符串
         * <p> 示例值：MTEx
         */
        private String base64;
        /**
         * 图片描述，目前为当前图片的前一段和后一段\n拼接
         * <p> 示例值：这是一个示例
         */
        private String caption;
        /**
         * 图片url
         * <p> 示例值：
         */
        private String[] links;

        /**
         * 图片完整内容base64字符串
         * <p> 示例值：MTEx
         *
         * @param base64
         * @return
         */
        public Builder base64(String base64) {
            this.base64 = base64;
            return this;
        }


        /**
         * 图片描述，目前为当前图片的前一段和后一段\n拼接
         * <p> 示例值：这是一个示例
         *
         * @param caption
         * @return
         */
        public Builder caption(String caption) {
            this.caption = caption;
            return this;
        }


        /**
         * 图片url
         * <p> 示例值：
         *
         * @param links
         * @return
         */
        public Builder links(String[] links) {
            this.links = links;
            return this;
        }


        public ImageDetail build() {
            return new ImageDetail(this);
        }
    }
}
