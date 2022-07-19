// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Query;

public class QueryShiftReq {

  @Query
  @SerializedName("shift_name")
  private String shiftName;

  // builder 开始
  public QueryShiftReq() {
  }

  public QueryShiftReq(Builder builder) {
    this.shiftName = builder.shiftName;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getShiftName() {
    return this.shiftName;
  }

  public void setShiftName(String shiftName) {
    this.shiftName = shiftName;
  }

  public static class Builder {

    private String shiftName;

    public Builder shiftName(String shiftName) {
      this.shiftName = shiftName;
      return this;
    }

    public QueryShiftReq build() {
      return new QueryShiftReq(this);
    }
  }
}