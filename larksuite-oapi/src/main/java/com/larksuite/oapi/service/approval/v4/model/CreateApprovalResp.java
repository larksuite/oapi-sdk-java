// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class CreateApprovalResp extends BaseResponse {

    @SerializedName("data")
    private CreateApprovalDTO body;

    public CreateApprovalDTO getCreateApprovalDTO() {
        return this.body;
    }

    public void setCreateApprovalDTO(CreateApprovalDTO body) {
        this.body = body;
    }
}
