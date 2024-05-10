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

package com.lark.oapi.service.im.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.im.v1.enums.*;
import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.response.BaseResponse;

public class DeleteChatMembersReq {
    /**
     * 出群成员ID类型;;**注意**：移除机器人请使用 ==app_id==
     * <p> 示例值：open_id
     */
    @Query
    @SerializedName("member_id_type")
    private String memberIdType;
    /**
     * 群 ID，详情参见[群ID 说明](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/im-v1/chat-id-description);;**注意**：仅支持群模式为`group`、`topic`的群组ID
     * <p> 示例值：oc_a0553eda9014c201e6969b478895c230
     */
    @Path
    @SerializedName("chat_id")
    private String chatId;
    @Body
    private DeleteChatMembersReqBody body;

    // builder 开始
    public DeleteChatMembersReq() {
    }

    public DeleteChatMembersReq(Builder builder) {
        /**
         * 出群成员ID类型;;**注意**：移除机器人请使用 ==app_id==
         * <p> 示例值：open_id
         */
        this.memberIdType = builder.memberIdType;
        /**
         * 群 ID，详情参见[群ID 说明](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/im-v1/chat-id-description);;**注意**：仅支持群模式为`group`、`topic`的群组ID
         * <p> 示例值：oc_a0553eda9014c201e6969b478895c230
         */
        this.chatId = builder.chatId;
        this.body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getMemberIdType() {
        return this.memberIdType;
    }

    public void setMemberIdType(String memberIdType) {
        this.memberIdType = memberIdType;
    }

    public String getChatId() {
        return this.chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public DeleteChatMembersReqBody getDeleteChatMembersReqBody() {
        return this.body;
    }

    public void setDeleteChatMembersReqBody(DeleteChatMembersReqBody body) {
        this.body = body;
    }

    public static class Builder {
        private String memberIdType; // 出群成员ID类型;;**注意**：移除机器人请使用 ==app_id==
        private String chatId; // 群 ID，详情参见[群ID 说明](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/im-v1/chat-id-description);;**注意**：仅支持群模式为`group`、`topic`的群组ID
        private DeleteChatMembersReqBody body;

        /**
         * 出群成员ID类型;;**注意**：移除机器人请使用 ==app_id==
         * <p> 示例值：open_id
         *
         * @param memberIdType
         * @return
         */
        public Builder memberIdType(String memberIdType) {
            this.memberIdType = memberIdType;
            return this;
        }

        /**
         * 出群成员ID类型;;**注意**：移除机器人请使用 ==app_id==
         * <p> 示例值：open_id
         *
         * @param memberIdType {@link com.lark.oapi.service.im.v1.enums.DeleteChatMembersMemberIdTypeEnum}
         * @return
         */
        public Builder memberIdType(com.lark.oapi.service.im.v1.enums.DeleteChatMembersMemberIdTypeEnum memberIdType) {
            this.memberIdType = memberIdType.getValue();
            return this;
        }

        /**
         * 群 ID，详情参见[群ID 说明](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/im-v1/chat-id-description);;**注意**：仅支持群模式为`group`、`topic`的群组ID
         * <p> 示例值：oc_a0553eda9014c201e6969b478895c230
         *
         * @param chatId
         * @return
         */
        public Builder chatId(String chatId) {
            this.chatId = chatId;
            return this;
        }

        public DeleteChatMembersReqBody getDeleteChatMembersReqBody() {
            return this.body;
        }

        /**
         * body
         *
         * @param body
         * @return
         */
        public Builder deleteChatMembersReqBody(DeleteChatMembersReqBody body) {
            this.body = body;
            return this;
        }

        public DeleteChatMembersReq build() {
            return new DeleteChatMembersReq(this);
        }
    }
}
