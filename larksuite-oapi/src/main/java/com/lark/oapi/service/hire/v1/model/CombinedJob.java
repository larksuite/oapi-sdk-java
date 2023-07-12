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

public class CombinedJob {
    /**
     * 职位 ID
     * <p> 示例值：6960663240925956576
     */
    @SerializedName("id")
    private String id;
    /**
     * 职位编号，可传入职位的「职位编号」、「职位 ID」或者「职位序号」，将以传入的参数作为职位编号，以便双方系统的数据映射
     * <p> 示例值：R18
     */
    @SerializedName("code")
    private String code;
    /**
     * 工作年限
     * <p> 示例值：1
     */
    @SerializedName("experience")
    private Integer experience;
    /**
     * 到期日期
     * <p> 示例值：1622484739955
     */
    @SerializedName("expiry_time")
    private Integer expiryTime;
    /**
     * 自定义字段
     * <p> 示例值：
     */
    @SerializedName("customized_data_list")
    private CombinedJobObjectValueMap[] customizedDataList;
    /**
     * 最低职级，枚举通过接口「获取职级列表」获取
     * <p> 示例值：6960663240925956547
     */
    @SerializedName("min_level_id")
    private String minLevelId;
    /**
     * 最低薪资，单位：k
     * <p> 示例值：1000
     */
    @SerializedName("min_salary")
    private Integer minSalary;
    /**
     * 职位名称
     * <p> 示例值：后端研发
     */
    @SerializedName("title")
    private String title;
    /**
     * 职位的招聘团队
     * <p> 示例值：
     */
    @SerializedName("job_managers")
    private JobManager jobManagers;
    /**
     * 招聘流程，枚举通过接口「获取招聘流程信息」获取
     * <p> 示例值：6960663240925956554
     */
    @SerializedName("job_process_id")
    private String jobProcessId;
    /**
     * 职位流程类型
     * <p> 示例值：1
     */
    @SerializedName("process_type")
    private Integer processType;
    /**
     * 项目，枚举通过「获取项目列表」接口
     * <p> 示例值：6960663240925956555
     */
    @SerializedName("subject_id")
    private String subjectId;
    /**
     * 职能分类，通过「获取职能分类」获取
     * <p> 示例值：6960663240925956555
     */
    @SerializedName("job_function_id")
    private String jobFunctionId;
    /**
     * 部门 ID，须传入open_department_id，格式为"od-xxxx"。可通过「获取部门信息列表」获取
     * <p> 示例值：od-b2fafdce6fc5800b574ba5b0e2798b36
     */
    @SerializedName("department_id")
    private String departmentId;
    /**
     * 招聘数量
     * <p> 示例值：100
     */
    @SerializedName("head_count")
    private Integer headCount;
    /**
     * 是否长期有效
     * <p> 示例值：false
     */
    @SerializedName("is_never_expired")
    private Boolean isNeverExpired;
    /**
     * 最高薪资，单位：k
     * <p> 示例值：2000
     */
    @SerializedName("max_salary")
    private Integer maxSalary;
    /**
     * 职位要求
     * <p> 示例值：熟悉后端研发
     */
    @SerializedName("requirement")
    private String requirement;
    /**
     * 职位描述
     * <p> 示例值：后端研发岗位描述
     */
    @SerializedName("description")
    private String description;
    /**
     * 职位亮点
     * <p> 示例值：6960663240925956554
     */
    @SerializedName("highlight_list")
    private String[] highlightList;
    /**
     * 职位类别
     * <p> 示例值：6960663240925956551
     */
    @SerializedName("job_type_id")
    private String jobTypeId;
    /**
     * 最高职级，枚举通过接口「获取职级列表」获取
     * <p> 示例值：6960663240925956548
     */
    @SerializedName("max_level_id")
    private String maxLevelId;
    /**
     * 雇佣类型
     * <p> 示例值：102
     */
    @SerializedName("recruitment_type_id")
    private String recruitmentTypeId;
    /**
     * 学历要求
     * <p> 示例值：1
     */
    @SerializedName("required_degree")
    private Integer requiredDegree;
    /**
     * 序列
     * <p> 示例值：6960663240925956550
     */
    @SerializedName("job_category_id")
    private String jobCategoryId;
    /**
     * 工作地点，枚举通过接口「获取地址列表」获取，选择地点用途为「职位地址」
     * <p> 示例值：7035374761602959660
     */
    @SerializedName("address_id_list")
    private String[] addressIdList;
    /**
     * 职位属性，1是实体职位，2是虚拟职位
     * <p> 示例值：职位类别
     */
    @SerializedName("job_attribute")
    private Integer jobAttribute;
    /**
     * 到期日期的毫秒时间戳
     * <p> 示例值：1622484739955
     */
    @SerializedName("expiry_timestamp")
    private String expiryTimestamp;
    /**
     * 面试登记表ID
     * <p> 示例值：6930815272790114324
     */
    @SerializedName("interview_registration_schema_id")
    private String interviewRegistrationSchemaId;

    // builder 开始
    public CombinedJob() {
    }

    public CombinedJob(Builder builder) {
        /**
         * 职位 ID
         * <p> 示例值：6960663240925956576
         */
        this.id = builder.id;
        /**
         * 职位编号，可传入职位的「职位编号」、「职位 ID」或者「职位序号」，将以传入的参数作为职位编号，以便双方系统的数据映射
         * <p> 示例值：R18
         */
        this.code = builder.code;
        /**
         * 工作年限
         * <p> 示例值：1
         */
        this.experience = builder.experience;
        /**
         * 到期日期
         * <p> 示例值：1622484739955
         */
        this.expiryTime = builder.expiryTime;
        /**
         * 自定义字段
         * <p> 示例值：
         */
        this.customizedDataList = builder.customizedDataList;
        /**
         * 最低职级，枚举通过接口「获取职级列表」获取
         * <p> 示例值：6960663240925956547
         */
        this.minLevelId = builder.minLevelId;
        /**
         * 最低薪资，单位：k
         * <p> 示例值：1000
         */
        this.minSalary = builder.minSalary;
        /**
         * 职位名称
         * <p> 示例值：后端研发
         */
        this.title = builder.title;
        /**
         * 职位的招聘团队
         * <p> 示例值：
         */
        this.jobManagers = builder.jobManagers;
        /**
         * 招聘流程，枚举通过接口「获取招聘流程信息」获取
         * <p> 示例值：6960663240925956554
         */
        this.jobProcessId = builder.jobProcessId;
        /**
         * 职位流程类型
         * <p> 示例值：1
         */
        this.processType = builder.processType;
        /**
         * 项目，枚举通过「获取项目列表」接口
         * <p> 示例值：6960663240925956555
         */
        this.subjectId = builder.subjectId;
        /**
         * 职能分类，通过「获取职能分类」获取
         * <p> 示例值：6960663240925956555
         */
        this.jobFunctionId = builder.jobFunctionId;
        /**
         * 部门 ID，须传入open_department_id，格式为"od-xxxx"。可通过「获取部门信息列表」获取
         * <p> 示例值：od-b2fafdce6fc5800b574ba5b0e2798b36
         */
        this.departmentId = builder.departmentId;
        /**
         * 招聘数量
         * <p> 示例值：100
         */
        this.headCount = builder.headCount;
        /**
         * 是否长期有效
         * <p> 示例值：false
         */
        this.isNeverExpired = builder.isNeverExpired;
        /**
         * 最高薪资，单位：k
         * <p> 示例值：2000
         */
        this.maxSalary = builder.maxSalary;
        /**
         * 职位要求
         * <p> 示例值：熟悉后端研发
         */
        this.requirement = builder.requirement;
        /**
         * 职位描述
         * <p> 示例值：后端研发岗位描述
         */
        this.description = builder.description;
        /**
         * 职位亮点
         * <p> 示例值：6960663240925956554
         */
        this.highlightList = builder.highlightList;
        /**
         * 职位类别
         * <p> 示例值：6960663240925956551
         */
        this.jobTypeId = builder.jobTypeId;
        /**
         * 最高职级，枚举通过接口「获取职级列表」获取
         * <p> 示例值：6960663240925956548
         */
        this.maxLevelId = builder.maxLevelId;
        /**
         * 雇佣类型
         * <p> 示例值：102
         */
        this.recruitmentTypeId = builder.recruitmentTypeId;
        /**
         * 学历要求
         * <p> 示例值：1
         */
        this.requiredDegree = builder.requiredDegree;
        /**
         * 序列
         * <p> 示例值：6960663240925956550
         */
        this.jobCategoryId = builder.jobCategoryId;
        /**
         * 工作地点，枚举通过接口「获取地址列表」获取，选择地点用途为「职位地址」
         * <p> 示例值：7035374761602959660
         */
        this.addressIdList = builder.addressIdList;
        /**
         * 职位属性，1是实体职位，2是虚拟职位
         * <p> 示例值：职位类别
         */
        this.jobAttribute = builder.jobAttribute;
        /**
         * 到期日期的毫秒时间戳
         * <p> 示例值：1622484739955
         */
        this.expiryTimestamp = builder.expiryTimestamp;
        /**
         * 面试登记表ID
         * <p> 示例值：6930815272790114324
         */
        this.interviewRegistrationSchemaId = builder.interviewRegistrationSchemaId;
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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getExperience() {
        return this.experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getExpiryTime() {
        return this.expiryTime;
    }

    public void setExpiryTime(Integer expiryTime) {
        this.expiryTime = expiryTime;
    }

    public CombinedJobObjectValueMap[] getCustomizedDataList() {
        return this.customizedDataList;
    }

    public void setCustomizedDataList(CombinedJobObjectValueMap[] customizedDataList) {
        this.customizedDataList = customizedDataList;
    }

    public String getMinLevelId() {
        return this.minLevelId;
    }

    public void setMinLevelId(String minLevelId) {
        this.minLevelId = minLevelId;
    }

    public Integer getMinSalary() {
        return this.minSalary;
    }

    public void setMinSalary(Integer minSalary) {
        this.minSalary = minSalary;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public JobManager getJobManagers() {
        return this.jobManagers;
    }

    public void setJobManagers(JobManager jobManagers) {
        this.jobManagers = jobManagers;
    }

    public String getJobProcessId() {
        return this.jobProcessId;
    }

    public void setJobProcessId(String jobProcessId) {
        this.jobProcessId = jobProcessId;
    }

    public Integer getProcessType() {
        return this.processType;
    }

    public void setProcessType(Integer processType) {
        this.processType = processType;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getJobFunctionId() {
        return this.jobFunctionId;
    }

    public void setJobFunctionId(String jobFunctionId) {
        this.jobFunctionId = jobFunctionId;
    }

    public String getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getHeadCount() {
        return this.headCount;
    }

    public void setHeadCount(Integer headCount) {
        this.headCount = headCount;
    }

    public Boolean getIsNeverExpired() {
        return this.isNeverExpired;
    }

    public void setIsNeverExpired(Boolean isNeverExpired) {
        this.isNeverExpired = isNeverExpired;
    }

    public Integer getMaxSalary() {
        return this.maxSalary;
    }

    public void setMaxSalary(Integer maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getRequirement() {
        return this.requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getHighlightList() {
        return this.highlightList;
    }

    public void setHighlightList(String[] highlightList) {
        this.highlightList = highlightList;
    }

    public String getJobTypeId() {
        return this.jobTypeId;
    }

    public void setJobTypeId(String jobTypeId) {
        this.jobTypeId = jobTypeId;
    }

    public String getMaxLevelId() {
        return this.maxLevelId;
    }

    public void setMaxLevelId(String maxLevelId) {
        this.maxLevelId = maxLevelId;
    }

    public String getRecruitmentTypeId() {
        return this.recruitmentTypeId;
    }

    public void setRecruitmentTypeId(String recruitmentTypeId) {
        this.recruitmentTypeId = recruitmentTypeId;
    }

    public Integer getRequiredDegree() {
        return this.requiredDegree;
    }

    public void setRequiredDegree(Integer requiredDegree) {
        this.requiredDegree = requiredDegree;
    }

    public String getJobCategoryId() {
        return this.jobCategoryId;
    }

    public void setJobCategoryId(String jobCategoryId) {
        this.jobCategoryId = jobCategoryId;
    }

    public String[] getAddressIdList() {
        return this.addressIdList;
    }

    public void setAddressIdList(String[] addressIdList) {
        this.addressIdList = addressIdList;
    }

    public Integer getJobAttribute() {
        return this.jobAttribute;
    }

    public void setJobAttribute(Integer jobAttribute) {
        this.jobAttribute = jobAttribute;
    }

    public String getExpiryTimestamp() {
        return this.expiryTimestamp;
    }

    public void setExpiryTimestamp(String expiryTimestamp) {
        this.expiryTimestamp = expiryTimestamp;
    }

    public String getInterviewRegistrationSchemaId() {
        return this.interviewRegistrationSchemaId;
    }

    public void setInterviewRegistrationSchemaId(String interviewRegistrationSchemaId) {
        this.interviewRegistrationSchemaId = interviewRegistrationSchemaId;
    }

    public static class Builder {
        /**
         * 职位 ID
         * <p> 示例值：6960663240925956576
         */
        private String id;
        /**
         * 职位编号，可传入职位的「职位编号」、「职位 ID」或者「职位序号」，将以传入的参数作为职位编号，以便双方系统的数据映射
         * <p> 示例值：R18
         */
        private String code;
        /**
         * 工作年限
         * <p> 示例值：1
         */
        private Integer experience;
        /**
         * 到期日期
         * <p> 示例值：1622484739955
         */
        private Integer expiryTime;
        /**
         * 自定义字段
         * <p> 示例值：
         */
        private CombinedJobObjectValueMap[] customizedDataList;
        /**
         * 最低职级，枚举通过接口「获取职级列表」获取
         * <p> 示例值：6960663240925956547
         */
        private String minLevelId;
        /**
         * 最低薪资，单位：k
         * <p> 示例值：1000
         */
        private Integer minSalary;
        /**
         * 职位名称
         * <p> 示例值：后端研发
         */
        private String title;
        /**
         * 职位的招聘团队
         * <p> 示例值：
         */
        private JobManager jobManagers;
        /**
         * 招聘流程，枚举通过接口「获取招聘流程信息」获取
         * <p> 示例值：6960663240925956554
         */
        private String jobProcessId;
        /**
         * 职位流程类型
         * <p> 示例值：1
         */
        private Integer processType;
        /**
         * 项目，枚举通过「获取项目列表」接口
         * <p> 示例值：6960663240925956555
         */
        private String subjectId;
        /**
         * 职能分类，通过「获取职能分类」获取
         * <p> 示例值：6960663240925956555
         */
        private String jobFunctionId;
        /**
         * 部门 ID，须传入open_department_id，格式为"od-xxxx"。可通过「获取部门信息列表」获取
         * <p> 示例值：od-b2fafdce6fc5800b574ba5b0e2798b36
         */
        private String departmentId;
        /**
         * 招聘数量
         * <p> 示例值：100
         */
        private Integer headCount;
        /**
         * 是否长期有效
         * <p> 示例值：false
         */
        private Boolean isNeverExpired;
        /**
         * 最高薪资，单位：k
         * <p> 示例值：2000
         */
        private Integer maxSalary;
        /**
         * 职位要求
         * <p> 示例值：熟悉后端研发
         */
        private String requirement;
        /**
         * 职位描述
         * <p> 示例值：后端研发岗位描述
         */
        private String description;
        /**
         * 职位亮点
         * <p> 示例值：6960663240925956554
         */
        private String[] highlightList;
        /**
         * 职位类别
         * <p> 示例值：6960663240925956551
         */
        private String jobTypeId;
        /**
         * 最高职级，枚举通过接口「获取职级列表」获取
         * <p> 示例值：6960663240925956548
         */
        private String maxLevelId;
        /**
         * 雇佣类型
         * <p> 示例值：102
         */
        private String recruitmentTypeId;
        /**
         * 学历要求
         * <p> 示例值：1
         */
        private Integer requiredDegree;
        /**
         * 序列
         * <p> 示例值：6960663240925956550
         */
        private String jobCategoryId;
        /**
         * 工作地点，枚举通过接口「获取地址列表」获取，选择地点用途为「职位地址」
         * <p> 示例值：7035374761602959660
         */
        private String[] addressIdList;
        /**
         * 职位属性，1是实体职位，2是虚拟职位
         * <p> 示例值：职位类别
         */
        private Integer jobAttribute;
        /**
         * 到期日期的毫秒时间戳
         * <p> 示例值：1622484739955
         */
        private String expiryTimestamp;
        /**
         * 面试登记表ID
         * <p> 示例值：6930815272790114324
         */
        private String interviewRegistrationSchemaId;

        /**
         * 职位 ID
         * <p> 示例值：6960663240925956576
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 职位编号，可传入职位的「职位编号」、「职位 ID」或者「职位序号」，将以传入的参数作为职位编号，以便双方系统的数据映射
         * <p> 示例值：R18
         *
         * @param code
         * @return
         */
        public Builder code(String code) {
            this.code = code;
            return this;
        }


        /**
         * 工作年限
         * <p> 示例值：1
         *
         * @param experience
         * @return
         */
        public Builder experience(Integer experience) {
            this.experience = experience;
            return this;
        }


        /**
         * 到期日期
         * <p> 示例值：1622484739955
         *
         * @param expiryTime
         * @return
         */
        public Builder expiryTime(Integer expiryTime) {
            this.expiryTime = expiryTime;
            return this;
        }


        /**
         * 自定义字段
         * <p> 示例值：
         *
         * @param customizedDataList
         * @return
         */
        public Builder customizedDataList(CombinedJobObjectValueMap[] customizedDataList) {
            this.customizedDataList = customizedDataList;
            return this;
        }


        /**
         * 最低职级，枚举通过接口「获取职级列表」获取
         * <p> 示例值：6960663240925956547
         *
         * @param minLevelId
         * @return
         */
        public Builder minLevelId(String minLevelId) {
            this.minLevelId = minLevelId;
            return this;
        }


        /**
         * 最低薪资，单位：k
         * <p> 示例值：1000
         *
         * @param minSalary
         * @return
         */
        public Builder minSalary(Integer minSalary) {
            this.minSalary = minSalary;
            return this;
        }


        /**
         * 职位名称
         * <p> 示例值：后端研发
         *
         * @param title
         * @return
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }


        /**
         * 职位的招聘团队
         * <p> 示例值：
         *
         * @param jobManagers
         * @return
         */
        public Builder jobManagers(JobManager jobManagers) {
            this.jobManagers = jobManagers;
            return this;
        }


        /**
         * 招聘流程，枚举通过接口「获取招聘流程信息」获取
         * <p> 示例值：6960663240925956554
         *
         * @param jobProcessId
         * @return
         */
        public Builder jobProcessId(String jobProcessId) {
            this.jobProcessId = jobProcessId;
            return this;
        }


        /**
         * 职位流程类型
         * <p> 示例值：1
         *
         * @param processType
         * @return
         */
        public Builder processType(Integer processType) {
            this.processType = processType;
            return this;
        }


        /**
         * 项目，枚举通过「获取项目列表」接口
         * <p> 示例值：6960663240925956555
         *
         * @param subjectId
         * @return
         */
        public Builder subjectId(String subjectId) {
            this.subjectId = subjectId;
            return this;
        }


        /**
         * 职能分类，通过「获取职能分类」获取
         * <p> 示例值：6960663240925956555
         *
         * @param jobFunctionId
         * @return
         */
        public Builder jobFunctionId(String jobFunctionId) {
            this.jobFunctionId = jobFunctionId;
            return this;
        }


        /**
         * 部门 ID，须传入open_department_id，格式为"od-xxxx"。可通过「获取部门信息列表」获取
         * <p> 示例值：od-b2fafdce6fc5800b574ba5b0e2798b36
         *
         * @param departmentId
         * @return
         */
        public Builder departmentId(String departmentId) {
            this.departmentId = departmentId;
            return this;
        }


        /**
         * 招聘数量
         * <p> 示例值：100
         *
         * @param headCount
         * @return
         */
        public Builder headCount(Integer headCount) {
            this.headCount = headCount;
            return this;
        }


        /**
         * 是否长期有效
         * <p> 示例值：false
         *
         * @param isNeverExpired
         * @return
         */
        public Builder isNeverExpired(Boolean isNeverExpired) {
            this.isNeverExpired = isNeverExpired;
            return this;
        }


        /**
         * 最高薪资，单位：k
         * <p> 示例值：2000
         *
         * @param maxSalary
         * @return
         */
        public Builder maxSalary(Integer maxSalary) {
            this.maxSalary = maxSalary;
            return this;
        }


        /**
         * 职位要求
         * <p> 示例值：熟悉后端研发
         *
         * @param requirement
         * @return
         */
        public Builder requirement(String requirement) {
            this.requirement = requirement;
            return this;
        }


        /**
         * 职位描述
         * <p> 示例值：后端研发岗位描述
         *
         * @param description
         * @return
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }


        /**
         * 职位亮点
         * <p> 示例值：6960663240925956554
         *
         * @param highlightList
         * @return
         */
        public Builder highlightList(String[] highlightList) {
            this.highlightList = highlightList;
            return this;
        }


        /**
         * 职位类别
         * <p> 示例值：6960663240925956551
         *
         * @param jobTypeId
         * @return
         */
        public Builder jobTypeId(String jobTypeId) {
            this.jobTypeId = jobTypeId;
            return this;
        }


        /**
         * 最高职级，枚举通过接口「获取职级列表」获取
         * <p> 示例值：6960663240925956548
         *
         * @param maxLevelId
         * @return
         */
        public Builder maxLevelId(String maxLevelId) {
            this.maxLevelId = maxLevelId;
            return this;
        }


        /**
         * 雇佣类型
         * <p> 示例值：102
         *
         * @param recruitmentTypeId
         * @return
         */
        public Builder recruitmentTypeId(String recruitmentTypeId) {
            this.recruitmentTypeId = recruitmentTypeId;
            return this;
        }


        /**
         * 学历要求
         * <p> 示例值：1
         *
         * @param requiredDegree
         * @return
         */
        public Builder requiredDegree(Integer requiredDegree) {
            this.requiredDegree = requiredDegree;
            return this;
        }


        /**
         * 序列
         * <p> 示例值：6960663240925956550
         *
         * @param jobCategoryId
         * @return
         */
        public Builder jobCategoryId(String jobCategoryId) {
            this.jobCategoryId = jobCategoryId;
            return this;
        }


        /**
         * 工作地点，枚举通过接口「获取地址列表」获取，选择地点用途为「职位地址」
         * <p> 示例值：7035374761602959660
         *
         * @param addressIdList
         * @return
         */
        public Builder addressIdList(String[] addressIdList) {
            this.addressIdList = addressIdList;
            return this;
        }


        /**
         * 职位属性，1是实体职位，2是虚拟职位
         * <p> 示例值：职位类别
         *
         * @param jobAttribute
         * @return
         */
        public Builder jobAttribute(Integer jobAttribute) {
            this.jobAttribute = jobAttribute;
            return this;
        }


        /**
         * 到期日期的毫秒时间戳
         * <p> 示例值：1622484739955
         *
         * @param expiryTimestamp
         * @return
         */
        public Builder expiryTimestamp(String expiryTimestamp) {
            this.expiryTimestamp = expiryTimestamp;
            return this;
        }


        /**
         * 面试登记表ID
         * <p> 示例值：6930815272790114324
         *
         * @param interviewRegistrationSchemaId
         * @return
         */
        public Builder interviewRegistrationSchemaId(String interviewRegistrationSchemaId) {
            this.interviewRegistrationSchemaId = interviewRegistrationSchemaId;
            return this;
        }


        public CombinedJob build() {
            return new CombinedJob(this);
        }
    }
}
