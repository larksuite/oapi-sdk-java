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

public class BatchGetEmployeesBpRespBody {
    /**
     * 员工直属 BP 信息，当员工所在部门、属地无 BP 时，会上钻找到最近的 BP
     * <p> 示例值：
     */
    @SerializedName("employment_direct_bps")
    private EmploymentBp[] employmentDirectBps;
    /**
     * 员工全部 BP 信息
     * <p> 示例值：
     */
    @SerializedName("employment_all_bps")
    private EmploymentBp[] employmentAllBps;

    public EmploymentBp[] getEmploymentDirectBps() {
        return this.employmentDirectBps;
    }

    public void setEmploymentDirectBps(EmploymentBp[] employmentDirectBps) {
        this.employmentDirectBps = employmentDirectBps;
    }

    public EmploymentBp[] getEmploymentAllBps() {
        return this.employmentAllBps;
    }

    public void setEmploymentAllBps(EmploymentBp[] employmentAllBps) {
        this.employmentAllBps = employmentAllBps;
    }

}
