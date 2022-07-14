package com.lark.oapi.core.exception;

public class AccessTokenNotGivenException extends RuntimeException {

  public AccessTokenNotGivenException() {
    super("Need pass an access token value");
  }
}
