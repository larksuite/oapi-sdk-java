// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.drive.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class GetFileSubscriptionResp extends BaseResponse {

    @SerializedName("data")
    private GetFileSubscriptionDTO body;

    public GetFileSubscriptionDTO getGetFileSubscriptionDTO() {
        return this.body;
    }

    public void setGetFileSubscriptionDTO(GetFileSubscriptionDTO body) {
        this.body = body;
    }
}