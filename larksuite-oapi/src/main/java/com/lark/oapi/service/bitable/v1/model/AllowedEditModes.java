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

package com.lark.oapi.service.bitable.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.bitable.v1.enums.*;
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

public class AllowedEditModes {
    /**
     * 是否允许手动录入
     * <p> 示例值：true
     */
    @SerializedName("manual")
    private Boolean manual;
    /**
     * 是否允许移动端录入
     * <p> 示例值：true
     */
    @SerializedName("scan")
    private Boolean scan;

    // builder 开始
    public AllowedEditModes() {
    }

    public AllowedEditModes(Builder builder) {
        /**
         * 是否允许手动录入
         * <p> 示例值：true
         */
        this.manual = builder.manual;
        /**
         * 是否允许移动端录入
         * <p> 示例值：true
         */
        this.scan = builder.scan;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Boolean getManual() {
        return this.manual;
    }

    public void setManual(Boolean manual) {
        this.manual = manual;
    }

    public Boolean getScan() {
        return this.scan;
    }

    public void setScan(Boolean scan) {
        this.scan = scan;
    }

    public static class Builder {
        /**
         * 是否允许手动录入
         * <p> 示例值：true
         */
        private Boolean manual;
        /**
         * 是否允许移动端录入
         * <p> 示例值：true
         */
        private Boolean scan;

        /**
         * 是否允许手动录入
         * <p> 示例值：true
         *
         * @param manual
         * @return
         */
        public Builder manual(Boolean manual) {
            this.manual = manual;
            return this;
        }


        /**
         * 是否允许移动端录入
         * <p> 示例值：true
         *
         * @param scan
         * @return
         */
        public Builder scan(Boolean scan) {
            this.scan = scan;
            return this;
        }


        public AllowedEditModes build() {
            return new AllowedEditModes(this);
        }
    }
}
