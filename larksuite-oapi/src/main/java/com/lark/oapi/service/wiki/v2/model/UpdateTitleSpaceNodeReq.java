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

package com.lark.oapi.service.wiki.v2.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.wiki.v2.enums.*;
import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.response.BaseResponse;

public class UpdateTitleSpaceNodeReq {
    /**
     * 知识空间ID
     * <p> 示例值：6946843325487912356
     */
    @Path
    @SerializedName("space_id")
    private String spaceId;
    /**
     * 节点token
     * <p> 示例值：wikcnKQ1k3pcuo5uSK4t8Vabcef
     */
    @Path
    @SerializedName("node_token")
    private String nodeToken;
    @Body
    private UpdateTitleSpaceNodeReqBody body;

    // builder 开始
    public UpdateTitleSpaceNodeReq() {
    }

    public UpdateTitleSpaceNodeReq(Builder builder) {
        /**
         * 知识空间ID
         * <p> 示例值：6946843325487912356
         */
        this.spaceId = builder.spaceId;
        /**
         * 节点token
         * <p> 示例值：wikcnKQ1k3pcuo5uSK4t8Vabcef
         */
        this.nodeToken = builder.nodeToken;
        this.body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public String getNodeToken() {
        return this.nodeToken;
    }

    public void setNodeToken(String nodeToken) {
        this.nodeToken = nodeToken;
    }

    public UpdateTitleSpaceNodeReqBody getUpdateTitleSpaceNodeReqBody() {
        return this.body;
    }

    public void setUpdateTitleSpaceNodeReqBody(UpdateTitleSpaceNodeReqBody body) {
        this.body = body;
    }

    public static class Builder {

        private String spaceId; // 知识空间ID
        private String nodeToken; // 节点token
        private UpdateTitleSpaceNodeReqBody body;

        /**
         * 知识空间ID
         * <p> 示例值：6946843325487912356
         *
         * @param spaceId
         * @return
         */
        public Builder spaceId(String spaceId) {
            this.spaceId = spaceId;
            return this;
        }

        /**
         * 节点token
         * <p> 示例值：wikcnKQ1k3pcuo5uSK4t8Vabcef
         *
         * @param nodeToken
         * @return
         */
        public Builder nodeToken(String nodeToken) {
            this.nodeToken = nodeToken;
            return this;
        }

        public UpdateTitleSpaceNodeReqBody getUpdateTitleSpaceNodeReqBody() {
            return this.body;
        }

        /**
         * body
         *
         * @param body
         * @return
         */
        public Builder updateTitleSpaceNodeReqBody(UpdateTitleSpaceNodeReqBody body) {
            this.body = body;
            return this;
        }

        public UpdateTitleSpaceNodeReq build() {
            return new UpdateTitleSpaceNodeReq(this);
        }
    }
}
