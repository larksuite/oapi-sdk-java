// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.calendar.v4.enums;

// 生成枚举值
public enum EventAttendeeTypeEnum {
    USER("user"),
    CHAT("chat"),
    RESOURCE("resource"),
    THIRDPARTY("third_party"),
    ;
    private String value;

    EventAttendeeTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}