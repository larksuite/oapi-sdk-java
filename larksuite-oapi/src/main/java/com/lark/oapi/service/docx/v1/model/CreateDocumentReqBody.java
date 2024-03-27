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

package com.lark.oapi.service.docx.v1.model;

import com.google.gson.annotations.SerializedName;

public class CreateDocumentReqBody {
    /**
     * 文件夹 token，获取方式见云文档接口快速入门；空表示根目录，tenant_access_token应用权限仅允许操作应用创建的目录
     * <p> 示例值：fldcnqquW1svRIYVT2Np6IuLCKd
     */
    @SerializedName("folder_token")
    private String folderToken;
    /**
     * 文档标题，只支持纯文本
     * <p> 示例值：undefined
     */
    @SerializedName("title")
    private String title;

    // builder 开始
    public CreateDocumentReqBody() {
    }

    public CreateDocumentReqBody(Builder builder) {
        /**
         * 文件夹 token，获取方式见云文档接口快速入门；空表示根目录，tenant_access_token应用权限仅允许操作应用创建的目录
         * <p> 示例值：fldcnqquW1svRIYVT2Np6IuLCKd
         */
        this.folderToken = builder.folderToken;
        /**
         * 文档标题，只支持纯文本
         * <p> 示例值：undefined
         */
        this.title = builder.title;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getFolderToken() {
        return this.folderToken;
    }

    public void setFolderToken(String folderToken) {
        this.folderToken = folderToken;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static class Builder {
        /**
         * 文件夹 token，获取方式见云文档接口快速入门；空表示根目录，tenant_access_token应用权限仅允许操作应用创建的目录
         * <p> 示例值：fldcnqquW1svRIYVT2Np6IuLCKd
         */
        private String folderToken;
        /**
         * 文档标题，只支持纯文本
         * <p> 示例值：undefined
         */
        private String title;

        /**
         * 文件夹 token，获取方式见云文档接口快速入门；空表示根目录，tenant_access_token应用权限仅允许操作应用创建的目录
         * <p> 示例值：fldcnqquW1svRIYVT2Np6IuLCKd
         *
         * @param folderToken
         * @return
         */
        public Builder folderToken(String folderToken) {
            this.folderToken = folderToken;
            return this;
        }


        /**
         * 文档标题，只支持纯文本
         * <p> 示例值：undefined
         *
         * @param title
         * @return
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }


        public CreateDocumentReqBody build() {
            return new CreateDocumentReqBody(this);
        }
    }
}
