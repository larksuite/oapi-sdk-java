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

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.drive.v1.enums.*;
import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.response.BaseResponse;

public class UpdatePermissionMemberReq {
    /**
     * 更新权限后是否通知对方;;**注意：** 使用`tenant_access_token`访问不支持该参数
     * <p> 示例值：false
     */
    @Query
    @SerializedName("need_notification")
    private Boolean needNotification;
    /**
     * 文件类型，需要与文件的 token 相匹配
     * <p> 示例值：doc
     */
    @Query
    @SerializedName("type")
    private String type;
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
    private BaseMember body;

    // builder 开始
    public UpdatePermissionMemberReq() {
    }

    public UpdatePermissionMemberReq(Builder builder) {
        /**
         * 更新权限后是否通知对方;;**注意：** 使用`tenant_access_token`访问不支持该参数
         * <p> 示例值：false
         */
        this.needNotification = builder.needNotification;
        /**
         * 文件类型，需要与文件的 token 相匹配
         * <p> 示例值：doc
         */
        this.type = builder.type;
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

    public Boolean getNeedNotification() {
        return this.needNotification;
    }

    public void setNeedNotification(Boolean needNotification) {
        this.needNotification = needNotification;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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

    public BaseMember getBaseMember() {
        return this.body;
    }

    public void setBaseMember(BaseMember body) {
        this.body = body;
    }

    public static class Builder {
        private Boolean needNotification; // 更新权限后是否通知对方;;**注意：** 使用`tenant_access_token`访问不支持该参数
        private String type; // 文件类型，需要与文件的 token 相匹配
        private String token; // 文件的 token，获取方式见 [如何获取云文档资源相关 token](https://open.feishu.cn/document/ukTMukTMukTM/uczNzUjL3czM14yN3MTN#08bb5df6)
        private String memberId; // 协作者 ID，与协作者 ID 类型需要对应
        private BaseMember body;

        /**
         * 更新权限后是否通知对方;;**注意：** 使用`tenant_access_token`访问不支持该参数
         * <p> 示例值：false
         *
         * @param needNotification
         * @return
         */
        public Builder needNotification(Boolean needNotification) {
            this.needNotification = needNotification;
            return this;
        }

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
         * @param type {@link com.lark.oapi.service.drive.v1.enums.UpdatePermissionMemberTokenTypeEnum}
         * @return
         */
        public Builder type(com.lark.oapi.service.drive.v1.enums.UpdatePermissionMemberTokenTypeEnum type) {
            this.type = type.getValue();
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

        public BaseMember getBaseMember() {
            return this.body;
        }

        /**
         * body
         *
         * @param body
         * @return
         */
        public Builder baseMember(BaseMember body) {
            this.body = body;
            return this;
        }

        public UpdatePermissionMemberReq build() {
            return new UpdatePermissionMemberReq(this);
        }
    }
}
