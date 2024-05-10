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

public class UrlPin {
    /**
     * url
     * <p> 示例值：https://open.feishu.cn/
     */
    @SerializedName("url")
    private String url;
    /**
     * <p> 示例值：
     */
    @SerializedName("icon")
    private ChatPinIcon icon;
    /**
     * 名称
     * <p> 示例值：待办事项
     */
    @SerializedName("title")
    private String title;
    /**
     * 国际化名称，如果客户端语言环境对应的i18n_title存在则会被优先展示，否则展示title。
     * <p> 示例值：
     */
    @SerializedName("i18n_title")
    private I18nNames i18nTitle;
    /**
     * 标题是否需要动态更新
     * <p> 示例值：false
     */
    @SerializedName("title_dynamic_update")
    private Boolean titleDynamicUpdate;
    /**
     * 图标是否需要动态更新
     * <p> 示例值：false
     */
    @SerializedName("icon_dynamic_update")
    private Boolean iconDynamicUpdate;

    // builder 开始
    public UrlPin() {
    }

    public UrlPin(Builder builder) {
        /**
         * url
         * <p> 示例值：https://open.feishu.cn/
         */
        this.url = builder.url;
        /**
         *
         * <p> 示例值：
         */
        this.icon = builder.icon;
        /**
         * 名称
         * <p> 示例值：待办事项
         */
        this.title = builder.title;
        /**
         * 国际化名称，如果客户端语言环境对应的i18n_title存在则会被优先展示，否则展示title。
         * <p> 示例值：
         */
        this.i18nTitle = builder.i18nTitle;
        /**
         * 标题是否需要动态更新
         * <p> 示例值：false
         */
        this.titleDynamicUpdate = builder.titleDynamicUpdate;
        /**
         * 图标是否需要动态更新
         * <p> 示例值：false
         */
        this.iconDynamicUpdate = builder.iconDynamicUpdate;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ChatPinIcon getIcon() {
        return this.icon;
    }

    public void setIcon(ChatPinIcon icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public I18nNames getI18nTitle() {
        return this.i18nTitle;
    }

    public void setI18nTitle(I18nNames i18nTitle) {
        this.i18nTitle = i18nTitle;
    }

    public Boolean getTitleDynamicUpdate() {
        return this.titleDynamicUpdate;
    }

    public void setTitleDynamicUpdate(Boolean titleDynamicUpdate) {
        this.titleDynamicUpdate = titleDynamicUpdate;
    }

    public Boolean getIconDynamicUpdate() {
        return this.iconDynamicUpdate;
    }

    public void setIconDynamicUpdate(Boolean iconDynamicUpdate) {
        this.iconDynamicUpdate = iconDynamicUpdate;
    }

    public static class Builder {
        /**
         * url
         * <p> 示例值：https://open.feishu.cn/
         */
        private String url;
        /**
         * <p> 示例值：
         */
        private ChatPinIcon icon;
        /**
         * 名称
         * <p> 示例值：待办事项
         */
        private String title;
        /**
         * 国际化名称，如果客户端语言环境对应的i18n_title存在则会被优先展示，否则展示title。
         * <p> 示例值：
         */
        private I18nNames i18nTitle;
        /**
         * 标题是否需要动态更新
         * <p> 示例值：false
         */
        private Boolean titleDynamicUpdate;
        /**
         * 图标是否需要动态更新
         * <p> 示例值：false
         */
        private Boolean iconDynamicUpdate;

        /**
         * url
         * <p> 示例值：https://open.feishu.cn/
         *
         * @param url
         * @return
         */
        public Builder url(String url) {
            this.url = url;
            return this;
        }


        /**
         * <p> 示例值：
         *
         * @param icon
         * @return
         */
        public Builder icon(ChatPinIcon icon) {
            this.icon = icon;
            return this;
        }


        /**
         * 名称
         * <p> 示例值：待办事项
         *
         * @param title
         * @return
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }


        /**
         * 国际化名称，如果客户端语言环境对应的i18n_title存在则会被优先展示，否则展示title。
         * <p> 示例值：
         *
         * @param i18nTitle
         * @return
         */
        public Builder i18nTitle(I18nNames i18nTitle) {
            this.i18nTitle = i18nTitle;
            return this;
        }


        /**
         * 标题是否需要动态更新
         * <p> 示例值：false
         *
         * @param titleDynamicUpdate
         * @return
         */
        public Builder titleDynamicUpdate(Boolean titleDynamicUpdate) {
            this.titleDynamicUpdate = titleDynamicUpdate;
            return this;
        }


        /**
         * 图标是否需要动态更新
         * <p> 示例值：false
         *
         * @param iconDynamicUpdate
         * @return
         */
        public Builder iconDynamicUpdate(Boolean iconDynamicUpdate) {
            this.iconDynamicUpdate = iconDynamicUpdate;
            return this;
        }


        public UrlPin build() {
            return new UrlPin(this);
        }
    }
}
