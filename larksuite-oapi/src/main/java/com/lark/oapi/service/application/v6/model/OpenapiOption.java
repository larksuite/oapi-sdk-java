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

package com.lark.oapi.service.application.v6.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.application.v6.enums.*;
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

public class OpenapiOption {
    /**
     * OpenAPI HTTP method
     * <p> 示例值：GET
     */
    @SerializedName("http_method")
    private String httpMethod;
    /**
     * OpenAPI HTTP URL
     * <p> 示例值：/open-apis/contact/v3/users/:user_id
     */
    @SerializedName("url_pattern")
    private String urlPattern;
    /**
     * 可访问性
     * <p> 示例值：
     */
    @SerializedName("accessibility")
    private Accessibility accessibility;

    // builder 开始
    public OpenapiOption() {
    }

    public OpenapiOption(Builder builder) {
        /**
         * OpenAPI HTTP method
         * <p> 示例值：GET
         */
        this.httpMethod = builder.httpMethod;
        /**
         * OpenAPI HTTP URL
         * <p> 示例值：/open-apis/contact/v3/users/:user_id
         */
        this.urlPattern = builder.urlPattern;
        /**
         * 可访问性
         * <p> 示例值：
         */
        this.accessibility = builder.accessibility;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getUrlPattern() {
        return this.urlPattern;
    }

    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    public Accessibility getAccessibility() {
        return this.accessibility;
    }

    public void setAccessibility(Accessibility accessibility) {
        this.accessibility = accessibility;
    }

    public static class Builder {
        /**
         * OpenAPI HTTP method
         * <p> 示例值：GET
         */
        private String httpMethod;
        /**
         * OpenAPI HTTP URL
         * <p> 示例值：/open-apis/contact/v3/users/:user_id
         */
        private String urlPattern;
        /**
         * 可访问性
         * <p> 示例值：
         */
        private Accessibility accessibility;

        /**
         * OpenAPI HTTP method
         * <p> 示例值：GET
         *
         * @param httpMethod
         * @return
         */
        public Builder httpMethod(String httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }


        /**
         * OpenAPI HTTP URL
         * <p> 示例值：/open-apis/contact/v3/users/:user_id
         *
         * @param urlPattern
         * @return
         */
        public Builder urlPattern(String urlPattern) {
            this.urlPattern = urlPattern;
            return this;
        }


        /**
         * 可访问性
         * <p> 示例值：
         *
         * @param accessibility
         * @return
         */
        public Builder accessibility(Accessibility accessibility) {
            this.accessibility = accessibility;
            return this;
        }


        public OpenapiOption build() {
            return new OpenapiOption(this);
        }
    }
}
