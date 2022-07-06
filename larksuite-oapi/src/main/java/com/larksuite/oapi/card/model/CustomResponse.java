package com.larksuite.oapi.card.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomResponse {
    private Map<String, List<String>> headers = new HashMap<String, List<String>>();
    private int statusCode;
    private Map<String, Object> body = new HashMap<String, Object>();

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }
}
