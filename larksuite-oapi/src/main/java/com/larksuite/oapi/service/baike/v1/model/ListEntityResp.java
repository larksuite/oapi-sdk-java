// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.baike.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class ListEntityResp extends BaseResponse {

    @SerializedName("data")
    private ListEntityDTO body;

    public ListEntityDTO getListEntityDTO() {
        return this.body;
    }

    public void setListEntityDTO(ListEntityDTO body) {
        this.body = body;
    }
}