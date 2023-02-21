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

public class PortalJobPost {
    /**
     * 职位广告 ID
     * <p> 示例值：1213213123123
     */
    @SerializedName("id")
    private String id;
    /**
     * 标题
     * <p> 示例值：测试
     */
    @SerializedName("title")
    private String title;
    /**
     * 职位 ID
     * <p> 示例值：xxx
     */
    @SerializedName("job_id")
    private String jobId;
    /**
     * 职位编码
     * <p> 示例值：007
     */
    @SerializedName("job_code")
    private String jobCode;
    /**
     * 职位过期时间，「null」代表「长期有效」
     * <p> 示例值：1111
     */
    @SerializedName("job_expire_time")
    private String jobExpireTime;
    /**
     * 职位状态
     * <p> 示例值：1
     */
    @SerializedName("job_active_status")
    private Integer jobActiveStatus;
    /**
     * 职位流程类型
     * <p> 示例值：1
     */
    @SerializedName("job_process_type")
    private Integer jobProcessType;
    /**
     * 职位雇佣类型
     * <p> 示例值：
     */
    @SerializedName("job_recruitment_type")
    private IdNameObject jobRecruitmentType;
    /**
     * 职位部门
     * <p> 示例值：
     */
    @SerializedName("job_department")
    private IdNameObject jobDepartment;
    /**
     * 职位类型
     * <p> 示例值：
     */
    @SerializedName("job_type")
    private IdNameObject jobType;
    /**
     * 职位地址
     * <p> 示例值：
     */
    @SerializedName("address")
    private CommonAddress address;
    /**
     * 月薪范围-最低薪资
     * <p> 示例值：5000
     */
    @SerializedName("min_salary")
    private String minSalary;
    /**
     * 月薪范围-最高薪资
     * <p> 示例值：10000
     */
    @SerializedName("max_salary")
    private String maxSalary;
    /**
     * 学历要求
     * <p> 示例值：1
     */
    @SerializedName("required_degree")
    private Integer requiredDegree;
    /**
     * 经验
     * <p> 示例值：1
     */
    @SerializedName("experience")
    private Integer experience;
    /**
     * 数量
     * <p> 示例值：12
     */
    @SerializedName("headcount")
    private Integer headcount;
    /**
     * 职位亮点
     * <p> 示例值：
     */
    @SerializedName("high_light_list")
    private IdNameObject[] highLightList;
    /**
     * 职位描述
     * <p> 示例值：负责软件开发
     */
    @SerializedName("description")
    private String description;
    /**
     * 职位要求
     * <p> 示例值：大专
     */
    @SerializedName("requirement")
    private String requirement;
    /**
     * 创建人
     * <p> 示例值：
     */
    @SerializedName("creator")
    private IdNameObject creator;
    /**
     * 创建时间
     * <p> 示例值：1111
     */
    @SerializedName("create_time")
    private String createTime;
    /**
     * 修改时间
     * <p> 示例值：222
     */
    @SerializedName("modify_time")
    private String modifyTime;
    /**
     * 自定义字段
     * <p> 示例值：
     */
    @SerializedName("customized_data_list")
    private WebsiteJobPostCustomizedData[] customizedDataList;
    /**
     * 职能分类
     * <p> 示例值：
     */
    @SerializedName("job_function")
    private IdNameObject jobFunction;
    /**
     * 职位项目
     * <p> 示例值：
     */
    @SerializedName("subject")
    private IdNameObject subject;
    /**
     * 职位广告地址列表
     * <p> 示例值：
     */
    @SerializedName("address_list")
    private CommonAddress[] addressList;

    // builder 开始
    public PortalJobPost() {
    }

    public PortalJobPost(Builder builder) {
        /**
         * 职位广告 ID
         * <p> 示例值：1213213123123
         */
        this.id = builder.id;
        /**
         * 标题
         * <p> 示例值：测试
         */
        this.title = builder.title;
        /**
         * 职位 ID
         * <p> 示例值：xxx
         */
        this.jobId = builder.jobId;
        /**
         * 职位编码
         * <p> 示例值：007
         */
        this.jobCode = builder.jobCode;
        /**
         * 职位过期时间，「null」代表「长期有效」
         * <p> 示例值：1111
         */
        this.jobExpireTime = builder.jobExpireTime;
        /**
         * 职位状态
         * <p> 示例值：1
         */
        this.jobActiveStatus = builder.jobActiveStatus;
        /**
         * 职位流程类型
         * <p> 示例值：1
         */
        this.jobProcessType = builder.jobProcessType;
        /**
         * 职位雇佣类型
         * <p> 示例值：
         */
        this.jobRecruitmentType = builder.jobRecruitmentType;
        /**
         * 职位部门
         * <p> 示例值：
         */
        this.jobDepartment = builder.jobDepartment;
        /**
         * 职位类型
         * <p> 示例值：
         */
        this.jobType = builder.jobType;
        /**
         * 职位地址
         * <p> 示例值：
         */
        this.address = builder.address;
        /**
         * 月薪范围-最低薪资
         * <p> 示例值：5000
         */
        this.minSalary = builder.minSalary;
        /**
         * 月薪范围-最高薪资
         * <p> 示例值：10000
         */
        this.maxSalary = builder.maxSalary;
        /**
         * 学历要求
         * <p> 示例值：1
         */
        this.requiredDegree = builder.requiredDegree;
        /**
         * 经验
         * <p> 示例值：1
         */
        this.experience = builder.experience;
        /**
         * 数量
         * <p> 示例值：12
         */
        this.headcount = builder.headcount;
        /**
         * 职位亮点
         * <p> 示例值：
         */
        this.highLightList = builder.highLightList;
        /**
         * 职位描述
         * <p> 示例值：负责软件开发
         */
        this.description = builder.description;
        /**
         * 职位要求
         * <p> 示例值：大专
         */
        this.requirement = builder.requirement;
        /**
         * 创建人
         * <p> 示例值：
         */
        this.creator = builder.creator;
        /**
         * 创建时间
         * <p> 示例值：1111
         */
        this.createTime = builder.createTime;
        /**
         * 修改时间
         * <p> 示例值：222
         */
        this.modifyTime = builder.modifyTime;
        /**
         * 自定义字段
         * <p> 示例值：
         */
        this.customizedDataList = builder.customizedDataList;
        /**
         * 职能分类
         * <p> 示例值：
         */
        this.jobFunction = builder.jobFunction;
        /**
         * 职位项目
         * <p> 示例值：
         */
        this.subject = builder.subject;
        /**
         * 职位广告地址列表
         * <p> 示例值：
         */
        this.addressList = builder.addressList;
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobId() {
        return this.jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobCode() {
        return this.jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getJobExpireTime() {
        return this.jobExpireTime;
    }

    public void setJobExpireTime(String jobExpireTime) {
        this.jobExpireTime = jobExpireTime;
    }

    public Integer getJobActiveStatus() {
        return this.jobActiveStatus;
    }

    public void setJobActiveStatus(Integer jobActiveStatus) {
        this.jobActiveStatus = jobActiveStatus;
    }

    public Integer getJobProcessType() {
        return this.jobProcessType;
    }

    public void setJobProcessType(Integer jobProcessType) {
        this.jobProcessType = jobProcessType;
    }

    public IdNameObject getJobRecruitmentType() {
        return this.jobRecruitmentType;
    }

    public void setJobRecruitmentType(IdNameObject jobRecruitmentType) {
        this.jobRecruitmentType = jobRecruitmentType;
    }

    public IdNameObject getJobDepartment() {
        return this.jobDepartment;
    }

    public void setJobDepartment(IdNameObject jobDepartment) {
        this.jobDepartment = jobDepartment;
    }

    public IdNameObject getJobType() {
        return this.jobType;
    }

    public void setJobType(IdNameObject jobType) {
        this.jobType = jobType;
    }

    public CommonAddress getAddress() {
        return this.address;
    }

    public void setAddress(CommonAddress address) {
        this.address = address;
    }

    public String getMinSalary() {
        return this.minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return this.maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Integer getRequiredDegree() {
        return this.requiredDegree;
    }

    public void setRequiredDegree(Integer requiredDegree) {
        this.requiredDegree = requiredDegree;
    }

    public Integer getExperience() {
        return this.experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getHeadcount() {
        return this.headcount;
    }

    public void setHeadcount(Integer headcount) {
        this.headcount = headcount;
    }

    public IdNameObject[] getHighLightList() {
        return this.highLightList;
    }

    public void setHighLightList(IdNameObject[] highLightList) {
        this.highLightList = highLightList;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirement() {
        return this.requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public IdNameObject getCreator() {
        return this.creator;
    }

    public void setCreator(IdNameObject creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public WebsiteJobPostCustomizedData[] getCustomizedDataList() {
        return this.customizedDataList;
    }

    public void setCustomizedDataList(WebsiteJobPostCustomizedData[] customizedDataList) {
        this.customizedDataList = customizedDataList;
    }

    public IdNameObject getJobFunction() {
        return this.jobFunction;
    }

    public void setJobFunction(IdNameObject jobFunction) {
        this.jobFunction = jobFunction;
    }

    public IdNameObject getSubject() {
        return this.subject;
    }

    public void setSubject(IdNameObject subject) {
        this.subject = subject;
    }

    public CommonAddress[] getAddressList() {
        return this.addressList;
    }

    public void setAddressList(CommonAddress[] addressList) {
        this.addressList = addressList;
    }

    public static class Builder {
        /**
         * 职位广告 ID
         * <p> 示例值：1213213123123
         */
        private String id;
        /**
         * 标题
         * <p> 示例值：测试
         */
        private String title;
        /**
         * 职位 ID
         * <p> 示例值：xxx
         */
        private String jobId;
        /**
         * 职位编码
         * <p> 示例值：007
         */
        private String jobCode;
        /**
         * 职位过期时间，「null」代表「长期有效」
         * <p> 示例值：1111
         */
        private String jobExpireTime;
        /**
         * 职位状态
         * <p> 示例值：1
         */
        private Integer jobActiveStatus;
        /**
         * 职位流程类型
         * <p> 示例值：1
         */
        private Integer jobProcessType;
        /**
         * 职位雇佣类型
         * <p> 示例值：
         */
        private IdNameObject jobRecruitmentType;
        /**
         * 职位部门
         * <p> 示例值：
         */
        private IdNameObject jobDepartment;
        /**
         * 职位类型
         * <p> 示例值：
         */
        private IdNameObject jobType;
        /**
         * 职位地址
         * <p> 示例值：
         */
        private CommonAddress address;
        /**
         * 月薪范围-最低薪资
         * <p> 示例值：5000
         */
        private String minSalary;
        /**
         * 月薪范围-最高薪资
         * <p> 示例值：10000
         */
        private String maxSalary;
        /**
         * 学历要求
         * <p> 示例值：1
         */
        private Integer requiredDegree;
        /**
         * 经验
         * <p> 示例值：1
         */
        private Integer experience;
        /**
         * 数量
         * <p> 示例值：12
         */
        private Integer headcount;
        /**
         * 职位亮点
         * <p> 示例值：
         */
        private IdNameObject[] highLightList;
        /**
         * 职位描述
         * <p> 示例值：负责软件开发
         */
        private String description;
        /**
         * 职位要求
         * <p> 示例值：大专
         */
        private String requirement;
        /**
         * 创建人
         * <p> 示例值：
         */
        private IdNameObject creator;
        /**
         * 创建时间
         * <p> 示例值：1111
         */
        private String createTime;
        /**
         * 修改时间
         * <p> 示例值：222
         */
        private String modifyTime;
        /**
         * 自定义字段
         * <p> 示例值：
         */
        private WebsiteJobPostCustomizedData[] customizedDataList;
        /**
         * 职能分类
         * <p> 示例值：
         */
        private IdNameObject jobFunction;
        /**
         * 职位项目
         * <p> 示例值：
         */
        private IdNameObject subject;
        /**
         * 职位广告地址列表
         * <p> 示例值：
         */
        private CommonAddress[] addressList;

        /**
         * 职位广告 ID
         * <p> 示例值：1213213123123
         *
         * @param id
         * @return
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }


        /**
         * 标题
         * <p> 示例值：测试
         *
         * @param title
         * @return
         */
        public Builder title(String title) {
            this.title = title;
            return this;
        }


        /**
         * 职位 ID
         * <p> 示例值：xxx
         *
         * @param jobId
         * @return
         */
        public Builder jobId(String jobId) {
            this.jobId = jobId;
            return this;
        }


        /**
         * 职位编码
         * <p> 示例值：007
         *
         * @param jobCode
         * @return
         */
        public Builder jobCode(String jobCode) {
            this.jobCode = jobCode;
            return this;
        }


        /**
         * 职位过期时间，「null」代表「长期有效」
         * <p> 示例值：1111
         *
         * @param jobExpireTime
         * @return
         */
        public Builder jobExpireTime(String jobExpireTime) {
            this.jobExpireTime = jobExpireTime;
            return this;
        }


        /**
         * 职位状态
         * <p> 示例值：1
         *
         * @param jobActiveStatus
         * @return
         */
        public Builder jobActiveStatus(Integer jobActiveStatus) {
            this.jobActiveStatus = jobActiveStatus;
            return this;
        }


        /**
         * 职位流程类型
         * <p> 示例值：1
         *
         * @param jobProcessType
         * @return
         */
        public Builder jobProcessType(Integer jobProcessType) {
            this.jobProcessType = jobProcessType;
            return this;
        }


        /**
         * 职位雇佣类型
         * <p> 示例值：
         *
         * @param jobRecruitmentType
         * @return
         */
        public Builder jobRecruitmentType(IdNameObject jobRecruitmentType) {
            this.jobRecruitmentType = jobRecruitmentType;
            return this;
        }


        /**
         * 职位部门
         * <p> 示例值：
         *
         * @param jobDepartment
         * @return
         */
        public Builder jobDepartment(IdNameObject jobDepartment) {
            this.jobDepartment = jobDepartment;
            return this;
        }


        /**
         * 职位类型
         * <p> 示例值：
         *
         * @param jobType
         * @return
         */
        public Builder jobType(IdNameObject jobType) {
            this.jobType = jobType;
            return this;
        }


        /**
         * 职位地址
         * <p> 示例值：
         *
         * @param address
         * @return
         */
        public Builder address(CommonAddress address) {
            this.address = address;
            return this;
        }


        /**
         * 月薪范围-最低薪资
         * <p> 示例值：5000
         *
         * @param minSalary
         * @return
         */
        public Builder minSalary(String minSalary) {
            this.minSalary = minSalary;
            return this;
        }


        /**
         * 月薪范围-最高薪资
         * <p> 示例值：10000
         *
         * @param maxSalary
         * @return
         */
        public Builder maxSalary(String maxSalary) {
            this.maxSalary = maxSalary;
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
         * 经验
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
         * 数量
         * <p> 示例值：12
         *
         * @param headcount
         * @return
         */
        public Builder headcount(Integer headcount) {
            this.headcount = headcount;
            return this;
        }


        /**
         * 职位亮点
         * <p> 示例值：
         *
         * @param highLightList
         * @return
         */
        public Builder highLightList(IdNameObject[] highLightList) {
            this.highLightList = highLightList;
            return this;
        }


        /**
         * 职位描述
         * <p> 示例值：负责软件开发
         *
         * @param description
         * @return
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }


        /**
         * 职位要求
         * <p> 示例值：大专
         *
         * @param requirement
         * @return
         */
        public Builder requirement(String requirement) {
            this.requirement = requirement;
            return this;
        }


        /**
         * 创建人
         * <p> 示例值：
         *
         * @param creator
         * @return
         */
        public Builder creator(IdNameObject creator) {
            this.creator = creator;
            return this;
        }


        /**
         * 创建时间
         * <p> 示例值：1111
         *
         * @param createTime
         * @return
         */
        public Builder createTime(String createTime) {
            this.createTime = createTime;
            return this;
        }


        /**
         * 修改时间
         * <p> 示例值：222
         *
         * @param modifyTime
         * @return
         */
        public Builder modifyTime(String modifyTime) {
            this.modifyTime = modifyTime;
            return this;
        }


        /**
         * 自定义字段
         * <p> 示例值：
         *
         * @param customizedDataList
         * @return
         */
        public Builder customizedDataList(WebsiteJobPostCustomizedData[] customizedDataList) {
            this.customizedDataList = customizedDataList;
            return this;
        }


        /**
         * 职能分类
         * <p> 示例值：
         *
         * @param jobFunction
         * @return
         */
        public Builder jobFunction(IdNameObject jobFunction) {
            this.jobFunction = jobFunction;
            return this;
        }


        /**
         * 职位项目
         * <p> 示例值：
         *
         * @param subject
         * @return
         */
        public Builder subject(IdNameObject subject) {
            this.subject = subject;
            return this;
        }


        /**
         * 职位广告地址列表
         * <p> 示例值：
         *
         * @param addressList
         * @return
         */
        public Builder addressList(CommonAddress[] addressList) {
            this.addressList = addressList;
            return this;
        }


        public PortalJobPost build() {
            return new PortalJobPost(this);
        }
    }
}