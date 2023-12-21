package com.lark.oapi.service.im.v1.enums.ext;

/**
 * 列宽度属性
 */
public enum MessageCardColumnWidthEnum {
    /**
     * 列宽度与列内元素宽度一致
     */
    AUTO("auto"),
    /**
     * 列宽度按weight定义的权重分布
     */
    WEIGHTED("weighted");

    private String value;

    MessageCardColumnWidthEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
