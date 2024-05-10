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

package com.lark.oapi.service.im.v2.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.im.v2.enums.*;
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

public class FeedGroupItem {
    /**
     * 消息卡片 ID
     * <p> 示例值：7191086414609645000
     */
    @SerializedName("feed_id")
    private String feedId;
    /**
     * 消息卡片类型
     * <p> 示例值：3
     */
    @SerializedName("feed_type")
    private String feedType;

    // builder 开始
    public FeedGroupItem() {
    }

    public FeedGroupItem(Builder builder) {
        /**
         * 消息卡片 ID
         * <p> 示例值：7191086414609645000
         */
        this.feedId = builder.feedId;
        /**
         * 消息卡片类型
         * <p> 示例值：3
         */
        this.feedType = builder.feedType;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getFeedId() {
        return this.feedId;
    }

    public void setFeedId(String feedId) {
        this.feedId = feedId;
    }

    public String getFeedType() {
        return this.feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public static class Builder {
        /**
         * 消息卡片 ID
         * <p> 示例值：7191086414609645000
         */
        private String feedId;
        /**
         * 消息卡片类型
         * <p> 示例值：3
         */
        private String feedType;

        /**
         * 消息卡片 ID
         * <p> 示例值：7191086414609645000
         *
         * @param feedId
         * @return
         */
        public Builder feedId(String feedId) {
            this.feedId = feedId;
            return this;
        }


        /**
         * 消息卡片类型
         * <p> 示例值：3
         *
         * @param feedType
         * @return
         */
        public Builder feedType(String feedType) {
            this.feedType = feedType;
            return this;
        }

        /**
         * 消息卡片类型
         * <p> 示例值：3
         *
         * @param feedType {@link com.lark.oapi.service.im.v2.enums.FeedGroupItemFeedTypeEnum}
         * @return
         */
        public Builder feedType(com.lark.oapi.service.im.v2.enums.FeedGroupItemFeedTypeEnum feedType) {
            this.feedType = feedType.getValue();
            return this;
        }


        public FeedGroupItem build() {
            return new FeedGroupItem(this);
        }
    }
}
