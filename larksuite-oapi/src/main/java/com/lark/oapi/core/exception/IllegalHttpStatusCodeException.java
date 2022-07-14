package com.lark.oapi.core.exception;

public class IllegalHttpStatusCodeException extends RuntimeException {

  public IllegalHttpStatusCodeException(int statusCode) {
    super(String.format("The status code %s of custom response is illegal", statusCode));
  }
}
