package com.lark.oapi.channel.model;

/**
 * Event emitted when an inbound message is rejected by the safety policy.
 */
public class RejectEvent {
    private final RejectReason reason;
    private final Object raw;

    public RejectEvent(RejectReason reason, Object raw) {
        this.reason = reason;
        this.raw = raw;
    }

    /** Policy rejection reason. */
    public RejectReason getReason() { return reason; }
    /** Original message/event that was rejected. */
    public Object getRaw() { return raw; }
}
