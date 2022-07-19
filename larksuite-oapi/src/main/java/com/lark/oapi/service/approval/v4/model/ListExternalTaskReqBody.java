// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class ListExternalTaskReqBody {

  @SerializedName("approval_codes")
  private String[] approvalCodes;
  @SerializedName("instance_ids")
  private String[] instanceIds;
  @SerializedName("user_ids")
  private String[] userIds;
  @SerializedName("status")
  private String status;

  // builder 开始
  public ListExternalTaskReqBody() {
  }

  public ListExternalTaskReqBody(Builder builder) {
    this.approvalCodes = builder.approvalCodes;
    this.instanceIds = builder.instanceIds;
    this.userIds = builder.userIds;
    this.status = builder.status;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String[] getApprovalCodes() {
    return this.approvalCodes;
  }

  public void setApprovalCodes(String[] approvalCodes) {
    this.approvalCodes = approvalCodes;
  }

  public String[] getInstanceIds() {
    return this.instanceIds;
  }

  public void setInstanceIds(String[] instanceIds) {
    this.instanceIds = instanceIds;
  }

  public String[] getUserIds() {
    return this.userIds;
  }

  public void setUserIds(String[] userIds) {
    this.userIds = userIds;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public static class Builder {

    private String[] approvalCodes;
    private String[] instanceIds;
    private String[] userIds;
    private String status;

    public Builder approvalCodes(String[] approvalCodes) {
      this.approvalCodes = approvalCodes;
      return this;
    }

    public Builder instanceIds(String[] instanceIds) {
      this.instanceIds = instanceIds;
      return this;
    }

    public Builder userIds(String[] userIds) {
      this.userIds = userIds;
      return this;
    }

    public Builder status(String status) {
      this.status = status;
      return this;
    }

    public Builder status(com.lark.oapi.service.approval.v4.enums.StatusEnum status) {
      this.status = status.getValue();
      return this;
    }


    public ListExternalTaskReqBody build() {
      return new ListExternalTaskReqBody(this);
    }
  }
}