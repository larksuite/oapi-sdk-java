// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;

public class DepartmentStatus {

  @SerializedName("is_deleted")
  private Boolean isDeleted;

  // builder 开始
  public DepartmentStatus() {
  }

  public DepartmentStatus(Builder builder) {
    this.isDeleted = builder.isDeleted;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Boolean getIsDeleted() {
    return this.isDeleted;
  }

  public void setIsDeleted(Boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  public static class Builder {

    private Boolean isDeleted;

    public Builder isDeleted(Boolean isDeleted) {
      this.isDeleted = isDeleted;
      return this;
    }


    public DepartmentStatus build() {
      return new DepartmentStatus(this);
    }
  }
}