// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.vc.v1.enums;

// 生成枚举值
public enum ExpireStatusEnum {
    NOT_EXPIRED(1),
    EXPIRED(2),
    ;
    private Integer value;

    ExpireStatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}