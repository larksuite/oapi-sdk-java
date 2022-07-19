// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.application.v6.enums;

// 生成枚举值
public enum ScopeLevelEnum {
  LOW_LEVEL(1),
  HIGH_LEVEL(2),
  SUPER_LEVEL(3),
  UNKNOWN_LEVEL(0),
  ;
  private Integer value;

  ScopeLevelEnum(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }
}