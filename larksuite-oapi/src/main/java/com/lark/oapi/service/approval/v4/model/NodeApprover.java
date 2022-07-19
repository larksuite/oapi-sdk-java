// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.approval.v4.model;

import com.google.gson.annotations.SerializedName;

public class NodeApprover {

  @SerializedName("key")
  private String key;
  @SerializedName("value")
  private String[] value;

  // builder 开始
  public NodeApprover() {
  }

  public NodeApprover(Builder builder) {
    this.key = builder.key;
    this.value = builder.value;
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

  public String[] getValue() {
    return this.value;
  }

  public void setValue(String[] value) {
    this.value = value;
  }

  public static class Builder {

    private String key;
    private String[] value;

    public Builder key(String key) {
      this.key = key;
      return this;
    }

    public Builder value(String[] value) {
      this.value = value;
      return this;
    }


    public NodeApprover build() {
      return new NodeApprover(this);
    }
  }
}