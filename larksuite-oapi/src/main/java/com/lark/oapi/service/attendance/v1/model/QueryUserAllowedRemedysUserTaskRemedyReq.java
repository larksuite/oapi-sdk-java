// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Query;

public class QueryUserAllowedRemedysUserTaskRemedyReq {

  @Query
  @SerializedName("employee_type")
  private String employeeType;
  @Body
  private QueryUserAllowedRemedysUserTaskRemedyReqBody body;

  // builder 开始
  public QueryUserAllowedRemedysUserTaskRemedyReq() {
  }

  public QueryUserAllowedRemedysUserTaskRemedyReq(Builder builder) {
    this.employeeType = builder.employeeType;
    this.body = builder.body;
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

  public QueryUserAllowedRemedysUserTaskRemedyReqBody getQueryUserAllowedRemedysUserTaskRemedyReqBody() {
    return this.body;
  }

  public void setQueryUserAllowedRemedysUserTaskRemedyReqBody(
      QueryUserAllowedRemedysUserTaskRemedyReqBody body) {
    this.body = body;
  }

  public static class Builder {

    private String employeeType;
    private QueryUserAllowedRemedysUserTaskRemedyReqBody body;

    public Builder employeeType(String employeeType) {
      this.employeeType = employeeType;
      return this;
    }

    public Builder employeeType(
        com.lark.oapi.service.attendance.v1.enums.EmployeeTypeEnum employeeType) {
      this.employeeType = employeeType.getValue();
      return this;
    }

    public QueryUserAllowedRemedysUserTaskRemedyReqBody getQueryUserAllowedRemedysUserTaskRemedyReqBody() {
      return this.body;
    }

    public Builder queryUserAllowedRemedysUserTaskRemedyReqBody(
        QueryUserAllowedRemedysUserTaskRemedyReqBody body) {
      this.body = body;
      return this;
    }

    public QueryUserAllowedRemedysUserTaskRemedyReq build() {
      return new QueryUserAllowedRemedysUserTaskRemedyReq(this);
    }
  }
}