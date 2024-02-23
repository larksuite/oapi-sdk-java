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

import com.google.gson.annotations.SerializedName;

public class MyAiVcMeetingScenarioContext {
    /**
     * 会话选择的插件列表
     * <p> 示例值：
     */
    @SerializedName("plugins")
    private MyAiPluginContext[] plugins;
    /**
     * 会话所在实体的信息
     * <p> 示例值：
     */
    @SerializedName("object")
    private MyAiObjectContext object;
    /**
     * 会话所处的业务模式
     * <p> 示例值：1
     */
    @SerializedName("work_mode")
    private Integer workMode;
    /**
     * 会话所处的业务场景
     * <p> 示例值：IM
     */
    @SerializedName("scenario")
    private String scenario;
    /**
     * 透传数据
     * <p> 示例值：
     */
    @SerializedName("extra")
    private MyAiVcMeetingExtra extra;
    /**
     * system info
     * <p> 示例值：
     */
    @SerializedName("system_info")
    private MyAiAvPluginContextSystemInfo systemInfo;

    // builder 开始
    public MyAiVcMeetingScenarioContext() {
    }

    public MyAiVcMeetingScenarioContext(Builder builder) {
        /**
         * 会话选择的插件列表
         * <p> 示例值：
         */
        this.plugins = builder.plugins;
        /**
         * 会话所在实体的信息
         * <p> 示例值：
         */
        this.object = builder.object;
        /**
         * 会话所处的业务模式
         * <p> 示例值：1
         */
        this.workMode = builder.workMode;
        /**
         * 会话所处的业务场景
         * <p> 示例值：IM
         */
        this.scenario = builder.scenario;
        /**
         * 透传数据
         * <p> 示例值：
         */
        this.extra = builder.extra;
        /**
         * system info
         * <p> 示例值：
         */
        this.systemInfo = builder.systemInfo;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public MyAiPluginContext[] getPlugins() {
        return this.plugins;
    }

    public void setPlugins(MyAiPluginContext[] plugins) {
        this.plugins = plugins;
    }

    public MyAiObjectContext getObject() {
        return this.object;
    }

    public void setObject(MyAiObjectContext object) {
        this.object = object;
    }

    public Integer getWorkMode() {
        return this.workMode;
    }

    public void setWorkMode(Integer workMode) {
        this.workMode = workMode;
    }

    public String getScenario() {
        return this.scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public MyAiVcMeetingExtra getExtra() {
        return this.extra;
    }

    public void setExtra(MyAiVcMeetingExtra extra) {
        this.extra = extra;
    }

    public MyAiAvPluginContextSystemInfo getSystemInfo() {
        return this.systemInfo;
    }

    public void setSystemInfo(MyAiAvPluginContextSystemInfo systemInfo) {
        this.systemInfo = systemInfo;
    }

    public static class Builder {
        /**
         * 会话选择的插件列表
         * <p> 示例值：
         */
        private MyAiPluginContext[] plugins;
        /**
         * 会话所在实体的信息
         * <p> 示例值：
         */
        private MyAiObjectContext object;
        /**
         * 会话所处的业务模式
         * <p> 示例值：1
         */
        private Integer workMode;
        /**
         * 会话所处的业务场景
         * <p> 示例值：IM
         */
        private String scenario;
        /**
         * 透传数据
         * <p> 示例值：
         */
        private MyAiVcMeetingExtra extra;
        /**
         * system info
         * <p> 示例值：
         */
        private MyAiAvPluginContextSystemInfo systemInfo;

        /**
         * 会话选择的插件列表
         * <p> 示例值：
         *
         * @param plugins
         * @return
         */
        public Builder plugins(MyAiPluginContext[] plugins) {
            this.plugins = plugins;
            return this;
        }


        /**
         * 会话所在实体的信息
         * <p> 示例值：
         *
         * @param object
         * @return
         */
        public Builder object(MyAiObjectContext object) {
            this.object = object;
            return this;
        }


        /**
         * 会话所处的业务模式
         * <p> 示例值：1
         *
         * @param workMode
         * @return
         */
        public Builder workMode(Integer workMode) {
            this.workMode = workMode;
            return this;
        }

        /**
         * 会话所处的业务模式
         * <p> 示例值：1
         *
         * @param workMode {@link com.lark.oapi.service.vc.v1.enums.MyAiVcMeetingScenarioContextWorkModeEnum}
         * @return
         */
        public Builder workMode(com.lark.oapi.service.vc.v1.enums.MyAiVcMeetingScenarioContextWorkModeEnum workMode) {
            this.workMode = workMode.getValue();
            return this;
        }


        /**
         * 会话所处的业务场景
         * <p> 示例值：IM
         *
         * @param scenario
         * @return
         */
        public Builder scenario(String scenario) {
            this.scenario = scenario;
            return this;
        }

        /**
         * 会话所处的业务场景
         * <p> 示例值：IM
         *
         * @param scenario {@link com.lark.oapi.service.vc.v1.enums.MyAiVcMeetingScenarioContextScenarioEnum}
         * @return
         */
        public Builder scenario(com.lark.oapi.service.vc.v1.enums.MyAiVcMeetingScenarioContextScenarioEnum scenario) {
            this.scenario = scenario.getValue();
            return this;
        }


        /**
         * 透传数据
         * <p> 示例值：
         *
         * @param extra
         * @return
         */
        public Builder extra(MyAiVcMeetingExtra extra) {
            this.extra = extra;
            return this;
        }


        /**
         * system info
         * <p> 示例值：
         *
         * @param systemInfo
         * @return
         */
        public Builder systemInfo(MyAiAvPluginContextSystemInfo systemInfo) {
            this.systemInfo = systemInfo;
            return this;
        }


        public MyAiVcMeetingScenarioContext build() {
            return new MyAiVcMeetingScenarioContext(this);
        }
    }
}
