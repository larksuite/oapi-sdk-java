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

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;

public class GetUserFlowReq {

  /**
   * 响应体中的 user_id 和 creator_id 的员工工号类型
   * <p> 示例值：employee_id
   */
  @Query
  @SerializedName("employee_type")
  private String employeeType;
  /**
   * 打卡流水记录 ID，获取方式：1）[批量查询打卡流水记录](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/user_flow/query)
   * 2）[获取打卡结果](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/user_task/query)
   * 3）[导入打卡流水记录](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/user_flow/batch_create)
   * <p> 示例值：6708236686834352397
   */
  @Path
  @SerializedName("user_flow_id")
  private String userFlowId;

  // builder 开始
  public GetUserFlowReq() {
  }

  public GetUserFlowReq(Builder builder) {
    /**
     * 响应体中的 user_id 和 creator_id 的员工工号类型
     * <p> 示例值：employee_id
     */
    this.employeeType = builder.employeeType;
    /**
     * 打卡流水记录 ID，获取方式：1）[批量查询打卡流水记录](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/user_flow/query) 2）[获取打卡结果](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/user_task/query) 3）[导入打卡流水记录](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/user_flow/batch_create)
     * <p> 示例值：6708236686834352397
     */
    this.userFlowId = builder.userFlowId;
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

  public String getUserFlowId() {
    return this.userFlowId;
  }

  public void setUserFlowId(String userFlowId) {
    this.userFlowId = userFlowId;
  }

  public static class Builder {

    private String employeeType; // 响应体中的 user_id 和 creator_id 的员工工号类型
    private String userFlowId; // 打卡流水记录 ID，获取方式：1）[批量查询打卡流水记录](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/user_flow/query) 2）[获取打卡结果](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/user_task/query) 3）[导入打卡流水记录](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/user_flow/batch_create)

    /**
     * 响应体中的 user_id 和 creator_id 的员工工号类型
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
     * 响应体中的 user_id 和 creator_id 的员工工号类型
     * <p> 示例值：employee_id
     *
     * @param employeeType {@link com.lark.oapi.service.attendance.v1.enums.GetUserFlowEmployeeTypeEnum}
     * @return
     */
    public Builder employeeType(
        com.lark.oapi.service.attendance.v1.enums.GetUserFlowEmployeeTypeEnum employeeType) {
      this.employeeType = employeeType.getValue();
      return this;
    }

    /**
     * 打卡流水记录 ID，获取方式：1）[批量查询打卡流水记录](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/user_flow/query)
     * 2）[获取打卡结果](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/user_task/query)
     * 3）[导入打卡流水记录](/ssl:ttdoc/uAjLw4CM/ukTMukTMukTM/reference/attendance-v1/user_flow/batch_create)
     * <p> 示例值：6708236686834352397
     *
     * @param userFlowId
     * @return
     */
    public Builder userFlowId(String userFlowId) {
      this.userFlowId = userFlowId;
      return this;
    }

    public GetUserFlowReq build() {
      return new GetUserFlowReq(this);
    }
  }
}