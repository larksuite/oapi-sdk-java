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

package com.lark.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;

public class EventTime {
    /**
     * <p> 示例值：
     */
    @SerializedName("time_stamp")
    private String timeStamp;

    // builder 开始
    public EventTime() {
    }

    public EventTime(Builder builder) {
        /**
         *
         * <p> 示例值：
         */
        this.timeStamp = builder.timeStamp;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public static class Builder {
        /**
         * <p> 示例值：
         */
        private String timeStamp;

        /**
         * <p> 示例值：
         *
         * @param timeStamp
         * @return
         */
        public Builder timeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }


        public EventTime build() {
            return new EventTime(this);
        }
    }
}
