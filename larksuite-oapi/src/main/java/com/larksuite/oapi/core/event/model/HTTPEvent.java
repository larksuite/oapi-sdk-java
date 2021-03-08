package com.larksuite.oapi.core.event.model;

import com.larksuite.oapi.core.model.OapiRequest;
import com.larksuite.oapi.core.model.OapiResponse;

public class HTTPEvent {

    public static final String Version1 = "1.0";
    public static final String Version2 = "2.0";

    private final OapiRequest request;
    private final OapiResponse response;
    private String input;
    private String schema;
    private String type;
    private String eventType;
    private String challenge;

    public HTTPEvent(OapiRequest request, OapiResponse response) {
        this.request = request;
        this.response = response;
    }

    public OapiRequest getRequest() {
        return request;
    }

    public OapiResponse getResponse() {
        return response;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }
}
