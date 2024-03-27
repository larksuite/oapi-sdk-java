// Code generated by lark suite oapi sdk gen
/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.lark.oapi.service.sheets.v3.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.annotation.Path;

public class GetSpreadsheetSheetFilterReq {
    /**
     * 表格 token
     * <p> 示例值：shtcnmBA\*****yGehy8
     */
    @Path
    @SerializedName("spreadsheet_token")
    private String spreadsheetToken;
    /**
     * 子表 id
     * <p> 示例值：0b\**12
     */
    @Path
    @SerializedName("sheet_id")
    private String sheetId;

    // builder 开始
    public GetSpreadsheetSheetFilterReq() {
    }

    public GetSpreadsheetSheetFilterReq(Builder builder) {
        /**
         * 表格 token
         * <p> 示例值：shtcnmBA\*****yGehy8
         */
        this.spreadsheetToken = builder.spreadsheetToken;
        /**
         * 子表 id
         * <p> 示例值：0b\**12
         */
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

        private String spreadsheetToken; // 表格 token
        private String sheetId; // 子表 id

        /**
         * 表格 token
         * <p> 示例值：shtcnmBA\*****yGehy8
         *
         * @param spreadsheetToken
         * @return
         */
        public Builder spreadsheetToken(String spreadsheetToken) {
            this.spreadsheetToken = spreadsheetToken;
            return this;
        }


        /**
         * 子表 id
         * <p> 示例值：0b\**12
         *
         * @param sheetId
         * @return
         */
        public Builder sheetId(String sheetId) {
            this.sheetId = sheetId;
            return this;
        }

        public GetSpreadsheetSheetFilterReq build() {
            return new GetSpreadsheetSheetFilterReq(this);
        }
    }
}
