package com.larksuite.oapi.event.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.request.EventReq;

public class BaseEvent {
    @SerializedName("ts")
    private String ts;
    @SerializedName("uuid")
    private String uuid;
    @SerializedName("token")
    private String token;
    @SerializedName("type")
    private String type;
    private EventReq eventReq;

    public EventReq getEventReq() {
        return eventReq;
    }

    public void setEventReq(EventReq eventReq) {
        this.eventReq = eventReq;
    }

    public String getRequestId() {
        return eventReq == null ? "" : eventReq.getRequestID();
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
