// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.task.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class CreateTaskCommentResp extends BaseResponse {

  @SerializedName("data")
  private CreateTaskComment body;

  public CreateTaskComment getCreateTaskComment() {
    return this.body;
  }

  public void setCreateTaskComment(CreateTaskComment body) {
    this.body = body;
  }
}
