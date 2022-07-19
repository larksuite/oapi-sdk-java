// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.docx.v1.model;

import com.google.gson.annotations.SerializedName;

public class Callout {

  @SerializedName("background_color")
  private Integer backgroundColor;
  @SerializedName("border_color")
  private Integer borderColor;
  @SerializedName("text_color")
  private Integer textColor;
  @SerializedName("emoji_id")
  private String emojiId;

  // builder 开始
  public Callout() {
  }

  public Callout(Builder builder) {
    this.backgroundColor = builder.backgroundColor;
    this.borderColor = builder.borderColor;
    this.textColor = builder.textColor;
    this.emojiId = builder.emojiId;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Integer getBackgroundColor() {
    return this.backgroundColor;
  }

  public void setBackgroundColor(Integer backgroundColor) {
    this.backgroundColor = backgroundColor;
  }

  public Integer getBorderColor() {
    return this.borderColor;
  }

  public void setBorderColor(Integer borderColor) {
    this.borderColor = borderColor;
  }

  public Integer getTextColor() {
    return this.textColor;
  }

  public void setTextColor(Integer textColor) {
    this.textColor = textColor;
  }

  public String getEmojiId() {
    return this.emojiId;
  }

  public void setEmojiId(String emojiId) {
    this.emojiId = emojiId;
  }

  public static class Builder {

    private Integer backgroundColor;
    private Integer borderColor;
    private Integer textColor;
    private String emojiId;

    public Builder backgroundColor(Integer backgroundColor) {
      this.backgroundColor = backgroundColor;
      return this;
    }

    public Builder backgroundColor(
        com.lark.oapi.service.docx.v1.enums.CalloutBackgroundColorEnum backgroundColor) {
      this.backgroundColor = backgroundColor.getValue();
      return this;
    }

    public Builder borderColor(Integer borderColor) {
      this.borderColor = borderColor;
      return this;
    }

    public Builder borderColor(
        com.lark.oapi.service.docx.v1.enums.CalloutBorderColorEnum borderColor) {
      this.borderColor = borderColor.getValue();
      return this;
    }

    public Builder textColor(Integer textColor) {
      this.textColor = textColor;
      return this;
    }

    public Builder textColor(com.lark.oapi.service.docx.v1.enums.FontColorEnum textColor) {
      this.textColor = textColor.getValue();
      return this;
    }

    public Builder emojiId(String emojiId) {
      this.emojiId = emojiId;
      return this;
    }


    public Callout build() {
      return new Callout(this);
    }
  }
}