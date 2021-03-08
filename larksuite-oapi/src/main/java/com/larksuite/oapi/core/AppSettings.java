package com.larksuite.oapi.core;

public class AppSettings {

    private final AppType appType;
    private final String appID;
    private final String appSecret;
    private final String verificationToken;
    private final String encryptKey;

    public AppSettings(AppType appType, String appID, String appSecret, String verificationToken, String encryptKey) {
        this.appType = appType;
        this.appID = appID;
        this.appSecret = appSecret;
        this.verificationToken = verificationToken;
        this.encryptKey = encryptKey;
    }

    public AppType getAppType() {
        return appType;
    }

    public String getAppID() {
        return appID;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    @Override
    public String toString() {
        return "AppSettings{" +
                "appType=" + appType +
                ", appID='" + appID + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", verificationToken='" + verificationToken + '\'' +
                ", encryptKey='" + encryptKey + '\'' +
                '}';
    }
}
