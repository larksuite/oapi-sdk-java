// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.application.v6.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.event.model.BaseEventV2;

public class ApplicationAppVersionAuditEvent extends BaseEventV2 {
    @SerializedName("event")
    private ApplicationAppVersionAuditEventData event;

    public ApplicationAppVersionAuditEventData getEvent() {
        return this.event;
    }

    public void setEvent(ApplicationAppVersionAuditEventData event) {
        this.event = event;
    }

}
