// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.task.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class GetTaskCommentResp extends BaseResponse {

  @SerializedName("data")
  private GetTaskComment body;

  public GetTaskComment getGetTaskComment() {
    return this.body;
  }

  public void setGetTaskComment(GetTaskComment body) {
    this.body = body;
  }
}
