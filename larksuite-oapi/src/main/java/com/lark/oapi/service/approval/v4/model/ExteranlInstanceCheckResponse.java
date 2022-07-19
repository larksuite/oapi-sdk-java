// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class ExteranlInstanceCheckResponse {

  @SerializedName("instance_id")
  private String instanceId;
  @SerializedName("update_time")
  private Long updateTime;
  @SerializedName("tasks")
  private ExternalInstanceTask[] tasks;

  // builder 开始
  public ExteranlInstanceCheckResponse() {
  }

  public ExteranlInstanceCheckResponse(Builder builder) {
    this.instanceId = builder.instanceId;
    this.updateTime = builder.updateTime;
    this.tasks = builder.tasks;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getInstanceId() {
    return this.instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

  public Long getUpdateTime() {
    return this.updateTime;
  }

  public void setUpdateTime(Long updateTime) {
    this.updateTime = updateTime;
  }

  public ExternalInstanceTask[] getTasks() {
    return this.tasks;
  }

  public void setTasks(ExternalInstanceTask[] tasks) {
    this.tasks = tasks;
  }

  public static class Builder {

    private String instanceId;
    private Long updateTime;
    private ExternalInstanceTask[] tasks;

    public Builder instanceId(String instanceId) {
      this.instanceId = instanceId;
      return this;
    }

    public Builder updateTime(Long updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    public Builder tasks(ExternalInstanceTask[] tasks) {
      this.tasks = tasks;
      return this;
    }


    public ExteranlInstanceCheckResponse build() {
      return new ExteranlInstanceCheckResponse(this);
    }
  }
}