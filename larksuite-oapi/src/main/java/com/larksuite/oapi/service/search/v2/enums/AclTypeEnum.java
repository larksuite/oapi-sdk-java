// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.search.v2.enums;

// 生成枚举值
public enum AclTypeEnum {
    USER("user"),
    GROUP("group"),
    ;
    private String value;

    AclTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}