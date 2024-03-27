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

package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;

public class Faq {
    /**
     * 知识库ID
     * <p> 示例值：6936004780707807231
     */
    @SerializedName("faq_id")
    private String faqId;
    /**
     * 知识库旧版ID，请使用faq_id
     * <p> 示例值：6936004780707807231
     */
    @SerializedName("id")
    private String id;
    /**
     * 服务台ID
     * <p> 示例值：6936004780707807251
     */
    @SerializedName("helpdesk_id")
    private String helpdeskId;
    /**
     * 问题
     * <p> 示例值：问题
     */
    @SerializedName("question")
    private String question;
    /**
     * 答案
     * <p> 示例值：答案
     */
    @SerializedName("answer")
    private String answer;
    /**
     * 富文本答案
     * <p> 示例值：
     */
    @SerializedName("answer_richtext")
    private Richtext[] answerRichtext;
    /**
     * 创建时间
     * <p> 示例值：1596379008
     */
    @SerializedName("create_time")
    private Integer createTime;
    /**
     * 修改时间
     * <p> 示例值：1596379008
     */
    @SerializedName("update_time")
    private Integer updateTime;
    /**
     * 分类
     * <p> 示例值：
     */
    @SerializedName("categories")
    private Category[] categories;
    /**
     * 相似问题列表
     * <p> 示例值：
     */
    @SerializedName("tags")
    private String[] tags;
    /**
     * 失效时间
     * <p> 示例值：1596379008
     */
    @SerializedName("expire_time")
    private Integer expireTime;
    /**
     * 更新用户
     * <p> 示例值：
     */
    @SerializedName("update_user")
    private TicketUser updateUser;
    /**
     * 创建用户
     * <p> 示例值：
     */
    @SerializedName("create_user")
    private TicketUser createUser;

    // builder 开始
    public Faq() {
    }

    public Faq(Builder builder) {
        /**
         * 知识库ID
         * <p> 示例值：6936004780707807231
         */
        this.faqId = builder.faqId;
        /**
         * 知识库旧版ID，请使用faq_id
         * <p> 示例值：6936004780707807231
         */
        this.id = builder.id;
        /**
         * 服务台ID
         * <p> 示例值：6936004780707807251
         */
        this.helpdeskId = builder.helpdeskId;
        /**
         * 问题
         * <p> 示例值：问题
         */
        this.question = builder.question;
        /**
         * 答案
         * <p> 示例值：答案
         */
        this.answer = builder.answer;
        /**
         * 富文本答案
         * <p> 示例值：
         */
        this.answerRichtext = builder.answerRichtext;
        /**
         * 创建时间
         * <p> 示例值：1596379008
         */
        this.createTime = builder.createTime;
        /**
         * 修改时间
         * <p> 示例值：1596379008
         */
        this.updateTime = builder.updateTime;
        /**
         * 分类
         * <p> 示例值：
         */
        this.categories = builder.categories;
        /**
         * 相似问题列表
         * <p> 示例值：
         */
        this.tags = builder.tags;
        /**
         * 失效时间
         * <p> 示例值：1596379008
         */
        this.expireTime = builder.expireTime;
        /**
         * 更新用户
         * <p> 示例值：
         */
        this.updateUser = builder.updateUser;
        /**
         * 创建用户
         * <p> 示例值：
         */
        this.createUser = builder.createUser;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getFaqId() {
        return this.faqId;
    }

    public void setFaqId(String faqId) {
        this.faqId = faqId;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHelpdeskId() {
        return this.helpdeskId;
    }

    public void setHelpdeskId(String helpdeskId) {
        this.helpdeskId = helpdeskId;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Richtext[] getAnswerRichtext() {
        return this.answerRichtext;
    }

    public void setAnswerRichtext(Richtext[] answerRichtext) {
        this.answerRichtext = answerRichtext;
    }

    public Integer getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Category[] getCategories() {
        return this.categories;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
    }

    public String[] getTags() {
        return this.tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Integer getExpireTime() {
        return this.expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public TicketUser getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(TicketUser updateUser) {
        this.updateUser = updateUser;
    }

    public TicketUser getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(TicketUser createUser) {
        this.createUser = createUser;
    }

    public static class Builder {
        /**
         * 知识库ID
         * <p> 示例值：6936004780707807231
         */
        private String faqId;
        /**
         * 知识库旧版ID，请使用faq_id
         * <p> 示例值：6936004780707807231
         */
        private String id;
        /**
         * 服务台ID
         * <p> 示例值：6936004780707807251
         */
        private String helpdeskId;
        /**
         * 问题
         * <p> 示例值：问题
         */
        private String question;
        /**
         * 答案
         * <p> 示例值：答案
         */
        private String answer;
        /**
         * 富文本答案
         * <p> 示例值：
         */
        private Richtext[] answerRichtext;
        /**
         * 创建时间
         * <p> 示例值：1596379008
         */
        private Integer createTime;
        /**
         * 修改时间
         * <p> 示例值：1596379008
         */
        private Integer updateTime;
        /**
         * 分类
         * <p> 示例值：
         */
        private Category[] categories;
        /**
         * 相似问题列表
         * <p> 示例值：
         */
        private String[] tags;
        /**
         * 失效时间
         * <p> 示例值：1596379008
         */
        private Integer expireTime;
        /**
         * 更新用户
         * <p> 示例值：
         */
        private TicketUser updateUser;
        /**
         * 创建用户
         * <p> 示例值：
         */
        private TicketUser createUser;

        /**
         * 知识库ID
         * <p> 示例值：6936004780707807231
         *
         * @param faqId
         * @return
         */
        public Builder faqId(String faqId) {
            this.faqId = faqId;
            return this;
        }


        /**
         * 知识库旧版ID，请使用faq_id
         * <p> 示例值：6936004780707807231
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 服务台ID
         * <p> 示例值：6936004780707807251
         *
         * @param helpdeskId
         * @return
         */
        public Builder helpdeskId(String helpdeskId) {
            this.helpdeskId = helpdeskId;
            return this;
        }


        /**
         * 问题
         * <p> 示例值：问题
         *
         * @param question
         * @return
         */
        public Builder question(String question) {
            this.question = question;
            return this;
        }


        /**
         * 答案
         * <p> 示例值：答案
         *
         * @param answer
         * @return
         */
        public Builder answer(String answer) {
            this.answer = answer;
            return this;
        }


        /**
         * 富文本答案
         * <p> 示例值：
         *
         * @param answerRichtext
         * @return
         */
        public Builder answerRichtext(Richtext[] answerRichtext) {
            this.answerRichtext = answerRichtext;
            return this;
        }


        /**
         * 创建时间
         * <p> 示例值：1596379008
         *
         * @param createTime
         * @return
         */
        public Builder createTime(Integer createTime) {
            this.createTime = createTime;
            return this;
        }


        /**
         * 修改时间
         * <p> 示例值：1596379008
         *
         * @param updateTime
         * @return
         */
        public Builder updateTime(Integer updateTime) {
            this.updateTime = updateTime;
            return this;
        }


        /**
         * 分类
         * <p> 示例值：
         *
         * @param categories
         * @return
         */
        public Builder categories(Category[] categories) {
            this.categories = categories;
            return this;
        }


        /**
         * 相似问题列表
         * <p> 示例值：
         *
         * @param tags
         * @return
         */
        public Builder tags(String[] tags) {
            this.tags = tags;
            return this;
        }


        /**
         * 失效时间
         * <p> 示例值：1596379008
         *
         * @param expireTime
         * @return
         */
        public Builder expireTime(Integer expireTime) {
            this.expireTime = expireTime;
            return this;
        }


        /**
         * 更新用户
         * <p> 示例值：
         *
         * @param updateUser
         * @return
         */
        public Builder updateUser(TicketUser updateUser) {
            this.updateUser = updateUser;
            return this;
        }


        /**
         * 创建用户
         * <p> 示例值：
         *
         * @param createUser
         * @return
         */
        public Builder createUser(TicketUser createUser) {
            this.createUser = createUser;
            return this;
        }


        public Faq build() {
            return new Faq(this);
        }
    }
}
