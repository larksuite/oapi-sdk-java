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

package com.lark.oapi.service.admin.v1.model;

import com.lark.oapi.core.response.EmptyData;
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

public class ListAuditInfoRespBody {
    /**
     * 是否有下一页数据
     * <p> 示例值：
     */
    @SerializedName("has_more")
    private Boolean hasMore;
    /**
     * 下一页分页的token
     * <p> 示例值：LC39/f1%2B/Sz9Uv39Gf39/ew/cd5WY0gfGYFdixOW9cVk4bC79ituO/gx0qpPn1bYf92nz/kI0nNJOG3wCwDJKoNU%2BtyaXbpI8pV/9UNDMZT0BNeyanFH17Wv711Qh9anR3l2GjQfc2fUqXtxg1YPp63XyhYY4iRMv54ySRG7r%2BI89iS3zAoPzFuuU1MUJKsf
     */
    @SerializedName("page_token")
    private String pageToken;
    /**
     * 返回的具体数据内容
     * <p> 示例值：
     */
    @SerializedName("items")
    private AuditInfo[] items;

    public Boolean getHasMore() {
        return this.hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public String getPageToken() {
        return this.pageToken;
    }

    public void setPageToken(String pageToken) {
        this.pageToken = pageToken;
    }

    public AuditInfo[] getItems() {
        return this.items;
    }

    public void setItems(AuditInfo[] items) {
        this.items = items;
    }

}
