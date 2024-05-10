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

package com.lark.oapi.service.attendance.v1.model;

import com.lark.oapi.core.response.EmptyData;
import com.lark.oapi.service.attendance.v1.enums.*;
import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.core.response.BaseResponse;

public class GetGroupReq {
    /**
     * 用户 ID 的类型
     * <p> 示例值：employee_id
     */
    @Query
    @SerializedName("employee_type")
    private String employeeType;
    /**
     * 部门 ID 的类型
     * <p> 示例值：od-fcb45c28a45311afd441b8869541ece8
     */
    @Query
    @SerializedName("dept_type")
    private String deptType;
    /**
     * 考勤组 ID，获取方式：1）[创建或修改考勤组](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/group/create) 2）[按名称查询考勤组](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/group/search) 3）[获取打卡结果](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/user_task/query)
     * <p> 示例值：6919358128597097404
     */
    @Path
    @SerializedName("group_id")
    private String groupId;

    // builder 开始
    public GetGroupReq() {
    }

    public GetGroupReq(Builder builder) {
        /**
         * 用户 ID 的类型
         * <p> 示例值：employee_id
         */
        this.employeeType = builder.employeeType;
        /**
         * 部门 ID 的类型
         * <p> 示例值：od-fcb45c28a45311afd441b8869541ece8
         */
        this.deptType = builder.deptType;
        /**
         * 考勤组 ID，获取方式：1）[创建或修改考勤组](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/group/create) 2）[按名称查询考勤组](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/group/search) 3）[获取打卡结果](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/user_task/query)
         * <p> 示例值：6919358128597097404
         */
        this.groupId = builder.groupId;
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

    public String getDeptType() {
        return this.deptType;
    }

    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public static class Builder {
        private String employeeType; // 用户 ID 的类型
        private String deptType; // 部门 ID 的类型
        private String groupId; // 考勤组 ID，获取方式：1）[创建或修改考勤组](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/group/create) 2）[按名称查询考勤组](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/group/search) 3）[获取打卡结果](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/user_task/query)

        /**
         * 用户 ID 的类型
         * <p> 示例值：employee_id
         *
         * @param employeeType
         * @return
         */
        public Builder employeeType(String employeeType) {
            this.employeeType = employeeType;
            return this;
        }

        /**
         * 用户 ID 的类型
         * <p> 示例值：employee_id
         *
         * @param employeeType {@link com.lark.oapi.service.attendance.v1.enums.GetGroupEmployeeTypeEnum}
         * @return
         */
        public Builder employeeType(com.lark.oapi.service.attendance.v1.enums.GetGroupEmployeeTypeEnum employeeType) {
            this.employeeType = employeeType.getValue();
            return this;
        }

        /**
         * 部门 ID 的类型
         * <p> 示例值：od-fcb45c28a45311afd441b8869541ece8
         *
         * @param deptType
         * @return
         */
        public Builder deptType(String deptType) {
            this.deptType = deptType;
            return this;
        }

        /**
         * 部门 ID 的类型
         * <p> 示例值：od-fcb45c28a45311afd441b8869541ece8
         *
         * @param deptType {@link com.lark.oapi.service.attendance.v1.enums.GetGroupDeptTypeEnum}
         * @return
         */
        public Builder deptType(com.lark.oapi.service.attendance.v1.enums.GetGroupDeptTypeEnum deptType) {
            this.deptType = deptType.getValue();
            return this;
        }

        /**
         * 考勤组 ID，获取方式：1）[创建或修改考勤组](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/group/create) 2）[按名称查询考勤组](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/group/search) 3）[获取打卡结果](https://open.feishu.cn/document/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/user_task/query)
         * <p> 示例值：6919358128597097404
         *
         * @param groupId
         * @return
         */
        public Builder groupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public GetGroupReq build() {
            return new GetGroupReq(this);
        }
    }
}
