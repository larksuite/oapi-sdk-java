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
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class PatchCustomFieldReq {
    /**
     * 用户ID格式
     * <p> 示例值：open_id
     */
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    /**
     * 自定义字段GUID
     * <p> 示例值：5ffbe0ca-6600-41e0-a634-2b38cbcf13b8
     */
    @Path
    @SerializedName("custom_field_guid")
    private String customFieldGuid;
    @Body
    private PatchCustomFieldReqBody body;

    // builder 开始
    public PatchCustomFieldReq() {
    }

    public PatchCustomFieldReq(Builder builder) {
        /**
         * 用户ID格式
         * <p> 示例值：open_id
         */
        this.userIdType = builder.userIdType;
        /**
         * 自定义字段GUID
         * <p> 示例值：5ffbe0ca-6600-41e0-a634-2b38cbcf13b8
         */
        this.customFieldGuid = builder.customFieldGuid;
        this.body = builder.body;
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

    public String getCustomFieldGuid() {
        return this.customFieldGuid;
    }

    public void setCustomFieldGuid(String customFieldGuid) {
        this.customFieldGuid = customFieldGuid;
    }

    public PatchCustomFieldReqBody getPatchCustomFieldReqBody() {
        return this.body;
    }

    public void setPatchCustomFieldReqBody(PatchCustomFieldReqBody body) {
        this.body = body;
    }

    public static class Builder {
        private String userIdType; // 用户ID格式
        private String customFieldGuid; // 自定义字段GUID
        private PatchCustomFieldReqBody body;

        /**
         * 用户ID格式
         * <p> 示例值：open_id
         *
         * @param userIdType
         * @return
         */
        public Builder userIdType(String userIdType) {
            this.userIdType = userIdType;
            return this;
        }

        /**
         * 用户ID格式
         * <p> 示例值：open_id
         *
         * @param userIdType {@link com.lark.oapi.service.task.v2.enums.PatchCustomFieldUserIdTypeEnum}
         * @return
         */
        public Builder userIdType(com.lark.oapi.service.task.v2.enums.PatchCustomFieldUserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        /**
         * 自定义字段GUID
         * <p> 示例值：5ffbe0ca-6600-41e0-a634-2b38cbcf13b8
         *
         * @param customFieldGuid
         * @return
         */
        public Builder customFieldGuid(String customFieldGuid) {
            this.customFieldGuid = customFieldGuid;
            return this;
        }

        public PatchCustomFieldReqBody getPatchCustomFieldReqBody() {
            return this.body;
        }

        /**
         * body
         *
         * @param body
         * @return
         */
        public Builder patchCustomFieldReqBody(PatchCustomFieldReqBody body) {
            this.body = body;
            return this;
        }

        public PatchCustomFieldReq build() {
            return new PatchCustomFieldReq(this);
        }
    }
}