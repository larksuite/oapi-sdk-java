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

package com.lark.oapi.service.mail.v1.model;

import com.google.gson.annotations.SerializedName;

public class RuleActionItem {
    /**
     * 操作类型
     * <p> 示例值：1
     */
    @SerializedName("type")
    private Integer type;
    /**
     * 当 type 为移动到文件夹时，该字段填文件夹的 id
     * <p> 示例值：283412371233
     */
    @SerializedName("input")
    private String input;

    // builder 开始
    public RuleActionItem() {
    }

    public RuleActionItem(Builder builder) {
        /**
         * 操作类型
         * <p> 示例值：1
         */
        this.type = builder.type;
        /**
         * 当 type 为移动到文件夹时，该字段填文件夹的 id
         * <p> 示例值：283412371233
         */
        this.input = builder.input;
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

    public String getInput() {
        return this.input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public static class Builder {
        /**
         * 操作类型
         * <p> 示例值：1
         */
        private Integer type;
        /**
         * 当 type 为移动到文件夹时，该字段填文件夹的 id
         * <p> 示例值：283412371233
         */
        private String input;

        /**
         * 操作类型
         * <p> 示例值：1
         *
         * @param type
         * @return
         */
        public Builder type(Integer type) {
            this.type = type;
            return this;
        }

        /**
         * 操作类型
         * <p> 示例值：1
         *
         * @param type {@link com.lark.oapi.service.mail.v1.enums.RuleActionItemRuleActionItemTypeEnum}
         * @return
         */
        public Builder type(com.lark.oapi.service.mail.v1.enums.RuleActionItemRuleActionItemTypeEnum type) {
            this.type = type.getValue();
            return this;
        }


        /**
         * 当 type 为移动到文件夹时，该字段填文件夹的 id
         * <p> 示例值：283412371233
         *
         * @param input
         * @return
         */
        public Builder input(String input) {
            this.input = input;
            return this;
        }


        public RuleActionItem build() {
            return new RuleActionItem(this);
        }
    }
}
