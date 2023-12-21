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

package com.lark.oapi.service.security_and_compliance.v1.model;

import com.google.gson.annotations.SerializedName;

public class DataArchivingMessageStruct {
    /**
     * 消息id
     * <p> 示例值：om_829acd7aaae80c031837ad1946d7cf9f
     */
    @SerializedName("message_id")
    private String messageId;
    /**
     * 消息类型
     * <p> 示例值：1
     */
    @SerializedName("message_type")
    private Integer messageType;
    /**
     * 发送者信息
     * <p> 示例值：
     */
    @SerializedName("sender_info")
    private DataArchivingUserStruct senderInfo;
    /**
     * 接受者信息
     * <p> 示例值：
     */
    @SerializedName("receiver_ids")
    private String[] receiverIds;
    /**
     * 操作类型
     * <p> 示例值：send
     */
    @SerializedName("action_type")
    private String actionType;
    /**
     * 会话ID
     * <p> 示例值：oc_1263d7c4d513defb9f5df13214602aa6
     */
    @SerializedName("chat_id")
    private String chatId;
    /**
     * 消息动作时间戳ms
     * <p> 示例值：1700191599000
     */
    @SerializedName("action_time")
    private String actionTime;
    /**
     * 是否超大群
     * <p> 示例值：true
     */
    @SerializedName("is_super_chat")
    private Boolean isSuperChat;
    /**
     * 是否跨租户群
     * <p> 示例值：true
     */
    @SerializedName("is_cross_tenant_chat")
    private Boolean isCrossTenantChat;
    /**
     * 会话名称
     * <p> 示例值：会话名称
     */
    @SerializedName("chat_name")
    private String chatName;
    /**
     * 文本内容
     * <p> 示例值：hello
     */
    @SerializedName("content")
    private String content;
    /**
     * 会话类型
     * <p> 示例值：group
     */
    @SerializedName("chat_mode")
    private String chatMode;
    /**
     * reaction类型
     * <p> 示例值：FISTBUMP
     */
    @SerializedName("reaction_type")
    private String reactionType;
    /**
     * 父id
     * <p> 示例值：om_829acd7aaae80c031837ad1946d7cf9f
     */
    @SerializedName("parent_msg_id")
    private String parentMsgId;

    // builder 开始
    public DataArchivingMessageStruct() {
    }

    public DataArchivingMessageStruct(Builder builder) {
        /**
         * 消息id
         * <p> 示例值：om_829acd7aaae80c031837ad1946d7cf9f
         */
        this.messageId = builder.messageId;
        /**
         * 消息类型
         * <p> 示例值：1
         */
        this.messageType = builder.messageType;
        /**
         * 发送者信息
         * <p> 示例值：
         */
        this.senderInfo = builder.senderInfo;
        /**
         * 接受者信息
         * <p> 示例值：
         */
        this.receiverIds = builder.receiverIds;
        /**
         * 操作类型
         * <p> 示例值：send
         */
        this.actionType = builder.actionType;
        /**
         * 会话ID
         * <p> 示例值：oc_1263d7c4d513defb9f5df13214602aa6
         */
        this.chatId = builder.chatId;
        /**
         * 消息动作时间戳ms
         * <p> 示例值：1700191599000
         */
        this.actionTime = builder.actionTime;
        /**
         * 是否超大群
         * <p> 示例值：true
         */
        this.isSuperChat = builder.isSuperChat;
        /**
         * 是否跨租户群
         * <p> 示例值：true
         */
        this.isCrossTenantChat = builder.isCrossTenantChat;
        /**
         * 会话名称
         * <p> 示例值：会话名称
         */
        this.chatName = builder.chatName;
        /**
         * 文本内容
         * <p> 示例值：hello
         */
        this.content = builder.content;
        /**
         * 会话类型
         * <p> 示例值：group
         */
        this.chatMode = builder.chatMode;
        /**
         * reaction类型
         * <p> 示例值：FISTBUMP
         */
        this.reactionType = builder.reactionType;
        /**
         * 父id
         * <p> 示例值：om_829acd7aaae80c031837ad1946d7cf9f
         */
        this.parentMsgId = builder.parentMsgId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getMessageId() {
        return this.messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Integer getMessageType() {
        return this.messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

    public DataArchivingUserStruct getSenderInfo() {
        return this.senderInfo;
    }

    public void setSenderInfo(DataArchivingUserStruct senderInfo) {
        this.senderInfo = senderInfo;
    }

    public String[] getReceiverIds() {
        return this.receiverIds;
    }

    public void setReceiverIds(String[] receiverIds) {
        this.receiverIds = receiverIds;
    }

    public String getActionType() {
        return this.actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getChatId() {
        return this.chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getActionTime() {
        return this.actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

    public Boolean getIsSuperChat() {
        return this.isSuperChat;
    }

    public void setIsSuperChat(Boolean isSuperChat) {
        this.isSuperChat = isSuperChat;
    }

    public Boolean getIsCrossTenantChat() {
        return this.isCrossTenantChat;
    }

    public void setIsCrossTenantChat(Boolean isCrossTenantChat) {
        this.isCrossTenantChat = isCrossTenantChat;
    }

    public String getChatName() {
        return this.chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChatMode() {
        return this.chatMode;
    }

    public void setChatMode(String chatMode) {
        this.chatMode = chatMode;
    }

    public String getReactionType() {
        return this.reactionType;
    }

    public void setReactionType(String reactionType) {
        this.reactionType = reactionType;
    }

    public String getParentMsgId() {
        return this.parentMsgId;
    }

    public void setParentMsgId(String parentMsgId) {
        this.parentMsgId = parentMsgId;
    }

    public static class Builder {
        /**
         * 消息id
         * <p> 示例值：om_829acd7aaae80c031837ad1946d7cf9f
         */
        private String messageId;
        /**
         * 消息类型
         * <p> 示例值：1
         */
        private Integer messageType;
        /**
         * 发送者信息
         * <p> 示例值：
         */
        private DataArchivingUserStruct senderInfo;
        /**
         * 接受者信息
         * <p> 示例值：
         */
        private String[] receiverIds;
        /**
         * 操作类型
         * <p> 示例值：send
         */
        private String actionType;
        /**
         * 会话ID
         * <p> 示例值：oc_1263d7c4d513defb9f5df13214602aa6
         */
        private String chatId;
        /**
         * 消息动作时间戳ms
         * <p> 示例值：1700191599000
         */
        private String actionTime;
        /**
         * 是否超大群
         * <p> 示例值：true
         */
        private Boolean isSuperChat;
        /**
         * 是否跨租户群
         * <p> 示例值：true
         */
        private Boolean isCrossTenantChat;
        /**
         * 会话名称
         * <p> 示例值：会话名称
         */
        private String chatName;
        /**
         * 文本内容
         * <p> 示例值：hello
         */
        private String content;
        /**
         * 会话类型
         * <p> 示例值：group
         */
        private String chatMode;
        /**
         * reaction类型
         * <p> 示例值：FISTBUMP
         */
        private String reactionType;
        /**
         * 父id
         * <p> 示例值：om_829acd7aaae80c031837ad1946d7cf9f
         */
        private String parentMsgId;

        /**
         * 消息id
         * <p> 示例值：om_829acd7aaae80c031837ad1946d7cf9f
         *
         * @param messageId
         * @return
         */
        public Builder messageId(String messageId) {
            this.messageId = messageId;
            return this;
        }


        /**
         * 消息类型
         * <p> 示例值：1
         *
         * @param messageType
         * @return
         */
        public Builder messageType(Integer messageType) {
            this.messageType = messageType;
            return this;
        }


        /**
         * 发送者信息
         * <p> 示例值：
         *
         * @param senderInfo
         * @return
         */
        public Builder senderInfo(DataArchivingUserStruct senderInfo) {
            this.senderInfo = senderInfo;
            return this;
        }


        /**
         * 接受者信息
         * <p> 示例值：
         *
         * @param receiverIds
         * @return
         */
        public Builder receiverIds(String[] receiverIds) {
            this.receiverIds = receiverIds;
            return this;
        }


        /**
         * 操作类型
         * <p> 示例值：send
         *
         * @param actionType
         * @return
         */
        public Builder actionType(String actionType) {
            this.actionType = actionType;
            return this;
        }


        /**
         * 会话ID
         * <p> 示例值：oc_1263d7c4d513defb9f5df13214602aa6
         *
         * @param chatId
         * @return
         */
        public Builder chatId(String chatId) {
            this.chatId = chatId;
            return this;
        }


        /**
         * 消息动作时间戳ms
         * <p> 示例值：1700191599000
         *
         * @param actionTime
         * @return
         */
        public Builder actionTime(String actionTime) {
            this.actionTime = actionTime;
            return this;
        }


        /**
         * 是否超大群
         * <p> 示例值：true
         *
         * @param isSuperChat
         * @return
         */
        public Builder isSuperChat(Boolean isSuperChat) {
            this.isSuperChat = isSuperChat;
            return this;
        }


        /**
         * 是否跨租户群
         * <p> 示例值：true
         *
         * @param isCrossTenantChat
         * @return
         */
        public Builder isCrossTenantChat(Boolean isCrossTenantChat) {
            this.isCrossTenantChat = isCrossTenantChat;
            return this;
        }


        /**
         * 会话名称
         * <p> 示例值：会话名称
         *
         * @param chatName
         * @return
         */
        public Builder chatName(String chatName) {
            this.chatName = chatName;
            return this;
        }


        /**
         * 文本内容
         * <p> 示例值：hello
         *
         * @param content
         * @return
         */
        public Builder content(String content) {
            this.content = content;
            return this;
        }


        /**
         * 会话类型
         * <p> 示例值：group
         *
         * @param chatMode
         * @return
         */
        public Builder chatMode(String chatMode) {
            this.chatMode = chatMode;
            return this;
        }


        /**
         * reaction类型
         * <p> 示例值：FISTBUMP
         *
         * @param reactionType
         * @return
         */
        public Builder reactionType(String reactionType) {
            this.reactionType = reactionType;
            return this;
        }


        /**
         * 父id
         * <p> 示例值：om_829acd7aaae80c031837ad1946d7cf9f
         *
         * @param parentMsgId
         * @return
         */
        public Builder parentMsgId(String parentMsgId) {
            this.parentMsgId = parentMsgId;
            return this;
        }


        public DataArchivingMessageStruct build() {
            return new DataArchivingMessageStruct(this);
        }
    }
}