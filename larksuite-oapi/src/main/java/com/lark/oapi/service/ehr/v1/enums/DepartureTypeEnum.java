// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.ehr.v1.enums;

// 生成枚举值
public enum DepartureTypeEnum {
  VOLUNTARY(1),
  INVOLUNTARY(2),
  ;
  private Integer value;

  DepartureTypeEnum(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }
}