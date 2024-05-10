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

public class MyAiVcMeetingRecapResult {
    /**
     * 会议纪要for快捷指令
     * <p> 示例值：会议纪要内容是xxx，或该会议未打开录制，无法生成纪要
     */
    @SerializedName("meeting_recap_or_fail_reason")
    private String meetingRecapOrFailReason;
    /**
     * 会议纪要for自由对话
     * <p> 示例值：会议纪要内容是xxx
     */
    @SerializedName("meeting_recap")
    private String meetingRecap;

    // builder 开始
    public MyAiVcMeetingRecapResult() {
    }

    public MyAiVcMeetingRecapResult(Builder builder) {
        /**
         * 会议纪要for快捷指令
         * <p> 示例值：会议纪要内容是xxx，或该会议未打开录制，无法生成纪要
         */
        this.meetingRecapOrFailReason = builder.meetingRecapOrFailReason;
        /**
         * 会议纪要for自由对话
         * <p> 示例值：会议纪要内容是xxx
         */
        this.meetingRecap = builder.meetingRecap;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getMeetingRecapOrFailReason() {
        return this.meetingRecapOrFailReason;
    }

    public void setMeetingRecapOrFailReason(String meetingRecapOrFailReason) {
        this.meetingRecapOrFailReason = meetingRecapOrFailReason;
    }

    public String getMeetingRecap() {
        return this.meetingRecap;
    }

    public void setMeetingRecap(String meetingRecap) {
        this.meetingRecap = meetingRecap;
    }

    public static class Builder {
        /**
         * 会议纪要for快捷指令
         * <p> 示例值：会议纪要内容是xxx，或该会议未打开录制，无法生成纪要
         */
        private String meetingRecapOrFailReason;
        /**
         * 会议纪要for自由对话
         * <p> 示例值：会议纪要内容是xxx
         */
        private String meetingRecap;

        /**
         * 会议纪要for快捷指令
         * <p> 示例值：会议纪要内容是xxx，或该会议未打开录制，无法生成纪要
         *
         * @param meetingRecapOrFailReason
         * @return
         */
        public Builder meetingRecapOrFailReason(String meetingRecapOrFailReason) {
            this.meetingRecapOrFailReason = meetingRecapOrFailReason;
            return this;
        }


        /**
         * 会议纪要for自由对话
         * <p> 示例值：会议纪要内容是xxx
         *
         * @param meetingRecap
         * @return
         */
        public Builder meetingRecap(String meetingRecap) {
            this.meetingRecap = meetingRecap;
            return this;
        }


        public MyAiVcMeetingRecapResult build() {
            return new MyAiVcMeetingRecapResult(this);
        }
    }
}
