package com.lark.oapi.service.ext.enums;

/**
 * 列的自适应方式
 */
public enum MessageCardLayoutFlexModeEnum {
    /**
     * 不做布局上的自适应
     */
    NONE("none"),
    /**
     * 行布局
     */
    STRETCH("stretch"),
    /**
     * 两列等分布局
     */
    BISECTED("bisected"),
    /**
     * 三列等分布局
     */
    TRISECTION("trisection"),
    /**
     * 列流式排布（自动换行）
     */
    FLOW("flow");


    private String value;

    MessageCardLayoutFlexModeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
