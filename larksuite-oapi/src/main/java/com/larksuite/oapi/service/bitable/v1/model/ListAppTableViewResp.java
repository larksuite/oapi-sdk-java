// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class ListAppTableViewResp extends BaseResponse {

    @SerializedName("data")
    private ListAppTableViewDTO body;

    public ListAppTableViewDTO getListAppTableViewDTO() {
        return this.body;
    }

    public void setListAppTableViewDTO(ListAppTableViewDTO body) {
        this.body = body;
    }
}