// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;

public class CustomAttrOptions {

  @SerializedName("default_option_id")
  private String defaultOptionId;
  @SerializedName("option_type")
  private String optionType;
  @SerializedName("options")
  private CustomAttrOption[] options;

  // builder 开始
  public CustomAttrOptions() {
  }

  public CustomAttrOptions(Builder builder) {
    this.defaultOptionId = builder.defaultOptionId;
    this.optionType = builder.optionType;
    this.options = builder.options;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getDefaultOptionId() {
    return this.defaultOptionId;
  }

  public void setDefaultOptionId(String defaultOptionId) {
    this.defaultOptionId = defaultOptionId;
  }

  public String getOptionType() {
    return this.optionType;
  }

  public void setOptionType(String optionType) {
    this.optionType = optionType;
  }

  public CustomAttrOption[] getOptions() {
    return this.options;
  }

  public void setOptions(CustomAttrOption[] options) {
    this.options = options;
  }

  public static class Builder {

    private String defaultOptionId;
    private String optionType;
    private CustomAttrOption[] options;

    public Builder defaultOptionId(String defaultOptionId) {
      this.defaultOptionId = defaultOptionId;
      return this;
    }

    public Builder optionType(String optionType) {
      this.optionType = optionType;
      return this;
    }

    public Builder optionType(com.lark.oapi.service.contact.v3.enums.OptionTypeEnum optionType) {
      this.optionType = optionType.getValue();
      return this;
    }

    public Builder options(CustomAttrOption[] options) {
      this.options = options;
      return this;
    }


    public CustomAttrOptions build() {
      return new CustomAttrOptions(this);
    }
  }
}