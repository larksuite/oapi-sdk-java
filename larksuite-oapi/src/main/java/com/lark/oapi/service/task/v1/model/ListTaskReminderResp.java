// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.task.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class ListTaskReminderResp extends BaseResponse {

  @SerializedName("data")
  private ListTaskReminder body;

  public ListTaskReminder getListTaskReminder() {
    return this.body;
  }

  public void setListTaskReminder(ListTaskReminder body) {
    this.body = body;
  }
}