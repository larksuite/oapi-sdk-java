// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class CreateDepartmentResp extends BaseResponse {

    @SerializedName("data")
    private CreateDepartmentDTO body;

    public CreateDepartmentDTO getCreateDepartmentDTO() {
        return this.body;
    }

    public void setCreateDepartmentDTO(CreateDepartmentDTO body) {
        this.body = body;
    }
}
