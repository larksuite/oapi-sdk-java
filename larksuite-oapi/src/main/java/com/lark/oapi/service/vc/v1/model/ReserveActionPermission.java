// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.vc.v1.model;

import com.google.gson.annotations.SerializedName;

public class ReserveActionPermission {

  @SerializedName("permission")
  private Integer permission;
  @SerializedName("permission_checkers")
  private ReservePermissionChecker[] permissionCheckers;

  // builder 开始
  public ReserveActionPermission() {
  }

  public ReserveActionPermission(Builder builder) {
    this.permission = builder.permission;
    this.permissionCheckers = builder.permissionCheckers;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Integer getPermission() {
    return this.permission;
  }

  public void setPermission(Integer permission) {
    this.permission = permission;
  }

  public ReservePermissionChecker[] getPermissionCheckers() {
    return this.permissionCheckers;
  }

  public void setPermissionCheckers(ReservePermissionChecker[] permissionCheckers) {
    this.permissionCheckers = permissionCheckers;
  }

  public static class Builder {

    private Integer permission;
    private ReservePermissionChecker[] permissionCheckers;

    public Builder permission(Integer permission) {
      this.permission = permission;
      return this;
    }

    public Builder permission(com.lark.oapi.service.vc.v1.enums.MeetingPermEnum permission) {
      this.permission = permission.getValue();
      return this;
    }

    public Builder permissionCheckers(ReservePermissionChecker[] permissionCheckers) {
      this.permissionCheckers = permissionCheckers;
      return this;
    }


    public ReserveActionPermission build() {
      return new ReserveActionPermission(this);
    }
  }
}