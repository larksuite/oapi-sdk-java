// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class PatchFileSubscriptionResp extends BaseResponse {

    @SerializedName("data")
    private PatchFileSubscriptionDTO body;

    public PatchFileSubscriptionDTO getPatchFileSubscriptionDTO() {
        return this.body;
    }

    public void setPatchFileSubscriptionDTO(PatchFileSubscriptionDTO body) {
        this.body = body;
    }
}
