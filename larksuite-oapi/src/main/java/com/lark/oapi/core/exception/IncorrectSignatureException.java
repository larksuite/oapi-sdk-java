package com.lark.oapi.core.exception;

public class IncorrectSignatureException extends RuntimeException {

  public IncorrectSignatureException() {
    super("The result of signature verification failed");
  }
}
