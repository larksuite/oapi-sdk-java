// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.task.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Body;
import com.larksuite.oapi.core.annotation.Query;

public class CreateTaskReq {
    @Query
    @SerializedName("user_id_type")
    private String userIdType;
    @Body
    private Task body;

    // builder 开始
    public CreateTaskReq() {
    }

    public CreateTaskReq(Builder builder) {
        this.userIdType = builder.userIdType;
        this.body = builder.body;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getUserIdType() {
        return this.userIdType;
    }

    public void setUserIdType(String userIdType) {
        this.userIdType = userIdType;
    }

    public Task getTask() {
        return this.body;
    }

    public void setTask(Task body) {
        this.body = body;
    }

    public static class Builder {
        private String userIdType;
        private Task body;

        public Builder userIdType(String userIdType) {
            this.userIdType = userIdType;
            return this;
        }

        public Builder userIdType(com.larksuite.oapi.service.task.v1.enums.UserIdTypeEnum userIdType) {
            this.userIdType = userIdType.getValue();
            return this;
        }

        public Task getTask() {
            return this.body;
        }

        public Builder task(Task body) {
            this.body = body;
            return this;
        }

        public CreateTaskReq build() {
            return new CreateTaskReq(this);
        }
    }
}
