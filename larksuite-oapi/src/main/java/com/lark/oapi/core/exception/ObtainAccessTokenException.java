package com.lark.oapi.core.exception;

public class ObtainAccessTokenException extends RuntimeException {

  public ObtainAccessTokenException(String messagePrefix, String msg) {
    super(messagePrefix + msg);
  }
}
