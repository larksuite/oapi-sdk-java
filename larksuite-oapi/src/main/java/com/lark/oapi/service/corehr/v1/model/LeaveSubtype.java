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

package com.lark.oapi.service.corehr.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.corehr.v1.enums.*;
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

public class LeaveSubtype {
    /**
     * 假期子类ID
     * <p> 示例值：4718803945687580505
     */
    @SerializedName("leave_type_id")
    private String leaveTypeId;
    /**
     * 假期子类名称
     * <p> 示例值：
     */
    @SerializedName("leave_type_name")
    private I18n[] leaveTypeName;

    // builder 开始
    public LeaveSubtype() {
    }

    public LeaveSubtype(Builder builder) {
        /**
         * 假期子类ID
         * <p> 示例值：4718803945687580505
         */
        this.leaveTypeId = builder.leaveTypeId;
        /**
         * 假期子类名称
         * <p> 示例值：
         */
        this.leaveTypeName = builder.leaveTypeName;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getLeaveTypeId() {
        return this.leaveTypeId;
    }

    public void setLeaveTypeId(String leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public I18n[] getLeaveTypeName() {
        return this.leaveTypeName;
    }

    public void setLeaveTypeName(I18n[] leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }

    public static class Builder {
        /**
         * 假期子类ID
         * <p> 示例值：4718803945687580505
         */
        private String leaveTypeId;
        /**
         * 假期子类名称
         * <p> 示例值：
         */
        private I18n[] leaveTypeName;

        /**
         * 假期子类ID
         * <p> 示例值：4718803945687580505
         *
         * @param leaveTypeId
         * @return
         */
        public Builder leaveTypeId(String leaveTypeId) {
            this.leaveTypeId = leaveTypeId;
            return this;
        }


        /**
         * 假期子类名称
         * <p> 示例值：
         *
         * @param leaveTypeName
         * @return
         */
        public Builder leaveTypeName(I18n[] leaveTypeName) {
            this.leaveTypeName = leaveTypeName;
            return this;
        }


        public LeaveSubtype build() {
            return new LeaveSubtype(this);
        }
    }
}
