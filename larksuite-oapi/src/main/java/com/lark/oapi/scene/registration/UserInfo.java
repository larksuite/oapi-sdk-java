package com.lark.oapi.scene.registration;

public class UserInfo {
    private final String openId;
    private final String tenantBrand;

    public UserInfo(String openId, String tenantBrand) {
        this.openId = openId;
        this.tenantBrand = tenantBrand;
    }

    public String getOpenId() {
        return openId;
    }

    public String getTenantBrand() {
        return tenantBrand;
    }
}
