package com.lark.oapi.card.model;

import com.google.gson.annotations.SerializedName;

public class MessageCardNote extends MessageCardElement implements IMessageCardElement {

  @SerializedName("elements")
  private IMessageCardNoteElement[] elements;

  public MessageCardNote() {
    this.tag = "note";
  }

  public MessageCardNote(Builder builder) {
    this.tag = "note";
    this.elements = builder.elements;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private IMessageCardNoteElement[] elements;

    public Builder elements(IMessageCardNoteElement[] elements) {
      this.elements = elements;
      return this;
    }

    public MessageCardNote build() {
      return new MessageCardNote(this);
    }

  }
}
