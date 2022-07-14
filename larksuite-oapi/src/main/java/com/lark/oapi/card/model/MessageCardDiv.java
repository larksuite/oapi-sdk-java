package com.lark.oapi.card.model;

import com.google.gson.annotations.SerializedName;

public class MessageCardDiv extends MessageCardElement implements IMessageCardElement {

  @SerializedName("text")
  private IMessageCardTextElement text;
  @SerializedName("fields")
  private MessageCardField[] fields;
  @SerializedName("extra")
  private IMessageCardExtraElement extra;

  public MessageCardDiv(Builder builder) {
    this.text = builder.text;
    this.fields = builder.fields;
    this.extra = builder.extra;
    this.tag = "div";
  }

  public MessageCardDiv() {
    this.tag = "div";
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private IMessageCardTextElement text;
    private MessageCardField[] fields;
    private IMessageCardExtraElement extra;

    public Builder text(IMessageCardTextElement text) {
      this.text = text;
      return this;
    }

    public Builder fields(MessageCardField[] fields) {
      this.fields = fields;
      return this;
    }

    public Builder extra(IMessageCardExtraElement extra) {
      this.extra = extra;
      return this;
    }

    public MessageCardDiv build() {
      return new MessageCardDiv(this);
    }
  }
}
