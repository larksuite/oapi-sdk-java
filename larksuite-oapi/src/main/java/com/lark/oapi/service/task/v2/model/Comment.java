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

package com.lark.oapi.service.task.v2.model;

import com.google.gson.annotations.SerializedName;

public class Comment {
    /**
     * 评论id
     * <p> 示例值：7197020628442939411
     */
    @SerializedName("id")
    private String id;
    /**
     * 评论内容
     * <p> 示例值：这是一条评论
     */
    @SerializedName("content")
    private String content;
    /**
     * 评论创建人
     * <p> 示例值：
     */
    @SerializedName("creator")
    private Member creator;
    /**
     * 被回复评论的id。如果不是回复评论，则为空。
     * <p> 示例值：7166825117308174356
     */
    @SerializedName("reply_to_comment_id")
    private String replyToCommentId;
    /**
     * 评论创建时间戳（ms)
     * <p> 示例值：1675742789470
     */
    @SerializedName("created_at")
    private String createdAt;
    /**
     * 评论更新时间戳（ms）
     * <p> 示例值：1675742789470
     */
    @SerializedName("updated_at")
    private String updatedAt;
    /**
     * 任务关联的资源类型
     * <p> 示例值：task
     */
    @SerializedName("resource_type")
    private String resourceType;
    /**
     * 任务关联的资源ID
     * <p> 示例值：ccb55625-95d2-2e80-655f-0e40bf67953f
     */
    @SerializedName("resource_id")
    private String resourceId;

    // builder 开始
    public Comment() {
    }

    public Comment(Builder builder) {
        /**
         * 评论id
         * <p> 示例值：7197020628442939411
         */
        this.id = builder.id;
        /**
         * 评论内容
         * <p> 示例值：这是一条评论
         */
        this.content = builder.content;
        /**
         * 评论创建人
         * <p> 示例值：
         */
        this.creator = builder.creator;
        /**
         * 被回复评论的id。如果不是回复评论，则为空。
         * <p> 示例值：7166825117308174356
         */
        this.replyToCommentId = builder.replyToCommentId;
        /**
         * 评论创建时间戳（ms)
         * <p> 示例值：1675742789470
         */
        this.createdAt = builder.createdAt;
        /**
         * 评论更新时间戳（ms）
         * <p> 示例值：1675742789470
         */
        this.updatedAt = builder.updatedAt;
        /**
         * 任务关联的资源类型
         * <p> 示例值：task
         */
        this.resourceType = builder.resourceType;
        /**
         * 任务关联的资源ID
         * <p> 示例值：ccb55625-95d2-2e80-655f-0e40bf67953f
         */
        this.resourceId = builder.resourceId;
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

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Member getCreator() {
        return this.creator;
    }

    public void setCreator(Member creator) {
        this.creator = creator;
    }

    public String getReplyToCommentId() {
        return this.replyToCommentId;
    }

    public void setReplyToCommentId(String replyToCommentId) {
        this.replyToCommentId = replyToCommentId;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getResourceType() {
        return this.resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public static class Builder {
        /**
         * 评论id
         * <p> 示例值：7197020628442939411
         */
        private String id;
        /**
         * 评论内容
         * <p> 示例值：这是一条评论
         */
        private String content;
        /**
         * 评论创建人
         * <p> 示例值：
         */
        private Member creator;
        /**
         * 被回复评论的id。如果不是回复评论，则为空。
         * <p> 示例值：7166825117308174356
         */
        private String replyToCommentId;
        /**
         * 评论创建时间戳（ms)
         * <p> 示例值：1675742789470
         */
        private String createdAt;
        /**
         * 评论更新时间戳（ms）
         * <p> 示例值：1675742789470
         */
        private String updatedAt;
        /**
         * 任务关联的资源类型
         * <p> 示例值：task
         */
        private String resourceType;
        /**
         * 任务关联的资源ID
         * <p> 示例值：ccb55625-95d2-2e80-655f-0e40bf67953f
         */
        private String resourceId;

        /**
         * 评论id
         * <p> 示例值：7197020628442939411
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 评论内容
         * <p> 示例值：这是一条评论
         *
         * @param content
         * @return
         */
        public Builder content(String content) {
            this.content = content;
            return this;
        }


        /**
         * 评论创建人
         * <p> 示例值：
         *
         * @param creator
         * @return
         */
        public Builder creator(Member creator) {
            this.creator = creator;
            return this;
        }


        /**
         * 被回复评论的id。如果不是回复评论，则为空。
         * <p> 示例值：7166825117308174356
         *
         * @param replyToCommentId
         * @return
         */
        public Builder replyToCommentId(String replyToCommentId) {
            this.replyToCommentId = replyToCommentId;
            return this;
        }


        /**
         * 评论创建时间戳（ms)
         * <p> 示例值：1675742789470
         *
         * @param createdAt
         * @return
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }


        /**
         * 评论更新时间戳（ms）
         * <p> 示例值：1675742789470
         *
         * @param updatedAt
         * @return
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }


        /**
         * 任务关联的资源类型
         * <p> 示例值：task
         *
         * @param resourceType
         * @return
         */
        public Builder resourceType(String resourceType) {
            this.resourceType = resourceType;
            return this;
        }


        /**
         * 任务关联的资源ID
         * <p> 示例值：ccb55625-95d2-2e80-655f-0e40bf67953f
         *
         * @param resourceId
         * @return
         */
        public Builder resourceId(String resourceId) {
            this.resourceId = resourceId;
            return this;
        }


        public Comment build() {
            return new Comment(this);
        }
    }
}