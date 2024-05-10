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

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.application.v6.enums.*;
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

public class AppCustomCategory {
    /**
     * 国际化语言的 key
     * <p> 示例值：zh_cn
     */
    @SerializedName("i18n_key")
    private String i18nKey;
    /**
     * 应用权限的国际化描述
     * <p> 示例值：获取应用信息
     */
    @SerializedName("description")
    private String description;
    /**
     * 在该分组下的应用 id 列表
     * <p> 示例值：
     */
    @SerializedName("app_ids")
    private String[] appIds;

    // builder 开始
    public AppCustomCategory() {
    }

    public AppCustomCategory(Builder builder) {
        /**
         * 国际化语言的 key
         * <p> 示例值：zh_cn
         */
        this.i18nKey = builder.i18nKey;
        /**
         * 应用权限的国际化描述
         * <p> 示例值：获取应用信息
         */
        this.description = builder.description;
        /**
         * 在该分组下的应用 id 列表
         * <p> 示例值：
         */
        this.appIds = builder.appIds;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getI18nKey() {
        return this.i18nKey;
    }

    public void setI18nKey(String i18nKey) {
        this.i18nKey = i18nKey;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getAppIds() {
        return this.appIds;
    }

    public void setAppIds(String[] appIds) {
        this.appIds = appIds;
    }

    public static class Builder {
        /**
         * 国际化语言的 key
         * <p> 示例值：zh_cn
         */
        private String i18nKey;
        /**
         * 应用权限的国际化描述
         * <p> 示例值：获取应用信息
         */
        private String description;
        /**
         * 在该分组下的应用 id 列表
         * <p> 示例值：
         */
        private String[] appIds;

        /**
         * 国际化语言的 key
         * <p> 示例值：zh_cn
         *
         * @param i18nKey
         * @return
         */
        public Builder i18nKey(String i18nKey) {
            this.i18nKey = i18nKey;
            return this;
        }

        /**
         * 国际化语言的 key
         * <p> 示例值：zh_cn
         *
         * @param i18nKey {@link com.lark.oapi.service.application.v6.enums.AppCustomCategoryI18nKeyEnum}
         * @return
         */
        public Builder i18nKey(com.lark.oapi.service.application.v6.enums.AppCustomCategoryI18nKeyEnum i18nKey) {
            this.i18nKey = i18nKey.getValue();
            return this;
        }


        /**
         * 应用权限的国际化描述
         * <p> 示例值：获取应用信息
         *
         * @param description
         * @return
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }


        /**
         * 在该分组下的应用 id 列表
         * <p> 示例值：
         *
         * @param appIds
         * @return
         */
        public Builder appIds(String[] appIds) {
            this.appIds = appIds;
            return this;
        }


        public AppCustomCategory build() {
            return new AppCustomCategory(this);
        }
    }
}
