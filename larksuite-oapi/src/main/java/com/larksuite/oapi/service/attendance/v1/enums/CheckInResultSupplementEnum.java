// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.attendance.v1.enums;

// 生成枚举值
public enum CheckInResultSupplementEnum {
    NONE("None"),
    MANAGERMODIFICATION("ManagerModification"),
    CARDREPLACEMENT("CardReplacement"),
    SHIFTCHANGE("ShiftChange"),
    TRAVEL("Travel"),
    LEAVE("Leave"),
    GOOUT("GoOut"),
    CARDREPLACEMENTAPPLICATION("CardReplacementApplication"),
    FIELDPUNCH("FieldPunch"),
    ;
    private String value;

    CheckInResultSupplementEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}