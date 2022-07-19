// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;

public class UnitDepartment {

  @SerializedName("unit_id")
  private String unitId;
  @SerializedName("department_id")
  private String departmentId;

  // builder 开始
  public UnitDepartment() {
  }

  public UnitDepartment(Builder builder) {
    this.unitId = builder.unitId;
    this.departmentId = builder.departmentId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getUnitId() {
    return this.unitId;
  }

  public void setUnitId(String unitId) {
    this.unitId = unitId;
  }

  public String getDepartmentId() {
    return this.departmentId;
  }

  public void setDepartmentId(String departmentId) {
    this.departmentId = departmentId;
  }

  public static class Builder {

    private String unitId;
    private String departmentId;

    public Builder unitId(String unitId) {
      this.unitId = unitId;
      return this;
    }

    public Builder departmentId(String departmentId) {
      this.departmentId = departmentId;
      return this;
    }


    public UnitDepartment build() {
      return new UnitDepartment(this);
    }
  }
}