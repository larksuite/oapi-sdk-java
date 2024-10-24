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

public class LlmDetail {
    /**
     * query在原始输入batch中的序号，从0开始
     * <p> 示例值：0
     */
    @SerializedName("query_id")
    private Integer queryId;
    /**
     * 统计输入和输出的token个数
     * <p> 示例值：
     */
    @SerializedName("usage")
    private LlmUsage usage;
    /**
     * 表明模型停止生成的原因，如'length', 'stop'
     * <p> 示例值：stop
     */
    @SerializedName("finish_reason")
    private String finishReason;

    // builder 开始
    public LlmDetail() {
    }

    public LlmDetail(Builder builder) {
        /**
         * query在原始输入batch中的序号，从0开始
         * <p> 示例值：0
         */
        this.queryId = builder.queryId;
        /**
         * 统计输入和输出的token个数
         * <p> 示例值：
         */
        this.usage = builder.usage;
        /**
         * 表明模型停止生成的原因，如'length', 'stop'
         * <p> 示例值：stop
         */
        this.finishReason = builder.finishReason;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getQueryId() {
        return this.queryId;
    }

    public void setQueryId(Integer queryId) {
        this.queryId = queryId;
    }

    public LlmUsage getUsage() {
        return this.usage;
    }

    public void setUsage(LlmUsage usage) {
        this.usage = usage;
    }

    public String getFinishReason() {
        return this.finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    public static class Builder {
        /**
         * query在原始输入batch中的序号，从0开始
         * <p> 示例值：0
         */
        private Integer queryId;
        /**
         * 统计输入和输出的token个数
         * <p> 示例值：
         */
        private LlmUsage usage;
        /**
         * 表明模型停止生成的原因，如'length', 'stop'
         * <p> 示例值：stop
         */
        private String finishReason;

        /**
         * query在原始输入batch中的序号，从0开始
         * <p> 示例值：0
         *
         * @param queryId
         * @return
         */
        public Builder queryId(Integer queryId) {
            this.queryId = queryId;
            return this;
        }


        /**
         * 统计输入和输出的token个数
         * <p> 示例值：
         *
         * @param usage
         * @return
         */
        public Builder usage(LlmUsage usage) {
            this.usage = usage;
            return this;
        }


        /**
         * 表明模型停止生成的原因，如'length', 'stop'
         * <p> 示例值：stop
         *
         * @param finishReason
         * @return
         */
        public Builder finishReason(String finishReason) {
            this.finishReason = finishReason;
            return this;
        }


        public LlmDetail build() {
            return new LlmDetail(this);
        }
    }
}