// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.bitable.v1.model;

import com.google.gson.annotations.SerializedName;

public class Url {

  @SerializedName("text")
  private String text;
  @SerializedName("link")
  private String link;

  // builder 开始
  public Url() {
  }

  public Url(Builder builder) {
    this.text = builder.text;
    this.link = builder.link;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getText() {
    return this.text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getLink() {
    return this.link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public static class Builder {

    private String text;
    private String link;

    public Builder text(String text) {
      this.text = text;
      return this;
    }

    public Builder link(String link) {
      this.link = link;
      return this;
    }


    public Url build() {
      return new Url(this);
    }
  }
}