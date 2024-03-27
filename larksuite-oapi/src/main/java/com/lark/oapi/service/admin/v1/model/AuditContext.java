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

import com.google.gson.annotations.SerializedName;

public class AuditContext {
    /**
     * 终端类型
     * <p> 示例值：
     */
    @SerializedName("terminal_type")
    private Integer terminalType;
    /**
     * ios的环境信息
     * <p> 示例值：
     */
    @SerializedName("ios_context")
    private AuditIosContext iosContext;
    /**
     * pc的环境信息
     * <p> 示例值：
     */
    @SerializedName("pc_context")
    private AuditPcContext pcContext;
    /**
     * web的环境信息
     * <p> 示例值：
     */
    @SerializedName("web_context")
    private AuditWebContext webContext;
    /**
     * android的环境信息
     * <p> 示例值：
     */
    @SerializedName("android_context")
    private AuditAndroidContext androidContext;

    // builder 开始
    public AuditContext() {
    }

    public AuditContext(Builder builder) {
        /**
         * 终端类型
         * <p> 示例值：
         */
        this.terminalType = builder.terminalType;
        /**
         * ios的环境信息
         * <p> 示例值：
         */
        this.iosContext = builder.iosContext;
        /**
         * pc的环境信息
         * <p> 示例值：
         */
        this.pcContext = builder.pcContext;
        /**
         * web的环境信息
         * <p> 示例值：
         */
        this.webContext = builder.webContext;
        /**
         * android的环境信息
         * <p> 示例值：
         */
        this.androidContext = builder.androidContext;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Integer getTerminalType() {
        return this.terminalType;
    }

    public void setTerminalType(Integer terminalType) {
        this.terminalType = terminalType;
    }

    public AuditIosContext getIosContext() {
        return this.iosContext;
    }

    public void setIosContext(AuditIosContext iosContext) {
        this.iosContext = iosContext;
    }

    public AuditPcContext getPcContext() {
        return this.pcContext;
    }

    public void setPcContext(AuditPcContext pcContext) {
        this.pcContext = pcContext;
    }

    public AuditWebContext getWebContext() {
        return this.webContext;
    }

    public void setWebContext(AuditWebContext webContext) {
        this.webContext = webContext;
    }

    public AuditAndroidContext getAndroidContext() {
        return this.androidContext;
    }

    public void setAndroidContext(AuditAndroidContext androidContext) {
        this.androidContext = androidContext;
    }

    public static class Builder {
        /**
         * 终端类型
         * <p> 示例值：
         */
        private Integer terminalType;
        /**
         * ios的环境信息
         * <p> 示例值：
         */
        private AuditIosContext iosContext;
        /**
         * pc的环境信息
         * <p> 示例值：
         */
        private AuditPcContext pcContext;
        /**
         * web的环境信息
         * <p> 示例值：
         */
        private AuditWebContext webContext;
        /**
         * android的环境信息
         * <p> 示例值：
         */
        private AuditAndroidContext androidContext;

        /**
         * 终端类型
         * <p> 示例值：
         *
         * @param terminalType
         * @return
         */
        public Builder terminalType(Integer terminalType) {
            this.terminalType = terminalType;
            return this;
        }

        /**
         * 终端类型
         * <p> 示例值：
         *
         * @param terminalType {@link com.lark.oapi.service.admin.v1.enums.AuditContextTerminalTypeEnum}
         * @return
         */
        public Builder terminalType(com.lark.oapi.service.admin.v1.enums.AuditContextTerminalTypeEnum terminalType) {
            this.terminalType = terminalType.getValue();
            return this;
        }


        /**
         * ios的环境信息
         * <p> 示例值：
         *
         * @param iosContext
         * @return
         */
        public Builder iosContext(AuditIosContext iosContext) {
            this.iosContext = iosContext;
            return this;
        }


        /**
         * pc的环境信息
         * <p> 示例值：
         *
         * @param pcContext
         * @return
         */
        public Builder pcContext(AuditPcContext pcContext) {
            this.pcContext = pcContext;
            return this;
        }


        /**
         * web的环境信息
         * <p> 示例值：
         *
         * @param webContext
         * @return
         */
        public Builder webContext(AuditWebContext webContext) {
            this.webContext = webContext;
            return this;
        }


        /**
         * android的环境信息
         * <p> 示例值：
         *
         * @param androidContext
         * @return
         */
        public Builder androidContext(AuditAndroidContext androidContext) {
            this.androidContext = androidContext;
            return this;
        }


        public AuditContext build() {
            return new AuditContext(this);
        }
    }
}
