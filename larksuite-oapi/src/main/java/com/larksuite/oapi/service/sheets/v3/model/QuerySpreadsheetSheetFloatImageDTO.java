// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.sheets.v3.model;

import com.google.gson.annotations.SerializedName;

public class QuerySpreadsheetSheetFloatImageDTO {
    @SerializedName("items")
    private FloatImage[] items;

    public FloatImage[] getItems() {
        return this.items;
    }

    public void setItems(FloatImage[] items) {
        this.items = items;
    }

}