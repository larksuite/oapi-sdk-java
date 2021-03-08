package com.larksuite.oapi.core.event.model;

import com.google.gson.annotations.SerializedName;

public class BaseEvent {
    @SerializedName("ts")
    private String ts;
    @SerializedName("uuid")
    private String uuid;
    @SerializedName("token")
    private String token;
    @SerializedName("type")
    private String type;

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
