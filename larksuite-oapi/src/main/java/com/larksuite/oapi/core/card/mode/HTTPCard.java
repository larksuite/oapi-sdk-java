package com.larksuite.oapi.core.card.mode;

import com.larksuite.oapi.core.model.OapiRequest;
import com.larksuite.oapi.core.model.OapiResponse;

public class HTTPCard {
    private final OapiRequest request;
    private final OapiResponse response;
    private Header header;
    private String input;
    private String type;
    private String Challenge;
    private Object output;

    public HTTPCard(OapiRequest request, OapiResponse response) {
        this.request = request;
        this.response = response;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChallenge() {
        return Challenge;
    }

    public void setChallenge(String challenge) {
        Challenge = challenge;
    }

    public Object getOutput() {
        return output;
    }

    public void setOutput(Object output) {
        this.output = output;
    }
}
