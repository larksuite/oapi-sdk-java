// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class ListAppTableRecordResp extends BaseResponse {

    @SerializedName("data")
    private ListAppTableRecordDTO body;

    public ListAppTableRecordDTO getListAppTableRecordDTO() {
        return this.body;
    }

    public void setListAppTableRecordDTO(ListAppTableRecordDTO body) {
        this.body = body;
    }
}
