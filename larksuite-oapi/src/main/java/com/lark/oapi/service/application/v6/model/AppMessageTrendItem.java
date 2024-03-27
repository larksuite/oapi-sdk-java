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

package com.lark.oapi.service.application.v6.model;

import com.google.gson.annotations.SerializedName;

public class AppMessageTrendItem {
    /**
     * 聊天类型，private：私聊；group：群聊
     * <p> 示例值：
     */
    @SerializedName("chat_type")
    private String chatType;
    /**
     * 消息事件类型,message_send:已发送消息;bot_notify_get_message:bot 通知收到消息;message_read:消息已读
     * <p> 示例值：
     */
    @SerializedName("event_type")
    private String eventType;
    /**
     * 消息类型，大小写不敏感，text：文本消息；image：图片消息；interactive：卡片消息；post：富文本消息；share_chat：群名片
     * <p> 示例值：
     */
    @SerializedName("message_type")
    private String messageType;
    /**
     * <p> 示例值：
     */
    @SerializedName("trend")
    private UsageTrendItem[] trend;

    // builder 开始
    public AppMessageTrendItem() {
    }

    public AppMessageTrendItem(Builder builder) {
        /**
         * 聊天类型，private：私聊；group：群聊
         * <p> 示例值：
         */
        this.chatType = builder.chatType;
        /**
         * 消息事件类型,message_send:已发送消息;bot_notify_get_message:bot 通知收到消息;message_read:消息已读
         * <p> 示例值：
         */
        this.eventType = builder.eventType;
        /**
         * 消息类型，大小写不敏感，text：文本消息；image：图片消息；interactive：卡片消息；post：富文本消息；share_chat：群名片
         * <p> 示例值：
         */
        this.messageType = builder.messageType;
        /**
         *
         * <p> 示例值：
         */
        this.trend = builder.trend;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getChatType() {
        return this.chatType;
    }

    public void setChatType(String chatType) {
        this.chatType = chatType;
    }

    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public UsageTrendItem[] getTrend() {
        return this.trend;
    }

    public void setTrend(UsageTrendItem[] trend) {
        this.trend = trend;
    }

    public static class Builder {
        /**
         * 聊天类型，private：私聊；group：群聊
         * <p> 示例值：
         */
        private String chatType;
        /**
         * 消息事件类型,message_send:已发送消息;bot_notify_get_message:bot 通知收到消息;message_read:消息已读
         * <p> 示例值：
         */
        private String eventType;
        /**
         * 消息类型，大小写不敏感，text：文本消息；image：图片消息；interactive：卡片消息；post：富文本消息；share_chat：群名片
         * <p> 示例值：
         */
        private String messageType;
        /**
         * <p> 示例值：
         */
        private UsageTrendItem[] trend;

        /**
         * 聊天类型，private：私聊；group：群聊
         * <p> 示例值：
         *
         * @param chatType
         * @return
         */
        public Builder chatType(String chatType) {
            this.chatType = chatType;
            return this;
        }

        /**
         * 聊天类型，private：私聊；group：群聊
         * <p> 示例值：
         *
         * @param chatType {@link com.lark.oapi.service.application.v6.enums.AppMessageTrendItemChatTypeEnum}
         * @return
         */
        public Builder chatType(com.lark.oapi.service.application.v6.enums.AppMessageTrendItemChatTypeEnum chatType) {
            this.chatType = chatType.getValue();
            return this;
        }


        /**
         * 消息事件类型,message_send:已发送消息;bot_notify_get_message:bot 通知收到消息;message_read:消息已读
         * <p> 示例值：
         *
         * @param eventType
         * @return
         */
        public Builder eventType(String eventType) {
            this.eventType = eventType;
            return this;
        }

        /**
         * 消息事件类型,message_send:已发送消息;bot_notify_get_message:bot 通知收到消息;message_read:消息已读
         * <p> 示例值：
         *
         * @param eventType {@link com.lark.oapi.service.application.v6.enums.AppMessageTrendItemEventTypeEnum}
         * @return
         */
        public Builder eventType(com.lark.oapi.service.application.v6.enums.AppMessageTrendItemEventTypeEnum eventType) {
            this.eventType = eventType.getValue();
            return this;
        }


        /**
         * 消息类型，大小写不敏感，text：文本消息；image：图片消息；interactive：卡片消息；post：富文本消息；share_chat：群名片
         * <p> 示例值：
         *
         * @param messageType
         * @return
         */
        public Builder messageType(String messageType) {
            this.messageType = messageType;
            return this;
        }

        /**
         * 消息类型，大小写不敏感，text：文本消息；image：图片消息；interactive：卡片消息；post：富文本消息；share_chat：群名片
         * <p> 示例值：
         *
         * @param messageType {@link com.lark.oapi.service.application.v6.enums.AppMessageTrendItemMessageTypeEnum}
         * @return
         */
        public Builder messageType(com.lark.oapi.service.application.v6.enums.AppMessageTrendItemMessageTypeEnum messageType) {
            this.messageType = messageType.getValue();
            return this;
        }


        /**
         * <p> 示例值：
         *
         * @param trend
         * @return
         */
        public Builder trend(UsageTrendItem[] trend) {
            this.trend = trend;
            return this;
        }


        public AppMessageTrendItem build() {
            return new AppMessageTrendItem(this);
        }
    }
}
