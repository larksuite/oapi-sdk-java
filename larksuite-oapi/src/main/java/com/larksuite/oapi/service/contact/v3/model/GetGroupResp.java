// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class GetGroupResp extends BaseResponse {

    @SerializedName("data")
    private GetGroupDTO body;

    public GetGroupDTO getGetGroupDTO() {
        return this.body;
    }

    public void setGetGroupDTO(GetGroupDTO body) {
        this.body = body;
    }
}
