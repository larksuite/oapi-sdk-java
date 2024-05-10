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

package com.lark.oapi.service.vc.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.vc.v1.enums.*;
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

public class DisableInformConfig {
    /**
     * 是否覆盖子层级及会议室
     * <p> 示例值：true
     */
    @SerializedName("if_cover_child_scope")
    private Boolean ifCoverChildScope;
    /**
     * 禁用状态变更通知开关
     * <p> 示例值：false
     */
    @SerializedName("if_inform")
    private Boolean ifInform;
    /**
     * 通知成员列表
     * <p> 示例值：
     */
    @SerializedName("informed_users")
    private SubscribeUser[] informedUsers;
    /**
     * 通知部门列表
     * <p> 示例值：
     */
    @SerializedName("informed_depts")
    private SubscribeDepartment[] informedDepts;

    // builder 开始
    public DisableInformConfig() {
    }

    public DisableInformConfig(Builder builder) {
        /**
         * 是否覆盖子层级及会议室
         * <p> 示例值：true
         */
        this.ifCoverChildScope = builder.ifCoverChildScope;
        /**
         * 禁用状态变更通知开关
         * <p> 示例值：false
         */
        this.ifInform = builder.ifInform;
        /**
         * 通知成员列表
         * <p> 示例值：
         */
        this.informedUsers = builder.informedUsers;
        /**
         * 通知部门列表
         * <p> 示例值：
         */
        this.informedDepts = builder.informedDepts;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Boolean getIfCoverChildScope() {
        return this.ifCoverChildScope;
    }

    public void setIfCoverChildScope(Boolean ifCoverChildScope) {
        this.ifCoverChildScope = ifCoverChildScope;
    }

    public Boolean getIfInform() {
        return this.ifInform;
    }

    public void setIfInform(Boolean ifInform) {
        this.ifInform = ifInform;
    }

    public SubscribeUser[] getInformedUsers() {
        return this.informedUsers;
    }

    public void setInformedUsers(SubscribeUser[] informedUsers) {
        this.informedUsers = informedUsers;
    }

    public SubscribeDepartment[] getInformedDepts() {
        return this.informedDepts;
    }

    public void setInformedDepts(SubscribeDepartment[] informedDepts) {
        this.informedDepts = informedDepts;
    }

    public static class Builder {
        /**
         * 是否覆盖子层级及会议室
         * <p> 示例值：true
         */
        private Boolean ifCoverChildScope;
        /**
         * 禁用状态变更通知开关
         * <p> 示例值：false
         */
        private Boolean ifInform;
        /**
         * 通知成员列表
         * <p> 示例值：
         */
        private SubscribeUser[] informedUsers;
        /**
         * 通知部门列表
         * <p> 示例值：
         */
        private SubscribeDepartment[] informedDepts;

        /**
         * 是否覆盖子层级及会议室
         * <p> 示例值：true
         *
         * @param ifCoverChildScope
         * @return
         */
        public Builder ifCoverChildScope(Boolean ifCoverChildScope) {
            this.ifCoverChildScope = ifCoverChildScope;
            return this;
        }


        /**
         * 禁用状态变更通知开关
         * <p> 示例值：false
         *
         * @param ifInform
         * @return
         */
        public Builder ifInform(Boolean ifInform) {
            this.ifInform = ifInform;
            return this;
        }


        /**
         * 通知成员列表
         * <p> 示例值：
         *
         * @param informedUsers
         * @return
         */
        public Builder informedUsers(SubscribeUser[] informedUsers) {
            this.informedUsers = informedUsers;
            return this;
        }


        /**
         * 通知部门列表
         * <p> 示例值：
         *
         * @param informedDepts
         * @return
         */
        public Builder informedDepts(SubscribeDepartment[] informedDepts) {
            this.informedDepts = informedDepts;
            return this;
        }


        public DisableInformConfig build() {
            return new DisableInformConfig(this);
        }
    }
}
