package com.lark.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;

public class MessagePostText extends MessagePostElement {

  @SerializedName("un_escape")
  private Boolean unEscape;
  @SerializedName("text")
  private String text;

  public MessagePostText() {
    tag = "text";
  }

  public MessagePostText(Builder builder) {
    tag = "text";
    this.text = builder.text;
    this.unEscape = builder.unEscape;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Boolean getUnEscape() {
    return unEscape;
  }

  public void setUnEscape(boolean unEscape) {
    this.unEscape = unEscape;
  }

  @Override
  String getTag() {
    return this.tag;
  }

  public static class Builder {

    private Boolean unEscape;
    private String text;

    public Builder text(String text) {
      this.text = text;
      return this;
    }

    public Builder unEscape(boolean unEscape) {
      this.unEscape = unEscape;
      return this;
    }

    public MessagePostText build() {
      return new MessagePostText(this);
    }
  }
}
