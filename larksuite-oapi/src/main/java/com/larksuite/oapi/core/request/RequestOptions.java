package com.larksuite.oapi.core.request;

import java.util.List;
import java.util.Map;

public class RequestOptions {
    private boolean needHelpDeskAuth;
    private String tenantKey;
    private String userAccessToken;
    private String appAccessToken;
    private String tenantAccessToken;
    private String requestId;
    private boolean supportUpload;
    private boolean supportDownLoad;
    private Map<String, List<String>> headers;

    public RequestOptions() {
    }

    public RequestOptions(Builder builder) {
        this.needHelpDeskAuth = builder.needHelpDeskAuth;
        this.userAccessToken = builder.userAccessToken;
        this.appAccessToken = builder.appAccessToken;
        this.tenantAccessToken = builder.tenantAccessToken;
        this.requestId = builder.requestId;
        this.supportDownLoad = builder.supportDownLoad;
        this.supportUpload = builder.supportUpload;
        this.headers = builder.headers;
        this.tenantKey = builder.tenantKey;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean isSupportUpload() {
        return supportUpload;
    }

    public void setSupportUpload(boolean supportUpload) {
        this.supportUpload = supportUpload;
    }

    public boolean isSupportDownLoad() {
        return supportDownLoad;
    }

    public void setSupportDownLoad(boolean supportDownLoad) {
        this.supportDownLoad = supportDownLoad;
    }

    public boolean isNeedHelpDeskAuth() {
        return needHelpDeskAuth;
    }

    public void setNeedHelpDeskAuth(boolean needHelpDeskAuth) {
        this.needHelpDeskAuth = needHelpDeskAuth;
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

    public String getAppAccessToken() {
        return appAccessToken;
    }

    public void setAppAccessToken(String appAccessToken) {
        this.appAccessToken = appAccessToken;
    }

    public String getTenantAccessToken() {
        return tenantAccessToken;
    }

    public void setTenantAccessToken(String tenantAccessToken) {
        this.tenantAccessToken = tenantAccessToken;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public static final class Builder {
        private boolean needHelpDeskAuth;
        private String tenantKey;
        private String userAccessToken;
        private String appAccessToken;
        private String tenantAccessToken;
        private String requestId;
        private boolean supportUpload;
        private boolean supportDownLoad;
        private Map<String, List<String>> headers;


        public Builder needHelpDeskAuth(boolean needHelpDeskAuth) {
            this.needHelpDeskAuth = needHelpDeskAuth;
            return this;
        }

        public Builder tenantKey(String tenantKey) {
            this.tenantKey = tenantKey;
            return this;
        }

        public Builder userAccessToken(String userAccessToken) {
            this.userAccessToken = userAccessToken;
            return this;
        }

        public Builder appAccessToken(String appAccessToken) {
            this.appAccessToken = appAccessToken;
            return this;
        }

        public Builder tenantAccessToken(String tenantAccessToken) {
            this.tenantAccessToken = tenantAccessToken;
            return this;
        }

        public Builder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder supportUpload() {
            this.supportUpload = true;
            return this;
        }

        public Builder supportDownLoad() {
            this.supportDownLoad = true;
            return this;
        }

        public Builder headers(Map<String, List<String>> headers) {
            this.headers = headers;
            return this;
        }

        public RequestOptions build() {
            return new RequestOptions(this);
        }
    }

}
