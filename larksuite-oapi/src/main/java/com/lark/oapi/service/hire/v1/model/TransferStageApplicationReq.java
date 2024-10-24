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

package com.lark.oapi.service.hire.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.response.BaseResponse;

public class TransferStageApplicationReq {
    /**
     * 投递 ID
     * <p> 示例值：6960663240925956401
     */
    @Path
    @SerializedName("application_id")
    private String applicationId;
    @Body
    private TransferStageApplicationReqBody body;

    // builder 开始
    public TransferStageApplicationReq() {
    }

    public TransferStageApplicationReq(Builder builder) {
        /**
         * 投递 ID
         * <p> 示例值：6960663240925956401
         */
        this.applicationId = builder.applicationId;
        this.body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public TransferStageApplicationReqBody getTransferStageApplicationReqBody() {
        return this.body;
    }

    public void setTransferStageApplicationReqBody(TransferStageApplicationReqBody body) {
        this.body = body;
    }

    public static class Builder {

        private String applicationId; // 投递 ID
        private TransferStageApplicationReqBody body;

        /**
         * 投递 ID
         * <p> 示例值：6960663240925956401
         *
         * @param applicationId
         * @return
         */
        public Builder applicationId(String applicationId) {
            this.applicationId = applicationId;
            return this;
        }

        public TransferStageApplicationReqBody getTransferStageApplicationReqBody() {
            return this.body;
        }

        /**
         * body
         *
         * @param body
         * @return
         */
        public Builder transferStageApplicationReqBody(TransferStageApplicationReqBody body) {
            this.body = body;
            return this;
        }

        public TransferStageApplicationReq build() {
            return new TransferStageApplicationReq(this);
        }
    }
}
