// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.task.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;

public class CompleteTaskReq {
    @Path
    @SerializedName("task_id")
    private String taskId;

    // builder 开始
    public CompleteTaskReq() {
    }

    public CompleteTaskReq(Builder builder) {
        this.taskId = builder.taskId;
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

    public static class Builder {

        private String taskId;

        public Builder taskId(String taskId) {
            this.taskId = taskId;
            return this;
        }

        public CompleteTaskReq build() {
            return new CompleteTaskReq(this);
        }
    }
}
