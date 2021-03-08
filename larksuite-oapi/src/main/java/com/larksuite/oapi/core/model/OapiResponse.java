package com.larksuite.oapi.core.model;

import com.larksuite.oapi.core.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OapiResponse {

    public static final String RESPONSE_FORMAT = "{\"codemsg\":\"%s\"}";
    public static final String CHALLENGE_RESPONSE_FORMAT = "{\"challenge\":\"%s\"}";

    private int statusCode;
    private String contentType;
    private Map<String, List<String>> headers = new HashMap<>();
    private String body;

    public OapiResponse() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
        List<String> ct = new ArrayList<>();
        ct.add(contentType);
        this.headers.put(Constants.CONTENT_TYPE, ct);
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
