package com.larksuite.oapi.core.api.request;

import java.util.Map;

public class RequestOpt {

    private Map<String, Object> pathParams;
    private Map<String, Object> queryParams;
    private String tenantKey;
    private String userAccessToken;
    private long timeoutOfMs;
    private boolean isNotDataField;
    private boolean isResponseStream;

    public long getTimeoutOfMs() {
        return timeoutOfMs;
    }

    public void setTimeoutOfMs(long timeoutOfMs) {
        this.timeoutOfMs = timeoutOfMs;
    }

    public Map<String, Object> getPathParams() {
        return pathParams;
    }

    public void setPathParams(Map<String, Object> pathParams) {
        this.pathParams = pathParams;
    }

    public Map<String, Object> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Map<String, Object> queryParams) {
        this.queryParams = queryParams;
    }

    public String getTenantKey() {
        return tenantKey;
    }

    public void setTenantKey(String tenantKey) {
        this.tenantKey = tenantKey;
    }

    public String getUserAccessToken() {
        return userAccessToken;
    }

    public void setUserAccessToken(String userAccessToken) {
        this.userAccessToken = userAccessToken;
    }

    public boolean isNotDataField() {
        return isNotDataField;
    }

    public void setNotDataField(boolean notDataField) {
        isNotDataField = notDataField;
    }

    public boolean isResponseStream() {
        return isResponseStream;
    }

    public void setResponseStream(boolean responseStream) {
        isResponseStream = responseStream;
    }
}
