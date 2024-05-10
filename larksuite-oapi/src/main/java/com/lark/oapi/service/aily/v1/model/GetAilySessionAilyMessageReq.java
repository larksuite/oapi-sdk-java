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

package com.lark.oapi.service.aily.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.aily.v1.enums.*;
import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.response.BaseResponse;

public class GetAilySessionAilyMessageReq {
    /**
     * 会话 ID
     * <p> 示例值：session_4dfunz7sp1g8m
     */
    @Path
    @SerializedName("aily_session_id")
    private String ailySessionId;
    /**
     * 消息 ID
     * <p> 示例值：message_4df45f2xknvcc
     */
    @Path
    @SerializedName("aily_message_id")
    private String ailyMessageId;

    // builder 开始
    public GetAilySessionAilyMessageReq() {
    }

    public GetAilySessionAilyMessageReq(Builder builder) {
        /**
         * 会话 ID
         * <p> 示例值：session_4dfunz7sp1g8m
         */
        this.ailySessionId = builder.ailySessionId;
        /**
         * 消息 ID
         * <p> 示例值：message_4df45f2xknvcc
         */
        this.ailyMessageId = builder.ailyMessageId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getAilySessionId() {
        return this.ailySessionId;
    }

    public void setAilySessionId(String ailySessionId) {
        this.ailySessionId = ailySessionId;
    }

    public String getAilyMessageId() {
        return this.ailyMessageId;
    }

    public void setAilyMessageId(String ailyMessageId) {
        this.ailyMessageId = ailyMessageId;
    }

    public static class Builder {

        private String ailySessionId; // 会话 ID
        private String ailyMessageId; // 消息 ID

        /**
         * 会话 ID
         * <p> 示例值：session_4dfunz7sp1g8m
         *
         * @param ailySessionId
         * @return
         */
        public Builder ailySessionId(String ailySessionId) {
            this.ailySessionId = ailySessionId;
            return this;
        }


        /**
         * 消息 ID
         * <p> 示例值：message_4df45f2xknvcc
         *
         * @param ailyMessageId
         * @return
         */
        public Builder ailyMessageId(String ailyMessageId) {
            this.ailyMessageId = ailyMessageId;
            return this;
        }

        public GetAilySessionAilyMessageReq build() {
            return new GetAilySessionAilyMessageReq(this);
        }
    }
}
