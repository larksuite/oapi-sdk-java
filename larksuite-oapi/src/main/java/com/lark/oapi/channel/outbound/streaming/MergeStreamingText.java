package com.lark.oapi.channel.outbound.streaming;

public final class MergeStreamingText {
    private MergeStreamingText() {
    }

    public static String merge(String previous, String next) {
        if (previous == null || previous.isEmpty()) {
            return next == null ? "" : next;
        }
        if (next == null || next.isEmpty()) {
            return previous;
        }
        if (next.startsWith(previous)) {
            return next;
        }
        if (previous.startsWith(next)) {
            return previous;
        }
        int maxOverlap = Math.min(previous.length(), next.length());
        for (int len = maxOverlap; len > 0; len--) {
            if (previous.endsWith(next.substring(0, len))) {
                return previous + next.substring(len);
            }
        }
        return previous + next;
    }
}
