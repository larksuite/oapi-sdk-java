// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.search.v2.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class GetDataSourceResp extends BaseResponse {

  @SerializedName("data")
  private GetDataSource body;

  public GetDataSource getGetDataSource() {
    return this.body;
  }

  public void setGetDataSource(GetDataSource body) {
    this.body = body;
  }
}
