// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class GetFileCommentResp extends BaseResponse {

  @SerializedName("data")
  private GetFileComment body;

  public GetFileComment getGetFileComment() {
    return this.body;
  }

  public void setGetFileComment(GetFileComment body) {
    this.body = body;
  }
}