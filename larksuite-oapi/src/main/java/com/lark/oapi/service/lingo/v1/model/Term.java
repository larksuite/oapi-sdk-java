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

package com.lark.oapi.service.lingo.v1.model;

import com.google.gson.annotations.SerializedName;

public class Term {
    /**
     * 名称
     * <p> 示例值：企业百科
     */
    @SerializedName("key")
    private String key;
    /**
     * 展示状态
     * <p> 示例值：
     */
    @SerializedName("display_status")
    private DisplayStatus displayStatus;

    // builder 开始
    public Term() {
    }

    public Term(Builder builder) {
        /**
         * 名称
         * <p> 示例值：企业百科
         */
        this.key = builder.key;
        /**
         * 展示状态
         * <p> 示例值：
         */
        this.displayStatus = builder.displayStatus;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public DisplayStatus getDisplayStatus() {
        return this.displayStatus;
    }

    public void setDisplayStatus(DisplayStatus displayStatus) {
        this.displayStatus = displayStatus;
    }

    public static class Builder {
        /**
         * 名称
         * <p> 示例值：企业百科
         */
        private String key;
        /**
         * 展示状态
         * <p> 示例值：
         */
        private DisplayStatus displayStatus;

        /**
         * 名称
         * <p> 示例值：企业百科
         *
         * @param key
         * @return
         */
        public Builder key(String key) {
            this.key = key;
            return this;
        }


        /**
         * 展示状态
         * <p> 示例值：
         *
         * @param displayStatus
         * @return
         */
        public Builder displayStatus(DisplayStatus displayStatus) {
            this.displayStatus = displayStatus;
            return this;
        }


        public Term build() {
            return new Term(this);
        }
    }
}
