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

public class Attachment {
    /**
     * 附件的正文，使用 base64url 编码（支持的文件最大 37MB）
     * <p> 示例值：aGVsbG8gd29ybGQK
     */
    @SerializedName("body")
    private String body;
    /**
     * 附件文件名
     * <p> 示例值：helloworld.txt
     */
    @SerializedName("filename")
    private String filename;
    /**
     * 附件 id
     * <p> 示例值：YQqYbQHoQoDqXjxWKhJbo8Gicjf
     */
    @SerializedName("id")
    private String id;
    /**
     * 附件类型
     * <p> 示例值：1
     */
    @SerializedName("attachment_type")
    private Integer attachmentType;

    // builder 开始
    public Attachment() {
    }

    public Attachment(Builder builder) {
        /**
         * 附件的正文，使用 base64url 编码（支持的文件最大 37MB）
         * <p> 示例值：aGVsbG8gd29ybGQK
         */
        this.body = builder.body;
        /**
         * 附件文件名
         * <p> 示例值：helloworld.txt
         */
        this.filename = builder.filename;
        /**
         * 附件 id
         * <p> 示例值：YQqYbQHoQoDqXjxWKhJbo8Gicjf
         */
        this.id = builder.id;
        /**
         * 附件类型
         * <p> 示例值：1
         */
        this.attachmentType = builder.attachmentType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFilename() {
        return this.filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAttachmentType() {
        return this.attachmentType;
    }

    public void setAttachmentType(Integer attachmentType) {
        this.attachmentType = attachmentType;
    }

    public static class Builder {
        /**
         * 附件的正文，使用 base64url 编码（支持的文件最大 37MB）
         * <p> 示例值：aGVsbG8gd29ybGQK
         */
        private String body;
        /**
         * 附件文件名
         * <p> 示例值：helloworld.txt
         */
        private String filename;
        /**
         * 附件 id
         * <p> 示例值：YQqYbQHoQoDqXjxWKhJbo8Gicjf
         */
        private String id;
        /**
         * 附件类型
         * <p> 示例值：1
         */
        private Integer attachmentType;

        /**
         * 附件的正文，使用 base64url 编码（支持的文件最大 37MB）
         * <p> 示例值：aGVsbG8gd29ybGQK
         *
         * @param body
         * @return
         */
        public Builder body(String body) {
            this.body = body;
            return this;
        }


        /**
         * 附件文件名
         * <p> 示例值：helloworld.txt
         *
         * @param filename
         * @return
         */
        public Builder filename(String filename) {
            this.filename = filename;
            return this;
        }


        /**
         * 附件 id
         * <p> 示例值：YQqYbQHoQoDqXjxWKhJbo8Gicjf
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 附件类型
         * <p> 示例值：1
         *
         * @param attachmentType
         * @return
         */
        public Builder attachmentType(Integer attachmentType) {
            this.attachmentType = attachmentType;
            return this;
        }

        /**
         * 附件类型
         * <p> 示例值：1
         *
         * @param attachmentType {@link com.lark.oapi.service.mail.v1.enums.AttachmentAttachmentTypeEnum}
         * @return
         */
        public Builder attachmentType(com.lark.oapi.service.mail.v1.enums.AttachmentAttachmentTypeEnum attachmentType) {
            this.attachmentType = attachmentType.getValue();
            return this;
        }


        public Attachment build() {
            return new Attachment(this);
        }
    }
}
