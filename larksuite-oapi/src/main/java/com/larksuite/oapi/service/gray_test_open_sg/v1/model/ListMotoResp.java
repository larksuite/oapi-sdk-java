// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.gray_test_open_sg.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class ListMotoResp extends BaseResponse {

    @SerializedName("data")
    private ListMotoDTO body;

    public ListMotoDTO getListMotoDTO() {
        return this.body;
    }

    public void setListMotoDTO(ListMotoDTO body) {
        this.body = body;
    }
}