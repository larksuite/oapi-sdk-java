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

package com.lark.oapi.service.docx.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.docx.v1.enums.*;
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

public class Image {
    /**
     * 宽度单位 px
     * <p> 示例值：4069
     */
    @SerializedName("width")
    private Integer width;
    /**
     * 高度
     * <p> 示例值：2480
     */
    @SerializedName("height")
    private Integer height;
    /**
     * 图片 Token
     * <p> 示例值：boxbcVA91JtFgNhaCgy6s6wK4he
     */
    @SerializedName("token")
    private String token;
    /**
     * 对齐方式
     * <p> 示例值：2
     */
    @SerializedName("align")
    private Integer align;

    // builder 开始
    public Image() {
    }

    public Image(Builder builder) {
        /**
         * 宽度单位 px
         * <p> 示例值：4069
         */
        this.width = builder.width;
        /**
         * 高度
         * <p> 示例值：2480
         */
        this.height = builder.height;
        /**
         * 图片 Token
         * <p> 示例值：boxbcVA91JtFgNhaCgy6s6wK4he
         */
        this.token = builder.token;
        /**
         * 对齐方式
         * <p> 示例值：2
         */
        this.align = builder.align;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getWidth() {
        return this.width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getAlign() {
        return this.align;
    }

    public void setAlign(Integer align) {
        this.align = align;
    }

    public static class Builder {
        /**
         * 宽度单位 px
         * <p> 示例值：4069
         */
        private Integer width;
        /**
         * 高度
         * <p> 示例值：2480
         */
        private Integer height;
        /**
         * 图片 Token
         * <p> 示例值：boxbcVA91JtFgNhaCgy6s6wK4he
         */
        private String token;
        /**
         * 对齐方式
         * <p> 示例值：2
         */
        private Integer align;

        /**
         * 宽度单位 px
         * <p> 示例值：4069
         *
         * @param width
         * @return
         */
        public Builder width(Integer width) {
            this.width = width;
            return this;
        }


        /**
         * 高度
         * <p> 示例值：2480
         *
         * @param height
         * @return
         */
        public Builder height(Integer height) {
            this.height = height;
            return this;
        }


        /**
         * 图片 Token
         * <p> 示例值：boxbcVA91JtFgNhaCgy6s6wK4he
         *
         * @param token
         * @return
         */
        public Builder token(String token) {
            this.token = token;
            return this;
        }


        /**
         * 对齐方式
         * <p> 示例值：2
         *
         * @param align
         * @return
         */
        public Builder align(Integer align) {
            this.align = align;
            return this;
        }

        /**
         * 对齐方式
         * <p> 示例值：2
         *
         * @param align {@link com.lark.oapi.service.docx.v1.enums.ImageAlignEnum}
         * @return
         */
        public Builder align(com.lark.oapi.service.docx.v1.enums.ImageAlignEnum align) {
            this.align = align.getValue();
            return this;
        }


        public Image build() {
            return new Image(this);
        }
    }
}
