// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.baike.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class HighlightEntityResp extends BaseResponse {

  @SerializedName("data")
  private HighlightEntity body;

  public HighlightEntity getHighlightEntity() {
    return this.body;
  }

  public void setHighlightEntity(HighlightEntity body) {
    this.body = body;
  }
}
