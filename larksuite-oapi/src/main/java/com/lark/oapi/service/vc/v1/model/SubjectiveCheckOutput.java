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

package com.lark.oapi.service.vc.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.vc.v1.enums.*;
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

public class SubjectiveCheckOutput {
    /**
     * 关键点
     * <p> 示例值：
     */
    @SerializedName("keypoints")
    private String[] keypoints;
    /**
     * 关键点详情
     * <p> 示例值：
     */
    @SerializedName("key_point_match_details")
    private KeyPointMatchDetails[] keyPointMatchDetails;
    /**
     * 用户prompt输出
     * <p> 示例值：
     */
    @SerializedName("user_prompt_outputs")
    private String[] userPromptOutputs;
    /**
     * 状态码
     * <p> 示例值：0
     */
    @SerializedName("status_code")
    private Integer statusCode;

    // builder 开始
    public SubjectiveCheckOutput() {
    }

    public SubjectiveCheckOutput(Builder builder) {
        /**
         * 关键点
         * <p> 示例值：
         */
        this.keypoints = builder.keypoints;
        /**
         * 关键点详情
         * <p> 示例值：
         */
        this.keyPointMatchDetails = builder.keyPointMatchDetails;
        /**
         * 用户prompt输出
         * <p> 示例值：
         */
        this.userPromptOutputs = builder.userPromptOutputs;
        /**
         * 状态码
         * <p> 示例值：0
         */
        this.statusCode = builder.statusCode;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String[] getKeypoints() {
        return this.keypoints;
    }

    public void setKeypoints(String[] keypoints) {
        this.keypoints = keypoints;
    }

    public KeyPointMatchDetails[] getKeyPointMatchDetails() {
        return this.keyPointMatchDetails;
    }

    public void setKeyPointMatchDetails(KeyPointMatchDetails[] keyPointMatchDetails) {
        this.keyPointMatchDetails = keyPointMatchDetails;
    }

    public String[] getUserPromptOutputs() {
        return this.userPromptOutputs;
    }

    public void setUserPromptOutputs(String[] userPromptOutputs) {
        this.userPromptOutputs = userPromptOutputs;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public static class Builder {
        /**
         * 关键点
         * <p> 示例值：
         */
        private String[] keypoints;
        /**
         * 关键点详情
         * <p> 示例值：
         */
        private KeyPointMatchDetails[] keyPointMatchDetails;
        /**
         * 用户prompt输出
         * <p> 示例值：
         */
        private String[] userPromptOutputs;
        /**
         * 状态码
         * <p> 示例值：0
         */
        private Integer statusCode;

        /**
         * 关键点
         * <p> 示例值：
         *
         * @param keypoints
         * @return
         */
        public Builder keypoints(String[] keypoints) {
            this.keypoints = keypoints;
            return this;
        }


        /**
         * 关键点详情
         * <p> 示例值：
         *
         * @param keyPointMatchDetails
         * @return
         */
        public Builder keyPointMatchDetails(KeyPointMatchDetails[] keyPointMatchDetails) {
            this.keyPointMatchDetails = keyPointMatchDetails;
            return this;
        }


        /**
         * 用户prompt输出
         * <p> 示例值：
         *
         * @param userPromptOutputs
         * @return
         */
        public Builder userPromptOutputs(String[] userPromptOutputs) {
            this.userPromptOutputs = userPromptOutputs;
            return this;
        }


        /**
         * 状态码
         * <p> 示例值：0
         *
         * @param statusCode
         * @return
         */
        public Builder statusCode(Integer statusCode) {
            this.statusCode = statusCode;
            return this;
        }


        public SubjectiveCheckOutput build() {
            return new SubjectiveCheckOutput(this);
        }
    }
}
