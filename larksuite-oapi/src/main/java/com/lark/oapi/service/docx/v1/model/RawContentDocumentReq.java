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

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class RawContentDocumentReq {
    /**
     * 语言（用于 MentionUser 语言的选取）
     * <p> 示例值：0
     */
    @Query
    @SerializedName("lang")
    private Integer lang;
    /**
     * 文档的唯一标识
     * <p> 示例值：doxbcmEtbFrbbq10nPNu8gO1F3b
     */
    @Path
    @SerializedName("document_id")
    private String documentId;

    // builder 开始
    public RawContentDocumentReq() {
    }

    public RawContentDocumentReq(Builder builder) {
        /**
         * 语言（用于 MentionUser 语言的选取）
         * <p> 示例值：0
         */
        this.lang = builder.lang;
        /**
         * 文档的唯一标识
         * <p> 示例值：doxbcmEtbFrbbq10nPNu8gO1F3b
         */
        this.documentId = builder.documentId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getLang() {
        return this.lang;
    }

    public void setLang(Integer lang) {
        this.lang = lang;
    }

    public String getDocumentId() {
        return this.documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public static class Builder {
        private Integer lang; // 语言（用于 MentionUser 语言的选取）
        private String documentId; // 文档的唯一标识

        /**
         * 语言（用于 MentionUser 语言的选取）
         * <p> 示例值：0
         *
         * @param lang
         * @return
         */
        public Builder lang(Integer lang) {
            this.lang = lang;
            return this;
        }

        /**
         * 语言（用于 MentionUser 语言的选取）
         * <p> 示例值：0
         *
         * @param lang {@link com.lark.oapi.service.docx.v1.enums.RawContentDocumentLangEnum}
         * @return
         */
        public Builder lang(com.lark.oapi.service.docx.v1.enums.RawContentDocumentLangEnum lang) {
            this.lang = lang.getValue();
            return this;
        }

        /**
         * 文档的唯一标识
         * <p> 示例值：doxbcmEtbFrbbq10nPNu8gO1F3b
         *
         * @param documentId
         * @return
         */
        public Builder documentId(String documentId) {
            this.documentId = documentId;
            return this;
        }

        public RawContentDocumentReq build() {
            return new RawContentDocumentReq(this);
        }
    }
}
