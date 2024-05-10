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

package com.lark.oapi.service.auth.v3.model;

import com.lark.oapi.core.response.EmptyData;
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

public class ResendAppTicketReqBody {
    /**
     * 应用唯一标识，创建应用后获得
     * <p> 示例值：cli_slkdjalasdkjasd
     */
    @SerializedName("app_id")
    private String appId;
    /**
     * 应用秘钥，创建应用后获得
     * <p> 示例值：dskLLdkasdjlasdKK
     */
    @SerializedName("app_secret")
    private String appSecret;

    // builder 开始
    public ResendAppTicketReqBody() {
    }

    public ResendAppTicketReqBody(Builder builder) {
        /**
         * 应用唯一标识，创建应用后获得
         * <p> 示例值：cli_slkdjalasdkjasd
         */
        this.appId = builder.appId;
        /**
         * 应用秘钥，创建应用后获得
         * <p> 示例值：dskLLdkasdjlasdKK
         */
        this.appSecret = builder.appSecret;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public static class Builder {
        /**
         * 应用唯一标识，创建应用后获得
         * <p> 示例值：cli_slkdjalasdkjasd
         */
        private String appId;
        /**
         * 应用秘钥，创建应用后获得
         * <p> 示例值：dskLLdkasdjlasdKK
         */
        private String appSecret;

        /**
         * 应用唯一标识，创建应用后获得
         * <p> 示例值：cli_slkdjalasdkjasd
         *
         * @param appId
         * @return
         */
        public Builder appId(String appId) {
            this.appId = appId;
            return this;
        }


        /**
         * 应用秘钥，创建应用后获得
         * <p> 示例值：dskLLdkasdjlasdKK
         *
         * @param appSecret
         * @return
         */
        public Builder appSecret(String appSecret) {
            this.appSecret = appSecret;
            return this;
        }


        public ResendAppTicketReqBody build() {
            return new ResendAppTicketReqBody(this);
        }
    }
}
