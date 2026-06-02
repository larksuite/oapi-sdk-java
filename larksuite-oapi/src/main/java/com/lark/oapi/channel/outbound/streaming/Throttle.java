package com.lark.oapi.channel.outbound.streaming;

public class Throttle {
    private final int ms;
    private final int chars;
    private final FireAction action;
    private long lastFireAt;
    private int pendingChars;

    public Throttle(int ms, int chars, FireAction action) {
        this.ms = ms;
        this.chars = chars;
        this.action = action;
    }

    public void note(int deltaChars) throws Exception {
        pendingChars += deltaChars;
        long elapsed = System.currentTimeMillis() - lastFireAt;
        if (pendingChars >= chars || elapsed >= ms) {
            flushNow();
        }
    }

    public void flushNow() throws Exception {
        pendingChars = 0;
        lastFireAt = System.currentTimeMillis();
        action.fire();
    }

    public void dispose() {
        pendingChars = 0;
    }

    public interface FireAction {
        void fire() throws Exception;
    }
}
