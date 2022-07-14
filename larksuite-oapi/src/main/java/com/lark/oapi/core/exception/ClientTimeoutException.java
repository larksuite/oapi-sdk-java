package com.lark.oapi.core.exception;

public class ClientTimeoutException extends RuntimeException {

  public ClientTimeoutException() {
    super("client time out");
  }
}
