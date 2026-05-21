package com.lark.oapi.channel.exception;

public class LarkChannelException extends RuntimeException {
    private final String code;
    private final String context;

    public LarkChannelException(LarkChannelErrorCode code, String message) {
        this(code, message, null, null);
    }

    public LarkChannelException(LarkChannelErrorCode code, String message, Throwable cause) {
        this(code, message, null, cause);
    }

    public LarkChannelException(LarkChannelErrorCode code, String message, String context, Throwable cause) {
        super(message, cause);
        this.code = code.getValue();
        this.context = context;
    }

    public String getCode() {
        return code;
    }

    public String getContext() {
        return context;
    }
}
