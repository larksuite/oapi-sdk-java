// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.application.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.event.model.BaseEvent;

public class AppUninstalledEvent extends BaseEvent{
    @SerializedName("event")
    private AppUninstalledEventData event;

    public AppUninstalledEventData getEvent() {
        return this.event;
    }

    public void setEvent(AppUninstalledEventData event) {
        this.event = event;
    }

}
