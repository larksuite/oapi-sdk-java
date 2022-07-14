package com.lark.oapi.service.im.v1.model.ext;

import com.google.gson.annotations.SerializedName;

public class MessagePostImage extends MessagePostElement {

  @SerializedName("image_key")
  private String imageKey;
  @SerializedName("height")
  private int height;
  @SerializedName("width")
  private int width;

  public MessagePostImage() {
    tag = "img";
  }

  public MessagePostImage(Builder builder) {
    tag = "img";
    this.imageKey = builder.imageKey;
    this.height = builder.height;
    this.width = builder.width;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public String getImageKey() {
    return imageKey;
  }

  public void setImageKey(String imageKey) {
    this.imageKey = imageKey;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  @Override
  String getTag() {
    return tag;
  }

  public static class Builder {

    private String imageKey;
    private int height;
    private int width;

    public Builder imageKey(String imageKey) {
      this.imageKey = imageKey;
      return this;
    }

    public Builder height(int height) {
      this.height = height;
      return this;
    }

    public Builder width(int width) {
      this.width = width;
      return this;
    }

    public MessagePostImage build() {
      return new MessagePostImage(this);
    }
  }
}
