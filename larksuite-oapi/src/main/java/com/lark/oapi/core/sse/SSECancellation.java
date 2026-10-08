package com.lark.oapi.core.sse;

/** A cancellation handle usable before opening or from a different thread. */
public final class SSECancellation {
    private boolean cancelled;
    private Runnable callback;

    public void cancel() {
        Runnable action;
        synchronized (this) {
            cancelled = true;
            action = callback;
        }
        if (action != null) {
            action.run();
        }
    }

    public void bind(Runnable action) {
        boolean run;
        synchronized (this) {
            callback = action;
            run = cancelled;
        }
        if (run && action != null) {
            action.run();
        }
    }
}
