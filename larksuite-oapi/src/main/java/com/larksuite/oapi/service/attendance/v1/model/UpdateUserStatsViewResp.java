// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class UpdateUserStatsViewResp extends BaseResponse {

    @SerializedName("data")
    private UpdateUserStatsViewDTO body;

    public UpdateUserStatsViewDTO getUpdateUserStatsViewDTO() {
        return this.body;
    }

    public void setUpdateUserStatsViewDTO(UpdateUserStatsViewDTO body) {
        this.body = body;
    }
}
