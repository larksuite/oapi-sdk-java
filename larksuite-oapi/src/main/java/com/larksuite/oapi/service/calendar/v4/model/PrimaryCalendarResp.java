// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class PrimaryCalendarResp extends BaseResponse {

    @SerializedName("data")
    private PrimaryCalendarDTO body;

    public PrimaryCalendarDTO getPrimaryCalendarDTO() {
        return this.body;
    }

    public void setPrimaryCalendarDTO(PrimaryCalendarDTO body) {
        this.body = body;
    }
}