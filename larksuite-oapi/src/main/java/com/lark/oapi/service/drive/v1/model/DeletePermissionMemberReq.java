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

package com.lark.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class DeletePermissionMemberReq {
    /**
     * 文件类型，需要与文件的 token 相匹配
     * <p> 示例值：doc
     */
    @Query
    @SerializedName("type")
    private String type;
    /**
     * 协作者 ID 类型，与协作者 ID 需要对应
     * <p> 示例值：openid
     */
    @Query
    @SerializedName("member_type")
    private String memberType;
    /**
     * 文件的 token，获取方式见 [如何获取云文档资源相关 token](https://open.feishu.cn/document/ukTMukTMukTM/uczNzUjL3czM14yN3MTN#08bb5df6)
     * <p> 示例值：doccnBKgoMyY5OMbUG6FioTXuBe
     */
    @Path
    @SerializedName("token")
    private String token;
    /**
     * 协作者 ID，与协作者 ID 类型需要对应
     * <p> 示例值：ou_7dab8a3d3cdcc9da365777c7ad535d62
     */
    @Path
    @SerializedName("member_id")
    private String memberId;
    @Body
    private DeletePermissionMemberReqBody body;

    // builder 开始
    public DeletePermissionMemberReq() {
    }

    public DeletePermissionMemberReq(Builder builder) {
        /**
         * 文件类型，需要与文件的 token 相匹配
         * <p> 示例值：doc
         */
        this.type = builder.type;
        /**
         * 协作者 ID 类型，与协作者 ID 需要对应
         * <p> 示例值：openid
         */
        this.memberType = builder.memberType;
        /**
         * 文件的 token，获取方式见 [如何获取云文档资源相关 token](https://open.feishu.cn/document/ukTMukTMukTM/uczNzUjL3czM14yN3MTN#08bb5df6)
         * <p> 示例值：doccnBKgoMyY5OMbUG6FioTXuBe
         */
        this.token = builder.token;
        /**
         * 协作者 ID，与协作者 ID 类型需要对应
         * <p> 示例值：ou_7dab8a3d3cdcc9da365777c7ad535d62
         */
        this.memberId = builder.memberId;
        this.body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemberType() {
        return this.memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public DeletePermissionMemberReqBody getDeletePermissionMemberReqBody() {
        return this.body;
    }

    public void setDeletePermissionMemberReqBody(DeletePermissionMemberReqBody body) {
        this.body = body;
    }

    public static class Builder {
        private String type; // 文件类型，需要与文件的 token 相匹配
        private String memberType; // 协作者 ID 类型，与协作者 ID 需要对应
        private String token; // 文件的 token，获取方式见 [如何获取云文档资源相关 token](https://open.feishu.cn/document/ukTMukTMukTM/uczNzUjL3czM14yN3MTN#08bb5df6)
        private String memberId; // 协作者 ID，与协作者 ID 类型需要对应
        private DeletePermissionMemberReqBody body;

        /**
         * 文件类型，需要与文件的 token 相匹配
         * <p> 示例值：doc
         *
         * @param type
         * @return
         */
        public Builder type(String type) {
            this.type = type;
            return this;
        }

        /**
         * 文件类型，需要与文件的 token 相匹配
         * <p> 示例值：doc
         *
         * @param type {@link com.lark.oapi.service.drive.v1.enums.DeletePermissionMemberTokenTypeV2Enum}
         * @return
         */
        public Builder type(com.lark.oapi.service.drive.v1.enums.DeletePermissionMemberTokenTypeV2Enum type) {
            this.type = type.getValue();
            return this;
        }

        /**
         * 协作者 ID 类型，与协作者 ID 需要对应
         * <p> 示例值：openid
         *
         * @param memberType
         * @return
         */
        public Builder memberType(String memberType) {
            this.memberType = memberType;
            return this;
        }

        /**
         * 协作者 ID 类型，与协作者 ID 需要对应
         * <p> 示例值：openid
         *
         * @param memberType {@link com.lark.oapi.service.drive.v1.enums.DeletePermissionMemberMemberTypeEnum}
         * @return
         */
        public Builder memberType(com.lark.oapi.service.drive.v1.enums.DeletePermissionMemberMemberTypeEnum memberType) {
            this.memberType = memberType.getValue();
            return this;
        }

        /**
         * 文件的 token，获取方式见 [如何获取云文档资源相关 token](https://open.feishu.cn/document/ukTMukTMukTM/uczNzUjL3czM14yN3MTN#08bb5df6)
         * <p> 示例值：doccnBKgoMyY5OMbUG6FioTXuBe
         *
         * @param token
         * @return
         */
        public Builder token(String token) {
            this.token = token;
            return this;
        }

        /**
         * 协作者 ID，与协作者 ID 类型需要对应
         * <p> 示例值：ou_7dab8a3d3cdcc9da365777c7ad535d62
         *
         * @param memberId
         * @return
         */
        public Builder memberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public DeletePermissionMemberReqBody getDeletePermissionMemberReqBody() {
            return this.body;
        }

        /**
         * body
         *
         * @param body
         * @return
         */
        public Builder deletePermissionMemberReqBody(DeletePermissionMemberReqBody body) {
            this.body = body;
            return this;
        }

        public DeletePermissionMemberReq build() {
            return new DeletePermissionMemberReq(this);
        }
    }
}
