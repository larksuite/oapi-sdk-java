package com.lark.oapi.card.enums;

public enum MessageCardImageModelEnum {
  FIT_HORIZONTAL("fit_horizontal"), CROP_CENTER("crop_center");
  private String value;

  MessageCardImageModelEnum(String value) {
    this.value = value;
  }
}
