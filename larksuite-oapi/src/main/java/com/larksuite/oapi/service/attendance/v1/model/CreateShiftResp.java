// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class CreateShiftResp extends BaseResponse {

    @SerializedName("data")
    private CreateShiftDTO body;

    public CreateShiftDTO getCreateShiftDTO() {
        return this.body;
    }

    public void setCreateShiftDTO(CreateShiftDTO body) {
        this.body = body;
    }
}
