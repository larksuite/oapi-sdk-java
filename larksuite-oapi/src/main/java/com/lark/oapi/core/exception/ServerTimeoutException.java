package com.lark.oapi.core.exception;

public class ServerTimeoutException extends RuntimeException {

  public ServerTimeoutException() {
    super("server time out");
  }
}
