// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.search.v2.model;

import com.google.gson.annotations.SerializedName;

public class Acl {

  @SerializedName("access")
  private String access;
  @SerializedName("value")
  private String value;
  @SerializedName("type")
  private String type;

  // builder 开始
  public Acl() {
  }

  public Acl(Builder builder) {
    this.access = builder.access;
    this.value = builder.value;
    this.type = builder.type;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getAccess() {
    return this.access;
  }

  public void setAccess(String access) {
    this.access = access;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public static class Builder {

    private String access;
    private String value;
    private String type;

    public Builder access(String access) {
      this.access = access;
      return this;
    }

    public Builder access(com.lark.oapi.service.search.v2.enums.AclAccessEnum access) {
      this.access = access.getValue();
      return this;
    }

    public Builder value(String value) {
      this.value = value;
      return this;
    }

    public Builder type(String type) {
      this.type = type;
      return this;
    }

    public Builder type(com.lark.oapi.service.search.v2.enums.AclTypeEnum type) {
      this.type = type.getValue();
      return this;
    }


    public Acl build() {
      return new Acl(this);
    }
  }
}