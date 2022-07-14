package com.lark.oapi.card.model;

public class MessageCardHr extends MessageCardElement implements IMessageCardElement {

  public MessageCardHr() {
    this.tag = "hr";
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    public MessageCardHr build() {
      return new MessageCardHr();
    }
  }
}
