package com.lark.oapi.scene.registration;

public class RegisterAppResult {
    private final String clientId;
    private final String clientSecret;
    private final UserInfo userInfo;

    public RegisterAppResult(String clientId, String clientSecret, UserInfo userInfo) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.userInfo = userInfo;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}
