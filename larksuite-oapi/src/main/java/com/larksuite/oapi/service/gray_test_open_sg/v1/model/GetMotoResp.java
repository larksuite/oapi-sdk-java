// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.gray_test_open_sg.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class GetMotoResp extends BaseResponse {

    @SerializedName("data")
    private GetMotoDTO body;

    public GetMotoDTO getGetMotoDTO() {
        return this.body;
    }

    public void setGetMotoDTO(GetMotoDTO body) {
        this.body = body;
    }
}