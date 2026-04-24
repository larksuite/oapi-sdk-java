package com.lark.oapi.scene.registration;

public class StatusChangeInfo {
    public static final String POLLING = "polling";
    public static final String SLOW_DOWN = "slow_down";
    public static final String DOMAIN_SWITCHED = "domain_switched";

    private final String status;
    private final int interval;

    public StatusChangeInfo(String status, int interval) {
        this.status = status;
        this.interval = interval;
    }

    public StatusChangeInfo(String status) {
        this(status, 0);
    }

    public String getStatus() {
        return status;
    }

    public int getInterval() {
        return interval;
    }
}
