// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.sheets.v3.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.annotation.Path;

public class QuerySpreadsheetSheetFilterViewReq {
    @Path
    @SerializedName("spreadsheet_token")
    private String spreadsheetToken;
    @Path
    @SerializedName("sheet_id")
    private String sheetId;

    // builder 开始
    public QuerySpreadsheetSheetFilterViewReq() {
    }

    public QuerySpreadsheetSheetFilterViewReq(Builder builder) {
        this.spreadsheetToken = builder.spreadsheetToken;
        this.sheetId = builder.sheetId;
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

    public static class Builder {

        private String spreadsheetToken;
        private String sheetId;

        public Builder spreadsheetToken(String spreadsheetToken) {
            this.spreadsheetToken = spreadsheetToken;
            return this;
        }

        public Builder sheetId(String sheetId) {
            this.sheetId = sheetId;
            return this;
        }

        public QuerySpreadsheetSheetFilterViewReq build() {
            return new QuerySpreadsheetSheetFilterViewReq(this);
        }
    }
}