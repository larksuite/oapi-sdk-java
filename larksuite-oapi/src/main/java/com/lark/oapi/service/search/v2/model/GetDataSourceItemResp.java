// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.search.v2.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class GetDataSourceItemResp extends BaseResponse {

  @SerializedName("data")
  private GetDataSourceItem body;

  public GetDataSourceItem getGetDataSourceItem() {
    return this.body;
  }

  public void setGetDataSourceItem(GetDataSourceItem body) {
    this.body = body;
  }
}