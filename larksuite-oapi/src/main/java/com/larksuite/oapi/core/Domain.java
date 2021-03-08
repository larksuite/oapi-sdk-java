package com.larksuite.oapi.core;

public enum Domain {

    FeiShu("https://open.feishu.cn"), LarkSuite("https://open.larksuite.com");

    private String url;

    Domain(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
