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

package com.lark.oapi.service.corehr.v1.model;

import com.google.gson.annotations.SerializedName;

public class JobData {
    /**
     * 任职信息 ID
     * <p> 示例值：6890452208593372679
     */
    @SerializedName("id")
    private String id;
    /**
     * 任职记录版本 ID
     * <p> 示例值：6890452208593372697
     */
    @SerializedName("version_id")
    private String versionId;
    /**
     * 职务级别 ID，枚举值及详细信息可通过【批量查询职务级别】接口查询获得
     * <p> 示例值：6890452208593372679
     */
    @SerializedName("job_level_id")
    private String jobLevelId;
    /**
     * 职等ID
     * <p> 示例值：6890452208593372679
     */
    @SerializedName("job_grade_id")
    private String jobGradeId;
    /**
     * 人员类型 ID，枚举值及详细信息可通过【批量查询人员类型】接口查询获得
     * <p> 示例值：6890452208593372679
     */
    @SerializedName("employee_type_id")
    private String employeeTypeId;
    /**
     * 工时制度 ID，枚举值及详细信息可通过【批量查询工时制度】接口查询获得
     * <p> 示例值：6890452208593372679
     */
    @SerializedName("working_hours_type_id")
    private String workingHoursTypeId;
    /**
     * 工作地点 ID，枚举值及详细信息可通过【批量查询地点】接口查询获得
     * <p> 示例值：6890452208593372679
     */
    @SerializedName("work_location_id")
    private String workLocationId;
    /**
     * 部门 ID，枚举值及详细信息可通过【批量查询部门】接口查询获得
     * <p> 示例值：6890452208593372679
     */
    @SerializedName("department_id")
    private String departmentId;
    /**
     * 职务 ID，枚举值及详细信息可通过【批量查询职务】接口查询获得
     * <p> 示例值：6890452208593372679
     */
    @SerializedName("job_id")
    private String jobId;
    /**
     * 试用期开始日期
     * <p> 示例值：2018-03-16
     */
    @SerializedName("probation_start_date")
    private String probationStartDate;
    /**
     * 试用期结束日期（实际结束日期）
     * <p> 示例值：2019-05-24
     */
    @SerializedName("probation_end_date")
    private String probationEndDate;
    /**
     * 是否为主任职
     * <p> 示例值：true
     */
    @SerializedName("primary_job_data")
    private Boolean primaryJobData;
    /**
     * 雇佣 ID
     * <p> 示例值：6893014062142064135
     */
    @SerializedName("employment_id")
    private String employmentId;
    /**
     * 生效时间
     * <p> 示例值：2020-05-01 00:00:00
     */
    @SerializedName("effective_time")
    private String effectiveTime;
    /**
     * 失效时间
     * <p> 示例值：2020-05-02 00:00:00
     */
    @SerializedName("expiration_time")
    private String expirationTime;
    /**
     * 职务序列 ID，枚举值及详细信息可通过【批量查询职务序列】接口查询获得
     * <p> 示例值：1245678
     */
    @SerializedName("job_family_id")
    private String jobFamilyId;
    /**
     * 任职原因，枚举值可通过文档[【飞书人事枚举常量】](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/corehr-v1/feishu-people-enum-constant)任职原因（assignment_start_reason）枚举定义部分获得
     * <p> 示例值：onboarding
     */
    @SerializedName("assignment_start_reason")
    private Enum assignmentStartReason;
    /**
     * 预计试用期结束日期
     * <p> 示例值：2006-01-02
     */
    @SerializedName("probation_expected_end_date")
    private String probationExpectedEndDate;
    /**
     * 试用期结果，枚举值可通过文档[【飞书人事枚举常量】](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/corehr-v1/feishu-people-enum-constant)试用期结果（probation_outcome）枚举定义部分获得
     * <p> 示例值：passed
     */
    @SerializedName("probation_outcome")
    private Enum probationOutcome;
    /**
     * 周工作时长
     * <p> 示例值：30
     */
    @SerializedName("weekly_working_hours")
    private Integer weeklyWorkingHours;
    /**
     * 实线主管的任职记录ID
     * <p> 示例值：6890452208593372679
     */
    @SerializedName("direct_manager_id")
    private String directManagerId;
    /**
     * 虚线主管的任职记录ID
     * <p> 示例值：["6971723901730686501"]
     */
    @SerializedName("dotted_line_manager_id_list")
    private String[] dottedLineManagerIdList;
    /**
     * 第二实线主管的任职记录ID
     * <p> 示例值：6890452208593372679
     */
    @SerializedName("second_direct_manager_id")
    private String secondDirectManagerId;
    /**
     * 成本中心分摊信息
     * <p> 示例值：
     */
    @SerializedName("cost_center_rate")
    private SupportCostCenterItem[] costCenterRate;
    /**
     * 周工作时长v2
     * <p> 示例值：37.5
     */
    @SerializedName("weekly_working_hours_v2")
    private Double weeklyWorkingHoursV2;
    /**
     * 排班类型
     * <p> 示例值：
     */
    @SerializedName("work_shift")
    private Enum workShift;
    /**
     * 薪资类型
     * <p> 示例值：
     */
    @SerializedName("compensation_type")
    private Enum compensationType;
    /**
     * 任职公司
     * <p> 示例值：6890452208593372680
     */
    @SerializedName("service_company")
    private String serviceCompany;

    // builder 开始
    public JobData() {
    }

    public JobData(Builder builder) {
        /**
         * 任职信息 ID
         * <p> 示例值：6890452208593372679
         */
        this.id = builder.id;
        /**
         * 任职记录版本 ID
         * <p> 示例值：6890452208593372697
         */
        this.versionId = builder.versionId;
        /**
         * 职务级别 ID，枚举值及详细信息可通过【批量查询职务级别】接口查询获得
         * <p> 示例值：6890452208593372679
         */
        this.jobLevelId = builder.jobLevelId;
        /**
         * 职等ID
         * <p> 示例值：6890452208593372679
         */
        this.jobGradeId = builder.jobGradeId;
        /**
         * 人员类型 ID，枚举值及详细信息可通过【批量查询人员类型】接口查询获得
         * <p> 示例值：6890452208593372679
         */
        this.employeeTypeId = builder.employeeTypeId;
        /**
         * 工时制度 ID，枚举值及详细信息可通过【批量查询工时制度】接口查询获得
         * <p> 示例值：6890452208593372679
         */
        this.workingHoursTypeId = builder.workingHoursTypeId;
        /**
         * 工作地点 ID，枚举值及详细信息可通过【批量查询地点】接口查询获得
         * <p> 示例值：6890452208593372679
         */
        this.workLocationId = builder.workLocationId;
        /**
         * 部门 ID，枚举值及详细信息可通过【批量查询部门】接口查询获得
         * <p> 示例值：6890452208593372679
         */
        this.departmentId = builder.departmentId;
        /**
         * 职务 ID，枚举值及详细信息可通过【批量查询职务】接口查询获得
         * <p> 示例值：6890452208593372679
         */
        this.jobId = builder.jobId;
        /**
         * 试用期开始日期
         * <p> 示例值：2018-03-16
         */
        this.probationStartDate = builder.probationStartDate;
        /**
         * 试用期结束日期（实际结束日期）
         * <p> 示例值：2019-05-24
         */
        this.probationEndDate = builder.probationEndDate;
        /**
         * 是否为主任职
         * <p> 示例值：true
         */
        this.primaryJobData = builder.primaryJobData;
        /**
         * 雇佣 ID
         * <p> 示例值：6893014062142064135
         */
        this.employmentId = builder.employmentId;
        /**
         * 生效时间
         * <p> 示例值：2020-05-01 00:00:00
         */
        this.effectiveTime = builder.effectiveTime;
        /**
         * 失效时间
         * <p> 示例值：2020-05-02 00:00:00
         */
        this.expirationTime = builder.expirationTime;
        /**
         * 职务序列 ID，枚举值及详细信息可通过【批量查询职务序列】接口查询获得
         * <p> 示例值：1245678
         */
        this.jobFamilyId = builder.jobFamilyId;
        /**
         * 任职原因，枚举值可通过文档[【飞书人事枚举常量】](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/corehr-v1/feishu-people-enum-constant)任职原因（assignment_start_reason）枚举定义部分获得
         * <p> 示例值：onboarding
         */
        this.assignmentStartReason = builder.assignmentStartReason;
        /**
         * 预计试用期结束日期
         * <p> 示例值：2006-01-02
         */
        this.probationExpectedEndDate = builder.probationExpectedEndDate;
        /**
         * 试用期结果，枚举值可通过文档[【飞书人事枚举常量】](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/corehr-v1/feishu-people-enum-constant)试用期结果（probation_outcome）枚举定义部分获得
         * <p> 示例值：passed
         */
        this.probationOutcome = builder.probationOutcome;
        /**
         * 周工作时长
         * <p> 示例值：30
         */
        this.weeklyWorkingHours = builder.weeklyWorkingHours;
        /**
         * 实线主管的任职记录ID
         * <p> 示例值：6890452208593372679
         */
        this.directManagerId = builder.directManagerId;
        /**
         * 虚线主管的任职记录ID
         * <p> 示例值：["6971723901730686501"]
         */
        this.dottedLineManagerIdList = builder.dottedLineManagerIdList;
        /**
         * 第二实线主管的任职记录ID
         * <p> 示例值：6890452208593372679
         */
        this.secondDirectManagerId = builder.secondDirectManagerId;
        /**
         * 成本中心分摊信息
         * <p> 示例值：
         */
        this.costCenterRate = builder.costCenterRate;
        /**
         * 周工作时长v2
         * <p> 示例值：37.5
         */
        this.weeklyWorkingHoursV2 = builder.weeklyWorkingHoursV2;
        /**
         * 排班类型
         * <p> 示例值：
         */
        this.workShift = builder.workShift;
        /**
         * 薪资类型
         * <p> 示例值：
         */
        this.compensationType = builder.compensationType;
        /**
         * 任职公司
         * <p> 示例值：6890452208593372680
         */
        this.serviceCompany = builder.serviceCompany;
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

    public String getVersionId() {
        return this.versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getJobLevelId() {
        return this.jobLevelId;
    }

    public void setJobLevelId(String jobLevelId) {
        this.jobLevelId = jobLevelId;
    }

    public String getJobGradeId() {
        return this.jobGradeId;
    }

    public void setJobGradeId(String jobGradeId) {
        this.jobGradeId = jobGradeId;
    }

    public String getEmployeeTypeId() {
        return this.employeeTypeId;
    }

    public void setEmployeeTypeId(String employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    public String getWorkingHoursTypeId() {
        return this.workingHoursTypeId;
    }

    public void setWorkingHoursTypeId(String workingHoursTypeId) {
        this.workingHoursTypeId = workingHoursTypeId;
    }

    public String getWorkLocationId() {
        return this.workLocationId;
    }

    public void setWorkLocationId(String workLocationId) {
        this.workLocationId = workLocationId;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobId() {
        return this.jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getProbationStartDate() {
        return this.probationStartDate;
    }

    public void setProbationStartDate(String probationStartDate) {
        this.probationStartDate = probationStartDate;
    }

    public String getProbationEndDate() {
        return this.probationEndDate;
    }

    public void setProbationEndDate(String probationEndDate) {
        this.probationEndDate = probationEndDate;
    }

    public Boolean getPrimaryJobData() {
        return this.primaryJobData;
    }

    public void setPrimaryJobData(Boolean primaryJobData) {
        this.primaryJobData = primaryJobData;
    }

    public String getEmploymentId() {
        return this.employmentId;
    }

    public void setEmploymentId(String employmentId) {
        this.employmentId = employmentId;
    }

    public String getEffectiveTime() {
        return this.effectiveTime;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getExpirationTime() {
        return this.expirationTime;
    }

    public void setExpirationTime(String expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getJobFamilyId() {
        return this.jobFamilyId;
    }

    public void setJobFamilyId(String jobFamilyId) {
        this.jobFamilyId = jobFamilyId;
    }

    public Enum getAssignmentStartReason() {
        return this.assignmentStartReason;
    }

    public void setAssignmentStartReason(Enum assignmentStartReason) {
        this.assignmentStartReason = assignmentStartReason;
    }

    public String getProbationExpectedEndDate() {
        return this.probationExpectedEndDate;
    }

    public void setProbationExpectedEndDate(String probationExpectedEndDate) {
        this.probationExpectedEndDate = probationExpectedEndDate;
    }

    public Enum getProbationOutcome() {
        return this.probationOutcome;
    }

    public void setProbationOutcome(Enum probationOutcome) {
        this.probationOutcome = probationOutcome;
    }

    public Integer getWeeklyWorkingHours() {
        return this.weeklyWorkingHours;
    }

    public void setWeeklyWorkingHours(Integer weeklyWorkingHours) {
        this.weeklyWorkingHours = weeklyWorkingHours;
    }

    public String getDirectManagerId() {
        return this.directManagerId;
    }

    public void setDirectManagerId(String directManagerId) {
        this.directManagerId = directManagerId;
    }

    public String[] getDottedLineManagerIdList() {
        return this.dottedLineManagerIdList;
    }

    public void setDottedLineManagerIdList(String[] dottedLineManagerIdList) {
        this.dottedLineManagerIdList = dottedLineManagerIdList;
    }

    public String getSecondDirectManagerId() {
        return this.secondDirectManagerId;
    }

    public void setSecondDirectManagerId(String secondDirectManagerId) {
        this.secondDirectManagerId = secondDirectManagerId;
    }

    public SupportCostCenterItem[] getCostCenterRate() {
        return this.costCenterRate;
    }

    public void setCostCenterRate(SupportCostCenterItem[] costCenterRate) {
        this.costCenterRate = costCenterRate;
    }

    public Double getWeeklyWorkingHoursV2() {
        return this.weeklyWorkingHoursV2;
    }

    public void setWeeklyWorkingHoursV2(Double weeklyWorkingHoursV2) {
        this.weeklyWorkingHoursV2 = weeklyWorkingHoursV2;
    }

    public Enum getWorkShift() {
        return this.workShift;
    }

    public void setWorkShift(Enum workShift) {
        this.workShift = workShift;
    }

    public Enum getCompensationType() {
        return this.compensationType;
    }

    public void setCompensationType(Enum compensationType) {
        this.compensationType = compensationType;
    }

    public String getServiceCompany() {
        return this.serviceCompany;
    }

    public void setServiceCompany(String serviceCompany) {
        this.serviceCompany = serviceCompany;
    }

    public static class Builder {
        /**
         * 任职信息 ID
         * <p> 示例值：6890452208593372679
         */
        private String id;
        /**
         * 任职记录版本 ID
         * <p> 示例值：6890452208593372697
         */
        private String versionId;
        /**
         * 职务级别 ID，枚举值及详细信息可通过【批量查询职务级别】接口查询获得
         * <p> 示例值：6890452208593372679
         */
        private String jobLevelId;
        /**
         * 职等ID
         * <p> 示例值：6890452208593372679
         */
        private String jobGradeId;
        /**
         * 人员类型 ID，枚举值及详细信息可通过【批量查询人员类型】接口查询获得
         * <p> 示例值：6890452208593372679
         */
        private String employeeTypeId;
        /**
         * 工时制度 ID，枚举值及详细信息可通过【批量查询工时制度】接口查询获得
         * <p> 示例值：6890452208593372679
         */
        private String workingHoursTypeId;
        /**
         * 工作地点 ID，枚举值及详细信息可通过【批量查询地点】接口查询获得
         * <p> 示例值：6890452208593372679
         */
        private String workLocationId;
        /**
         * 部门 ID，枚举值及详细信息可通过【批量查询部门】接口查询获得
         * <p> 示例值：6890452208593372679
         */
        private String departmentId;
        /**
         * 职务 ID，枚举值及详细信息可通过【批量查询职务】接口查询获得
         * <p> 示例值：6890452208593372679
         */
        private String jobId;
        /**
         * 试用期开始日期
         * <p> 示例值：2018-03-16
         */
        private String probationStartDate;
        /**
         * 试用期结束日期（实际结束日期）
         * <p> 示例值：2019-05-24
         */
        private String probationEndDate;
        /**
         * 是否为主任职
         * <p> 示例值：true
         */
        private Boolean primaryJobData;
        /**
         * 雇佣 ID
         * <p> 示例值：6893014062142064135
         */
        private String employmentId;
        /**
         * 生效时间
         * <p> 示例值：2020-05-01 00:00:00
         */
        private String effectiveTime;
        /**
         * 失效时间
         * <p> 示例值：2020-05-02 00:00:00
         */
        private String expirationTime;
        /**
         * 职务序列 ID，枚举值及详细信息可通过【批量查询职务序列】接口查询获得
         * <p> 示例值：1245678
         */
        private String jobFamilyId;
        /**
         * 任职原因，枚举值可通过文档[【飞书人事枚举常量】](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/corehr-v1/feishu-people-enum-constant)任职原因（assignment_start_reason）枚举定义部分获得
         * <p> 示例值：onboarding
         */
        private Enum assignmentStartReason;
        /**
         * 预计试用期结束日期
         * <p> 示例值：2006-01-02
         */
        private String probationExpectedEndDate;
        /**
         * 试用期结果，枚举值可通过文档[【飞书人事枚举常量】](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/corehr-v1/feishu-people-enum-constant)试用期结果（probation_outcome）枚举定义部分获得
         * <p> 示例值：passed
         */
        private Enum probationOutcome;
        /**
         * 周工作时长
         * <p> 示例值：30
         */
        private Integer weeklyWorkingHours;
        /**
         * 实线主管的任职记录ID
         * <p> 示例值：6890452208593372679
         */
        private String directManagerId;
        /**
         * 虚线主管的任职记录ID
         * <p> 示例值：["6971723901730686501"]
         */
        private String[] dottedLineManagerIdList;
        /**
         * 第二实线主管的任职记录ID
         * <p> 示例值：6890452208593372679
         */
        private String secondDirectManagerId;
        /**
         * 成本中心分摊信息
         * <p> 示例值：
         */
        private SupportCostCenterItem[] costCenterRate;
        /**
         * 周工作时长v2
         * <p> 示例值：37.5
         */
        private Double weeklyWorkingHoursV2;
        /**
         * 排班类型
         * <p> 示例值：
         */
        private Enum workShift;
        /**
         * 薪资类型
         * <p> 示例值：
         */
        private Enum compensationType;
        /**
         * 任职公司
         * <p> 示例值：6890452208593372680
         */
        private String serviceCompany;

        /**
         * 任职信息 ID
         * <p> 示例值：6890452208593372679
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 任职记录版本 ID
         * <p> 示例值：6890452208593372697
         *
         * @param versionId
         * @return
         */
        public Builder versionId(String versionId) {
            this.versionId = versionId;
            return this;
        }


        /**
         * 职务级别 ID，枚举值及详细信息可通过【批量查询职务级别】接口查询获得
         * <p> 示例值：6890452208593372679
         *
         * @param jobLevelId
         * @return
         */
        public Builder jobLevelId(String jobLevelId) {
            this.jobLevelId = jobLevelId;
            return this;
        }


        /**
         * 职等ID
         * <p> 示例值：6890452208593372679
         *
         * @param jobGradeId
         * @return
         */
        public Builder jobGradeId(String jobGradeId) {
            this.jobGradeId = jobGradeId;
            return this;
        }


        /**
         * 人员类型 ID，枚举值及详细信息可通过【批量查询人员类型】接口查询获得
         * <p> 示例值：6890452208593372679
         *
         * @param employeeTypeId
         * @return
         */
        public Builder employeeTypeId(String employeeTypeId) {
            this.employeeTypeId = employeeTypeId;
            return this;
        }


        /**
         * 工时制度 ID，枚举值及详细信息可通过【批量查询工时制度】接口查询获得
         * <p> 示例值：6890452208593372679
         *
         * @param workingHoursTypeId
         * @return
         */
        public Builder workingHoursTypeId(String workingHoursTypeId) {
            this.workingHoursTypeId = workingHoursTypeId;
            return this;
        }


        /**
         * 工作地点 ID，枚举值及详细信息可通过【批量查询地点】接口查询获得
         * <p> 示例值：6890452208593372679
         *
         * @param workLocationId
         * @return
         */
        public Builder workLocationId(String workLocationId) {
            this.workLocationId = workLocationId;
            return this;
        }


        /**
         * 部门 ID，枚举值及详细信息可通过【批量查询部门】接口查询获得
         * <p> 示例值：6890452208593372679
         *
         * @param departmentId
         * @return
         */
        public Builder departmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }


        /**
         * 职务 ID，枚举值及详细信息可通过【批量查询职务】接口查询获得
         * <p> 示例值：6890452208593372679
         *
         * @param jobId
         * @return
         */
        public Builder jobId(String jobId) {
            this.jobId = jobId;
            return this;
        }


        /**
         * 试用期开始日期
         * <p> 示例值：2018-03-16
         *
         * @param probationStartDate
         * @return
         */
        public Builder probationStartDate(String probationStartDate) {
            this.probationStartDate = probationStartDate;
            return this;
        }


        /**
         * 试用期结束日期（实际结束日期）
         * <p> 示例值：2019-05-24
         *
         * @param probationEndDate
         * @return
         */
        public Builder probationEndDate(String probationEndDate) {
            this.probationEndDate = probationEndDate;
            return this;
        }


        /**
         * 是否为主任职
         * <p> 示例值：true
         *
         * @param primaryJobData
         * @return
         */
        public Builder primaryJobData(Boolean primaryJobData) {
            this.primaryJobData = primaryJobData;
            return this;
        }


        /**
         * 雇佣 ID
         * <p> 示例值：6893014062142064135
         *
         * @param employmentId
         * @return
         */
        public Builder employmentId(String employmentId) {
            this.employmentId = employmentId;
            return this;
        }


        /**
         * 生效时间
         * <p> 示例值：2020-05-01 00:00:00
         *
         * @param effectiveTime
         * @return
         */
        public Builder effectiveTime(String effectiveTime) {
            this.effectiveTime = effectiveTime;
            return this;
        }


        /**
         * 失效时间
         * <p> 示例值：2020-05-02 00:00:00
         *
         * @param expirationTime
         * @return
         */
        public Builder expirationTime(String expirationTime) {
            this.expirationTime = expirationTime;
            return this;
        }


        /**
         * 职务序列 ID，枚举值及详细信息可通过【批量查询职务序列】接口查询获得
         * <p> 示例值：1245678
         *
         * @param jobFamilyId
         * @return
         */
        public Builder jobFamilyId(String jobFamilyId) {
            this.jobFamilyId = jobFamilyId;
            return this;
        }


        /**
         * 任职原因，枚举值可通过文档[【飞书人事枚举常量】](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/corehr-v1/feishu-people-enum-constant)任职原因（assignment_start_reason）枚举定义部分获得
         * <p> 示例值：onboarding
         *
         * @param assignmentStartReason
         * @return
         */
        public Builder assignmentStartReason(Enum assignmentStartReason) {
            this.assignmentStartReason = assignmentStartReason;
            return this;
        }


        /**
         * 预计试用期结束日期
         * <p> 示例值：2006-01-02
         *
         * @param probationExpectedEndDate
         * @return
         */
        public Builder probationExpectedEndDate(String probationExpectedEndDate) {
            this.probationExpectedEndDate = probationExpectedEndDate;
            return this;
        }


        /**
         * 试用期结果，枚举值可通过文档[【飞书人事枚举常量】](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/corehr-v1/feishu-people-enum-constant)试用期结果（probation_outcome）枚举定义部分获得
         * <p> 示例值：passed
         *
         * @param probationOutcome
         * @return
         */
        public Builder probationOutcome(Enum probationOutcome) {
            this.probationOutcome = probationOutcome;
            return this;
        }


        /**
         * 周工作时长
         * <p> 示例值：30
         *
         * @param weeklyWorkingHours
         * @return
         */
        public Builder weeklyWorkingHours(Integer weeklyWorkingHours) {
            this.weeklyWorkingHours = weeklyWorkingHours;
            return this;
        }


        /**
         * 实线主管的任职记录ID
         * <p> 示例值：6890452208593372679
         *
         * @param directManagerId
         * @return
         */
        public Builder directManagerId(String directManagerId) {
            this.directManagerId = directManagerId;
            return this;
        }


        /**
         * 虚线主管的任职记录ID
         * <p> 示例值：["6971723901730686501"]
         *
         * @param dottedLineManagerIdList
         * @return
         */
        public Builder dottedLineManagerIdList(String[] dottedLineManagerIdList) {
            this.dottedLineManagerIdList = dottedLineManagerIdList;
            return this;
        }


        /**
         * 第二实线主管的任职记录ID
         * <p> 示例值：6890452208593372679
         *
         * @param secondDirectManagerId
         * @return
         */
        public Builder secondDirectManagerId(String secondDirectManagerId) {
            this.secondDirectManagerId = secondDirectManagerId;
            return this;
        }


        /**
         * 成本中心分摊信息
         * <p> 示例值：
         *
         * @param costCenterRate
         * @return
         */
        public Builder costCenterRate(SupportCostCenterItem[] costCenterRate) {
            this.costCenterRate = costCenterRate;
            return this;
        }


        /**
         * 周工作时长v2
         * <p> 示例值：37.5
         *
         * @param weeklyWorkingHoursV2
         * @return
         */
        public Builder weeklyWorkingHoursV2(Double weeklyWorkingHoursV2) {
            this.weeklyWorkingHoursV2 = weeklyWorkingHoursV2;
            return this;
        }


        /**
         * 排班类型
         * <p> 示例值：
         *
         * @param workShift
         * @return
         */
        public Builder workShift(Enum workShift) {
            this.workShift = workShift;
            return this;
        }


        /**
         * 薪资类型
         * <p> 示例值：
         *
         * @param compensationType
         * @return
         */
        public Builder compensationType(Enum compensationType) {
            this.compensationType = compensationType;
            return this;
        }


        /**
         * 任职公司
         * <p> 示例值：6890452208593372680
         *
         * @param serviceCompany
         * @return
         */
        public Builder serviceCompany(String serviceCompany) {
            this.serviceCompany = serviceCompany;
            return this;
        }


        public JobData build() {
            return new JobData(this);
        }
    }
}
