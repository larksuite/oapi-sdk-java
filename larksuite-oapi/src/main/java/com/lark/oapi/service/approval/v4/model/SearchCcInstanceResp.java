// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class SearchCcInstanceResp extends BaseResponse {

  @SerializedName("data")
  private SearchCcInstance body;

  public SearchCcInstance getSearchCcInstance() {
    return this.body;
  }

  public void setSearchCcInstance(SearchCcInstance body) {
    this.body = body;
  }
}
