// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.admin.v1.enums;

// 生成枚举值
public enum TerminalTypeEnum {
  IOS(0),
  ANDROID(1),
  PC(2),
  WEB(3),
  ;
  private Integer value;

  TerminalTypeEnum(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }
}