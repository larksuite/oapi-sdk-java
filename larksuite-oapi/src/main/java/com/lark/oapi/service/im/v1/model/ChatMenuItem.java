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

package com.lark.oapi.service.im.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.im.v1.enums.*;
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

public class ChatMenuItem {
    /**
     * 菜单类型
     * <p> 示例值：NONE
     */
    @SerializedName("action_type")
    private String actionType;
    /**
     * 跳转链接
     * <p> 示例值：
     */
    @SerializedName("redirect_link")
    private ChatMenuItemRedirectLink redirectLink;
    /**
     * image_key，通过 [上传图片](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/im-v1/image/create) 接口上传message类型图片获取image_key
     * <p> 示例值：img_v2_b0fbe905-7988-4282-b882-82edd010336j
     */
    @SerializedName("image_key")
    private String imageKey;
    /**
     * 名称，一级菜单名称字符数要在1到8范围内，二级菜单名称字符数要在1到24范围内;;;**注意：** ;- 1中文=2英文=2其他语言字符=2字符
     * <p> 示例值：群聊
     */
    @SerializedName("name")
    private String name;
    /**
     * 国际化名称，一级菜单名称字符数要在1到8范围内，二级菜单名称字符数要在1到24范围内;;**注意：**;- 1中文=2英文=2其他语言字符=2字符
     * <p> 示例值：
     */
    @SerializedName("i18n_names")
    private I18nNames i18nNames;

    // builder 开始
    public ChatMenuItem() {
    }

    public ChatMenuItem(Builder builder) {
        /**
         * 菜单类型
         * <p> 示例值：NONE
         */
        this.actionType = builder.actionType;
        /**
         * 跳转链接
         * <p> 示例值：
         */
        this.redirectLink = builder.redirectLink;
        /**
         * image_key，通过 [上传图片](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/im-v1/image/create) 接口上传message类型图片获取image_key
         * <p> 示例值：img_v2_b0fbe905-7988-4282-b882-82edd010336j
         */
        this.imageKey = builder.imageKey;
        /**
         * 名称，一级菜单名称字符数要在1到8范围内，二级菜单名称字符数要在1到24范围内;;;**注意：** ;- 1中文=2英文=2其他语言字符=2字符
         * <p> 示例值：群聊
         */
        this.name = builder.name;
        /**
         * 国际化名称，一级菜单名称字符数要在1到8范围内，二级菜单名称字符数要在1到24范围内;;**注意：**;- 1中文=2英文=2其他语言字符=2字符
         * <p> 示例值：
         */
        this.i18nNames = builder.i18nNames;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getActionType() {
        return this.actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public ChatMenuItemRedirectLink getRedirectLink() {
        return this.redirectLink;
    }

    public void setRedirectLink(ChatMenuItemRedirectLink redirectLink) {
        this.redirectLink = redirectLink;
    }

    public String getImageKey() {
        return this.imageKey;
    }

    public void setImageKey(String imageKey) {
        this.imageKey = imageKey;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public I18nNames getI18nNames() {
        return this.i18nNames;
    }

    public void setI18nNames(I18nNames i18nNames) {
        this.i18nNames = i18nNames;
    }

    public static class Builder {
        /**
         * 菜单类型
         * <p> 示例值：NONE
         */
        private String actionType;
        /**
         * 跳转链接
         * <p> 示例值：
         */
        private ChatMenuItemRedirectLink redirectLink;
        /**
         * image_key，通过 [上传图片](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/im-v1/image/create) 接口上传message类型图片获取image_key
         * <p> 示例值：img_v2_b0fbe905-7988-4282-b882-82edd010336j
         */
        private String imageKey;
        /**
         * 名称，一级菜单名称字符数要在1到8范围内，二级菜单名称字符数要在1到24范围内;;;**注意：** ;- 1中文=2英文=2其他语言字符=2字符
         * <p> 示例值：群聊
         */
        private String name;
        /**
         * 国际化名称，一级菜单名称字符数要在1到8范围内，二级菜单名称字符数要在1到24范围内;;**注意：**;- 1中文=2英文=2其他语言字符=2字符
         * <p> 示例值：
         */
        private I18nNames i18nNames;

        /**
         * 菜单类型
         * <p> 示例值：NONE
         *
         * @param actionType
         * @return
         */
        public Builder actionType(String actionType) {
            this.actionType = actionType;
            return this;
        }

        /**
         * 菜单类型
         * <p> 示例值：NONE
         *
         * @param actionType {@link com.lark.oapi.service.im.v1.enums.ChatMenuItemChatMenuItemActionTypeEnum}
         * @return
         */
        public Builder actionType(com.lark.oapi.service.im.v1.enums.ChatMenuItemChatMenuItemActionTypeEnum actionType) {
            this.actionType = actionType.getValue();
            return this;
        }


        /**
         * 跳转链接
         * <p> 示例值：
         *
         * @param redirectLink
         * @return
         */
        public Builder redirectLink(ChatMenuItemRedirectLink redirectLink) {
            this.redirectLink = redirectLink;
            return this;
        }


        /**
         * image_key，通过 [上传图片](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/im-v1/image/create) 接口上传message类型图片获取image_key
         * <p> 示例值：img_v2_b0fbe905-7988-4282-b882-82edd010336j
         *
         * @param imageKey
         * @return
         */
        public Builder imageKey(String imageKey) {
            this.imageKey = imageKey;
            return this;
        }


        /**
         * 名称，一级菜单名称字符数要在1到8范围内，二级菜单名称字符数要在1到24范围内;;;**注意：** ;- 1中文=2英文=2其他语言字符=2字符
         * <p> 示例值：群聊
         *
         * @param name
         * @return
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }


        /**
         * 国际化名称，一级菜单名称字符数要在1到8范围内，二级菜单名称字符数要在1到24范围内;;**注意：**;- 1中文=2英文=2其他语言字符=2字符
         * <p> 示例值：
         *
         * @param i18nNames
         * @return
         */
        public Builder i18nNames(I18nNames i18nNames) {
            this.i18nNames = i18nNames;
            return this;
        }


        public ChatMenuItem build() {
            return new ChatMenuItem(this);
        }
    }
}
