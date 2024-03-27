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

package com.lark.oapi.service.task.v2.model;

import com.google.gson.annotations.SerializedName;

public class PatchCustomFieldOptionReqBody {
    /**
     * 要更新的option数据
     * <p> 示例值：
     */
    @SerializedName("option")
    private InputOption option;
    /**
     * 要更新的字段名，支持name,color,is_hidden,insert_before,insert_after
     * <p> 示例值：
     */
    @SerializedName("update_fields")
    private String[] updateFields;

    // builder 开始
    public PatchCustomFieldOptionReqBody() {
    }

    public PatchCustomFieldOptionReqBody(Builder builder) {
        /**
         * 要更新的option数据
         * <p> 示例值：
         */
        this.option = builder.option;
        /**
         * 要更新的字段名，支持name,color,is_hidden,insert_before,insert_after
         * <p> 示例值：
         */
        this.updateFields = builder.updateFields;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public InputOption getOption() {
        return this.option;
    }

    public void setOption(InputOption option) {
        this.option = option;
    }

    public String[] getUpdateFields() {
        return this.updateFields;
    }

    public void setUpdateFields(String[] updateFields) {
        this.updateFields = updateFields;
    }

    public static class Builder {
        /**
         * 要更新的option数据
         * <p> 示例值：
         */
        private InputOption option;
        /**
         * 要更新的字段名，支持name,color,is_hidden,insert_before,insert_after
         * <p> 示例值：
         */
        private String[] updateFields;

        /**
         * 要更新的option数据
         * <p> 示例值：
         *
         * @param option
         * @return
         */
        public Builder option(InputOption option) {
            this.option = option;
            return this;
        }


        /**
         * 要更新的字段名，支持name,color,is_hidden,insert_before,insert_after
         * <p> 示例值：
         *
         * @param updateFields
         * @return
         */
        public Builder updateFields(String[] updateFields) {
            this.updateFields = updateFields;
            return this;
        }


        public PatchCustomFieldOptionReqBody build() {
            return new PatchCustomFieldOptionReqBody(this);
        }
    }
}
