// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;

public class QueryUserApprovalDTO {

  @SerializedName("user_approvals")
  private UserApproval[] userApprovals;

  public UserApproval[] getUserApprovals() {
    return this.userApprovals;
  }

  public void setUserApprovals(UserApproval[] userApprovals) {
    this.userApprovals = userApprovals;
  }

}