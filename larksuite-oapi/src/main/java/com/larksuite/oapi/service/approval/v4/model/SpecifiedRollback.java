// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class SpecifiedRollback {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("task_id")
    private Long taskId;
    @SerializedName("reason")
    private String reason;
    @SerializedName("extra")
    private String extra;
    @SerializedName("task_def_key_list")
    private String[] taskDefKeyList;

    // builder 开始
    public SpecifiedRollback() {
    }

    public SpecifiedRollback(Builder builder) {
        this.userId = builder.userId;
        this.taskId = builder.taskId;
        this.reason = builder.reason;
        this.extra = builder.extra;
        this.taskDefKeyList = builder.taskDefKeyList;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getExtra() {
        return this.extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String[] getTaskDefKeyList() {
        return this.taskDefKeyList;
    }

    public void setTaskDefKeyList(String[] taskDefKeyList) {
        this.taskDefKeyList = taskDefKeyList;
    }

    public static class Builder {
        private String userId;
        private Long taskId;
        private String reason;
        private String extra;
        private String[] taskDefKeyList;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder taskId(Long taskId) {
            this.taskId = taskId;
            return this;
        }

        public Builder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder extra(String extra) {
            this.extra = extra;
            return this;
        }

        public Builder taskDefKeyList(String[] taskDefKeyList) {
            this.taskDefKeyList = taskDefKeyList;
            return this;
        }


        public SpecifiedRollback build() {
            return new SpecifiedRollback(this);
        }
    }
}
