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

package com.lark.oapi.service.search.v2.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.search.v2.enums.*;
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

public class CreateDocParam {
    /**
     * 文档的唯一标识，只允许英文字母、数字和下划线
     * <p> 示例值：3953903108179099667
     */
    @SerializedName("doc_id")
    private String docId;
    /**
     * 文档对应filter_schema的值
     * <p> 示例值：{\"domains\": [\"domain1\"],\"versions\": [\"v1\"]}
     */
    @SerializedName("filter_data")
    private String filterData;
    /**
     * 需要向量化的文本内容
     * <p> 示例值：这是一段纯文本内容，模型会将这段话变成向量
     */
    @SerializedName("content")
    private String content;
    /**
     * 文本块列表
     * <p> 示例值：
     */
    @SerializedName("chunks")
    private String[] chunks;
    /**
     * 如果文本块超过最大长度的话，确定返回错误还是进行截断，默认是返回错误
     * <p> 示例值：1
     */
    @SerializedName("overlength_handle_type")
    private Integer overlengthHandleType;

    // builder 开始
    public CreateDocParam() {
    }

    public CreateDocParam(Builder builder) {
        /**
         * 文档的唯一标识，只允许英文字母、数字和下划线
         * <p> 示例值：3953903108179099667
         */
        this.docId = builder.docId;
        /**
         * 文档对应filter_schema的值
         * <p> 示例值：{\"domains\": [\"domain1\"],\"versions\": [\"v1\"]}
         */
        this.filterData = builder.filterData;
        /**
         * 需要向量化的文本内容
         * <p> 示例值：这是一段纯文本内容，模型会将这段话变成向量
         */
        this.content = builder.content;
        /**
         * 文本块列表
         * <p> 示例值：
         */
        this.chunks = builder.chunks;
        /**
         * 如果文本块超过最大长度的话，确定返回错误还是进行截断，默认是返回错误
         * <p> 示例值：1
         */
        this.overlengthHandleType = builder.overlengthHandleType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getDocId() {
        return this.docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getFilterData() {
        return this.filterData;
    }

    public void setFilterData(String filterData) {
        this.filterData = filterData;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String[] getChunks() {
        return this.chunks;
    }

    public void setChunks(String[] chunks) {
        this.chunks = chunks;
    }

    public Integer getOverlengthHandleType() {
        return this.overlengthHandleType;
    }

    public void setOverlengthHandleType(Integer overlengthHandleType) {
        this.overlengthHandleType = overlengthHandleType;
    }

    public static class Builder {
        /**
         * 文档的唯一标识，只允许英文字母、数字和下划线
         * <p> 示例值：3953903108179099667
         */
        private String docId;
        /**
         * 文档对应filter_schema的值
         * <p> 示例值：{\"domains\": [\"domain1\"],\"versions\": [\"v1\"]}
         */
        private String filterData;
        /**
         * 需要向量化的文本内容
         * <p> 示例值：这是一段纯文本内容，模型会将这段话变成向量
         */
        private String content;
        /**
         * 文本块列表
         * <p> 示例值：
         */
        private String[] chunks;
        /**
         * 如果文本块超过最大长度的话，确定返回错误还是进行截断，默认是返回错误
         * <p> 示例值：1
         */
        private Integer overlengthHandleType;

        /**
         * 文档的唯一标识，只允许英文字母、数字和下划线
         * <p> 示例值：3953903108179099667
         *
         * @param docId
         * @return
         */
        public Builder docId(String docId) {
            this.docId = docId;
            return this;
        }


        /**
         * 文档对应filter_schema的值
         * <p> 示例值：{\"domains\": [\"domain1\"],\"versions\": [\"v1\"]}
         *
         * @param filterData
         * @return
         */
        public Builder filterData(String filterData) {
            this.filterData = filterData;
            return this;
        }


        /**
         * 需要向量化的文本内容
         * <p> 示例值：这是一段纯文本内容，模型会将这段话变成向量
         *
         * @param content
         * @return
         */
        public Builder content(String content) {
            this.content = content;
            return this;
        }


        /**
         * 文本块列表
         * <p> 示例值：
         *
         * @param chunks
         * @return
         */
        public Builder chunks(String[] chunks) {
            this.chunks = chunks;
            return this;
        }


        /**
         * 如果文本块超过最大长度的话，确定返回错误还是进行截断，默认是返回错误
         * <p> 示例值：1
         *
         * @param overlengthHandleType
         * @return
         */
        public Builder overlengthHandleType(Integer overlengthHandleType) {
            this.overlengthHandleType = overlengthHandleType;
            return this;
        }

        /**
         * 如果文本块超过最大长度的话，确定返回错误还是进行截断，默认是返回错误
         * <p> 示例值：1
         *
         * @param overlengthHandleType {@link com.lark.oapi.service.search.v2.enums.CreateDocParamOverlengthHandleTypeEnum}
         * @return
         */
        public Builder overlengthHandleType(com.lark.oapi.service.search.v2.enums.CreateDocParamOverlengthHandleTypeEnum overlengthHandleType) {
            this.overlengthHandleType = overlengthHandleType.getValue();
            return this;
        }


        public CreateDocParam build() {
            return new CreateDocParam(this);
        }
    }
}
