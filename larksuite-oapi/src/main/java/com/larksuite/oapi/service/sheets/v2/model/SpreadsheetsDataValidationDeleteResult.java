// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.sheets.v2.model;
import com.google.gson.annotations.SerializedName;

public class SpreadsheetsDataValidationDeleteResult {
    @SerializedName("rangeResults")
    private DataValidationDeleteResult[] rangeResults;

    public DataValidationDeleteResult[] getRangeResults() {
        return this.rangeResults;
    }

    public void setRangeResults(DataValidationDeleteResult[] rangeResults) {
        this.rangeResults = rangeResults;
    }

}
