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

package com.lark.oapi.service.hire.v1.model;

import com.google.gson.annotations.SerializedName;

public class Evaluation {
    /**
     * 评估 ID
     * <p> 示例值：6875295756292425998
     */
    @SerializedName("id")
    private String id;
    /**
     * 投递 ID
     * <p> 示例值：6875569957036738823
     */
    @SerializedName("application_id")
    private String applicationId;
    /**
     * 投递阶段
     * <p> 示例值：6784315427607595268
     */
    @SerializedName("stage_id")
    private String stageId;
    /**
     * 创建人user_id
     * <p> 示例值：ou_aaf83d1b2c856ead36aa9a38784b9a5c
     */
    @SerializedName("creator_id")
    private String creatorId;
    /**
     * 评估人user_id
     * <p> 示例值：ou_aaf83d1b2c856ead36aa9a38784b9a5c
     */
    @SerializedName("evaluator_id")
    private String evaluatorId;
    /**
     * 提交状态
     * <p> 示例值：1
     */
    @SerializedName("commit_status")
    private Integer commitStatus;
    /**
     * 评估结论
     * <p> 示例值：1
     */
    @SerializedName("conclusion")
    private Integer conclusion;
    /**
     * 评估详情
     * <p> 示例值：这位同学很优秀
     */
    @SerializedName("content")
    private String content;
    /**
     * 创建时间
     * <p> 示例值：1600843767338
     */
    @SerializedName("create_time")
    private String createTime;
    /**
     * 最近更新时间
     * <p> 示例值：1600843937733
     */
    @SerializedName("update_time")
    private String updateTime;

    // builder 开始
    public Evaluation() {
    }

    public Evaluation(Builder builder) {
        /**
         * 评估 ID
         * <p> 示例值：6875295756292425998
         */
        this.id = builder.id;
        /**
         * 投递 ID
         * <p> 示例值：6875569957036738823
         */
        this.applicationId = builder.applicationId;
        /**
         * 投递阶段
         * <p> 示例值：6784315427607595268
         */
        this.stageId = builder.stageId;
        /**
         * 创建人user_id
         * <p> 示例值：ou_aaf83d1b2c856ead36aa9a38784b9a5c
         */
        this.creatorId = builder.creatorId;
        /**
         * 评估人user_id
         * <p> 示例值：ou_aaf83d1b2c856ead36aa9a38784b9a5c
         */
        this.evaluatorId = builder.evaluatorId;
        /**
         * 提交状态
         * <p> 示例值：1
         */
        this.commitStatus = builder.commitStatus;
        /**
         * 评估结论
         * <p> 示例值：1
         */
        this.conclusion = builder.conclusion;
        /**
         * 评估详情
         * <p> 示例值：这位同学很优秀
         */
        this.content = builder.content;
        /**
         * 创建时间
         * <p> 示例值：1600843767338
         */
        this.createTime = builder.createTime;
        /**
         * 最近更新时间
         * <p> 示例值：1600843937733
         */
        this.updateTime = builder.updateTime;
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

    public String getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getStageId() {
        return this.stageId;
    }

    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

    public String getCreatorId() {
        return this.creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getEvaluatorId() {
        return this.evaluatorId;
    }

    public void setEvaluatorId(String evaluatorId) {
        this.evaluatorId = evaluatorId;
    }

    public Integer getCommitStatus() {
        return this.commitStatus;
    }

    public void setCommitStatus(Integer commitStatus) {
        this.commitStatus = commitStatus;
    }

    public Integer getConclusion() {
        return this.conclusion;
    }

    public void setConclusion(Integer conclusion) {
        this.conclusion = conclusion;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public static class Builder {
        /**
         * 评估 ID
         * <p> 示例值：6875295756292425998
         */
        private String id;
        /**
         * 投递 ID
         * <p> 示例值：6875569957036738823
         */
        private String applicationId;
        /**
         * 投递阶段
         * <p> 示例值：6784315427607595268
         */
        private String stageId;
        /**
         * 创建人user_id
         * <p> 示例值：ou_aaf83d1b2c856ead36aa9a38784b9a5c
         */
        private String creatorId;
        /**
         * 评估人user_id
         * <p> 示例值：ou_aaf83d1b2c856ead36aa9a38784b9a5c
         */
        private String evaluatorId;
        /**
         * 提交状态
         * <p> 示例值：1
         */
        private Integer commitStatus;
        /**
         * 评估结论
         * <p> 示例值：1
         */
        private Integer conclusion;
        /**
         * 评估详情
         * <p> 示例值：这位同学很优秀
         */
        private String content;
        /**
         * 创建时间
         * <p> 示例值：1600843767338
         */
        private String createTime;
        /**
         * 最近更新时间
         * <p> 示例值：1600843937733
         */
        private String updateTime;

        /**
         * 评估 ID
         * <p> 示例值：6875295756292425998
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 投递 ID
         * <p> 示例值：6875569957036738823
         *
         * @param applicationId
         * @return
         */
        public Builder applicationId(String applicationId) {
            this.applicationId = applicationId;
            return this;
        }


        /**
         * 投递阶段
         * <p> 示例值：6784315427607595268
         *
         * @param stageId
         * @return
         */
        public Builder stageId(String stageId) {
            this.stageId = stageId;
            return this;
        }


        /**
         * 创建人user_id
         * <p> 示例值：ou_aaf83d1b2c856ead36aa9a38784b9a5c
         *
         * @param creatorId
         * @return
         */
        public Builder creatorId(String creatorId) {
            this.creatorId = creatorId;
            return this;
        }


        /**
         * 评估人user_id
         * <p> 示例值：ou_aaf83d1b2c856ead36aa9a38784b9a5c
         *
         * @param evaluatorId
         * @return
         */
        public Builder evaluatorId(String evaluatorId) {
            this.evaluatorId = evaluatorId;
            return this;
        }


        /**
         * 提交状态
         * <p> 示例值：1
         *
         * @param commitStatus
         * @return
         */
        public Builder commitStatus(Integer commitStatus) {
            this.commitStatus = commitStatus;
            return this;
        }


        /**
         * 评估结论
         * <p> 示例值：1
         *
         * @param conclusion
         * @return
         */
        public Builder conclusion(Integer conclusion) {
            this.conclusion = conclusion;
            return this;
        }


        /**
         * 评估详情
         * <p> 示例值：这位同学很优秀
         *
         * @param content
         * @return
         */
        public Builder content(String content) {
            this.content = content;
            return this;
        }


        /**
         * 创建时间
         * <p> 示例值：1600843767338
         *
         * @param createTime
         * @return
         */
        public Builder createTime(String createTime) {
            this.createTime = createTime;
            return this;
        }


        /**
         * 最近更新时间
         * <p> 示例值：1600843937733
         *
         * @param updateTime
         * @return
         */
        public Builder updateTime(String updateTime) {
            this.updateTime = updateTime;
            return this;
        }


        public Evaluation build() {
            return new Evaluation(this);
        }
    }
}
