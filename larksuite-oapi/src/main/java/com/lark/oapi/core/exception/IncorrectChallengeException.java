package com.lark.oapi.core.exception;

public class IncorrectChallengeException extends RuntimeException {

  public IncorrectChallengeException() {
    super("The result of auth by challenge failed");
  }
}
