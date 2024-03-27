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

package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Query;

public class ListFaqReq {
    /**
     * 知识库分类ID
     * <p> 示例值：6856395522433908739
     */
    @Query
    @SerializedName("category_id")
    private String categoryId;
    /**
     * 搜索条件: 知识库状态 1:在线 0:删除，可恢复 2：删除，不可恢复
     * <p> 示例值：1
     */
    @Query
    @SerializedName("status")
    private String status;
    /**
     * 搜索条件: 关键词，匹配问题标题，问题关键字，用户姓名
     * <p> 示例值：点餐
     */
    @Query
    @SerializedName("search")
    private String search;
    /**
     * <p> 示例值：6856395634652479491
     */
    @Query
    @SerializedName("page_token")
    private String pageToken;
    /**
     * <p> 示例值：10
     */
    @Query
    @SerializedName("page_size")
    private Integer pageSize;

    // builder 开始
    public ListFaqReq() {
    }

    public ListFaqReq(Builder builder) {
        /**
         *  知识库分类ID
         * <p> 示例值：6856395522433908739
         */
        this.categoryId = builder.categoryId;
        /**
         * 搜索条件: 知识库状态 1:在线 0:删除，可恢复 2：删除，不可恢复
         * <p> 示例值：1
         */
        this.status = builder.status;
        /**
         * 搜索条件: 关键词，匹配问题标题，问题关键字，用户姓名
         * <p> 示例值：点餐
         */
        this.search = builder.search;
        /**
         *
         * <p> 示例值：6856395634652479491
         */
        this.pageToken = builder.pageToken;
        /**
         *
         * <p> 示例值：10
         */
        this.pageSize = builder.pageSize;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSearch() {
        return this.search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getPageToken() {
        return this.pageToken;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public static class Builder {
        private String categoryId; //  知识库分类ID
        private String status; // 搜索条件: 知识库状态 1:在线 0:删除，可恢复 2：删除，不可恢复
        private String search; // 搜索条件: 关键词，匹配问题标题，问题关键字，用户姓名
        private String pageToken; //
        private Integer pageSize; //


        /**
         * 知识库分类ID
         * <p> 示例值：6856395522433908739
         *
         * @param categoryId
         * @return
         */
        public Builder categoryId(String categoryId) {
            this.categoryId = categoryId;
            return this;
        }


        /**
         * 搜索条件: 知识库状态 1:在线 0:删除，可恢复 2：删除，不可恢复
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
         * 搜索条件: 关键词，匹配问题标题，问题关键字，用户姓名
         * <p> 示例值：点餐
         *
         * @param search
         * @return
         */
        public Builder search(String search) {
            this.search = search;
            return this;
        }


        /**
         * <p> 示例值：6856395634652479491
         *
         * @param pageToken
         * @return
         */
        public Builder pageToken(String pageToken) {
            this.pageToken = pageToken;
            return this;
        }


        /**
         * <p> 示例值：10
         *
         * @param pageSize
         * @return
         */
        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public ListFaqReq build() {
            return new ListFaqReq(this);
        }
    }
}
