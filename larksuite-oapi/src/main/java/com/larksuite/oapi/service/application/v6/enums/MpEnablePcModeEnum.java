// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.application.v6.enums;

// 生成枚举值
public enum MpEnablePcModeEnum {
    SIDEBAR(1),
    PC(2),
    NAVIGATE(4),
    ;
    private Integer value;

    MpEnablePcModeEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}