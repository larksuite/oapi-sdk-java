// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.sheets.v3.model;

import com.google.gson.annotations.SerializedName;

public class GetSpreadsheetSheetFilterDTO {

  @SerializedName("sheet_filter_info")
  private SheetFilterInfo sheetFilterInfo;

  public SheetFilterInfo getSheetFilterInfo() {
    return this.sheetFilterInfo;
  }

  public void setSheetFilterInfo(SheetFilterInfo sheetFilterInfo) {
    this.sheetFilterInfo = sheetFilterInfo;
  }

}