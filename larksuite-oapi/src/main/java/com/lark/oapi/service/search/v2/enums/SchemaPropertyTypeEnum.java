// Code generated by lark suite oapi sdk gen
package com.lark.oapi.service.search.v2.enums;

// 生成枚举值
public enum SchemaPropertyTypeEnum {
  TEXT("text"),
  INT("int"),
  TAG("tag"),
  TIMESTAMP("timestamp"),
  DOUBLE("double"),
  TINYTEXT("tinytext"),
  ;
  private String value;

  SchemaPropertyTypeEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}