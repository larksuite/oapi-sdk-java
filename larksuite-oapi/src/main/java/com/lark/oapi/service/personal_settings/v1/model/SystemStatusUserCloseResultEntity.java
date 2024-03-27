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

package com.lark.oapi.service.personal_settings.v1.model;

import com.google.gson.annotations.SerializedName;

public class SystemStatusUserCloseResultEntity {
    /**
     * 用户ID
     * <p> 示例值：ou_53edd3282dbc2fdbe5c593cfa5ce82ab
     */
    @SerializedName("user_id")
    private String userId;
    /**
     * 关闭结果
     * <p> 示例值：success
     */
    @SerializedName("result")
    private String result;

    // builder 开始
    public SystemStatusUserCloseResultEntity() {
    }

    public SystemStatusUserCloseResultEntity(Builder builder) {
        /**
         * 用户ID
         * <p> 示例值：ou_53edd3282dbc2fdbe5c593cfa5ce82ab
         */
        this.userId = builder.userId;
        /**
         * 关闭结果
         * <p> 示例值：success
         */
        this.result = builder.result;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static class Builder {
        /**
         * 用户ID
         * <p> 示例值：ou_53edd3282dbc2fdbe5c593cfa5ce82ab
         */
        private String userId;
        /**
         * 关闭结果
         * <p> 示例值：success
         */
        private String result;

        /**
         * 用户ID
         * <p> 示例值：ou_53edd3282dbc2fdbe5c593cfa5ce82ab
         *
         * @param userId
         * @return
         */
        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }


        /**
         * 关闭结果
         * <p> 示例值：success
         *
         * @param result
         * @return
         */
        public Builder result(String result) {
            this.result = result;
            return this;
        }

        /**
         * 关闭结果
         * <p> 示例值：success
         *
         * @param result {@link com.lark.oapi.service.personal_settings.v1.enums.SystemStatusUserCloseResultEntitySystemStatusUserCloseResultEnum}
         * @return
         */
        public Builder result(com.lark.oapi.service.personal_settings.v1.enums.SystemStatusUserCloseResultEntitySystemStatusUserCloseResultEnum result) {
            this.result = result.getValue();
            return this;
        }


        public SystemStatusUserCloseResultEntity build() {
            return new SystemStatusUserCloseResultEntity(this);
        }
    }
}
