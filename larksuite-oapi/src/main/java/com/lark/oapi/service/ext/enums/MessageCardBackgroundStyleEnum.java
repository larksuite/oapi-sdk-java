package com.lark.oapi.service.ext.enums;

/**
 * 列集的背景色样式
 */
public enum MessageCardBackgroundStyleEnum {
    /**
     * 默认的白底样式，dark mode下为黑底
     */
    DEFAULT("default"),
    /**
     * 灰底样式
     */
    GREY("grey");

    private String value;

    MessageCardBackgroundStyleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
