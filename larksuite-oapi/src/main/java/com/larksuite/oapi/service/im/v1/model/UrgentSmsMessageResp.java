// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class UrgentSmsMessageResp extends BaseResponse {

    @SerializedName("data")
    private UrgentSmsMessageDTO body;

    public UrgentSmsMessageDTO getUrgentSmsMessageDTO() {
        return this.body;
    }

    public void setUrgentSmsMessageDTO(UrgentSmsMessageDTO body) {
        this.body = body;
    }
}