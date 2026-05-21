package com.lark.oapi.channel.outbound;

import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;

public final class OutboundErrors {
    private OutboundErrors() {
    }

    public static LarkChannelException classifyError(Throwable error) {
        return classifyError(error, null);
    }

    public static LarkChannelException classifyError(Throwable error, String message) {
        if (error instanceof LarkChannelException) {
            return (LarkChannelException) error;
        }
        String text = error == null || error.getMessage() == null ? "" : error.getMessage();
        String lower = text.toLowerCase();
        LarkChannelErrorCode code = inferCode(text, lower);
        return new LarkChannelException(code, message == null || message.isEmpty() ? text : message, null,
                error instanceof Exception ? (Exception) error : new RuntimeException(error));
    }

    public static boolean isRetryable(LarkChannelException error) {
        return hasCode(error, LarkChannelErrorCode.RATE_LIMITED) || hasCode(error, LarkChannelErrorCode.UNKNOWN);
    }

    public static boolean isFormatError(LarkChannelException error) {
        return hasCode(error, LarkChannelErrorCode.FORMAT_ERROR);
    }

    public static boolean isReplyTargetGone(LarkChannelException error) {
        return hasCode(error, LarkChannelErrorCode.TARGET_REVOKED);
    }

    private static boolean hasCode(LarkChannelException error, LarkChannelErrorCode expected) {
        return error != null && expected.getValue().equals(error.getCode());
    }

    private static LarkChannelErrorCode inferCode(String text, String lower) {
        if (text.contains("230020") || text.contains("230017") || text.contains("404")) {
            return LarkChannelErrorCode.TARGET_REVOKED;
        }
        if (text.contains("99991401") || text.contains("99991400") || text.contains("401") || text.contains("403")) {
            return LarkChannelErrorCode.PERMISSION_DENIED;
        }
        if (text.contains("230002") || text.contains("230001") || text.contains("400")) {
            return LarkChannelErrorCode.FORMAT_ERROR;
        }
        if (text.contains("429")) {
            return LarkChannelErrorCode.RATE_LIMITED;
        }
        if (lower.startsWith("ssrf_blocked") || lower.contains("ssrf")) {
            return LarkChannelErrorCode.SSRF_BLOCKED;
        }
        if (lower.contains("timeout") || text.contains("ETIMEDOUT") || text.contains("ECONNABORTED")) {
            return LarkChannelErrorCode.SEND_TIMEOUT;
        }
        return LarkChannelErrorCode.UNKNOWN;
    }
}
