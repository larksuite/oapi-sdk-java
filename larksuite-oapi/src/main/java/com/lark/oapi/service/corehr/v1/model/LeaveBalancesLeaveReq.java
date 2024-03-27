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

public class LeaveBalancesLeaveReq {
    /**
     * 页码标识，获取第一页传空，每次查询会返回下一页的page_token
     * <p> 示例值：eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
     */
    @Query
    @SerializedName("page_token")
    private String pageToken;
    /**
     * 每页获取记录数量，最大20
     * <p> 示例值：20
     */
    @Query
    @SerializedName("page_size")
    private String pageSize;
    /**
     * 查询截止日期，即截止到某天余额数据的日期（不传则默认为当天）
     * <p> 示例值：2022-07-29
     */
    @Query
    @SerializedName("as_of_date")
    private String asOfDate;
    /**
     * 员工 ID 列表，最大 100 个（不传则默认查询全部员工）
     * <p> 示例值：["6919733291281024526"]
     */
    @Query
    @SerializedName("employment_id_list")
    private String[] employmentIdList;
    /**
     * 用户 ID 类型
     * <p> 示例值：people_corehr_id
     */
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    /**
     * 查询时区
     * <p> 示例值：Asia/Shanghai
     */
    @Query
    @SerializedName("time_zone")
    private String timeZone;

    // builder 开始
    public LeaveBalancesLeaveReq() {
    }

    public LeaveBalancesLeaveReq(Builder builder) {
        /**
         * 页码标识，获取第一页传空，每次查询会返回下一页的page_token
         * <p> 示例值：eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
         */
        this.pageToken = builder.pageToken;
        /**
         * 每页获取记录数量，最大20
         * <p> 示例值：20
         */
        this.pageSize = builder.pageSize;
        /**
         * 查询截止日期，即截止到某天余额数据的日期（不传则默认为当天）
         * <p> 示例值：2022-07-29
         */
        this.asOfDate = builder.asOfDate;
        /**
         * 员工 ID 列表，最大 100 个（不传则默认查询全部员工）
         * <p> 示例值：["6919733291281024526"]
         */
        this.employmentIdList = builder.employmentIdList;
        /**
         * 用户 ID 类型
         * <p> 示例值：people_corehr_id
         */
        this.userIdType = builder.userIdType;
        /**
         * 查询时区
         * <p> 示例值：Asia/Shanghai
         */
        this.timeZone = builder.timeZone;
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

    public String getAsOfDate() {
        return this.asOfDate;
    }

    public void setAsOfDate(String asOfDate) {
        this.asOfDate = asOfDate;
    }

    public String[] getEmploymentIdList() {
        return this.employmentIdList;
    }

    public void setEmploymentIdList(String[] employmentIdList) {
        this.employmentIdList = employmentIdList;
    }

    public String getUserIdType() {
        return this.userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public static class Builder {
        private String pageToken; // 页码标识，获取第一页传空，每次查询会返回下一页的page_token
        private String pageSize; // 每页获取记录数量，最大20
        private String asOfDate; // 查询截止日期，即截止到某天余额数据的日期（不传则默认为当天）
        private String[] employmentIdList; // 员工 ID 列表，最大 100 个（不传则默认查询全部员工）
        private String userIdType; // 用户 ID 类型
        private String timeZone; // 查询时区


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
         * 每页获取记录数量，最大20
         * <p> 示例值：20
         *
         * @param pageSize
         * @return
         */
        public Builder pageSize(String pageSize) {
            this.pageSize = pageSize;
            return this;
        }


        /**
         * 查询截止日期，即截止到某天余额数据的日期（不传则默认为当天）
         * <p> 示例值：2022-07-29
         *
         * @param asOfDate
         * @return
         */
        public Builder asOfDate(String asOfDate) {
            this.asOfDate = asOfDate;
            return this;
        }


        /**
         * 员工 ID 列表，最大 100 个（不传则默认查询全部员工）
         * <p> 示例值：["6919733291281024526"]
         *
         * @param employmentIdList
         * @return
         */
        public Builder employmentIdList(String[] employmentIdList) {
            this.employmentIdList = employmentIdList;
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
         * @param userIdType {@link com.lark.oapi.service.corehr.v1.enums.LeaveBalancesLeaveUserIdTypeEnum}
         * @return
         */
        public Builder userIdType(com.lark.oapi.service.corehr.v1.enums.LeaveBalancesLeaveUserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }


        /**
         * 查询时区
         * <p> 示例值：Asia/Shanghai
         *
         * @param timeZone
         * @return
         */
        public Builder timeZone(String timeZone) {
            this.timeZone = timeZone;
            return this;
        }

        public LeaveBalancesLeaveReq build() {
            return new LeaveBalancesLeaveReq(this);
        }
    }
}
