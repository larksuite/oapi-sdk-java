// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class ModifyUserSettingResp extends BaseResponse {

    @SerializedName("data")
    private ModifyUserSettingDTO body;

    public ModifyUserSettingDTO getModifyUserSettingDTO() {
        return this.body;
    }

    public void setModifyUserSettingDTO(ModifyUserSettingDTO body) {
        this.body = body;
    }
}