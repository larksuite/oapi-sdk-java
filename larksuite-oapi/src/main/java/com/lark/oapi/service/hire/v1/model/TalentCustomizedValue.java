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
import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.response.BaseResponse;

public class TalentCustomizedValue {
    /**
     * 当字段类型为单行文本、多行文本、模块、默认字段时，从此字段取值
     * <p> 示例值：text
     */
    @SerializedName("content")
    private String content;
    /**
     * 当字段类型为单选时，从此字段取值
     * <p> 示例值：
     */
    @SerializedName("option")
    private TalentCustomizedOption option;
    /**
     * 当字段类型为多选时，从此字段取值
     * <p> 示例值：
     */
    @SerializedName("option_list")
    private TalentCustomizedOption[] optionList;
    /**
     * 当字段类型为时间段时，从此字段取值
     * <p> 示例值：
     */
    @SerializedName("time_range")
    private TalentCustomizedTimeRange timeRange;
    /**
     * 当字段类型为日期选择、月份选择、年份选择时，从此字段取值，该字段是秒级时间戳
     * <p> 示例值：1625456721
     */
    @SerializedName("time")
    private String time;
    /**
     * 当字段类型为数字时，从此字段取值
     * <p> 示例值：111
     */
    @SerializedName("number")
    private String number;
    /**
     * 当字段类型为附件时，从此字段取值
     * <p> 示例值：
     */
    @SerializedName("customized_attachment")
    private TalentCustomizedAttachment[] customizedAttachment;

    // builder 开始
    public TalentCustomizedValue() {
    }

    public TalentCustomizedValue(Builder builder) {
        /**
         * 当字段类型为单行文本、多行文本、模块、默认字段时，从此字段取值
         * <p> 示例值：text
         */
        this.content = builder.content;
        /**
         * 当字段类型为单选时，从此字段取值
         * <p> 示例值：
         */
        this.option = builder.option;
        /**
         * 当字段类型为多选时，从此字段取值
         * <p> 示例值：
         */
        this.optionList = builder.optionList;
        /**
         * 当字段类型为时间段时，从此字段取值
         * <p> 示例值：
         */
        this.timeRange = builder.timeRange;
        /**
         * 当字段类型为日期选择、月份选择、年份选择时，从此字段取值，该字段是秒级时间戳
         * <p> 示例值：1625456721
         */
        this.time = builder.time;
        /**
         * 当字段类型为数字时，从此字段取值
         * <p> 示例值：111
         */
        this.number = builder.number;
        /**
         * 当字段类型为附件时，从此字段取值
         * <p> 示例值：
         */
        this.customizedAttachment = builder.customizedAttachment;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TalentCustomizedOption getOption() {
        return this.option;
    }

    public void setOption(TalentCustomizedOption option) {
        this.option = option;
    }

    public TalentCustomizedOption[] getOptionList() {
        return this.optionList;
    }

    public void setOptionList(TalentCustomizedOption[] optionList) {
        this.optionList = optionList;
    }

    public TalentCustomizedTimeRange getTimeRange() {
        return this.timeRange;
    }

    public void setTimeRange(TalentCustomizedTimeRange timeRange) {
        this.timeRange = timeRange;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public TalentCustomizedAttachment[] getCustomizedAttachment() {
        return this.customizedAttachment;
    }

    public void setCustomizedAttachment(TalentCustomizedAttachment[] customizedAttachment) {
        this.customizedAttachment = customizedAttachment;
    }

    public static class Builder {
        /**
         * 当字段类型为单行文本、多行文本、模块、默认字段时，从此字段取值
         * <p> 示例值：text
         */
        private String content;
        /**
         * 当字段类型为单选时，从此字段取值
         * <p> 示例值：
         */
        private TalentCustomizedOption option;
        /**
         * 当字段类型为多选时，从此字段取值
         * <p> 示例值：
         */
        private TalentCustomizedOption[] optionList;
        /**
         * 当字段类型为时间段时，从此字段取值
         * <p> 示例值：
         */
        private TalentCustomizedTimeRange timeRange;
        /**
         * 当字段类型为日期选择、月份选择、年份选择时，从此字段取值，该字段是秒级时间戳
         * <p> 示例值：1625456721
         */
        private String time;
        /**
         * 当字段类型为数字时，从此字段取值
         * <p> 示例值：111
         */
        private String number;
        /**
         * 当字段类型为附件时，从此字段取值
         * <p> 示例值：
         */
        private TalentCustomizedAttachment[] customizedAttachment;

        /**
         * 当字段类型为单行文本、多行文本、模块、默认字段时，从此字段取值
         * <p> 示例值：text
         *
         * @param content
         * @return
         */
        public Builder content(String content) {
            this.content = content;
            return this;
        }


        /**
         * 当字段类型为单选时，从此字段取值
         * <p> 示例值：
         *
         * @param option
         * @return
         */
        public Builder option(TalentCustomizedOption option) {
            this.option = option;
            return this;
        }


        /**
         * 当字段类型为多选时，从此字段取值
         * <p> 示例值：
         *
         * @param optionList
         * @return
         */
        public Builder optionList(TalentCustomizedOption[] optionList) {
            this.optionList = optionList;
            return this;
        }


        /**
         * 当字段类型为时间段时，从此字段取值
         * <p> 示例值：
         *
         * @param timeRange
         * @return
         */
        public Builder timeRange(TalentCustomizedTimeRange timeRange) {
            this.timeRange = timeRange;
            return this;
        }


        /**
         * 当字段类型为日期选择、月份选择、年份选择时，从此字段取值，该字段是秒级时间戳
         * <p> 示例值：1625456721
         *
         * @param time
         * @return
         */
        public Builder time(String time) {
            this.time = time;
            return this;
        }


        /**
         * 当字段类型为数字时，从此字段取值
         * <p> 示例值：111
         *
         * @param number
         * @return
         */
        public Builder number(String number) {
            this.number = number;
            return this;
        }


        /**
         * 当字段类型为附件时，从此字段取值
         * <p> 示例值：
         *
         * @param customizedAttachment
         * @return
         */
        public Builder customizedAttachment(TalentCustomizedAttachment[] customizedAttachment) {
            this.customizedAttachment = customizedAttachment;
            return this;
        }


        public TalentCustomizedValue build() {
            return new TalentCustomizedValue(this);
        }
    }
}
