// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.mail.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class QueryUserResp extends BaseResponse {

  @SerializedName("data")
  private QueryUser body;

  public QueryUser getQueryUser() {
    return this.body;
  }

  public void setQueryUser(QueryUser body) {
    this.body = body;
  }
}