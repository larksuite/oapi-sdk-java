// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class PatchAppTableFormFieldResp extends BaseResponse {

    @SerializedName("data")
    private PatchAppTableFormFieldDTO body;

    public PatchAppTableFormFieldDTO getPatchAppTableFormFieldDTO() {
        return this.body;
    }

    public void setPatchAppTableFormFieldDTO(PatchAppTableFormFieldDTO body) {
        this.body = body;
    }
}