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

public class Abbreviation {
    /**
     * 相关其他词条 id
     * <p> 示例值：enterprise_51587960
     */
    @SerializedName("id")
    private String id;

    // builder 开始
    public Abbreviation() {
    }

    public Abbreviation(Builder builder) {
        /**
         * 相关其他词条 id
         * <p> 示例值：enterprise_51587960
         */
        this.id = builder.id;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static class Builder {
        /**
         * 相关其他词条 id
         * <p> 示例值：enterprise_51587960
         */
        private String id;

        /**
         * 相关其他词条 id
         * <p> 示例值：enterprise_51587960
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        public Abbreviation build() {
            return new Abbreviation(this);
        }
    }
}
