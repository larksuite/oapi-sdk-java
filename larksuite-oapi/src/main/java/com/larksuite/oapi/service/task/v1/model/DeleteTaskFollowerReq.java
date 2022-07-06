// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.task.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;

public class DeleteTaskFollowerReq {
    @Path
    @SerializedName("task_id")
    private String taskId;
    @Path
    @SerializedName("follower_id")
    private String followerId;

    // builder 开始
    public DeleteTaskFollowerReq() {
    }

    public DeleteTaskFollowerReq(Builder builder) {
        this.taskId = builder.taskId;
        this.followerId = builder.followerId;
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

    public String getFollowerId() {
        return this.followerId;
    }

    public void setFollowerId(String followerId) {
        this.followerId = followerId;
    }

    public static class Builder {

        private String taskId;
        private String followerId;

        public Builder taskId(String taskId) {
            this.taskId = taskId;
            return this;
        }

        public Builder followerId(String followerId) {
            this.followerId = followerId;
            return this;
        }

        public DeleteTaskFollowerReq build() {
            return new DeleteTaskFollowerReq(this);
        }
    }
}
