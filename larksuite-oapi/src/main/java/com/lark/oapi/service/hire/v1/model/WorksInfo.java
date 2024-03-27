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

import com.google.gson.annotations.SerializedName;

public class WorksInfo {
    /**
     * 作品集附件ID
     * <p> 示例值：
     */
    @SerializedName("attachment_id")
    private String attachmentId;
    /**
     * 作品描述
     * <p> 示例值：
     */
    @SerializedName("desc")
    private String desc;
    /**
     * 作品链接
     * <p> 示例值：
     */
    @SerializedName("link")
    private String link;

    // builder 开始
    public WorksInfo() {
    }

    public WorksInfo(Builder builder) {
        /**
         * 作品集附件ID
         * <p> 示例值：
         */
        this.attachmentId = builder.attachmentId;
        /**
         * 作品描述
         * <p> 示例值：
         */
        this.desc = builder.desc;
        /**
         * 作品链接
         * <p> 示例值：
         */
        this.link = builder.link;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getAttachmentId() {
        return this.attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public static class Builder {
        /**
         * 作品集附件ID
         * <p> 示例值：
         */
        private String attachmentId;
        /**
         * 作品描述
         * <p> 示例值：
         */
        private String desc;
        /**
         * 作品链接
         * <p> 示例值：
         */
        private String link;

        /**
         * 作品集附件ID
         * <p> 示例值：
         *
         * @param attachmentId
         * @return
         */
        public Builder attachmentId(String attachmentId) {
            this.attachmentId = attachmentId;
            return this;
        }


        /**
         * 作品描述
         * <p> 示例值：
         *
         * @param desc
         * @return
         */
        public Builder desc(String desc) {
            this.desc = desc;
            return this;
        }


        /**
         * 作品链接
         * <p> 示例值：
         *
         * @param link
         * @return
         */
        public Builder link(String link) {
            this.link = link;
            return this;
        }


        public WorksInfo build() {
            return new WorksInfo(this);
        }
    }
}
