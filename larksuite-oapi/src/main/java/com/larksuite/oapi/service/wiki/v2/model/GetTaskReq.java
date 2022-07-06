// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.wiki.v2.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;
import com.larksuite.oapi.core.annotation.Query;

public class GetTaskReq {
    @Query
    @SerializedName("task_type")
    private String taskType;
    @Path
    @SerializedName("task_id")
    private String taskId;

    // builder 开始
    public GetTaskReq() {
    }

    public GetTaskReq(Builder builder) {
        this.taskType = builder.taskType;
        this.taskId = builder.taskId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getTaskType() {
        return this.taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public static class Builder {
        private String taskType;
        private String taskId;

        public Builder taskType(String taskType) {
            this.taskType = taskType;
            return this;
        }

        public Builder taskType(com.larksuite.oapi.service.wiki.v2.enums.TaskTypeEnum taskType) {
            this.taskType = taskType.getValue();
            return this;
        }

        public Builder taskId(String taskId) {
            this.taskId = taskId;
            return this;
        }

        public GetTaskReq build() {
            return new GetTaskReq(this);
        }
    }
}