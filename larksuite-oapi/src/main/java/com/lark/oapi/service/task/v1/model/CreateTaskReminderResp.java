// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.task.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class CreateTaskReminderResp extends BaseResponse {

  @SerializedName("data")
  private CreateTaskReminder body;

  public CreateTaskReminder getCreateTaskReminder() {
    return this.body;
  }

  public void setCreateTaskReminder(CreateTaskReminder body) {
    this.body = body;
  }
}
