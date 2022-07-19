// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.im.v1.model;

import com.google.gson.annotations.SerializedName;

public class Mention {

  @SerializedName("key")
  private String key;
  @SerializedName("id")
  private String id;
  @SerializedName("id_type")
  private String idType;
  @SerializedName("name")
  private String name;
  @SerializedName("tenant_key")
  private String tenantKey;

  // builder 开始
  public Mention() {
  }

  public Mention(Builder builder) {
    this.key = builder.key;
    this.id = builder.id;
    this.idType = builder.idType;
    this.name = builder.name;
    this.tenantKey = builder.tenantKey;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getKey() {
    return this.key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getIdType() {
    return this.idType;
  }

  public void setIdType(String idType) {
    this.idType = idType;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTenantKey() {
    return this.tenantKey;
  }

  public void setTenantKey(String tenantKey) {
    this.tenantKey = tenantKey;
  }

  public static class Builder {

    private String key;
    private String id;
    private String idType;
    private String name;
    private String tenantKey;

    public Builder key(String key) {
      this.key = key;
      return this;
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder idType(String idType) {
      this.idType = idType;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder tenantKey(String tenantKey) {
      this.tenantKey = tenantKey;
      return this;
    }


    public Mention build() {
      return new Mention(this);
    }
  }
}