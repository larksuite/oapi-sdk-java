package com.larksuite.oapi.core.event.model;

import com.google.gson.annotations.SerializedName;

public class Fuzzy {
    @SerializedName("encrypt")
    private String encrypt;
    @SerializedName("schema")
    private String schema;
    @SerializedName("token")
    private String token;
    @SerializedName("type")
    private String type;
    @SerializedName("challenge")
    private String challenge;
    @SerializedName("header")
    private Header header;
    @SerializedName("event")
    private Event event;

    public String getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
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

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
