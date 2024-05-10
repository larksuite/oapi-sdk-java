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

public class ReportTopUser {
    /**
     * 用户ID
     * <p> 示例值：ou_3ec3f6a28a0d08c45d895276e8e5e19b
     */
    @SerializedName("id")
    private String id;
    /**
     * 用户名
     * <p> 示例值：name
     */
    @SerializedName("name")
    private String name;
    /**
     * 用户类型
     * <p> 示例值：1
     */
    @SerializedName("user_type")
    private Integer userType;
    /**
     * 会议数量
     * <p> 示例值：100
     */
    @SerializedName("meeting_count")
    private String meetingCount;
    /**
     * 会议时长（单位min）
     * <p> 示例值：3000
     */
    @SerializedName("meeting_duration")
    private String meetingDuration;

    // builder 开始
    public ReportTopUser() {
    }

    public ReportTopUser(Builder builder) {
        /**
         * 用户ID
         * <p> 示例值：ou_3ec3f6a28a0d08c45d895276e8e5e19b
         */
        this.id = builder.id;
        /**
         * 用户名
         * <p> 示例值：name
         */
        this.name = builder.name;
        /**
         * 用户类型
         * <p> 示例值：1
         */
        this.userType = builder.userType;
        /**
         * 会议数量
         * <p> 示例值：100
         */
        this.meetingCount = builder.meetingCount;
        /**
         * 会议时长（单位min）
         * <p> 示例值：3000
         */
        this.meetingDuration = builder.meetingDuration;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserType() {
        return this.userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getMeetingCount() {
        return this.meetingCount;
    }

    public void setMeetingCount(String meetingCount) {
        this.meetingCount = meetingCount;
    }

    public String getMeetingDuration() {
        return this.meetingDuration;
    }

    public void setMeetingDuration(String meetingDuration) {
        this.meetingDuration = meetingDuration;
    }

    public static class Builder {
        /**
         * 用户ID
         * <p> 示例值：ou_3ec3f6a28a0d08c45d895276e8e5e19b
         */
        private String id;
        /**
         * 用户名
         * <p> 示例值：name
         */
        private String name;
        /**
         * 用户类型
         * <p> 示例值：1
         */
        private Integer userType;
        /**
         * 会议数量
         * <p> 示例值：100
         */
        private String meetingCount;
        /**
         * 会议时长（单位min）
         * <p> 示例值：3000
         */
        private String meetingDuration;

        /**
         * 用户ID
         * <p> 示例值：ou_3ec3f6a28a0d08c45d895276e8e5e19b
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 用户名
         * <p> 示例值：name
         *
         * @param name
         * @return
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }


        /**
         * 用户类型
         * <p> 示例值：1
         *
         * @param userType
         * @return
         */
        public Builder userType(Integer userType) {
            this.userType = userType;
            return this;
        }

        /**
         * 用户类型
         * <p> 示例值：1
         *
         * @param userType {@link com.lark.oapi.service.vc.v1.enums.ReportTopUserUserTypeEnum}
         * @return
         */
        public Builder userType(com.lark.oapi.service.vc.v1.enums.ReportTopUserUserTypeEnum userType) {
            this.userType = userType.getValue();
            return this;
        }


        /**
         * 会议数量
         * <p> 示例值：100
         *
         * @param meetingCount
         * @return
         */
        public Builder meetingCount(String meetingCount) {
            this.meetingCount = meetingCount;
            return this;
        }


        /**
         * 会议时长（单位min）
         * <p> 示例值：3000
         *
         * @param meetingDuration
         * @return
         */
        public Builder meetingDuration(String meetingDuration) {
            this.meetingDuration = meetingDuration;
            return this;
        }


        public ReportTopUser build() {
            return new ReportTopUser(this);
        }
    }
}
