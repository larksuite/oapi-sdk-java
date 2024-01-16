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

package com.lark.oapi.service.corehr.v2.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Query;

public class SearchBasicInfoCountryRegionReq {
    /**
     * 分页大小，最大 100
     * <p> 示例值：100
     */
    @Query
    @SerializedName("page_size")
    private Integer pageSize;
    /**
     * 分页标记，第一次请求不填，表示从头开始遍历；分页查询结果还有更多项时会同时返回新的 page_token，下次遍历可采用该 page_token 获取查询结果
     * <p> 示例值：6891251722631890445
     */
    @Query
    @SerializedName("page_token")
    private String pageToken;
    @Body
    private SearchBasicInfoCountryRegionReqBody body;

    // builder 开始
    public SearchBasicInfoCountryRegionReq() {
    }

    public SearchBasicInfoCountryRegionReq(Builder builder) {
        /**
         * 分页大小，最大 100
         * <p> 示例值：100
         */
        this.pageSize = builder.pageSize;
        /**
         * 分页标记，第一次请求不填，表示从头开始遍历；分页查询结果还有更多项时会同时返回新的 page_token，下次遍历可采用该 page_token 获取查询结果
         * <p> 示例值：6891251722631890445
         */
        this.pageToken = builder.pageToken;
        this.body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
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

    public SearchBasicInfoCountryRegionReqBody getSearchBasicInfoCountryRegionReqBody() {
        return this.body;
    }

    public void setSearchBasicInfoCountryRegionReqBody(SearchBasicInfoCountryRegionReqBody body) {
        this.body = body;
    }

    public static class Builder {
        private Integer pageSize; // 分页大小，最大 100
        private String pageToken; // 分页标记，第一次请求不填，表示从头开始遍历；分页查询结果还有更多项时会同时返回新的 page_token，下次遍历可采用该 page_token 获取查询结果
        private SearchBasicInfoCountryRegionReqBody body;

        /**
         * 分页大小，最大 100
         * <p> 示例值：100
         *
         * @param pageSize
         * @return
         */
        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        /**
         * 分页标记，第一次请求不填，表示从头开始遍历；分页查询结果还有更多项时会同时返回新的 page_token，下次遍历可采用该 page_token 获取查询结果
         * <p> 示例值：6891251722631890445
         *
         * @param pageToken
         * @return
         */
        public Builder pageToken(String pageToken) {
            this.pageToken = pageToken;
            return this;
        }

        public SearchBasicInfoCountryRegionReqBody getSearchBasicInfoCountryRegionReqBody() {
            return this.body;
        }

        /**
         * body
         *
         * @param body
         * @return
         */
        public Builder searchBasicInfoCountryRegionReqBody(SearchBasicInfoCountryRegionReqBody body) {
            this.body = body;
            return this;
        }

        public SearchBasicInfoCountryRegionReq build() {
            return new SearchBasicInfoCountryRegionReq(this);
        }
    }
}