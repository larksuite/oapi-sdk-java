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

package com.lark.oapi.service.approval.v4.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.approval.v4.enums.*;
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

public class FieldGroup {
    /**
     * 可写权限的表单项的 id列表
     * <p> 示例值：9293493
     */
    @SerializedName("writable")
    private String[] writable;
    /**
     * 可读权限的表单项的 id列表
     * <p> 示例值：9293493
     */
    @SerializedName("readable")
    private String[] readable;

    // builder 开始
    public FieldGroup() {
    }

    public FieldGroup(Builder builder) {
        /**
         * 可写权限的表单项的 id列表
         * <p> 示例值：9293493
         */
        this.writable = builder.writable;
        /**
         * 可读权限的表单项的 id列表
         * <p> 示例值：9293493
         */
        this.readable = builder.readable;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String[] getWritable() {
        return this.writable;
    }

    public void setWritable(String[] writable) {
        this.writable = writable;
    }

    public String[] getReadable() {
        return this.readable;
    }

    public void setReadable(String[] readable) {
        this.readable = readable;
    }

    public static class Builder {
        /**
         * 可写权限的表单项的 id列表
         * <p> 示例值：9293493
         */
        private String[] writable;
        /**
         * 可读权限的表单项的 id列表
         * <p> 示例值：9293493
         */
        private String[] readable;

        /**
         * 可写权限的表单项的 id列表
         * <p> 示例值：9293493
         *
         * @param writable
         * @return
         */
        public Builder writable(String[] writable) {
            this.writable = writable;
            return this;
        }


        /**
         * 可读权限的表单项的 id列表
         * <p> 示例值：9293493
         *
         * @param readable
         * @return
         */
        public Builder readable(String[] readable) {
            this.readable = readable;
            return this;
        }


        public FieldGroup build() {
            return new FieldGroup(this);
        }
    }
}
