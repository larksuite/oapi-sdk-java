package com.lark.oapi.scene.registration;

public class QRCodeInfo {
    private final String url;
    private final int expireIn;

    public QRCodeInfo(String url, int expireIn) {
        this.url = url;
        this.expireIn = expireIn;
    }

    public String getUrl() {
        return url;
    }

    public int getExpireIn() {
        return expireIn;
    }
}
