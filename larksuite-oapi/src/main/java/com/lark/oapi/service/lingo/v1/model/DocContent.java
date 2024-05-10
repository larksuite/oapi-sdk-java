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

package com.lark.oapi.service.lingo.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.lingo.v1.enums.*;
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

public class DocContent {
    /**
     * 节点ID
     * <p> 示例值：xxxxx
     */
    @SerializedName("id")
    private String id;
    /**
     * 子节点
     * <p> 示例值：
     */
    @SerializedName("children")
    private String[] children;
    /**
     * 内容类型
     * <p> 示例值：1
     */
    @SerializedName("content_type")
    private Integer contentType;
    /**
     * 纯文本
     * <p> 示例值：
     */
    @SerializedName("text")
    private DocText text;
    /**
     * 标题
     * <p> 示例值：
     */
    @SerializedName("heading")
    private DocHeading heading;
    /**
     * 无序列表
     * <p> 示例值：
     */
    @SerializedName("bullet")
    private DocBullet bullet;
    /**
     * 有序列表
     * <p> 示例值：
     */
    @SerializedName("ordered")
    private DocRodered ordered;
    /**
     * 代码块
     * <p> 示例值：
     */
    @SerializedName("code")
    private DocCode code;
    /**
     * 链接
     * <p> 示例值：
     */
    @SerializedName("link")
    private DocLink link;
    /**
     * 图片
     * <p> 示例值：
     */
    @SerializedName("image")
    private DocImage image;
    /**
     * 用户
     * <p> 示例值：
     */
    @SerializedName("user")
    private DocUser user;
    /**
     * 分割线
     * <p> 示例值：
     */
    @SerializedName("divider")
    private DocDivider divider;
    /**
     * 容器
     * <p> 示例值：
     */
    @SerializedName("container")
    private DocContainer container;

    // builder 开始
    public DocContent() {
    }

    public DocContent(Builder builder) {
        /**
         * 节点ID
         * <p> 示例值：xxxxx
         */
        this.id = builder.id;
        /**
         * 子节点
         * <p> 示例值：
         */
        this.children = builder.children;
        /**
         * 内容类型
         * <p> 示例值：1
         */
        this.contentType = builder.contentType;
        /**
         * 纯文本
         * <p> 示例值：
         */
        this.text = builder.text;
        /**
         * 标题
         * <p> 示例值：
         */
        this.heading = builder.heading;
        /**
         * 无序列表
         * <p> 示例值：
         */
        this.bullet = builder.bullet;
        /**
         * 有序列表
         * <p> 示例值：
         */
        this.ordered = builder.ordered;
        /**
         * 代码块
         * <p> 示例值：
         */
        this.code = builder.code;
        /**
         * 链接
         * <p> 示例值：
         */
        this.link = builder.link;
        /**
         * 图片
         * <p> 示例值：
         */
        this.image = builder.image;
        /**
         * 用户
         * <p> 示例值：
         */
        this.user = builder.user;
        /**
         * 分割线
         * <p> 示例值：
         */
        this.divider = builder.divider;
        /**
         * 容器
         * <p> 示例值：
         */
        this.container = builder.container;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getChildren() {
        return this.children;
    }

    public void setChildren(String[] children) {
        this.children = children;
    }

    public Integer getContentType() {
        return this.contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public DocText getText() {
        return this.text;
    }

    public void setText(DocText text) {
        this.text = text;
    }

    public DocHeading getHeading() {
        return this.heading;
    }

    public void setHeading(DocHeading heading) {
        this.heading = heading;
    }

    public DocBullet getBullet() {
        return this.bullet;
    }

    public void setBullet(DocBullet bullet) {
        this.bullet = bullet;
    }

    public DocRodered getOrdered() {
        return this.ordered;
    }

    public void setOrdered(DocRodered ordered) {
        this.ordered = ordered;
    }

    public DocCode getCode() {
        return this.code;
    }

    public void setCode(DocCode code) {
        this.code = code;
    }

    public DocLink getLink() {
        return this.link;
    }

    public void setLink(DocLink link) {
        this.link = link;
    }

    public DocImage getImage() {
        return this.image;
    }

    public void setImage(DocImage image) {
        this.image = image;
    }

    public DocUser getUser() {
        return this.user;
    }

    public void setUser(DocUser user) {
        this.user = user;
    }

    public DocDivider getDivider() {
        return this.divider;
    }

    public void setDivider(DocDivider divider) {
        this.divider = divider;
    }

    public DocContainer getContainer() {
        return this.container;
    }

    public void setContainer(DocContainer container) {
        this.container = container;
    }

    public static class Builder {
        /**
         * 节点ID
         * <p> 示例值：xxxxx
         */
        private String id;
        /**
         * 子节点
         * <p> 示例值：
         */
        private String[] children;
        /**
         * 内容类型
         * <p> 示例值：1
         */
        private Integer contentType;
        /**
         * 纯文本
         * <p> 示例值：
         */
        private DocText text;
        /**
         * 标题
         * <p> 示例值：
         */
        private DocHeading heading;
        /**
         * 无序列表
         * <p> 示例值：
         */
        private DocBullet bullet;
        /**
         * 有序列表
         * <p> 示例值：
         */
        private DocRodered ordered;
        /**
         * 代码块
         * <p> 示例值：
         */
        private DocCode code;
        /**
         * 链接
         * <p> 示例值：
         */
        private DocLink link;
        /**
         * 图片
         * <p> 示例值：
         */
        private DocImage image;
        /**
         * 用户
         * <p> 示例值：
         */
        private DocUser user;
        /**
         * 分割线
         * <p> 示例值：
         */
        private DocDivider divider;
        /**
         * 容器
         * <p> 示例值：
         */
        private DocContainer container;

        /**
         * 节点ID
         * <p> 示例值：xxxxx
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 子节点
         * <p> 示例值：
         *
         * @param children
         * @return
         */
        public Builder children(String[] children) {
            this.children = children;
            return this;
        }


        /**
         * 内容类型
         * <p> 示例值：1
         *
         * @param contentType
         * @return
         */
        public Builder contentType(Integer contentType) {
            this.contentType = contentType;
            return this;
        }

        /**
         * 内容类型
         * <p> 示例值：1
         *
         * @param contentType {@link com.lark.oapi.service.lingo.v1.enums.DocContentContentTypeEnum}
         * @return
         */
        public Builder contentType(com.lark.oapi.service.lingo.v1.enums.DocContentContentTypeEnum contentType) {
            this.contentType = contentType.getValue();
            return this;
        }


        /**
         * 纯文本
         * <p> 示例值：
         *
         * @param text
         * @return
         */
        public Builder text(DocText text) {
            this.text = text;
            return this;
        }


        /**
         * 标题
         * <p> 示例值：
         *
         * @param heading
         * @return
         */
        public Builder heading(DocHeading heading) {
            this.heading = heading;
            return this;
        }


        /**
         * 无序列表
         * <p> 示例值：
         *
         * @param bullet
         * @return
         */
        public Builder bullet(DocBullet bullet) {
            this.bullet = bullet;
            return this;
        }


        /**
         * 有序列表
         * <p> 示例值：
         *
         * @param ordered
         * @return
         */
        public Builder ordered(DocRodered ordered) {
            this.ordered = ordered;
            return this;
        }


        /**
         * 代码块
         * <p> 示例值：
         *
         * @param code
         * @return
         */
        public Builder code(DocCode code) {
            this.code = code;
            return this;
        }


        /**
         * 链接
         * <p> 示例值：
         *
         * @param link
         * @return
         */
        public Builder link(DocLink link) {
            this.link = link;
            return this;
        }


        /**
         * 图片
         * <p> 示例值：
         *
         * @param image
         * @return
         */
        public Builder image(DocImage image) {
            this.image = image;
            return this;
        }


        /**
         * 用户
         * <p> 示例值：
         *
         * @param user
         * @return
         */
        public Builder user(DocUser user) {
            this.user = user;
            return this;
        }


        /**
         * 分割线
         * <p> 示例值：
         *
         * @param divider
         * @return
         */
        public Builder divider(DocDivider divider) {
            this.divider = divider;
            return this;
        }


        /**
         * 容器
         * <p> 示例值：
         *
         * @param container
         * @return
         */
        public Builder container(DocContainer container) {
            this.container = container;
            return this;
        }


        public DocContent build() {
            return new DocContent(this);
        }
    }
}
