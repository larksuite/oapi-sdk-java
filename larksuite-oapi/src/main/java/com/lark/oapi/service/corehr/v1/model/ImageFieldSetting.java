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

package com.lark.oapi.service.corehr.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.corehr.v1.enums.*;
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

public class ImageFieldSetting {
    /**
     * 图片类型枚举，具体如下：;1. Avatar 头像;2. BadgePhoto 工卡照片;3. Logo 标志
     * <p> 示例值：1
     */
    @SerializedName("image_type")
    private Integer imageType;
    /**
     * 显示样式枚举，具体如下：;1. SquareImage 方形;2. RoundImage  圆形
     * <p> 示例值：1
     */
    @SerializedName("display_style")
    private Integer displayStyle;

    // builder 开始
    public ImageFieldSetting() {
    }

    public ImageFieldSetting(Builder builder) {
        /**
         * 图片类型枚举，具体如下：;1. Avatar 头像;2. BadgePhoto 工卡照片;3. Logo 标志
         * <p> 示例值：1
         */
        this.imageType = builder.imageType;
        /**
         * 显示样式枚举，具体如下：;1. SquareImage 方形;2. RoundImage  圆形
         * <p> 示例值：1
         */
        this.displayStyle = builder.displayStyle;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getImageType() {
        return this.imageType;
    }

    public void setImageType(Integer imageType) {
        this.imageType = imageType;
    }

    public Integer getDisplayStyle() {
        return this.displayStyle;
    }

    public void setDisplayStyle(Integer displayStyle) {
        this.displayStyle = displayStyle;
    }

    public static class Builder {
        /**
         * 图片类型枚举，具体如下：;1. Avatar 头像;2. BadgePhoto 工卡照片;3. Logo 标志
         * <p> 示例值：1
         */
        private Integer imageType;
        /**
         * 显示样式枚举，具体如下：;1. SquareImage 方形;2. RoundImage  圆形
         * <p> 示例值：1
         */
        private Integer displayStyle;

        /**
         * 图片类型枚举，具体如下：;1. Avatar 头像;2. BadgePhoto 工卡照片;3. Logo 标志
         * <p> 示例值：1
         *
         * @param imageType
         * @return
         */
        public Builder imageType(Integer imageType) {
            this.imageType = imageType;
            return this;
        }


        /**
         * 显示样式枚举，具体如下：;1. SquareImage 方形;2. RoundImage  圆形
         * <p> 示例值：1
         *
         * @param displayStyle
         * @return
         */
        public Builder displayStyle(Integer displayStyle) {
            this.displayStyle = displayStyle;
            return this;
        }


        public ImageFieldSetting build() {
            return new ImageFieldSetting(this);
        }
    }
}
