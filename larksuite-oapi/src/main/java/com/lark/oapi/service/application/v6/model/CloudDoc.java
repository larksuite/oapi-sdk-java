// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.application.v6.model;

import com.google.gson.annotations.SerializedName;

public class CloudDoc {

  @SerializedName("space_url")
  private String spaceUrl;
  @SerializedName("i18n")
  private CloudDocI18nInfo[] i18n;
  @SerializedName("icon_url")
  private String iconUrl;
  @SerializedName("mode")
  private Integer mode;

  // builder 开始
  public CloudDoc() {
  }

  public CloudDoc(Builder builder) {
    this.spaceUrl = builder.spaceUrl;
    this.i18n = builder.i18n;
    this.iconUrl = builder.iconUrl;
    this.mode = builder.mode;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getSpaceUrl() {
    return this.spaceUrl;
  }

  public void setSpaceUrl(String spaceUrl) {
    this.spaceUrl = spaceUrl;
  }

  public CloudDocI18nInfo[] getI18n() {
    return this.i18n;
  }

  public void setI18n(CloudDocI18nInfo[] i18n) {
    this.i18n = i18n;
  }

  public String getIconUrl() {
    return this.iconUrl;
  }

  public void setIconUrl(String iconUrl) {
    this.iconUrl = iconUrl;
  }

  public Integer getMode() {
    return this.mode;
  }

  public void setMode(Integer mode) {
    this.mode = mode;
  }

  public static class Builder {

    private String spaceUrl;
    private CloudDocI18nInfo[] i18n;
    private String iconUrl;
    private Integer mode;

    public Builder spaceUrl(String spaceUrl) {
      this.spaceUrl = spaceUrl;
      return this;
    }

    public Builder i18n(CloudDocI18nInfo[] i18n) {
      this.i18n = i18n;
      return this;
    }

    public Builder iconUrl(String iconUrl) {
      this.iconUrl = iconUrl;
      return this;
    }

    public Builder mode(Integer mode) {
      this.mode = mode;
      return this;
    }

    public Builder mode(com.lark.oapi.service.application.v6.enums.CloudDocSupportModeEnum mode) {
      this.mode = mode.getValue();
      return this;
    }


    public CloudDoc build() {
      return new CloudDoc(this);
    }
  }
}