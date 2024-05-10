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

package com.lark.oapi.service.baike.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.baike.v1.enums.*;
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

public class Entity {
    /**
     * 词条 ID （需要更新某个词条时填写，若是创建新词条可不填写）
     * <p> 示例值：enterprise_40217521
     */
    @SerializedName("id")
    private String id;
    /**
     * 词条名
     * <p> 示例值：
     */
    @SerializedName("main_keys")
    private Term[] mainKeys;
    /**
     * 别名
     * <p> 示例值：
     */
    @SerializedName("aliases")
    private Term[] aliases;
    /**
     * 词条释义（纯文本格式）
     * <p> 示例值：企业百科是飞书提供的一款知识管理工具，通过企业百科可以帮助企业将分散的知识信息进行聚合，并通过UGC的方式，促进企业知识的保鲜和流通
     */
    @SerializedName("description")
    private String description;
    /**
     * 创建者
     * <p> 示例值：ou_30b07b63089ea46518789914dac63d36
     */
    @SerializedName("creator")
    private String creator;
    /**
     * 词条创建时间
     * <p> 示例值：1649318125
     */
    @SerializedName("create_time")
    private String createTime;
    /**
     * 最近一次更新者
     * <p> 示例值：ou_30b07b63089ea46518789914dac63d36
     */
    @SerializedName("updater")
    private String updater;
    /**
     * 词条最近更新时间
     * <p> 示例值：1649318125
     */
    @SerializedName("update_time")
    private String updateTime;
    /**
     * 更多相关信息
     * <p> 示例值：
     */
    @SerializedName("related_meta")
    private RelatedMeta relatedMeta;
    /**
     * 当前词条收到的反馈数据
     * <p> 示例值：
     */
    @SerializedName("statistics")
    private Statistics statistics;
    /**
     * 外部系统关联数据
     * <p> 示例值：
     */
    @SerializedName("outer_info")
    private OuterInfo outerInfo;
    /**
     * 富文本格式（当填写富文本内容时，description字段将会失效可不填写），支持的格式参考[企业百科指南](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/baike-v1/overview)中的释义部分
     * <p> 示例值：&lt;b&gt;加粗&lt;/b&gt;&lt;i&gt;斜体&lt;/i&gt;&lt;p&gt;&lt;a href=\"https://feishu.cn\"&gt;链接&lt;/a&gt;&lt;/p&gt;&lt;p&gt;&lt;span&gt;企业百科是飞书提供的一款知识管理工具，通过企业百科可以帮助企业将分散的知识信息进行聚合，并通过UGC的方式，促进企业知识的保鲜和流通&lt;/span&gt;&lt;/p&gt;
     */
    @SerializedName("rich_text")
    private String richText;
    /**
     * 词条的创建来源，1：用户主动创建，2：批量导入，3：官方词，4：OpenAPI 创建
     * <p> 示例值：1
     */
    @SerializedName("source")
    private Integer source;

    // builder 开始
    public Entity() {
    }

    public Entity(Builder builder) {
        /**
         * 词条 ID （需要更新某个词条时填写，若是创建新词条可不填写）
         * <p> 示例值：enterprise_40217521
         */
        this.id = builder.id;
        /**
         * 词条名
         * <p> 示例值：
         */
        this.mainKeys = builder.mainKeys;
        /**
         * 别名
         * <p> 示例值：
         */
        this.aliases = builder.aliases;
        /**
         * 词条释义（纯文本格式）
         * <p> 示例值：企业百科是飞书提供的一款知识管理工具，通过企业百科可以帮助企业将分散的知识信息进行聚合，并通过UGC的方式，促进企业知识的保鲜和流通
         */
        this.description = builder.description;
        /**
         * 创建者
         * <p> 示例值：ou_30b07b63089ea46518789914dac63d36
         */
        this.creator = builder.creator;
        /**
         * 词条创建时间
         * <p> 示例值：1649318125
         */
        this.createTime = builder.createTime;
        /**
         * 最近一次更新者
         * <p> 示例值：ou_30b07b63089ea46518789914dac63d36
         */
        this.updater = builder.updater;
        /**
         * 词条最近更新时间
         * <p> 示例值：1649318125
         */
        this.updateTime = builder.updateTime;
        /**
         * 更多相关信息
         * <p> 示例值：
         */
        this.relatedMeta = builder.relatedMeta;
        /**
         * 当前词条收到的反馈数据
         * <p> 示例值：
         */
        this.statistics = builder.statistics;
        /**
         * 外部系统关联数据
         * <p> 示例值：
         */
        this.outerInfo = builder.outerInfo;
        /**
         * 富文本格式（当填写富文本内容时，description字段将会失效可不填写），支持的格式参考[企业百科指南](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/baike-v1/overview)中的释义部分
         * <p> 示例值：&lt;b&gt;加粗&lt;/b&gt;&lt;i&gt;斜体&lt;/i&gt;&lt;p&gt;&lt;a href=\"https://feishu.cn\"&gt;链接&lt;/a&gt;&lt;/p&gt;&lt;p&gt;&lt;span&gt;企业百科是飞书提供的一款知识管理工具，通过企业百科可以帮助企业将分散的知识信息进行聚合，并通过UGC的方式，促进企业知识的保鲜和流通&lt;/span&gt;&lt;/p&gt;
         */
        this.richText = builder.richText;
        /**
         * 词条的创建来源，1：用户主动创建，2：批量导入，3：官方词，4：OpenAPI 创建
         * <p> 示例值：1
         */
        this.source = builder.source;
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

    public Term[] getMainKeys() {
        return this.mainKeys;
    }

    public void setMainKeys(Term[] mainKeys) {
        this.mainKeys = mainKeys;
    }

    public Term[] getAliases() {
        return this.aliases;
    }

    public void setAliases(Term[] aliases) {
        this.aliases = aliases;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return this.updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public RelatedMeta getRelatedMeta() {
        return this.relatedMeta;
    }

    public void setRelatedMeta(RelatedMeta relatedMeta) {
        this.relatedMeta = relatedMeta;
    }

    public Statistics getStatistics() {
        return this.statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public OuterInfo getOuterInfo() {
        return this.outerInfo;
    }

    public void setOuterInfo(OuterInfo outerInfo) {
        this.outerInfo = outerInfo;
    }

    public String getRichText() {
        return this.richText;
    }

    public void setRichText(String richText) {
        this.richText = richText;
    }

    public Integer getSource() {
        return this.source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public static class Builder {
        /**
         * 词条 ID （需要更新某个词条时填写，若是创建新词条可不填写）
         * <p> 示例值：enterprise_40217521
         */
        private String id;
        /**
         * 词条名
         * <p> 示例值：
         */
        private Term[] mainKeys;
        /**
         * 别名
         * <p> 示例值：
         */
        private Term[] aliases;
        /**
         * 词条释义（纯文本格式）
         * <p> 示例值：企业百科是飞书提供的一款知识管理工具，通过企业百科可以帮助企业将分散的知识信息进行聚合，并通过UGC的方式，促进企业知识的保鲜和流通
         */
        private String description;
        /**
         * 创建者
         * <p> 示例值：ou_30b07b63089ea46518789914dac63d36
         */
        private String creator;
        /**
         * 词条创建时间
         * <p> 示例值：1649318125
         */
        private String createTime;
        /**
         * 最近一次更新者
         * <p> 示例值：ou_30b07b63089ea46518789914dac63d36
         */
        private String updater;
        /**
         * 词条最近更新时间
         * <p> 示例值：1649318125
         */
        private String updateTime;
        /**
         * 更多相关信息
         * <p> 示例值：
         */
        private RelatedMeta relatedMeta;
        /**
         * 当前词条收到的反馈数据
         * <p> 示例值：
         */
        private Statistics statistics;
        /**
         * 外部系统关联数据
         * <p> 示例值：
         */
        private OuterInfo outerInfo;
        /**
         * 富文本格式（当填写富文本内容时，description字段将会失效可不填写），支持的格式参考[企业百科指南](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/baike-v1/overview)中的释义部分
         * <p> 示例值：&lt;b&gt;加粗&lt;/b&gt;&lt;i&gt;斜体&lt;/i&gt;&lt;p&gt;&lt;a href=\"https://feishu.cn\"&gt;链接&lt;/a&gt;&lt;/p&gt;&lt;p&gt;&lt;span&gt;企业百科是飞书提供的一款知识管理工具，通过企业百科可以帮助企业将分散的知识信息进行聚合，并通过UGC的方式，促进企业知识的保鲜和流通&lt;/span&gt;&lt;/p&gt;
         */
        private String richText;
        /**
         * 词条的创建来源，1：用户主动创建，2：批量导入，3：官方词，4：OpenAPI 创建
         * <p> 示例值：1
         */
        private Integer source;

        /**
         * 词条 ID （需要更新某个词条时填写，若是创建新词条可不填写）
         * <p> 示例值：enterprise_40217521
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 词条名
         * <p> 示例值：
         *
         * @param mainKeys
         * @return
         */
        public Builder mainKeys(Term[] mainKeys) {
            this.mainKeys = mainKeys;
            return this;
        }


        /**
         * 别名
         * <p> 示例值：
         *
         * @param aliases
         * @return
         */
        public Builder aliases(Term[] aliases) {
            this.aliases = aliases;
            return this;
        }


        /**
         * 词条释义（纯文本格式）
         * <p> 示例值：企业百科是飞书提供的一款知识管理工具，通过企业百科可以帮助企业将分散的知识信息进行聚合，并通过UGC的方式，促进企业知识的保鲜和流通
         *
         * @param description
         * @return
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }


        /**
         * 创建者
         * <p> 示例值：ou_30b07b63089ea46518789914dac63d36
         *
         * @param creator
         * @return
         */
        public Builder creator(String creator) {
            this.creator = creator;
            return this;
        }


        /**
         * 词条创建时间
         * <p> 示例值：1649318125
         *
         * @param createTime
         * @return
         */
        public Builder createTime(String createTime) {
            this.createTime = createTime;
            return this;
        }


        /**
         * 最近一次更新者
         * <p> 示例值：ou_30b07b63089ea46518789914dac63d36
         *
         * @param updater
         * @return
         */
        public Builder updater(String updater) {
            this.updater = updater;
            return this;
        }


        /**
         * 词条最近更新时间
         * <p> 示例值：1649318125
         *
         * @param updateTime
         * @return
         */
        public Builder updateTime(String updateTime) {
            this.updateTime = updateTime;
            return this;
        }


        /**
         * 更多相关信息
         * <p> 示例值：
         *
         * @param relatedMeta
         * @return
         */
        public Builder relatedMeta(RelatedMeta relatedMeta) {
            this.relatedMeta = relatedMeta;
            return this;
        }


        /**
         * 当前词条收到的反馈数据
         * <p> 示例值：
         *
         * @param statistics
         * @return
         */
        public Builder statistics(Statistics statistics) {
            this.statistics = statistics;
            return this;
        }


        /**
         * 外部系统关联数据
         * <p> 示例值：
         *
         * @param outerInfo
         * @return
         */
        public Builder outerInfo(OuterInfo outerInfo) {
            this.outerInfo = outerInfo;
            return this;
        }


        /**
         * 富文本格式（当填写富文本内容时，description字段将会失效可不填写），支持的格式参考[企业百科指南](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/baike-v1/overview)中的释义部分
         * <p> 示例值：&lt;b&gt;加粗&lt;/b&gt;&lt;i&gt;斜体&lt;/i&gt;&lt;p&gt;&lt;a href=\"https://feishu.cn\"&gt;链接&lt;/a&gt;&lt;/p&gt;&lt;p&gt;&lt;span&gt;企业百科是飞书提供的一款知识管理工具，通过企业百科可以帮助企业将分散的知识信息进行聚合，并通过UGC的方式，促进企业知识的保鲜和流通&lt;/span&gt;&lt;/p&gt;
         *
         * @param richText
         * @return
         */
        public Builder richText(String richText) {
            this.richText = richText;
            return this;
        }


        /**
         * 词条的创建来源，1：用户主动创建，2：批量导入，3：官方词，4：OpenAPI 创建
         * <p> 示例值：1
         *
         * @param source
         * @return
         */
        public Builder source(Integer source) {
            this.source = source;
            return this;
        }


        public Entity build() {
            return new Entity(this);
        }
    }
}
