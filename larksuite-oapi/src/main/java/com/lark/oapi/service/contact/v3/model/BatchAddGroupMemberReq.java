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

package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;

public class BatchAddGroupMemberReq {
    /**
     * 用户组ID
     * <p> 示例值：test_group
     */
    @Path
    @SerializedName("group_id")
    private String groupId;
    @Body
    private BatchAddGroupMemberReqBody body;

    // builder 开始
    public BatchAddGroupMemberReq() {
    }

    public BatchAddGroupMemberReq(Builder builder) {
        /**
         * 用户组ID
         * <p> 示例值：test_group
         */
        this.groupId = builder.groupId;
        this.body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public BatchAddGroupMemberReqBody getBatchAddGroupMemberReqBody() {
        return this.body;
    }

    public void setBatchAddGroupMemberReqBody(BatchAddGroupMemberReqBody body) {
        this.body = body;
    }

    public static class Builder {

        private String groupId; // 用户组ID
        private BatchAddGroupMemberReqBody body;

        /**
         * 用户组ID
         * <p> 示例值：test_group
         *
         * @param groupId
         * @return
         */
        public Builder groupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public BatchAddGroupMemberReqBody getBatchAddGroupMemberReqBody() {
            return this.body;
        }

        /**
         * body
         *
         * @param body
         * @return
         */
        public Builder batchAddGroupMemberReqBody(BatchAddGroupMemberReqBody body) {
            this.body = body;
            return this;
        }

        public BatchAddGroupMemberReq build() {
            return new BatchAddGroupMemberReq(this);
        }
    }
}
