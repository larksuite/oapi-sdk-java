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

package com.lark.oapi.service.task.v2.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.task.v2.enums.*;
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

public class Section {
    /**
     * 自定义分组的guid
     * <p> 示例值：e6e37dcc-f75a-5936-f589-12fb4b5c80c2
     */
    @SerializedName("guid")
    private String guid;
    /**
     * 自定义分组的名字
     * <p> 示例值：已经评审过的任务
     */
    @SerializedName("name")
    private String name;
    /**
     * 资源类型
     * <p> 示例值：tasklist
     */
    @SerializedName("resource_type")
    private String resourceType;
    /**
     * 分组是否为默认自定义分组
     * <p> 示例值：true
     */
    @SerializedName("is_default")
    private Boolean isDefault;
    /**
     * 自定义分组的创建者
     * <p> 示例值：
     */
    @SerializedName("creator")
    private Member creator;
    /**
     * 如果该分组归属于清单，展示清单的简要信息
     * <p> 示例值：
     */
    @SerializedName("tasklist")
    private TasklistSummary tasklist;
    /**
     * 自定义分组创建时间戳(ms)
     * <p> 示例值：1675742789470
     */
    @SerializedName("created_at")
    private String createdAt;
    /**
     * 自定义分组最近一次更新时间戳(ms)
     * <p> 示例值：1675742789470
     */
    @SerializedName("updated_at")
    private String updatedAt;

    // builder 开始
    public Section() {
    }

    public Section(Builder builder) {
        /**
         * 自定义分组的guid
         * <p> 示例值：e6e37dcc-f75a-5936-f589-12fb4b5c80c2
         */
        this.guid = builder.guid;
        /**
         * 自定义分组的名字
         * <p> 示例值：已经评审过的任务
         */
        this.name = builder.name;
        /**
         * 资源类型
         * <p> 示例值：tasklist
         */
        this.resourceType = builder.resourceType;
        /**
         * 分组是否为默认自定义分组
         * <p> 示例值：true
         */
        this.isDefault = builder.isDefault;
        /**
         * 自定义分组的创建者
         * <p> 示例值：
         */
        this.creator = builder.creator;
        /**
         * 如果该分组归属于清单，展示清单的简要信息
         * <p> 示例值：
         */
        this.tasklist = builder.tasklist;
        /**
         * 自定义分组创建时间戳(ms)
         * <p> 示例值：1675742789470
         */
        this.createdAt = builder.createdAt;
        /**
         * 自定义分组最近一次更新时间戳(ms)
         * <p> 示例值：1675742789470
         */
        this.updatedAt = builder.updatedAt;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getGuid() {
        return this.guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return this.resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Boolean getIsDefault() {
        return this.isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Member getCreator() {
        return this.creator;
    }

    public void setCreator(Member creator) {
        this.creator = creator;
    }

    public TasklistSummary getTasklist() {
        return this.tasklist;
    }

    public void setTasklist(TasklistSummary tasklist) {
        this.tasklist = tasklist;
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
         * 自定义分组的guid
         * <p> 示例值：e6e37dcc-f75a-5936-f589-12fb4b5c80c2
         */
        private String guid;
        /**
         * 自定义分组的名字
         * <p> 示例值：已经评审过的任务
         */
        private String name;
        /**
         * 资源类型
         * <p> 示例值：tasklist
         */
        private String resourceType;
        /**
         * 分组是否为默认自定义分组
         * <p> 示例值：true
         */
        private Boolean isDefault;
        /**
         * 自定义分组的创建者
         * <p> 示例值：
         */
        private Member creator;
        /**
         * 如果该分组归属于清单，展示清单的简要信息
         * <p> 示例值：
         */
        private TasklistSummary tasklist;
        /**
         * 自定义分组创建时间戳(ms)
         * <p> 示例值：1675742789470
         */
        private String createdAt;
        /**
         * 自定义分组最近一次更新时间戳(ms)
         * <p> 示例值：1675742789470
         */
        private String updatedAt;

        /**
         * 自定义分组的guid
         * <p> 示例值：e6e37dcc-f75a-5936-f589-12fb4b5c80c2
         *
         * @param guid
         * @return
         */
        public Builder guid(String guid) {
            this.guid = guid;
            return this;
        }


        /**
         * 自定义分组的名字
         * <p> 示例值：已经评审过的任务
         *
         * @param name
         * @return
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }


        /**
         * 资源类型
         * <p> 示例值：tasklist
         *
         * @param resourceType
         * @return
         */
        public Builder resourceType(String resourceType) {
            this.resourceType = resourceType;
            return this;
        }


        /**
         * 分组是否为默认自定义分组
         * <p> 示例值：true
         *
         * @param isDefault
         * @return
         */
        public Builder isDefault(Boolean isDefault) {
            this.isDefault = isDefault;
            return this;
        }


        /**
         * 自定义分组的创建者
         * <p> 示例值：
         *
         * @param creator
         * @return
         */
        public Builder creator(Member creator) {
            this.creator = creator;
            return this;
        }


        /**
         * 如果该分组归属于清单，展示清单的简要信息
         * <p> 示例值：
         *
         * @param tasklist
         * @return
         */
        public Builder tasklist(TasklistSummary tasklist) {
            this.tasklist = tasklist;
            return this;
        }


        /**
         * 自定义分组创建时间戳(ms)
         * <p> 示例值：1675742789470
         *
         * @param createdAt
         * @return
         */
        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }


        /**
         * 自定义分组最近一次更新时间戳(ms)
         * <p> 示例值：1675742789470
         *
         * @param updatedAt
         * @return
         */
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }


        public Section build() {
            return new Section(this);
        }
    }
}
