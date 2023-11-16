package com.lark.oapi.service.ext.enums;

/**
 * 列内成员垂直对齐方式
 */
public enum MessageCardColumnVerticalAlignEnum {
    /**
     * 顶对齐
     */
    TOP("top"),
    /**
     * 居中对齐
     */
    CENTER("center"),
    /**
     * 底部对齐
     */
    BOTTOM("bottom");

    private String value;

    MessageCardColumnVerticalAlignEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
