// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.contact.v3.enums;

// 生成枚举值
public enum EmployeeTypeEnum {
  FULL_TIME(1),
  INTERNSHIP(2),
  OUTSOURCING(3),
  LABOR(4),
  CONSULTANT(5),
  ;
  private Integer value;

  EmployeeTypeEnum(Integer value) {
    this.value = value;
  }

  public Integer getValue() {
    return this.value;
  }
}