// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class RemoveInstanceCommentResp extends BaseResponse {

  @SerializedName("data")
  private RemoveInstanceComment body;

  public RemoveInstanceComment getRemoveInstanceComment() {
    return this.body;
  }

  public void setRemoveInstanceComment(RemoveInstanceComment body) {
    this.body = body;
  }
}
