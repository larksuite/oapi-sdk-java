package com.larksuite.oapi.core.model;

import java.util.List;
import java.util.Map;

public class OapiRequest {
    private final String uri;
    private final OapiHeader header;
    private Map<String, List<String>> queryString;
    private String body;
    private String remoteAddress;

    public OapiRequest(String uri, OapiHeader header, String body) {
        this.uri = uri;
        this.header = header;
        this.body = body;
    }

    public OapiRequest(String uri, OapiHeader header, Map<String, List<String>> queryString, String body) {
        this.uri = uri;
        this.header = header;
        this.queryString = queryString;
        this.body = body;
    }

    public OapiRequest(String uri, OapiHeader header, Map<String, List<String>> queryString, String body, String remoteAddress) {
        this.uri = uri;
        this.header = header;
        this.queryString = queryString;
        this.body = body;
        this.remoteAddress = remoteAddress;
    }

    public String getUri() {
        return uri;
    }

    public OapiHeader getHeader() {
        return header;
    }

    public Map<String, List<String>> getQueryString() {
        return queryString;
    }

    public void setQueryString(Map<String, List<String>> queryString) {
        this.queryString = queryString;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }
}
