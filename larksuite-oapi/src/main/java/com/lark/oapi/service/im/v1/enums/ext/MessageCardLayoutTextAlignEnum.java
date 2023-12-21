package com.lark.oapi.service.im.v1.enums.ext;

public enum MessageCardLayoutTextAlignEnum {
    /**
     * 左对齐
     */
    LEFT("left"),
    /**
     * 居中对齐
     */
    CENTER("center"),
    /**
     * 右对齐
     */
    RIGHT("right");

    private String value;

    MessageCardLayoutTextAlignEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
