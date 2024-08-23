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

package com.lark.oapi.service.corehr.v2.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.corehr.v2.enums.*;
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

public class SearchJobChangeReqBody {
    /**
     * 雇员 ID 列表
     * <p> 示例值：
     */
    @SerializedName("employment_ids")
    private String[] employmentIds;
    /**
     * 异动记录 ID 列表
     * <p> 示例值：
     */
    @SerializedName("job_change_ids")
    private String[] jobChangeIds;
    /**
     * 异动状态，多个状态之间为「或」的关系
     * <p> 示例值：Approved
     */
    @SerializedName("statuses")
    private String[] statuses;
    /**
     * 异动生效日期 - 搜索范围开始，需要与搜索范围结束一同使用
     * <p> 示例值：2022-01-01
     */
    @SerializedName("effective_date_start")
    private String effectiveDateStart;
    /**
     * 异动生效日期 - 搜索范围结束
     * <p> 示例值：2022-01-01
     */
    @SerializedName("effective_date_end")
    private String effectiveDateEnd;
    /**
     * 异动更新时间 - 搜索范围开始，需要与搜索范围结束一同使用
     * <p> 示例值：1704084635000
     */
    @SerializedName("updated_time_start")
    private String updatedTimeStart;
    /**
     * 异动更新时间 - 搜索范围结束
     * <p> 示例值：1704084635000
     */
    @SerializedName("updated_time_end")
    private String updatedTimeEnd;
    /**
     * 新部门 ID 列表
     * <p> 示例值：
     */
    @SerializedName("target_department_ids")
    private String[] targetDepartmentIds;

    // builder 开始
    public SearchJobChangeReqBody() {
    }

    public SearchJobChangeReqBody(Builder builder) {
        /**
         * 雇员 ID 列表
         * <p> 示例值：
         */
        this.employmentIds = builder.employmentIds;
        /**
         * 异动记录 ID 列表
         * <p> 示例值：
         */
        this.jobChangeIds = builder.jobChangeIds;
        /**
         * 异动状态，多个状态之间为「或」的关系
         * <p> 示例值：Approved
         */
        this.statuses = builder.statuses;
        /**
         * 异动生效日期 - 搜索范围开始，需要与搜索范围结束一同使用
         * <p> 示例值：2022-01-01
         */
        this.effectiveDateStart = builder.effectiveDateStart;
        /**
         * 异动生效日期 - 搜索范围结束
         * <p> 示例值：2022-01-01
         */
        this.effectiveDateEnd = builder.effectiveDateEnd;
        /**
         * 异动更新时间 - 搜索范围开始，需要与搜索范围结束一同使用
         * <p> 示例值：1704084635000
         */
        this.updatedTimeStart = builder.updatedTimeStart;
        /**
         * 异动更新时间 - 搜索范围结束
         * <p> 示例值：1704084635000
         */
        this.updatedTimeEnd = builder.updatedTimeEnd;
        /**
         * 新部门 ID 列表
         * <p> 示例值：
         */
        this.targetDepartmentIds = builder.targetDepartmentIds;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String[] getEmploymentIds() {
        return this.employmentIds;
    }

    public void setEmploymentIds(String[] employmentIds) {
        this.employmentIds = employmentIds;
    }

    public String[] getJobChangeIds() {
        return this.jobChangeIds;
    }

    public void setJobChangeIds(String[] jobChangeIds) {
        this.jobChangeIds = jobChangeIds;
    }

    public String[] getStatuses() {
        return this.statuses;
    }

    public void setStatuses(String[] statuses) {
        this.statuses = statuses;
    }

    public String getEffectiveDateStart() {
        return this.effectiveDateStart;
    }

    public void setEffectiveDateStart(String effectiveDateStart) {
        this.effectiveDateStart = effectiveDateStart;
    }

    public String getEffectiveDateEnd() {
        return this.effectiveDateEnd;
    }

    public void setEffectiveDateEnd(String effectiveDateEnd) {
        this.effectiveDateEnd = effectiveDateEnd;
    }

    public String getUpdatedTimeStart() {
        return this.updatedTimeStart;
    }

    public void setUpdatedTimeStart(String updatedTimeStart) {
        this.updatedTimeStart = updatedTimeStart;
    }

    public String getUpdatedTimeEnd() {
        return this.updatedTimeEnd;
    }

    public void setUpdatedTimeEnd(String updatedTimeEnd) {
        this.updatedTimeEnd = updatedTimeEnd;
    }

    public String[] getTargetDepartmentIds() {
        return this.targetDepartmentIds;
    }

    public void setTargetDepartmentIds(String[] targetDepartmentIds) {
        this.targetDepartmentIds = targetDepartmentIds;
    }

    public static class Builder {
        /**
         * 雇员 ID 列表
         * <p> 示例值：
         */
        private String[] employmentIds;
        /**
         * 异动记录 ID 列表
         * <p> 示例值：
         */
        private String[] jobChangeIds;
        /**
         * 异动状态，多个状态之间为「或」的关系
         * <p> 示例值：Approved
         */
        private String[] statuses;
        /**
         * 异动生效日期 - 搜索范围开始，需要与搜索范围结束一同使用
         * <p> 示例值：2022-01-01
         */
        private String effectiveDateStart;
        /**
         * 异动生效日期 - 搜索范围结束
         * <p> 示例值：2022-01-01
         */
        private String effectiveDateEnd;
        /**
         * 异动更新时间 - 搜索范围开始，需要与搜索范围结束一同使用
         * <p> 示例值：1704084635000
         */
        private String updatedTimeStart;
        /**
         * 异动更新时间 - 搜索范围结束
         * <p> 示例值：1704084635000
         */
        private String updatedTimeEnd;
        /**
         * 新部门 ID 列表
         * <p> 示例值：
         */
        private String[] targetDepartmentIds;

        /**
         * 雇员 ID 列表
         * <p> 示例值：
         *
         * @param employmentIds
         * @return
         */
        public Builder employmentIds(String[] employmentIds) {
            this.employmentIds = employmentIds;
            return this;
        }


        /**
         * 异动记录 ID 列表
         * <p> 示例值：
         *
         * @param jobChangeIds
         * @return
         */
        public Builder jobChangeIds(String[] jobChangeIds) {
            this.jobChangeIds = jobChangeIds;
            return this;
        }


        /**
         * 异动状态，多个状态之间为「或」的关系
         * <p> 示例值：Approved
         *
         * @param statuses
         * @return
         */
        public Builder statuses(String[] statuses) {
            this.statuses = statuses;
            return this;
        }


        /**
         * 异动生效日期 - 搜索范围开始，需要与搜索范围结束一同使用
         * <p> 示例值：2022-01-01
         *
         * @param effectiveDateStart
         * @return
         */
        public Builder effectiveDateStart(String effectiveDateStart) {
            this.effectiveDateStart = effectiveDateStart;
            return this;
        }


        /**
         * 异动生效日期 - 搜索范围结束
         * <p> 示例值：2022-01-01
         *
         * @param effectiveDateEnd
         * @return
         */
        public Builder effectiveDateEnd(String effectiveDateEnd) {
            this.effectiveDateEnd = effectiveDateEnd;
            return this;
        }


        /**
         * 异动更新时间 - 搜索范围开始，需要与搜索范围结束一同使用
         * <p> 示例值：1704084635000
         *
         * @param updatedTimeStart
         * @return
         */
        public Builder updatedTimeStart(String updatedTimeStart) {
            this.updatedTimeStart = updatedTimeStart;
            return this;
        }


        /**
         * 异动更新时间 - 搜索范围结束
         * <p> 示例值：1704084635000
         *
         * @param updatedTimeEnd
         * @return
         */
        public Builder updatedTimeEnd(String updatedTimeEnd) {
            this.updatedTimeEnd = updatedTimeEnd;
            return this;
        }


        /**
         * 新部门 ID 列表
         * <p> 示例值：
         *
         * @param targetDepartmentIds
         * @return
         */
        public Builder targetDepartmentIds(String[] targetDepartmentIds) {
            this.targetDepartmentIds = targetDepartmentIds;
            return this;
        }


        public SearchJobChangeReqBody build() {
            return new SearchJobChangeReqBody(this);
        }
    }
}
