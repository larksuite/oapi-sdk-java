// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.calendar.v4.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class PatchCalendarEventResp extends BaseResponse {

    @SerializedName("data")
    private PatchCalendarEventDTO body;

    public PatchCalendarEventDTO getPatchCalendarEventDTO() {
        return this.body;
    }

    public void setPatchCalendarEventDTO(PatchCalendarEventDTO body) {
        this.body = body;
    }
}
