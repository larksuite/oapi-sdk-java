package com.lark.oapi.card.model;

import com.google.gson.annotations.SerializedName;

public class MessageCardPlainText extends MessageCardElement implements IMessageCardNoteElement,
    IMessageCardTextElement, IMessageCardExtraElement {

  @SerializedName("content")
  private String content;
  @SerializedName("lines")
  private Integer lines;
  @SerializedName("i18n")
  private MessageCardPlainTextI18n i18n;

  public MessageCardPlainText(Builder builder) {
    this.content = builder.content;
    this.lines = builder.lines;
    this.i18n = builder.i18n;
    this.tag = "plain_text";
  }

  public MessageCardPlainText() {
    this.tag = "plain_text";
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private String content;
    private Integer lines;
    private MessageCardPlainTextI18n i18n;

    public Builder content(String content) {
      this.content = content;
      return this;
    }

    public Builder lines(Integer lines) {
      this.lines = lines;
      return this;
    }

    public Builder i18n(MessageCardPlainTextI18n i18n) {
      this.i18n = i18n;
      return this;
    }

    public MessageCardPlainText build() {
      return new MessageCardPlainText(this);
    }
  }
}
