package com.lark.oapi.ws.enums;

public enum FrameType {
    CONTROL(0),
    DATA(1),
    ;

    private int code;

    FrameType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static FrameType of(int code) {
        for (FrameType type : FrameType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("No FrameType code of " + code);
    }
}
