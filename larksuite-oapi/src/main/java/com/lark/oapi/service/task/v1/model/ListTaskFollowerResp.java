// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.task.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class ListTaskFollowerResp extends BaseResponse {

  @SerializedName("data")
  private ListTaskFollower body;

  public ListTaskFollower getListTaskFollower() {
    return this.body;
  }

  public void setListTaskFollower(ListTaskFollower body) {
    this.body = body;
  }
}