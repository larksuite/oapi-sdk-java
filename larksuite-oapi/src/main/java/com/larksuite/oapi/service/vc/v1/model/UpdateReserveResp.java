// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.vc.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class UpdateReserveResp extends BaseResponse {

    @SerializedName("data")
    private UpdateReserveDTO body;

    public UpdateReserveDTO getUpdateReserveDTO() {
        return this.body;
    }

    public void setUpdateReserveDTO(UpdateReserveDTO body) {
        this.body = body;
    }
}
