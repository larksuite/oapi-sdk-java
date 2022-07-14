package com.lark.oapi.card.model;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.card.enums.MessageCardImageModelEnum;

public class MessageCardEmbedImage extends MessageCardElement implements IMessageCardNoteElement,
    IMessageCardExtraElement {

  @SerializedName("alt")
  private MessageCardPlainText alt;
  @SerializedName("img_key")
  private String imgKey;
  @SerializedName("mode")
  private MessageCardImageModelEnum mode;
  @SerializedName("preview")
  private Boolean preview;

  public MessageCardEmbedImage() {
    this.tag = "img";
  }

  public MessageCardEmbedImage(Builder builder) {
    this.tag = "img";
    this.alt = builder.alt;
    this.imgKey = builder.imgKey;
    this.mode = builder.mode;
    this.preview = builder.preview;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private MessageCardPlainText alt;
    private String imgKey;
    private MessageCardImageModelEnum mode;
    private Boolean preview;

    public Builder alt(MessageCardPlainText alt) {
      this.alt = alt;
      return this;
    }

    public Builder imgKey(String imgKey) {
      this.imgKey = imgKey;
      return this;
    }


    public Builder mode(MessageCardImageModelEnum mode) {
      this.mode = mode;
      return this;
    }

    public Builder preview(Boolean preview) {
      this.preview = preview;
      return this;
    }

    public MessageCardEmbedImage build() {
      return new MessageCardEmbedImage(this);
    }
  }
}
