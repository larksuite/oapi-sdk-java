// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.event.model.BaseEventV2;

public class DepartmentUpdatedEvent extends BaseEventV2 {
    @SerializedName("event")
    private DepartmentUpdatedEventData event;

    public DepartmentUpdatedEventData getEvent() {
        return this.event;
    }

    public void setEvent(DepartmentUpdatedEventData event) {
        this.event = event;
    }

}
