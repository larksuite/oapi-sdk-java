// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class QueryUserStatsDataResp extends BaseResponse {

  @SerializedName("data")
  private QueryUserStatsData body;

  public QueryUserStatsData getQueryUserStatsData() {
    return this.body;
  }

  public void setQueryUserStatsData(QueryUserStatsData body) {
    this.body = body;
  }
}