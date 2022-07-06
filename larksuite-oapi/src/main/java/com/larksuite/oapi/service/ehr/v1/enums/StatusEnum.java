// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.ehr.v1.enums;

// 生成枚举值
public enum StatusEnum {
    TO_BE_ONBOARDED(1),
    ACTIVE(2),
    ONBOARDING_CANCELLED(3),
    OFFBOARDING(4),
    OFFBOARDED(5),
    ;
    private Integer value;

    StatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}