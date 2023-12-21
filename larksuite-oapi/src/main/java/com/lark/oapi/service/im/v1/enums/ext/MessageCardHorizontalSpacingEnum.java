package com.lark.oapi.service.im.v1.enums.ext;

/**
 * 列集内，每列与上一列的左右间距
 */
public enum MessageCardHorizontalSpacingEnum {
    /**
     * 默认间距
     */
    DEFAULT("default"),
    /**
     * 窄间距
     */
    SMALL("small");

    private String value;

    MessageCardHorizontalSpacingEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
