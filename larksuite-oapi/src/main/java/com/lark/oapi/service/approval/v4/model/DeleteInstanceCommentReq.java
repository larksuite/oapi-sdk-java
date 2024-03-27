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

package com.lark.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class DeleteInstanceCommentReq {
    /**
     * 用户ID类型，不填默认为open_id
     * <p> 示例值：user_id
     */
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    /**
     * 根据user_id_type填写用户ID
     * <p> 示例值：ou_806a18fb5bdf525e38ba219733bdbd73
     */
    @Query
    @SerializedName("user_id")
    private String userId;
    /**
     * 审批实例code（或者租户自定义审批实例ID）
     * <p> 示例值：6A123516-FB88-470D-A428-9AF58B71B3C0
     */
    @Path
    @SerializedName("instance_id")
    private String instanceId;
    /**
     * 评论ID
     * <p> 示例值：7081516627711606803
     */
    @Path
    @SerializedName("comment_id")
    private String commentId;

    // builder 开始
    public DeleteInstanceCommentReq() {
    }

    public DeleteInstanceCommentReq(Builder builder) {
        /**
         * 用户ID类型，不填默认为open_id
         * <p> 示例值：user_id
         */
        this.userIdType = builder.userIdType;
        /**
         * 根据user_id_type填写用户ID
         * <p> 示例值：ou_806a18fb5bdf525e38ba219733bdbd73
         */
        this.userId = builder.userId;
        /**
         * 审批实例code（或者租户自定义审批实例ID）
         * <p> 示例值：6A123516-FB88-470D-A428-9AF58B71B3C0
         */
        this.instanceId = builder.instanceId;
        /**
         * 评论ID
         * <p> 示例值：7081516627711606803
         */
        this.commentId = builder.commentId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUserIdType() {
        return this.userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public static class Builder {
        private String userIdType; // 用户ID类型，不填默认为open_id
        private String userId; // 根据user_id_type填写用户ID
        private String instanceId; // 审批实例code（或者租户自定义审批实例ID）
        private String commentId; // 评论ID

        /**
         * 用户ID类型，不填默认为open_id
         * <p> 示例值：user_id
         *
         * @param userIdType
         * @return
         */
        public Builder userIdType(String userIdType) {
            this.userIdType = userIdType;
            return this;
        }

        /**
         * 用户ID类型，不填默认为open_id
         * <p> 示例值：user_id
         *
         * @param userIdType {@link com.lark.oapi.service.approval.v4.enums.DeleteInstanceCommentUserIdTypeEnum}
         * @return
         */
        public Builder userIdType(com.lark.oapi.service.approval.v4.enums.DeleteInstanceCommentUserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        /**
         * 根据user_id_type填写用户ID
         * <p> 示例值：ou_806a18fb5bdf525e38ba219733bdbd73
         *
         * @param userId
         * @return
         */
        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        /**
         * 审批实例code（或者租户自定义审批实例ID）
         * <p> 示例值：6A123516-FB88-470D-A428-9AF58B71B3C0
         *
         * @param instanceId
         * @return
         */
        public Builder instanceId(String instanceId) {
            this.instanceId = instanceId;
            return this;
        }


        /**
         * 评论ID
         * <p> 示例值：7081516627711606803
         *
         * @param commentId
         * @return
         */
        public Builder commentId(String commentId) {
            this.commentId = commentId;
            return this;
        }

        public DeleteInstanceCommentReq build() {
            return new DeleteInstanceCommentReq(this);
        }
    }
}
