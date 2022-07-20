// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Query;

public class ListAgentScheduleReq {

  @Query
  @SerializedName("status")
  private Integer[] status;

  // builder 开始
  public ListAgentScheduleReq() {
  }

  public ListAgentScheduleReq(Builder builder) {
    this.status = builder.status;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Integer[] getStatus() {
    return this.status;
  }

  public void setStatus(Integer[] status) {
    this.status = status;
  }

  public static class Builder {

    private Integer[] status;

    public Builder status(Integer[] status) {
      this.status = status;
      return this;
    }

    public ListAgentScheduleReq build() {
      return new ListAgentScheduleReq(this);
    }
  }
}
