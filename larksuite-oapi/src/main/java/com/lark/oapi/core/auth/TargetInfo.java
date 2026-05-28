package com.lark.oapi.core.auth;

public class TargetInfo {
    private String targetService;
    private String targetPrefix;

    public TargetInfo() {
    }

    public TargetInfo(String targetService, String targetPrefix) {
        this.targetService = targetService;
        this.targetPrefix = targetPrefix;
    }

    public String getTargetService() {
        return targetService;
    }

    public void setTargetService(String targetService) {
        this.targetService = targetService;
    }

    public String getTargetPrefix() {
        return targetPrefix;
    }

    public void setTargetPrefix(String targetPrefix) {
        this.targetPrefix = targetPrefix;
    }
}
