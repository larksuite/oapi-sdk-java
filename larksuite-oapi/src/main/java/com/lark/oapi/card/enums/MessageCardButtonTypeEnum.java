package com.lark.oapi.card.enums;

public enum MessageCardButtonTypeEnum {
  DEFAULT("default"), PRIMARY("primary"), DANGER("danger");
  private String value;

  MessageCardButtonTypeEnum(String value) {
    this.value = value;
  }
}
