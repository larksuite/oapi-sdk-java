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

public class CorrectError {
    /**
     * <p> 示例值：
     */
    @SerializedName("type")
    private Integer type;
    /**
     * 该类型错误在请求时间周期内的累计数量
     * <p> 示例值：
     */
    @SerializedName("total")
    private Integer total;
    /**
     * 该类型错误在周期内具体的纠错对
     * <p> 示例值：
     */
    @SerializedName("correct_pairs")
    private CorrectPair[] correctPairs;

    // builder 开始
    public CorrectError() {
    }

    public CorrectError(Builder builder) {
        /**
         *
         * <p> 示例值：
         */
        this.type = builder.type;
        /**
         * 该类型错误在请求时间周期内的累计数量
         * <p> 示例值：
         */
        this.total = builder.total;
        /**
         * 该类型错误在周期内具体的纠错对
         * <p> 示例值：
         */
        this.correctPairs = builder.correctPairs;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public CorrectPair[] getCorrectPairs() {
        return this.correctPairs;
    }

    public void setCorrectPairs(CorrectPair[] correctPairs) {
        this.correctPairs = correctPairs;
    }

    public static class Builder {
        /**
         * <p> 示例值：
         */
        private Integer type;
        /**
         * 该类型错误在请求时间周期内的累计数量
         * <p> 示例值：
         */
        private Integer total;
        /**
         * 该类型错误在周期内具体的纠错对
         * <p> 示例值：
         */
        private CorrectPair[] correctPairs;

        /**
         * <p> 示例值：
         *
         * @param type
         * @return
         */
        public Builder type(Integer type) {
            this.type = type;
            return this;
        }

        /**
         * <p> 示例值：
         *
         * @param type {@link com.lark.oapi.service.lingo.v1.enums.CorrectErrorCorrectTypeEnum}
         * @return
         */
        public Builder type(com.lark.oapi.service.lingo.v1.enums.CorrectErrorCorrectTypeEnum type) {
            this.type = type.getValue();
            return this;
        }


        /**
         * 该类型错误在请求时间周期内的累计数量
         * <p> 示例值：
         *
         * @param total
         * @return
         */
        public Builder total(Integer total) {
            this.total = total;
            return this;
        }


        /**
         * 该类型错误在周期内具体的纠错对
         * <p> 示例值：
         *
         * @param correctPairs
         * @return
         */
        public Builder correctPairs(CorrectPair[] correctPairs) {
            this.correctPairs = correctPairs;
            return this;
        }


        public CorrectError build() {
            return new CorrectError(this);
        }
    }
}
