// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.sheets.v3.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.response.BaseResponse;

public class FindSpreadsheetSheetResp extends BaseResponse {

  @SerializedName("data")
  private FindSpreadsheetSheet body;

  public FindSpreadsheetSheet getFindSpreadsheetSheet() {
    return this.body;
  }

  public void setFindSpreadsheetSheet(FindSpreadsheetSheet body) {
    this.body = body;
  }
}
