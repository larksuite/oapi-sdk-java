package com.lark.oapi.core.enums;

public enum BaseUrlEnum {
  FeiShu("https://open.feishu.cn"),
  LarkSuite("https://open.larksuite.com"),
  ;

  private String url;

  BaseUrlEnum(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }
}
