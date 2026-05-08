package com.lark.oapi.channel.model;

public class RejectEvent {
    private final RejectReason reason;
    private final Object raw;

    public RejectEvent(RejectReason reason, Object raw) {
        this.reason = reason;
        this.raw = raw;
    }

    public RejectReason getReason() { return reason; }
    public Object getRaw() { return raw; }
}
