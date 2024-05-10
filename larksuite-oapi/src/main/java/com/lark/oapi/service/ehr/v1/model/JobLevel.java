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

package com.lark.oapi.service.ehr.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.ehr.v1.enums.*;
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

public class JobLevel {
    /**
     * 职级 ID
     * <p> 示例值：1695838220091399
     */
    @SerializedName("id")
    private Long id;
    /**
     * 职级名称
     * <p> 示例值：CEO
     */
    @SerializedName("name")
    private String name;

    // builder 开始
    public JobLevel() {
    }

    public JobLevel(Builder builder) {
        /**
         * 职级 ID
         * <p> 示例值：1695838220091399
         */
        this.id = builder.id;
        /**
         * 职级名称
         * <p> 示例值：CEO
         */
        this.name = builder.name;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder {
        /**
         * 职级 ID
         * <p> 示例值：1695838220091399
         */
        private Long id;
        /**
         * 职级名称
         * <p> 示例值：CEO
         */
        private String name;

        /**
         * 职级 ID
         * <p> 示例值：1695838220091399
         *
         * @param id
         * @return
         */
        public Builder id(Long id) {
            this.id = id;
            return this;
        }


        /**
         * 职级名称
         * <p> 示例值：CEO
         *
         * @param name
         * @return
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }


        public JobLevel build() {
            return new JobLevel(this);
        }
    }
}
