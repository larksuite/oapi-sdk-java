// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.helpdesk.v1.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class SearchFaqResp extends BaseResponse {

  @SerializedName("data")
  private SearchFaq body;

  public SearchFaq getSearchFaq() {
    return this.body;
  }

  public void setSearchFaq(SearchFaq body) {
    this.body = body;
  }
}
