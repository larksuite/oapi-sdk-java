package com.lark.oapi.card.exception;

public class HandlerNotFoundException extends RuntimeException {

  public HandlerNotFoundException() {
    super("not found card action handler");
  }
}
