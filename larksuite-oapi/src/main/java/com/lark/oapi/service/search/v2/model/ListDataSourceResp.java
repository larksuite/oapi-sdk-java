// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.search.v2.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class ListDataSourceResp extends BaseResponse {

  @SerializedName("data")
  private ListDataSource body;

  public ListDataSource getListDataSource() {
    return this.body;
  }

  public void setListDataSource(ListDataSource body) {
    this.body = body;
  }
}