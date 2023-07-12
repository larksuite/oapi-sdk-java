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

import com.google.gson.annotations.SerializedName;

public class FilterSchema {
    /**
     * 过滤字段的名字
     * <p> 示例值：domain
     */
    @SerializedName("field")
    private String field;
    /**
     * 过滤字段的类型
     * <p> 示例值：list<string>
     */
    @SerializedName("type")
    private String type;
    /**
     * 过滤字段的默认值
     * <p> 示例值：-1
     */
    @SerializedName("default_val")
    private String defaultVal;

    // builder 开始
    public FilterSchema() {
    }

    public FilterSchema(Builder builder) {
        /**
         * 过滤字段的名字
         * <p> 示例值：domain
         */
        this.field = builder.field;
        /**
         * 过滤字段的类型
         * <p> 示例值：list<string>
         */
        this.type = builder.type;
        /**
         * 过滤字段的默认值
         * <p> 示例值：-1
         */
        this.defaultVal = builder.defaultVal;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefaultVal() {
        return this.defaultVal;
    }

    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }

    public static class Builder {
        /**
         * 过滤字段的名字
         * <p> 示例值：domain
         */
        private String field;
        /**
         * 过滤字段的类型
         * <p> 示例值：list<string>
         */
        private String type;
        /**
         * 过滤字段的默认值
         * <p> 示例值：-1
         */
        private String defaultVal;

        /**
         * 过滤字段的名字
         * <p> 示例值：domain
         *
         * @param field
         * @return
         */
        public Builder field(String field) {
            this.field = field;
            return this;
        }


        /**
         * 过滤字段的类型
         * <p> 示例值：list<string>
         *
         * @param type
         * @return
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * 过滤字段的类型
         * <p> 示例值：list<string>
         *
         * @param type {@link com.lark.oapi.service.search.v2.enums.FilterSchemaFilterTypeEnum}
         * @return
         */
        public Builder type(com.lark.oapi.service.search.v2.enums.FilterSchemaFilterTypeEnum type) {
            this.type = type.getValue();
            return this;
        }


        /**
         * 过滤字段的默认值
         * <p> 示例值：-1
         *
         * @param defaultVal
         * @return
         */
        public Builder defaultVal(String defaultVal) {
            this.defaultVal = defaultVal;
            return this;
        }


        public FilterSchema build() {
            return new FilterSchema(this);
        }
    }
}
