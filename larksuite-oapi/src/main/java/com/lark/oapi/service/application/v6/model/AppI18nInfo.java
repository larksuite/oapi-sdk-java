// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.application.v6.model;

import com.google.gson.annotations.SerializedName;

public class AppI18nInfo {

  @SerializedName("i18n_key")
  private String i18nKey;
  @SerializedName("name")
  private String name;
  @SerializedName("description")
  private String description;
  @SerializedName("help_use")
  private String helpUse;

  // builder 开始
  public AppI18nInfo() {
  }

  public AppI18nInfo(Builder builder) {
    this.i18nKey = builder.i18nKey;
    this.name = builder.name;
    this.description = builder.description;
    this.helpUse = builder.helpUse;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getI18nKey() {
    return this.i18nKey;
  }

  public void setI18nKey(String i18nKey) {
    this.i18nKey = i18nKey;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getHelpUse() {
    return this.helpUse;
  }

  public void setHelpUse(String helpUse) {
    this.helpUse = helpUse;
  }

  public static class Builder {

    private String i18nKey;
    private String name;
    private String description;
    private String helpUse;

    public Builder i18nKey(String i18nKey) {
      this.i18nKey = i18nKey;
      return this;
    }

    public Builder i18nKey(com.lark.oapi.service.application.v6.enums.I18nKeyEnum i18nKey) {
      this.i18nKey = i18nKey.getValue();
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder description(String description) {
      this.description = description;
      return this;
    }

    public Builder helpUse(String helpUse) {
      this.helpUse = helpUse;
      return this;
    }


    public AppI18nInfo build() {
      return new AppI18nInfo(this);
    }
  }
}