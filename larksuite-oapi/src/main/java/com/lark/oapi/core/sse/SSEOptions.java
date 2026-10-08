package com.lark.oapi.core.sse;

/** Per-request SSE bounds. Zero total timeout leaves the stream lifetime unlimited. */
public final class SSEOptions {
    private long openTimeoutMillis = 10000;
    private int idleReadTimeoutMillis = 60000;
    private long totalTimeoutMillis;
    private int maxEventBytes = 1024 * 1024;
    private String lastEventId = "";
    private SSECancellation cancellation;

    public long getOpenTimeoutMillis() {
        return openTimeoutMillis;
    }

    public int getIdleReadTimeoutMillis() {
        return idleReadTimeoutMillis;
    }

    public long getTotalTimeoutMillis() {
        return totalTimeoutMillis;
    }

    public int getMaxEventBytes() {
        return maxEventBytes;
    }

    public String getLastEventId() {
        return lastEventId;
    }

    public SSECancellation getCancellation() {
        return cancellation;
    }

    public SSEOptions openTimeoutMillis(long value) {
        openTimeoutMillis = value;
        return this;
    }

    public SSEOptions idleReadTimeoutMillis(int value) {
        idleReadTimeoutMillis = value;
        return this;
    }

    public SSEOptions totalTimeoutMillis(long value) {
        totalTimeoutMillis = value;
        return this;
    }

    public SSEOptions maxEventBytes(int value) {
        maxEventBytes = value;
        return this;
    }

    public SSEOptions lastEventId(String value) {
        lastEventId = value;
        return this;
    }

    public SSEOptions cancellation(SSECancellation value) {
        cancellation = value;
        return this;
    }

    public void validate() {
        if (openTimeoutMillis <= 0
                || openTimeoutMillis > Integer.MAX_VALUE
                || idleReadTimeoutMillis <= 0
                || totalTimeoutMillis < 0
                || maxEventBytes <= 0) {
            throw new IllegalArgumentException("invalid SSE timeout or event size limit");
        }
        if (lastEventId == null
                || lastEventId.getBytes(java.nio.charset.StandardCharsets.UTF_8).length > 8192
                || lastEventId.indexOf('\r') >= 0
                || lastEventId.indexOf('\n') >= 0
                || lastEventId.indexOf('\0') >= 0) {
            throw new IllegalArgumentException("invalid SSE last event ID");
        }
    }
}
