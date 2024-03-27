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

package com.lark.oapi.service.wiki.v2.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class GetSpaceReq {
    /**
     * 当查询个人文档库时，指定返回的文档库名称展示语言。可选值有：zh, id, de, en, es, fr, it, pt, vi, ru, hi, th, ko, ja, zh-HK, zh-TW。
     * <p> 示例值：zh
     */
    @Query
    @SerializedName("lang")
    private String lang;
    /**
     * 知识空间id
     * <p> 示例值：6870403571079249922
     */
    @Path
    @SerializedName("space_id")
    private String spaceId;

    // builder 开始
    public GetSpaceReq() {
    }

    public GetSpaceReq(Builder builder) {
        /**
         * 当查询个人文档库时，指定返回的文档库名称展示语言。可选值有：zh, id, de, en, es, fr, it, pt, vi, ru, hi, th, ko, ja, zh-HK, zh-TW。
         * <p> 示例值：zh
         */
        this.lang = builder.lang;
        /**
         * 知识空间id
         * <p> 示例值：6870403571079249922
         */
        this.spaceId = builder.spaceId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public static class Builder {
        private String lang; // 当查询个人文档库时，指定返回的文档库名称展示语言。可选值有：zh, id, de, en, es, fr, it, pt, vi, ru, hi, th, ko, ja, zh-HK, zh-TW。
        private String spaceId; // 知识空间id

        /**
         * 当查询个人文档库时，指定返回的文档库名称展示语言。可选值有：zh, id, de, en, es, fr, it, pt, vi, ru, hi, th, ko, ja, zh-HK, zh-TW。
         * <p> 示例值：zh
         *
         * @param lang
         * @return
         */
        public Builder lang(String lang) {
            this.lang = lang;
            return this;
        }

        /**
         * 当查询个人文档库时，指定返回的文档库名称展示语言。可选值有：zh, id, de, en, es, fr, it, pt, vi, ru, hi, th, ko, ja, zh-HK, zh-TW。
         * <p> 示例值：zh
         *
         * @param lang {@link com.lark.oapi.service.wiki.v2.enums.GetSpaceShowLanguageEnum}
         * @return
         */
        public Builder lang(com.lark.oapi.service.wiki.v2.enums.GetSpaceShowLanguageEnum lang) {
            this.lang = lang.getValue();
            return this;
        }

        /**
         * 知识空间id
         * <p> 示例值：6870403571079249922
         *
         * @param spaceId
         * @return
         */
        public Builder spaceId(String spaceId) {
            this.spaceId = spaceId;
            return this;
        }

        public GetSpaceReq build() {
            return new GetSpaceReq(this);
        }
    }
}
