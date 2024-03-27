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

package com.lark.oapi.service.search.v2.model;

import com.google.gson.annotations.SerializedName;

public class ItemRecord {
    /**
     * 冗余当前item的ID
     * <p> 示例值：
     */
    @SerializedName("item_id")
    private String itemId;
    /**
     * 数据源id
     * <p> 示例值：
     */
    @SerializedName("data_source_id")
    private String dataSourceId;
    /**
     * 当前数据的最新版本号，其值等于上一次item/create接口传入的时间戳
     * <p> 示例值：
     */
    @SerializedName("version")
    private String version;
    /**
     * 第一次投递时间
     * <p> 示例值：
     */
    @SerializedName("created_at")
    private String createdAt;
    /**
     * 上一次更新落库时间
     * <p> 示例值：
     */
    @SerializedName("updated_at")
    private String updatedAt;

    // builder 开始
    public ItemRecord() {
    }

    public ItemRecord(Builder builder) {
        /**
         * 冗余当前item的ID
         * <p> 示例值：
         */
        this.itemId = builder.itemId;
        /**
         * 数据源id
         * <p> 示例值：
         */
        this.dataSourceId = builder.dataSourceId;
        /**
         * 当前数据的最新版本号，其值等于上一次item/create接口传入的时间戳
         * <p> 示例值：
         */
        this.version = builder.version;
        /**
         * 第一次投递时间
         * <p> 示例值：
         */
        this.createdAt = builder.createdAt;
        /**
         * 上一次更新落库时间
         * <p> 示例值：
         */
        this.updatedAt = builder.updatedAt;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getItemId() {
        return this.itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDataSourceId() {
        return this.dataSourceId;
    }

    public void setDataSourceId(String dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static class Builder {
        /**
         * 冗余当前item的ID
         * <p> 示例值：
         */
        private String itemId;
        /**
         * 数据源id
         * <p> 示例值：
         */
        private String dataSourceId;
        /**
         * 当前数据的最新版本号，其值等于上一次item/create接口传入的时间戳
         * <p> 示例值：
         */
        private String version;
        /**
         * 第一次投递时间
         * <p> 示例值：
         */
        private String createdAt;
        /**
         * 上一次更新落库时间
         * <p> 示例值：
         */
        private String updatedAt;

        /**
         * 冗余当前item的ID
         * <p> 示例值：
         *
         * @param itemId
         * @return
         */
        public Builder itemId(String itemId) {
            this.itemId = itemId;
            return this;
        }


        /**
         * 数据源id
         * <p> 示例值：
         *
         * @param dataSourceId
         * @return
         */
        public Builder dataSourceId(String dataSourceId) {
            this.dataSourceId = dataSourceId;
            return this;
        }


        /**
         * 当前数据的最新版本号，其值等于上一次item/create接口传入的时间戳
         * <p> 示例值：
         *
         * @param version
         * @return
         */
        public Builder version(String version) {
            this.version = version;
            return this;
        }


        /**
         * 第一次投递时间
         * <p> 示例值：
         *
         * @param createdAt
         * @return
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }


        /**
         * 上一次更新落库时间
         * <p> 示例值：
         *
         * @param updatedAt
         * @return
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }


        public ItemRecord build() {
            return new ItemRecord(this);
        }
    }
}
