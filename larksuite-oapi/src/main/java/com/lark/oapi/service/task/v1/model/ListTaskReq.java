// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.task.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Query;

public class ListTaskReq {

  @Query
  @SerializedName("page_size")
  private Integer pageSize;
  @Query
  @SerializedName("page_token")
  private String pageToken;
  @Query
  @SerializedName("start_create_time")
  private Long startCreateTime;
  @Query
  @SerializedName("end_create_time")
  private Long endCreateTime;
  @Query
  @SerializedName("task_completed")
  private Boolean taskCompleted;
  @Query
  @SerializedName("user_id_type")
  private String userIdType;

  // builder 开始
  public ListTaskReq() {
  }

  public ListTaskReq(Builder builder) {
    this.pageSize = builder.pageSize;
    this.pageToken = builder.pageToken;
    this.startCreateTime = builder.startCreateTime;
    this.endCreateTime = builder.endCreateTime;
    this.taskCompleted = builder.taskCompleted;
    this.userIdType = builder.userIdType;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Integer getPageSize() {
    return this.pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public String getPageToken() {
    return this.pageToken;
  }

  public void setPageToken(String pageToken) {
    this.pageToken = pageToken;
  }

  public Long getStartCreateTime() {
    return this.startCreateTime;
  }

  public void setStartCreateTime(Long startCreateTime) {
    this.startCreateTime = startCreateTime;
  }

  public Long getEndCreateTime() {
    return this.endCreateTime;
  }

  public void setEndCreateTime(Long endCreateTime) {
    this.endCreateTime = endCreateTime;
  }

  public Boolean getTaskCompleted() {
    return this.taskCompleted;
  }

  public void setTaskCompleted(Boolean taskCompleted) {
    this.taskCompleted = taskCompleted;
  }

  public String getUserIdType() {
    return this.userIdType;
  }

  public void setUserIdType(String userIdType) {
    this.userIdType = userIdType;
  }

  public static class Builder {

    private Integer pageSize;
    private String pageToken;
    private Long startCreateTime;
    private Long endCreateTime;
    private Boolean taskCompleted;
    private String userIdType;

    public Builder pageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    public Builder pageToken(String pageToken) {
      this.pageToken = pageToken;
      return this;
    }

    public Builder startCreateTime(Long startCreateTime) {
      this.startCreateTime = startCreateTime;
      return this;
    }

    public Builder endCreateTime(Long endCreateTime) {
      this.endCreateTime = endCreateTime;
      return this;
    }

    public Builder taskCompleted(Boolean taskCompleted) {
      this.taskCompleted = taskCompleted;
      return this;
    }

    public Builder userIdType(String userIdType) {
      this.userIdType = userIdType;
      return this;
    }

    public Builder userIdType(com.lark.oapi.service.task.v1.enums.UserIdTypeEnum userIdType) {
      this.userIdType = userIdType.getValue();
      return this;
    }

    public ListTaskReq build() {
      return new ListTaskReq(this);
    }
  }
}