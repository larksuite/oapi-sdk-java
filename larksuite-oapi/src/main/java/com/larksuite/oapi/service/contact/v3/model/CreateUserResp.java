// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class CreateUserResp extends BaseResponse {

    @SerializedName("data")
    private CreateUserDTO body;

    public CreateUserDTO getCreateUserDTO() {
        return this.body;
    }

    public void setCreateUserDTO(CreateUserDTO body) {
        this.body = body;
    }
}