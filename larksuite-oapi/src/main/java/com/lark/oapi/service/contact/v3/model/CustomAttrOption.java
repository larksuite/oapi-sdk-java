// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.contact.v3.model;

import com.google.gson.annotations.SerializedName;

public class CustomAttrOption {

  @SerializedName("id")
  private String id;
  @SerializedName("value")
  private String value;
  @SerializedName("name")
  private String name;

  // builder 开始
  public CustomAttrOption() {
  }

  public CustomAttrOption(Builder builder) {
    this.id = builder.id;
    this.value = builder.value;
    this.name = builder.name;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static class Builder {

    private String id;
    private String value;
    private String name;

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder value(String value) {
      this.value = value;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }


    public CustomAttrOption build() {
      return new CustomAttrOption(this);
    }
  }
}