// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class CreateAppTableResp extends BaseResponse {

    @SerializedName("data")
    private CreateAppTableDTO body;

    public CreateAppTableDTO getCreateAppTableDTO() {
        return this.body;
    }

    public void setCreateAppTableDTO(CreateAppTableDTO body) {
        this.body = body;
    }
}