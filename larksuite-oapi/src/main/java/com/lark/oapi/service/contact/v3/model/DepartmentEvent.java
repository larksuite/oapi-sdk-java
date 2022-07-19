// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;

public class DepartmentEvent {

  @SerializedName("name")
  private String name;
  @SerializedName("parent_department_id")
  private String parentDepartmentId;
  @SerializedName("department_id")
  private String departmentId;
  @SerializedName("open_department_id")
  private String openDepartmentId;
  @SerializedName("leader_user_id")
  private String leaderUserId;
  @SerializedName("chat_id")
  private String chatId;
  @SerializedName("order")
  private Integer order;
  @SerializedName("status")
  private DepartmentStatus status;

  // builder 开始
  public DepartmentEvent() {
  }

  public DepartmentEvent(Builder builder) {
    this.name = builder.name;
    this.parentDepartmentId = builder.parentDepartmentId;
    this.departmentId = builder.departmentId;
    this.openDepartmentId = builder.openDepartmentId;
    this.leaderUserId = builder.leaderUserId;
    this.chatId = builder.chatId;
    this.order = builder.order;
    this.status = builder.status;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getParentDepartmentId() {
    return this.parentDepartmentId;
  }

  public void setParentDepartmentId(String parentDepartmentId) {
    this.parentDepartmentId = parentDepartmentId;
  }

  public String getDepartmentId() {
    return this.departmentId;
  }

  public void setDepartmentId(String departmentId) {
    this.departmentId = departmentId;
  }

  public String getOpenDepartmentId() {
    return this.openDepartmentId;
  }

  public void setOpenDepartmentId(String openDepartmentId) {
    this.openDepartmentId = openDepartmentId;
  }

  public String getLeaderUserId() {
    return this.leaderUserId;
  }

  public void setLeaderUserId(String leaderUserId) {
    this.leaderUserId = leaderUserId;
  }

  public String getChatId() {
    return this.chatId;
  }

  public void setChatId(String chatId) {
    this.chatId = chatId;
  }

  public Integer getOrder() {
    return this.order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }

  public DepartmentStatus getStatus() {
    return this.status;
  }

  public void setStatus(DepartmentStatus status) {
    this.status = status;
  }

  public static class Builder {

    private String name;
    private String parentDepartmentId;
    private String departmentId;
    private String openDepartmentId;
    private String leaderUserId;
    private String chatId;
    private Integer order;
    private DepartmentStatus status;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder parentDepartmentId(String parentDepartmentId) {
      this.parentDepartmentId = parentDepartmentId;
      return this;
    }

    public Builder departmentId(String departmentId) {
      this.departmentId = departmentId;
      return this;
    }

    public Builder openDepartmentId(String openDepartmentId) {
      this.openDepartmentId = openDepartmentId;
      return this;
    }

    public Builder leaderUserId(String leaderUserId) {
      this.leaderUserId = leaderUserId;
      return this;
    }

    public Builder chatId(String chatId) {
      this.chatId = chatId;
      return this;
    }

    public Builder order(Integer order) {
      this.order = order;
      return this;
    }


    public Builder status(DepartmentStatus status) {
      this.status = status;
      return this;
    }


    public DepartmentEvent build() {
      return new DepartmentEvent(this);
    }
  }
}