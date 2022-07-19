// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.sheets.v3.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;

public class UpdateSpreadsheetSheetFilterReq {

  @Path
  @SerializedName("spreadsheet_token")
  private String spreadsheetToken;
  @Path
  @SerializedName("sheet_id")
  private String sheetId;
  @Body
  private UpdateSheetFilter body;

  // builder 开始
  public UpdateSpreadsheetSheetFilterReq() {
  }

  public UpdateSpreadsheetSheetFilterReq(Builder builder) {
    this.spreadsheetToken = builder.spreadsheetToken;
    this.sheetId = builder.sheetId;
    this.body = builder.body;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getSpreadsheetToken() {
    return this.spreadsheetToken;
  }

  public void setSpreadsheetToken(String spreadsheetToken) {
    this.spreadsheetToken = spreadsheetToken;
  }

  public String getSheetId() {
    return this.sheetId;
  }

  public void setSheetId(String sheetId) {
    this.sheetId = sheetId;
  }

  public UpdateSheetFilter getUpdateSheetFilter() {
    return this.body;
  }

  public void setUpdateSheetFilter(UpdateSheetFilter body) {
    this.body = body;
  }

  public static class Builder {

    private String spreadsheetToken;
    private String sheetId;
    private UpdateSheetFilter body;

    public Builder spreadsheetToken(String spreadsheetToken) {
      this.spreadsheetToken = spreadsheetToken;
      return this;
    }

    public Builder sheetId(String sheetId) {
      this.sheetId = sheetId;
      return this;
    }

    public UpdateSheetFilter getUpdateSheetFilter() {
      return this.body;
    }

    public Builder updateSheetFilter(UpdateSheetFilter body) {
      this.body = body;
      return this;
    }

    public UpdateSpreadsheetSheetFilterReq build() {
      return new UpdateSpreadsheetSheetFilterReq(this);
    }
  }
}