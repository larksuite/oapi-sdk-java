package com.larksuite.oapi.core.enums;

public enum DomainEnum {
    FeiShu("https://open.feishu.cn"),
    LarkSuite("https://open.larksuite.com"),
    ;

    private String url;

    DomainEnum(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
