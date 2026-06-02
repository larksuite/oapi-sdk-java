package com.lark.oapi.channel.outbound;

import com.lark.oapi.channel.exception.LarkChannelErrorCode;
import com.lark.oapi.channel.exception.LarkChannelException;

public final class OutboundRouting {
    private OutboundRouting() {
    }

    public static ReceiveIdType detectReceiveIdType(String to) {
        if (to == null || to.isEmpty()) {
            throw new LarkChannelException(LarkChannelErrorCode.FORMAT_ERROR, "empty receive_id");
        }
        if (to.startsWith("oc_")) {
            return ReceiveIdType.CHAT_ID;
        }
        if (to.startsWith("ou_")) {
            return ReceiveIdType.OPEN_ID;
        }
        if (to.startsWith("on_")) {
            return ReceiveIdType.UNION_ID;
        }
        if (to.contains("@")) {
            return ReceiveIdType.EMAIL;
        }
        return ReceiveIdType.USER_ID;
    }

    public enum ReceiveIdType {
        CHAT_ID("chat_id"),
        OPEN_ID("open_id"),
        USER_ID("user_id"),
        UNION_ID("union_id"),
        EMAIL("email");

        private final String value;

        ReceiveIdType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
