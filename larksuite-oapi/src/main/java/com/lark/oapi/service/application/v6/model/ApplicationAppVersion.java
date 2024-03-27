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

package com.lark.oapi.service.application.v6.model;

import com.google.gson.annotations.SerializedName;

public class ApplicationAppVersion {
    /**
     * 应用 id
     * <p> 示例值：cli_9f3ca975326b501b
     */
    @SerializedName("app_id")
    private String appId;
    /**
     * 在开发者后台填入的应用版本号
     * <p> 示例值：1.0.0
     */
    @SerializedName("version")
    private String version;
    /**
     * 唯一标识应用版本的 ID
     * <p> 示例值：oav_d317f090b7258ad0372aa53963cda70d
     */
    @SerializedName("version_id")
    private String versionId;
    /**
     * 应用默认名称
     * <p> 示例值：应用名称
     */
    @SerializedName("app_name")
    private String appName;
    /**
     * 应用头像 url
     * <p> 示例值：https://www.example.com
     */
    @SerializedName("avatar_url")
    private String avatarUrl;
    /**
     * 应用默认描述
     * <p> 示例值：应用描述
     */
    @SerializedName("description")
    private String description;
    /**
     * 应用权限列表
     * <p> 示例值：
     */
    @SerializedName("scopes")
    private AppScope[] scopes;
    /**
     * 后台主页地址
     * <p> 示例值：https://www.example.com
     */
    @SerializedName("back_home_url")
    private String backHomeUrl;
    /**
     * 应用的国际化信息列表
     * <p> 示例值：
     */
    @SerializedName("i18n")
    private AppI18nInfo[] i18n;
    /**
     * 应用分类的国际化描述
     * <p> 示例值：
     */
    @SerializedName("common_categories")
    private String[] commonCategories;
    /**
     * 应用已订阅开放平台事件列表
     * <p> 示例值：
     */
    @SerializedName("events")
    private String[] events;
    /**
     * 版本状态
     * <p> 示例值：1
     */
    @SerializedName("status")
    private Integer status;
    /**
     * 版本创建时间（单位：s）
     * <p> 示例值：1610462759
     */
    @SerializedName("create_time")
    private String createTime;
    /**
     * 版本发布时间（单位：s）
     * <p> 示例值：1610462759
     */
    @SerializedName("publish_time")
    private String publishTime;
    /**
     * 当前版本下应用开启的能力
     * <p> 示例值：
     */
    @SerializedName("ability")
    private AppAbility ability;
    /**
     * 跟随应用版本的信息
     * <p> 示例值：
     */
    @SerializedName("remark")
    private AppVersionRemark remark;
    /**
     * 应用已订阅事件详情列表
     * <p> 示例值：
     */
    @SerializedName("event_infos")
    private Event[] eventInfos;

    // builder 开始
    public ApplicationAppVersion() {
    }

    public ApplicationAppVersion(Builder builder) {
        /**
         * 应用 id
         * <p> 示例值：cli_9f3ca975326b501b
         */
        this.appId = builder.appId;
        /**
         * 在开发者后台填入的应用版本号
         * <p> 示例值：1.0.0
         */
        this.version = builder.version;
        /**
         * 唯一标识应用版本的 ID
         * <p> 示例值：oav_d317f090b7258ad0372aa53963cda70d
         */
        this.versionId = builder.versionId;
        /**
         * 应用默认名称
         * <p> 示例值：应用名称
         */
        this.appName = builder.appName;
        /**
         * 应用头像 url
         * <p> 示例值：https://www.example.com
         */
        this.avatarUrl = builder.avatarUrl;
        /**
         * 应用默认描述
         * <p> 示例值：应用描述
         */
        this.description = builder.description;
        /**
         * 应用权限列表
         * <p> 示例值：
         */
        this.scopes = builder.scopes;
        /**
         * 后台主页地址
         * <p> 示例值：https://www.example.com
         */
        this.backHomeUrl = builder.backHomeUrl;
        /**
         * 应用的国际化信息列表
         * <p> 示例值：
         */
        this.i18n = builder.i18n;
        /**
         * 应用分类的国际化描述
         * <p> 示例值：
         */
        this.commonCategories = builder.commonCategories;
        /**
         * 应用已订阅开放平台事件列表
         * <p> 示例值：
         */
        this.events = builder.events;
        /**
         * 版本状态
         * <p> 示例值：1
         */
        this.status = builder.status;
        /**
         * 版本创建时间（单位：s）
         * <p> 示例值：1610462759
         */
        this.createTime = builder.createTime;
        /**
         * 版本发布时间（单位：s）
         * <p> 示例值：1610462759
         */
        this.publishTime = builder.publishTime;
        /**
         * 当前版本下应用开启的能力
         * <p> 示例值：
         */
        this.ability = builder.ability;
        /**
         * 跟随应用版本的信息
         * <p> 示例值：
         */
        this.remark = builder.remark;
        /**
         * 应用已订阅事件详情列表
         * <p> 示例值：
         */
        this.eventInfos = builder.eventInfos;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAvatarUrl() {
        return this.avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AppScope[] getScopes() {
        return this.scopes;
    }

    public void setScopes(AppScope[] scopes) {
        this.scopes = scopes;
    }

    public String getBackHomeUrl() {
        return this.backHomeUrl;
    }

    public void setBackHomeUrl(String backHomeUrl) {
        this.backHomeUrl = backHomeUrl;
    }

    public AppI18nInfo[] getI18n() {
        return this.i18n;
    }

    public void setI18n(AppI18nInfo[] i18n) {
        this.i18n = i18n;
    }

    public String[] getCommonCategories() {
        return this.commonCategories;
    }

    public void setCommonCategories(String[] commonCategories) {
        this.commonCategories = commonCategories;
    }

    public String[] getEvents() {
        return this.events;
    }

    public void setEvents(String[] events) {
        this.events = events;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPublishTime() {
        return this.publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public AppAbility getAbility() {
        return this.ability;
    }

    public void setAbility(AppAbility ability) {
        this.ability = ability;
    }

    public AppVersionRemark getRemark() {
        return this.remark;
    }

    public void setRemark(AppVersionRemark remark) {
        this.remark = remark;
    }

    public Event[] getEventInfos() {
        return this.eventInfos;
    }

    public void setEventInfos(Event[] eventInfos) {
        this.eventInfos = eventInfos;
    }

    public static class Builder {
        /**
         * 应用 id
         * <p> 示例值：cli_9f3ca975326b501b
         */
        private String appId;
        /**
         * 在开发者后台填入的应用版本号
         * <p> 示例值：1.0.0
         */
        private String version;
        /**
         * 唯一标识应用版本的 ID
         * <p> 示例值：oav_d317f090b7258ad0372aa53963cda70d
         */
        private String versionId;
        /**
         * 应用默认名称
         * <p> 示例值：应用名称
         */
        private String appName;
        /**
         * 应用头像 url
         * <p> 示例值：https://www.example.com
         */
        private String avatarUrl;
        /**
         * 应用默认描述
         * <p> 示例值：应用描述
         */
        private String description;
        /**
         * 应用权限列表
         * <p> 示例值：
         */
        private AppScope[] scopes;
        /**
         * 后台主页地址
         * <p> 示例值：https://www.example.com
         */
        private String backHomeUrl;
        /**
         * 应用的国际化信息列表
         * <p> 示例值：
         */
        private AppI18nInfo[] i18n;
        /**
         * 应用分类的国际化描述
         * <p> 示例值：
         */
        private String[] commonCategories;
        /**
         * 应用已订阅开放平台事件列表
         * <p> 示例值：
         */
        private String[] events;
        /**
         * 版本状态
         * <p> 示例值：1
         */
        private Integer status;
        /**
         * 版本创建时间（单位：s）
         * <p> 示例值：1610462759
         */
        private String createTime;
        /**
         * 版本发布时间（单位：s）
         * <p> 示例值：1610462759
         */
        private String publishTime;
        /**
         * 当前版本下应用开启的能力
         * <p> 示例值：
         */
        private AppAbility ability;
        /**
         * 跟随应用版本的信息
         * <p> 示例值：
         */
        private AppVersionRemark remark;
        /**
         * 应用已订阅事件详情列表
         * <p> 示例值：
         */
        private Event[] eventInfos;

        /**
         * 应用 id
         * <p> 示例值：cli_9f3ca975326b501b
         *
         * @param appId
         * @return
         */
        public Builder appId(String appId) {
            this.appId = appId;
            return this;
        }


        /**
         * 在开发者后台填入的应用版本号
         * <p> 示例值：1.0.0
         *
         * @param version
         * @return
         */
        public Builder version(String version) {
            this.version = version;
            return this;
        }


        /**
         * 唯一标识应用版本的 ID
         * <p> 示例值：oav_d317f090b7258ad0372aa53963cda70d
         *
         * @param versionId
         * @return
         */
        public Builder versionId(String versionId) {
            this.versionId = versionId;
            return this;
        }


        /**
         * 应用默认名称
         * <p> 示例值：应用名称
         *
         * @param appName
         * @return
         */
        public Builder appName(String appName) {
            this.appName = appName;
            return this;
        }


        /**
         * 应用头像 url
         * <p> 示例值：https://www.example.com
         *
         * @param avatarUrl
         * @return
         */
        public Builder avatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
            return this;
        }


        /**
         * 应用默认描述
         * <p> 示例值：应用描述
         *
         * @param description
         * @return
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }


        /**
         * 应用权限列表
         * <p> 示例值：
         *
         * @param scopes
         * @return
         */
        public Builder scopes(AppScope[] scopes) {
            this.scopes = scopes;
            return this;
        }


        /**
         * 后台主页地址
         * <p> 示例值：https://www.example.com
         *
         * @param backHomeUrl
         * @return
         */
        public Builder backHomeUrl(String backHomeUrl) {
            this.backHomeUrl = backHomeUrl;
            return this;
        }


        /**
         * 应用的国际化信息列表
         * <p> 示例值：
         *
         * @param i18n
         * @return
         */
        public Builder i18n(AppI18nInfo[] i18n) {
            this.i18n = i18n;
            return this;
        }


        /**
         * 应用分类的国际化描述
         * <p> 示例值：
         *
         * @param commonCategories
         * @return
         */
        public Builder commonCategories(String[] commonCategories) {
            this.commonCategories = commonCategories;
            return this;
        }


        /**
         * 应用已订阅开放平台事件列表
         * <p> 示例值：
         *
         * @param events
         * @return
         */
        public Builder events(String[] events) {
            this.events = events;
            return this;
        }


        /**
         * 版本状态
         * <p> 示例值：1
         *
         * @param status
         * @return
         */
        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        /**
         * 版本状态
         * <p> 示例值：1
         *
         * @param status {@link com.lark.oapi.service.application.v6.enums.ApplicationAppVersionAppVersionStatusEnum}
         * @return
         */
        public Builder status(com.lark.oapi.service.application.v6.enums.ApplicationAppVersionAppVersionStatusEnum status) {
            this.status = status.getValue();
            return this;
        }


        /**
         * 版本创建时间（单位：s）
         * <p> 示例值：1610462759
         *
         * @param createTime
         * @return
         */
        public Builder createTime(String createTime) {
            this.createTime = createTime;
            return this;
        }


        /**
         * 版本发布时间（单位：s）
         * <p> 示例值：1610462759
         *
         * @param publishTime
         * @return
         */
        public Builder publishTime(String publishTime) {
            this.publishTime = publishTime;
            return this;
        }


        /**
         * 当前版本下应用开启的能力
         * <p> 示例值：
         *
         * @param ability
         * @return
         */
        public Builder ability(AppAbility ability) {
            this.ability = ability;
            return this;
        }


        /**
         * 跟随应用版本的信息
         * <p> 示例值：
         *
         * @param remark
         * @return
         */
        public Builder remark(AppVersionRemark remark) {
            this.remark = remark;
            return this;
        }


        /**
         * 应用已订阅事件详情列表
         * <p> 示例值：
         *
         * @param eventInfos
         * @return
         */
        public Builder eventInfos(Event[] eventInfos) {
            this.eventInfos = eventInfos;
            return this;
        }


        public ApplicationAppVersion build() {
            return new ApplicationAppVersion(this);
        }
    }
}
