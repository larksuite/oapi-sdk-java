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

package com.lark.oapi.service.mail.v1.model;

import com.google.gson.annotations.SerializedName;

public class EventLog {
    /**
     * 发信人
     * <p> 示例值：abc@example.com
     */
    @SerializedName("mail_from")
    private String mailFrom;
    /**
     * 收信人
     * <p> 示例值：abc@example.com
     */
    @SerializedName("rcpt_to")
    private String rcptTo;
    /**
     * 邮件ID
     * <p> 示例值：abc@example.com
     */
    @SerializedName("smtp_message_id")
    private String smtpMessageId;
    /**
     * 行为类型
     * <p> 示例值：auto_forward
     */
    @SerializedName("event_type")
    private String eventType;
    /**
     * 时间戳
     * <p> 示例值：1706882657
     */
    @SerializedName("timestamp")
    private Integer timestamp;

    // builder 开始
    public EventLog() {
    }

    public EventLog(Builder builder) {
        /**
         * 发信人
         * <p> 示例值：abc@example.com
         */
        this.mailFrom = builder.mailFrom;
        /**
         * 收信人
         * <p> 示例值：abc@example.com
         */
        this.rcptTo = builder.rcptTo;
        /**
         * 邮件ID
         * <p> 示例值：abc@example.com
         */
        this.smtpMessageId = builder.smtpMessageId;
        /**
         * 行为类型
         * <p> 示例值：auto_forward
         */
        this.eventType = builder.eventType;
        /**
         * 时间戳
         * <p> 示例值：1706882657
         */
        this.timestamp = builder.timestamp;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getMailFrom() {
        return this.mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getRcptTo() {
        return this.rcptTo;
    }

    public void setRcptTo(String rcptTo) {
        this.rcptTo = rcptTo;
    }

    public String getSmtpMessageId() {
        return this.smtpMessageId;
    }

    public void setSmtpMessageId(String smtpMessageId) {
        this.smtpMessageId = smtpMessageId;
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Integer getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public static class Builder {
        /**
         * 发信人
         * <p> 示例值：abc@example.com
         */
        private String mailFrom;
        /**
         * 收信人
         * <p> 示例值：abc@example.com
         */
        private String rcptTo;
        /**
         * 邮件ID
         * <p> 示例值：abc@example.com
         */
        private String smtpMessageId;
        /**
         * 行为类型
         * <p> 示例值：auto_forward
         */
        private String eventType;
        /**
         * 时间戳
         * <p> 示例值：1706882657
         */
        private Integer timestamp;

        /**
         * 发信人
         * <p> 示例值：abc@example.com
         *
         * @param mailFrom
         * @return
         */
        public Builder mailFrom(String mailFrom) {
            this.mailFrom = mailFrom;
            return this;
        }


        /**
         * 收信人
         * <p> 示例值：abc@example.com
         *
         * @param rcptTo
         * @return
         */
        public Builder rcptTo(String rcptTo) {
            this.rcptTo = rcptTo;
            return this;
        }


        /**
         * 邮件ID
         * <p> 示例值：abc@example.com
         *
         * @param smtpMessageId
         * @return
         */
        public Builder smtpMessageId(String smtpMessageId) {
            this.smtpMessageId = smtpMessageId;
            return this;
        }


        /**
         * 行为类型
         * <p> 示例值：auto_forward
         *
         * @param eventType
         * @return
         */
        public Builder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        /**
         * 行为类型
         * <p> 示例值：auto_forward
         *
         * @param eventType {@link com.lark.oapi.service.mail.v1.enums.EventLogEventTypeEnum}
         * @return
         */
        public Builder eventType(com.lark.oapi.service.mail.v1.enums.EventLogEventTypeEnum eventType) {
            this.eventType = eventType.getValue();
            return this;
        }


        /**
         * 时间戳
         * <p> 示例值：1706882657
         *
         * @param timestamp
         * @return
         */
        public Builder timestamp(Integer timestamp) {
            this.timestamp = timestamp;
            return this;
        }


        public EventLog build() {
            return new EventLog(this);
        }
    }
}
