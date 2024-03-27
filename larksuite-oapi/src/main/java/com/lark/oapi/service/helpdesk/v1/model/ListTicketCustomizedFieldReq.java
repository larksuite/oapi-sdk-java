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
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Query;

public class ListTicketCustomizedFieldReq {
    /**
     * <p> 示例值：6948728206392295444
     */
    @Query
    @SerializedName("page_token")
    private String pageToken;
    /**
     * <p> 示例值：10；默认为20
     */
    @Query
    @SerializedName("page_size")
    private Integer pageSize;
    @Body
    private ListTicketCustomizedFieldReqBody body;

    // builder 开始
    public ListTicketCustomizedFieldReq() {
    }

    public ListTicketCustomizedFieldReq(Builder builder) {
        /**
         *
         * <p> 示例值：6948728206392295444
         */
        this.pageToken = builder.pageToken;
        /**
         *
         * <p> 示例值：10；默认为20
         */
        this.pageSize = builder.pageSize;
        this.body = builder.body;
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

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public ListTicketCustomizedFieldReqBody getListTicketCustomizedFieldReqBody() {
        return this.body;
    }

    public void setListTicketCustomizedFieldReqBody(ListTicketCustomizedFieldReqBody body) {
        this.body = body;
    }

    public static class Builder {
        private String pageToken; //
        private Integer pageSize; //
        private ListTicketCustomizedFieldReqBody body;

        /**
         * <p> 示例值：6948728206392295444
         *
         * @param pageToken
         * @return
         */
        public Builder pageToken(String pageToken) {
            this.pageToken = pageToken;
            return this;
        }

        /**
         * <p> 示例值：10；默认为20
         *
         * @param pageSize
         * @return
         */
        public Builder pageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public ListTicketCustomizedFieldReqBody getListTicketCustomizedFieldReqBody() {
            return this.body;
        }

        /**
         * body
         *
         * @param body
         * @return
         */
        public Builder listTicketCustomizedFieldReqBody(ListTicketCustomizedFieldReqBody body) {
            this.body = body;
            return this;
        }

        public ListTicketCustomizedFieldReq build() {
            return new ListTicketCustomizedFieldReq(this);
        }
    }
}
