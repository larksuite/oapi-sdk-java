package com.lark.oapi.card.enums;

public enum MessageCardHeaderTemplateEnum {
  BLUE("blue"),
  WATHET("wathet"),
  TURQUOISE("turquoise"),
  GREEN("green"),
  YELLOW("yellow"),
  ORANGE("orange"),
  RED("red"),
  CARMINE("carmine"),
  VIOLET("violet"),
  PURPLE("purple"),
  INDIGO("indigo"),
  GREY("grey");
  private String value;

  MessageCardHeaderTemplateEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
