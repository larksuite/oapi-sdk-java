// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class ExternalInstanceTask {

  @SerializedName("task_id")
  private String taskId;
  @SerializedName("update_time")
  private Long updateTime;

  // builder 开始
  public ExternalInstanceTask() {
  }

  public ExternalInstanceTask(Builder builder) {
    this.taskId = builder.taskId;
    this.updateTime = builder.updateTime;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getTaskId() {
    return this.taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public Long getUpdateTime() {
    return this.updateTime;
  }

  public void setUpdateTime(Long updateTime) {
    this.updateTime = updateTime;
  }

  public static class Builder {

    private String taskId;
    private Long updateTime;

    public Builder taskId(String taskId) {
      this.taskId = taskId;
      return this;
    }

    public Builder updateTime(Long updateTime) {
      this.updateTime = updateTime;
      return this;
    }


    public ExternalInstanceTask build() {
      return new ExternalInstanceTask(this);
    }
  }
}