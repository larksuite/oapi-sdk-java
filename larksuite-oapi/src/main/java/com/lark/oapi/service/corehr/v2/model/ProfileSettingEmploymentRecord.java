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

import com.google.gson.annotations.SerializedName;

public class ProfileSettingEmploymentRecord {
    /**
     * 人员类型 ID
     * <p> 示例值：6890452208593372679
     */
    @SerializedName("employee_type")
    private String employeeType;
    /**
     * 部门 ID
     * <p> 示例值：6890452208593372679
     */
    @SerializedName("department")
    private String department;
    /**
     * 实线主管雇佣ID
     * <p> 示例值：6893014062142064135
     */
    @SerializedName("direct_manager")
    private String directManager;
    /**
     * 工时制度 ID
     * <p> 示例值：6890452208593372600
     */
    @SerializedName("working_hours_type")
    private String workingHoursType;
    /**
     * 成本中心分摊信息
     * <p> 示例值：
     */
    @SerializedName("cost_centers")
    private ProfileSettingCostCenter[] costCenters;
    /**
     * 实线主管入职日期
     * <p> 示例值：2020-01-01
     */
    @SerializedName("direct_manager_effective_time")
    private String directManagerEffectiveTime;
    /**
     * 虚线主管雇佣ID
     * <p> 示例值：6893014062142064136
     */
    @SerializedName("dotted_line_manager")
    private String dottedLineManager;
    /**
     * 虚线主管入职日期
     * <p> 示例值：2020-01-01
     */
    @SerializedName("dotted_line_manager_effective_time")
    private String dottedLineManagerEffectiveTime;
    /**
     * 职务 ID
     * <p> 示例值：6890452208593372679
     */
    @SerializedName("job")
    private String job;
    /**
     * 职务序列 ID
     * <p> 示例值：6890452208593372680
     */
    @SerializedName("job_family")
    private String jobFamily;
    /**
     * 职务级别 ID
     * <p> 示例值：6890452208593372681
     */
    @SerializedName("job_level")
    private String jobLevel;
    /**
     * 职等 ID
     * <p> 示例值：6890452208593372682
     */
    @SerializedName("job_grade")
    private String jobGrade;
    /**
     * 工作地点 ID
     * <p> 示例值：6890452208593372683
     */
    @SerializedName("work_location")
    private String workLocation;
    /**
     * 周工作时长
     * <p> 示例值：100
     */
    @SerializedName("weekly_working_hours")
    private Integer weeklyWorkingHours;

    // builder 开始
    public ProfileSettingEmploymentRecord() {
    }

    public ProfileSettingEmploymentRecord(Builder builder) {
        /**
         * 人员类型 ID
         * <p> 示例值：6890452208593372679
         */
        this.employeeType = builder.employeeType;
        /**
         * 部门 ID
         * <p> 示例值：6890452208593372679
         */
        this.department = builder.department;
        /**
         * 实线主管雇佣ID
         * <p> 示例值：6893014062142064135
         */
        this.directManager = builder.directManager;
        /**
         * 工时制度 ID
         * <p> 示例值：6890452208593372600
         */
        this.workingHoursType = builder.workingHoursType;
        /**
         * 成本中心分摊信息
         * <p> 示例值：
         */
        this.costCenters = builder.costCenters;
        /**
         * 实线主管入职日期
         * <p> 示例值：2020-01-01
         */
        this.directManagerEffectiveTime = builder.directManagerEffectiveTime;
        /**
         * 虚线主管雇佣ID
         * <p> 示例值：6893014062142064136
         */
        this.dottedLineManager = builder.dottedLineManager;
        /**
         * 虚线主管入职日期
         * <p> 示例值：2020-01-01
         */
        this.dottedLineManagerEffectiveTime = builder.dottedLineManagerEffectiveTime;
        /**
         * 职务 ID
         * <p> 示例值：6890452208593372679
         */
        this.job = builder.job;
        /**
         * 职务序列 ID
         * <p> 示例值：6890452208593372680
         */
        this.jobFamily = builder.jobFamily;
        /**
         * 职务级别 ID
         * <p> 示例值：6890452208593372681
         */
        this.jobLevel = builder.jobLevel;
        /**
         * 职等 ID
         * <p> 示例值：6890452208593372682
         */
        this.jobGrade = builder.jobGrade;
        /**
         * 工作地点 ID
         * <p> 示例值：6890452208593372683
         */
        this.workLocation = builder.workLocation;
        /**
         * 周工作时长
         * <p> 示例值：100
         */
        this.weeklyWorkingHours = builder.weeklyWorkingHours;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getEmployeeType() {
        return this.employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDirectManager() {
        return this.directManager;
    }

    public void setDirectManager(String directManager) {
        this.directManager = directManager;
    }

    public String getWorkingHoursType() {
        return this.workingHoursType;
    }

    public void setWorkingHoursType(String workingHoursType) {
        this.workingHoursType = workingHoursType;
    }

    public ProfileSettingCostCenter[] getCostCenters() {
        return this.costCenters;
    }

    public void setCostCenters(ProfileSettingCostCenter[] costCenters) {
        this.costCenters = costCenters;
    }

    public String getDirectManagerEffectiveTime() {
        return this.directManagerEffectiveTime;
    }

    public void setDirectManagerEffectiveTime(String directManagerEffectiveTime) {
        this.directManagerEffectiveTime = directManagerEffectiveTime;
    }

    public String getDottedLineManager() {
        return this.dottedLineManager;
    }

    public void setDottedLineManager(String dottedLineManager) {
        this.dottedLineManager = dottedLineManager;
    }

    public String getDottedLineManagerEffectiveTime() {
        return this.dottedLineManagerEffectiveTime;
    }

    public void setDottedLineManagerEffectiveTime(String dottedLineManagerEffectiveTime) {
        this.dottedLineManagerEffectiveTime = dottedLineManagerEffectiveTime;
    }

    public String getJob() {
        return this.job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobFamily() {
        return this.jobFamily;
    }

    public void setJobFamily(String jobFamily) {
        this.jobFamily = jobFamily;
    }

    public String getJobLevel() {
        return this.jobLevel;
    }

    public void setJobLevel(String jobLevel) {
        this.jobLevel = jobLevel;
    }

    public String getJobGrade() {
        return this.jobGrade;
    }

    public void setJobGrade(String jobGrade) {
        this.jobGrade = jobGrade;
    }

    public String getWorkLocation() {
        return this.workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public Integer getWeeklyWorkingHours() {
        return this.weeklyWorkingHours;
    }

    public void setWeeklyWorkingHours(Integer weeklyWorkingHours) {
        this.weeklyWorkingHours = weeklyWorkingHours;
    }

    public static class Builder {
        /**
         * 人员类型 ID
         * <p> 示例值：6890452208593372679
         */
        private String employeeType;
        /**
         * 部门 ID
         * <p> 示例值：6890452208593372679
         */
        private String department;
        /**
         * 实线主管雇佣ID
         * <p> 示例值：6893014062142064135
         */
        private String directManager;
        /**
         * 工时制度 ID
         * <p> 示例值：6890452208593372600
         */
        private String workingHoursType;
        /**
         * 成本中心分摊信息
         * <p> 示例值：
         */
        private ProfileSettingCostCenter[] costCenters;
        /**
         * 实线主管入职日期
         * <p> 示例值：2020-01-01
         */
        private String directManagerEffectiveTime;
        /**
         * 虚线主管雇佣ID
         * <p> 示例值：6893014062142064136
         */
        private String dottedLineManager;
        /**
         * 虚线主管入职日期
         * <p> 示例值：2020-01-01
         */
        private String dottedLineManagerEffectiveTime;
        /**
         * 职务 ID
         * <p> 示例值：6890452208593372679
         */
        private String job;
        /**
         * 职务序列 ID
         * <p> 示例值：6890452208593372680
         */
        private String jobFamily;
        /**
         * 职务级别 ID
         * <p> 示例值：6890452208593372681
         */
        private String jobLevel;
        /**
         * 职等 ID
         * <p> 示例值：6890452208593372682
         */
        private String jobGrade;
        /**
         * 工作地点 ID
         * <p> 示例值：6890452208593372683
         */
        private String workLocation;
        /**
         * 周工作时长
         * <p> 示例值：100
         */
        private Integer weeklyWorkingHours;

        /**
         * 人员类型 ID
         * <p> 示例值：6890452208593372679
         *
         * @param employeeType
         * @return
         */
        public Builder employeeType(String employeeType) {
            this.employeeType = employeeType;
            return this;
        }


        /**
         * 部门 ID
         * <p> 示例值：6890452208593372679
         *
         * @param department
         * @return
         */
        public Builder department(String department) {
            this.department = department;
            return this;
        }


        /**
         * 实线主管雇佣ID
         * <p> 示例值：6893014062142064135
         *
         * @param directManager
         * @return
         */
        public Builder directManager(String directManager) {
            this.directManager = directManager;
            return this;
        }


        /**
         * 工时制度 ID
         * <p> 示例值：6890452208593372600
         *
         * @param workingHoursType
         * @return
         */
        public Builder workingHoursType(String workingHoursType) {
            this.workingHoursType = workingHoursType;
            return this;
        }


        /**
         * 成本中心分摊信息
         * <p> 示例值：
         *
         * @param costCenters
         * @return
         */
        public Builder costCenters(ProfileSettingCostCenter[] costCenters) {
            this.costCenters = costCenters;
            return this;
        }


        /**
         * 实线主管入职日期
         * <p> 示例值：2020-01-01
         *
         * @param directManagerEffectiveTime
         * @return
         */
        public Builder directManagerEffectiveTime(String directManagerEffectiveTime) {
            this.directManagerEffectiveTime = directManagerEffectiveTime;
            return this;
        }


        /**
         * 虚线主管雇佣ID
         * <p> 示例值：6893014062142064136
         *
         * @param dottedLineManager
         * @return
         */
        public Builder dottedLineManager(String dottedLineManager) {
            this.dottedLineManager = dottedLineManager;
            return this;
        }


        /**
         * 虚线主管入职日期
         * <p> 示例值：2020-01-01
         *
         * @param dottedLineManagerEffectiveTime
         * @return
         */
        public Builder dottedLineManagerEffectiveTime(String dottedLineManagerEffectiveTime) {
            this.dottedLineManagerEffectiveTime = dottedLineManagerEffectiveTime;
            return this;
        }


        /**
         * 职务 ID
         * <p> 示例值：6890452208593372679
         *
         * @param job
         * @return
         */
        public Builder job(String job) {
            this.job = job;
            return this;
        }


        /**
         * 职务序列 ID
         * <p> 示例值：6890452208593372680
         *
         * @param jobFamily
         * @return
         */
        public Builder jobFamily(String jobFamily) {
            this.jobFamily = jobFamily;
            return this;
        }


        /**
         * 职务级别 ID
         * <p> 示例值：6890452208593372681
         *
         * @param jobLevel
         * @return
         */
        public Builder jobLevel(String jobLevel) {
            this.jobLevel = jobLevel;
            return this;
        }


        /**
         * 职等 ID
         * <p> 示例值：6890452208593372682
         *
         * @param jobGrade
         * @return
         */
        public Builder jobGrade(String jobGrade) {
            this.jobGrade = jobGrade;
            return this;
        }


        /**
         * 工作地点 ID
         * <p> 示例值：6890452208593372683
         *
         * @param workLocation
         * @return
         */
        public Builder workLocation(String workLocation) {
            this.workLocation = workLocation;
            return this;
        }


        /**
         * 周工作时长
         * <p> 示例值：100
         *
         * @param weeklyWorkingHours
         * @return
         */
        public Builder weeklyWorkingHours(Integer weeklyWorkingHours) {
            this.weeklyWorkingHours = weeklyWorkingHours;
            return this;
        }


        public ProfileSettingEmploymentRecord build() {
            return new ProfileSettingEmploymentRecord(this);
        }
    }
}
