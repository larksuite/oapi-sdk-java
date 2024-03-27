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

package com.lark.oapi.service.workplace.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Query;

public class SearchWorkplaceAccessDataReq {
    /**
     * 数据检索开始时间，精确到日。格式yyyy-MM-dd
     * <p> 示例值：2023-03-01
     */
    @Query
    @SerializedName("from_date")
    private String fromDate;
    /**
     * 数据检索结束时间，精确到日。格式yyyy-MM-dd。
     * <p> 示例值：2023-03-22
     */
    @Query
    @SerializedName("to_date")
    private String toDate;
    /**
     * 分页大小，最小为 1，最大为 200，默认为 20。
     * <p> 示例值：20
     */
    @Query
    @SerializedName("page_size")
    private Integer pageSize;
    /**
     * 用于标记当前请求的分页标记，将返回以当前分页标记开始，往后 page_size 个元素。第一次访问接口的时候不需要传。
     * <p> 示例值：ddowkdkl9w2d
     */
    @Query
    @SerializedName("page_token")
    private String pageToken;

    // builder 开始
    public SearchWorkplaceAccessDataReq() {
    }

    public SearchWorkplaceAccessDataReq(Builder builder) {
        /**
         * 数据检索开始时间，精确到日。格式yyyy-MM-dd
         * <p> 示例值：2023-03-01
         */
        this.fromDate = builder.fromDate;
        /**
         * 数据检索结束时间，精确到日。格式yyyy-MM-dd。
         * <p> 示例值：2023-03-22
         */
        this.toDate = builder.toDate;
        /**
         * 分页大小，最小为 1，最大为 200，默认为 20。
         * <p> 示例值：20
         */
        this.pageSize = builder.pageSize;
        /**
         * 用于标记当前请求的分页标记，将返回以当前分页标记开始，往后 page_size 个元素。第一次访问接口的时候不需要传。
         * <p> 示例值：ddowkdkl9w2d
         */
        this.pageToken = builder.pageToken;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getFromDate() {
        return this.fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return this.toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageToken() {
        return this.pageToken;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public static class Builder {
        private String fromDate; // 数据检索开始时间，精确到日。格式yyyy-MM-dd
        private String toDate; // 数据检索结束时间，精确到日。格式yyyy-MM-dd。
        private Integer pageSize; // 分页大小，最小为 1，最大为 200，默认为 20。
        private String pageToken; // 用于标记当前请求的分页标记，将返回以当前分页标记开始，往后 page_size 个元素。第一次访问接口的时候不需要传。


        /**
         * 数据检索开始时间，精确到日。格式yyyy-MM-dd
         * <p> 示例值：2023-03-01
         *
         * @param fromDate
         * @return
         */
        public Builder fromDate(String fromDate) {
            this.fromDate = fromDate;
            return this;
        }


        /**
         * 数据检索结束时间，精确到日。格式yyyy-MM-dd。
         * <p> 示例值：2023-03-22
         *
         * @param toDate
         * @return
         */
        public Builder toDate(String toDate) {
            this.toDate = toDate;
            return this;
        }


        /**
         * 分页大小，最小为 1，最大为 200，默认为 20。
         * <p> 示例值：20
         *
         * @param pageSize
         * @return
         */
        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }


        /**
         * 用于标记当前请求的分页标记，将返回以当前分页标记开始，往后 page_size 个元素。第一次访问接口的时候不需要传。
         * <p> 示例值：ddowkdkl9w2d
         *
         * @param pageToken
         * @return
         */
        public Builder pageToken(String pageToken) {
            this.pageToken = pageToken;
            return this;
        }

        public SearchWorkplaceAccessDataReq build() {
            return new SearchWorkplaceAccessDataReq(this);
        }
    }
}
