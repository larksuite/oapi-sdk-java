// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class CheckExternalInstanceResp extends BaseResponse {

    @SerializedName("data")
    private CheckExternalInstanceDTO body;

    public CheckExternalInstanceDTO getCheckExternalInstanceDTO() {
        return this.body;
    }

    public void setCheckExternalInstanceDTO(CheckExternalInstanceDTO body) {
        this.body = body;
    }
}