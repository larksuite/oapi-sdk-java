// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.approval.v4.enums;

// 生成枚举值
public enum ActionTypeEnum {
  APPROVE("APPROVE"),
  REJECT("REJECT"),
  KEY("{KEY}"),
  ;
  private String value;

  ActionTypeEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}