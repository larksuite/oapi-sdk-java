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

public class LlmUsage {
    /**
     * 当前输入token的个数
     * <p> 示例值：226
     */
    @SerializedName("prompt_tokens")
    private Integer promptTokens;
    /**
     * 当前输出token的个数
     * <p> 示例值：115
     */
    @SerializedName("completion_tokens")
    private Integer completionTokens;
    /**
     * 输入+输出token的总个数
     * <p> 示例值：341
     */
    @SerializedName("total_tokens")
    private Integer totalTokens;

    // builder 开始
    public LlmUsage() {
    }

    public LlmUsage(Builder builder) {
        /**
         * 当前输入token的个数
         * <p> 示例值：226
         */
        this.promptTokens = builder.promptTokens;
        /**
         * 当前输出token的个数
         * <p> 示例值：115
         */
        this.completionTokens = builder.completionTokens;
        /**
         * 输入+输出token的总个数
         * <p> 示例值：341
         */
        this.totalTokens = builder.totalTokens;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getPromptTokens() {
        return this.promptTokens;
    }

    public void setPromptTokens(Integer promptTokens) {
        this.promptTokens = promptTokens;
    }

    public Integer getCompletionTokens() {
        return this.completionTokens;
    }

    public void setCompletionTokens(Integer completionTokens) {
        this.completionTokens = completionTokens;
    }

    public Integer getTotalTokens() {
        return this.totalTokens;
    }

    public void setTotalTokens(Integer totalTokens) {
        this.totalTokens = totalTokens;
    }

    public static class Builder {
        /**
         * 当前输入token的个数
         * <p> 示例值：226
         */
        private Integer promptTokens;
        /**
         * 当前输出token的个数
         * <p> 示例值：115
         */
        private Integer completionTokens;
        /**
         * 输入+输出token的总个数
         * <p> 示例值：341
         */
        private Integer totalTokens;

        /**
         * 当前输入token的个数
         * <p> 示例值：226
         *
         * @param promptTokens
         * @return
         */
        public Builder promptTokens(Integer promptTokens) {
            this.promptTokens = promptTokens;
            return this;
        }


        /**
         * 当前输出token的个数
         * <p> 示例值：115
         *
         * @param completionTokens
         * @return
         */
        public Builder completionTokens(Integer completionTokens) {
            this.completionTokens = completionTokens;
            return this;
        }


        /**
         * 输入+输出token的总个数
         * <p> 示例值：341
         *
         * @param totalTokens
         * @return
         */
        public Builder totalTokens(Integer totalTokens) {
            this.totalTokens = totalTokens;
            return this;
        }


        public LlmUsage build() {
            return new LlmUsage(this);
        }
    }
}