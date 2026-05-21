package com.lark.oapi.channel.model;

public enum RejectReason {
    GROUP_NOT_ALLOWED("group_not_allowed"),
    SENDER_NOT_ALLOWED("sender_not_allowed"),
    NO_MENTION("no_mention"),
    DM_DISABLED("dm_disabled"),
    MENTION_ALL_BLOCKED("mention_all_blocked");

    private final String value;

    RejectReason(String value) { this.value = value; }
    public String getValue() { return value; }

    @Override
    public String toString() { return value; }
}
