// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.sheets.v2.model;
import com.google.gson.annotations.SerializedName;

public class SpreadsheetsProtectedRangeBatchCreateReqBody {
    @SerializedName("addProtectedDimension")
    private AddProtectedDimension[] addProtectedDimension;

    public AddProtectedDimension[] getAddProtectedDimension() {
        return this.addProtectedDimension;
    }

    public void setAddProtectedDimension(AddProtectedDimension[] addProtectedDimension) {
        this.addProtectedDimension = addProtectedDimension;
    }

}
