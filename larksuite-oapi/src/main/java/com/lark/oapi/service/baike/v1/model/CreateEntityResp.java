// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.baike.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class CreateEntityResp extends BaseResponse {

  @SerializedName("data")
  private CreateEntity body;

  public CreateEntity getCreateEntity() {
    return this.body;
  }

  public void setCreateEntity(CreateEntity body) {
    this.body = body;
  }
}
