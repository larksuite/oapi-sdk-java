package com.lark.oapi.card.model;

import com.google.gson.annotations.SerializedName;

public class MessageCardPlainTextI18n {

  @SerializedName("zh_cn")
  private String zhCn;
  @SerializedName("en_us")
  private String enUs;
  @SerializedName("ja_jp")
  private String jaJp;

  public MessageCardPlainTextI18n(Builder builder) {
    this.enUs = builder.enUs;
    this.zhCn = builder.zhCn;
    this.jaJp = builder.jaJp;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getZhCn() {
    return zhCn;
  }

  public void setZhCn(String zhCn) {
    this.zhCn = zhCn;
  }

  public String getEnUs() {
    return enUs;
  }

  public void setEnUs(String enUs) {
    this.enUs = enUs;
  }

  public String getJaJp() {
    return jaJp;
  }

  public void setJaJp(String jaJp) {
    this.jaJp = jaJp;
  }

  public static class Builder {

    private String zhCn;
    private String enUs;
    private String jaJp;

    public Builder zhCn(String zhCn) {
      this.zhCn = zhCn;
      return this;
    }

    public Builder enUs(String enUs) {
      this.enUs = enUs;
      return this;
    }

    public Builder jaJp(String jaJp) {
      this.jaJp = jaJp;
      return this;
    }

    public MessageCardPlainTextI18n build() {
      return new MessageCardPlainTextI18n(this);
    }
  }
}
