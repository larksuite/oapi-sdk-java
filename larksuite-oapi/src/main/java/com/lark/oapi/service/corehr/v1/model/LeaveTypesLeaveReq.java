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

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Query;

public class LeaveTypesLeaveReq {
    /**
     * 页码标识，获取第一页传空，每次查询会返回下一页的page_token
     * <p> 示例值：eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
     */
    @Query
    @SerializedName("page_token")
    private String pageToken;
    /**
     * 每页获取记录数量，最大100
     * <p> 示例值：100
     */
    @Query
    @SerializedName("page_size")
    private String pageSize;
    /**
     * 假期类型状态（不传则为全部）;;可选值有：;;- 1：已启用;;- 2：已停用
     * <p> 示例值：1
     */
    @Query
    @SerializedName("status")
    private String status;
    /**
     * 用户 ID 类型
     * <p> 示例值：people_corehr_id
     */
    @Query
    @SerializedName("user_id_type")
    private String userIdType;

    // builder 开始
    public LeaveTypesLeaveReq() {
    }

    public LeaveTypesLeaveReq(Builder builder) {
        /**
         * 页码标识，获取第一页传空，每次查询会返回下一页的page_token
         * <p> 示例值：eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
         */
        this.pageToken = builder.pageToken;
        /**
         * 每页获取记录数量，最大100
         * <p> 示例值：100
         */
        this.pageSize = builder.pageSize;
        /**
         * 假期类型状态（不传则为全部）;;可选值有：;;- 1：已启用;;- 2：已停用
         * <p> 示例值：1
         */
        this.status = builder.status;
        /**
         * 用户 ID 类型
         * <p> 示例值：people_corehr_id
         */
        this.userIdType = builder.userIdType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getPageToken() {
        return this.pageToken;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public String getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserIdType() {
        return this.userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType;
    }

    public static class Builder {
        private String pageToken; // 页码标识，获取第一页传空，每次查询会返回下一页的page_token
        private String pageSize; // 每页获取记录数量，最大100
        private String status; // 假期类型状态（不传则为全部）;;可选值有：;;- 1：已启用;;- 2：已停用
        private String userIdType; // 用户 ID 类型


        /**
         * 页码标识，获取第一页传空，每次查询会返回下一页的page_token
         * <p> 示例值：eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
         *
         * @param pageToken
         * @return
         */
        public Builder pageToken(String pageToken) {
            this.pageToken = pageToken;
            return this;
        }


        /**
         * 每页获取记录数量，最大100
         * <p> 示例值：100
         *
         * @param pageSize
         * @return
         */
        public Builder pageSize(String pageSize) {
            this.pageSize = pageSize;
            return this;
        }


        /**
         * 假期类型状态（不传则为全部）;;可选值有：;;- 1：已启用;;- 2：已停用
         * <p> 示例值：1
         *
         * @param status
         * @return
         */
        public Builder status(String status) {
            this.status = status;
            return this;
        }


        /**
         * 用户 ID 类型
         * <p> 示例值：people_corehr_id
         *
         * @param userIdType
         * @return
         */
        public Builder userIdType(String userIdType) {
            this.userIdType = userIdType;
            return this;
        }

        /**
         * 用户 ID 类型
         * <p> 示例值：people_corehr_id
         *
         * @param userIdType {@link com.lark.oapi.service.corehr.v1.enums.LeaveTypesLeaveUserIdTypeEnum}
         * @return
         */
        public Builder userIdType(com.lark.oapi.service.corehr.v1.enums.LeaveTypesLeaveUserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        public LeaveTypesLeaveReq build() {
            return new LeaveTypesLeaveReq(this);
        }
    }
}
