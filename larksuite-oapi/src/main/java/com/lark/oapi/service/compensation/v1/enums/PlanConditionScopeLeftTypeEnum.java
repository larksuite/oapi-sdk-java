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

package com.lark.oapi.service.compensation.v1.enums;

/**
 * 适用范围左值
 */
public enum PlanConditionScopeLeftTypeEnum {
    DEPARTMENT(1), // 部门
    DEPARTMENTCONTAINSSUB(2), // 部门（包含下级部门）
    LOCATION(3), // 工作地点
    LOCATIONCONTAINSSUB(4), // 工作地点（包含下级地点）
    COMPANY(5), // 公司
    COMPANYCONTAINSSUB(6), // 公司（包含下级公司）
    JOBFAMILY(7), // 序列
    JOBFAMILYCONTAINSSUB(8), // 序列（包含子序列）
    JOB(9), // 职务
    JOBLEVEL(10), // 职级
    WORKFORCETYPE(11), // 人员类型
    RECRUITMENTTYPE(12), // 招聘类型
    COUNTRYREGION(13), // 国家/地区
    JOBGRADE(14), // 职等
    ;
    private Integer value;

    PlanConditionScopeLeftTypeEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}