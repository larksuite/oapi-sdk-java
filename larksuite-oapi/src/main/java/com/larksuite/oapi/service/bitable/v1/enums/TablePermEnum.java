// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.bitable.v1.enums;

// 生成枚举值
public enum TablePermEnum {
    NOPERM(0),
    READ(1),
    EDIT(2),
    ADMIN(4),
    ;
    private Integer value;

    TablePermEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}