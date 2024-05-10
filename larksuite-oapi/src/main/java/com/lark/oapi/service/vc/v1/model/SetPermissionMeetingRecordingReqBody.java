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

package com.lark.oapi.service.vc.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.vc.v1.enums.*;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.response.BaseResponse;

public class SetPermissionMeetingRecordingReqBody {
    /**
     * 授权对象列表
     * <p> 示例值：
     */
    @SerializedName("permission_objects")
    private RecordingPermissionObject[] permissionObjects;
    /**
     * 授权或者取消授权，默认授权
     * <p> 示例值：1
     */
    @SerializedName("action_type")
    private Integer actionType;

    // builder 开始
    public SetPermissionMeetingRecordingReqBody() {
    }

    public SetPermissionMeetingRecordingReqBody(Builder builder) {
        /**
         * 授权对象列表
         * <p> 示例值：
         */
        this.permissionObjects = builder.permissionObjects;
        /**
         * 授权或者取消授权，默认授权
         * <p> 示例值：1
         */
        this.actionType = builder.actionType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public RecordingPermissionObject[] getPermissionObjects() {
        return this.permissionObjects;
    }

    public void setPermissionObjects(RecordingPermissionObject[] permissionObjects) {
        this.permissionObjects = permissionObjects;
    }

    public Integer getActionType() {
        return this.actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public static class Builder {
        /**
         * 授权对象列表
         * <p> 示例值：
         */
        private RecordingPermissionObject[] permissionObjects;
        /**
         * 授权或者取消授权，默认授权
         * <p> 示例值：1
         */
        private Integer actionType;

        /**
         * 授权对象列表
         * <p> 示例值：
         *
         * @param permissionObjects
         * @return
         */
        public Builder permissionObjects(RecordingPermissionObject[] permissionObjects) {
            this.permissionObjects = permissionObjects;
            return this;
        }


        /**
         * 授权或者取消授权，默认授权
         * <p> 示例值：1
         *
         * @param actionType
         * @return
         */
        public Builder actionType(Integer actionType) {
            this.actionType = actionType;
            return this;
        }

        /**
         * 授权或者取消授权，默认授权
         * <p> 示例值：1
         *
         * @param actionType {@link com.lark.oapi.service.vc.v1.enums.SetPermissionMeetingRecordingActionTypeEnum}
         * @return
         */
        public Builder actionType(com.lark.oapi.service.vc.v1.enums.SetPermissionMeetingRecordingActionTypeEnum actionType) {
            this.actionType = actionType.getValue();
            return this;
        }


        public SetPermissionMeetingRecordingReqBody build() {
            return new SetPermissionMeetingRecordingReqBody(this);
        }
    }
}
