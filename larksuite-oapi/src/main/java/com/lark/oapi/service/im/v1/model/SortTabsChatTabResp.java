// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class SortTabsChatTabResp extends BaseResponse {

  @SerializedName("data")
  private SortTabsChatTab body;

  public SortTabsChatTab getSortTabsChatTab() {
    return this.body;
  }

  public void setSortTabsChatTab(SortTabsChatTab body) {
    this.body = body;
  }
}