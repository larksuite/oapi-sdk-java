package com.lark.oapi.core.sse;

import java.io.Closeable;
import java.io.IOException;
import java.util.*;

/** One synchronous event reader. Close/cancel may be called by another thread. */
public final class SSEStream implements Closeable {
    private final StreamingCall call;
    private final StreamingResponse response;
    private final SSEParser parser;
    private final Timer timer;
    private final SSECancellation cancellation;
    private final Map<String, List<String>> headers;
    private final Object readLock = new Object();
    private boolean closed;
    private volatile IOException closeFailure;

    private SSEStream(
            StreamingCall call, StreamingResponse response, SSEOptions options, Timer timer) {
        this.call = call;
        this.response = response;
        this.timer = timer;
        this.cancellation = options.getCancellation();
        this.parser =
                new SSEParser(response.body, options.getMaxEventBytes(), options.getLastEventId());
        Map<String, List<String>> copy = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        response.headers.forEach(
                (key, values) ->
                        copy.put(key, Collections.unmodifiableList(new ArrayList<>(values))));
        this.headers = Collections.unmodifiableMap(copy);
    }

    public static SSEStream open(StreamingCall call, SSEOptions options) throws Exception {
        long started = System.nanoTime();
        Timer timer = new Timer("lark-sse-timeout", true);
        long openMillis = options.getOpenTimeoutMillis();
        if (options.getTotalTimeoutMillis() > 0) {
            openMillis = Math.min(openMillis, options.getTotalTimeoutMillis());
        }
        TimerTask openDeadline = deadline(timer, call, openMillis);
        if (options.getCancellation() != null) {
            options.getCancellation().bind(call::cancel);
        }
        StreamingResponse response = null;
        try {
            response = call.execute();
            openDeadline.cancel();
            validate(response);
            SSEStream stream = new SSEStream(call, response, options, timer);
            stream.armTotalTimeout(options, started);
            if (options.getCancellation() != null) {
                options.getCancellation().bind(stream::cancel);
            }
            return stream;
        } catch (Exception error) {
            timer.cancel();
            call.cancel();
            if (options.getCancellation() != null) {
                options.getCancellation().bind(null);
            }
            if (response != null) {
                try {
                    response.close();
                } catch (IOException cleanup) {
                    error.addSuppressed(cleanup);
                }
            }
            throw error;
        }
    }

    private void armTotalTimeout(SSEOptions options, long started) throws IOException {
        if (options.getTotalTimeoutMillis() == 0) {
            return;
        }
        long elapsed =
                java.util.concurrent.TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - started);
        long remaining = options.getTotalTimeoutMillis() - elapsed;
        if (remaining <= 0) {
            close();
            throw new java.net.SocketTimeoutException("SSE total timeout");
        }
        timer.schedule(
                new TimerTask() {
                    public void run() {
                        timeout();
                    }
                },
                remaining);
    }

    private void timeout() {
        closeFailure = new java.net.SocketTimeoutException("SSE total timeout");
        cancel();
    }

    private void cancel() {
        try {
            close();
        } catch (IOException error) {
            if (closeFailure == null) {
                closeFailure = error;
            } else {
                closeFailure.addSuppressed(error);
            }
        }
    }

    private static TimerTask deadline(Timer timer, StreamingCall call, long millis) {
        TimerTask task =
                new TimerTask() {
                    public void run() {
                        call.cancel();
                    }
                };
        timer.schedule(task, millis);
        return task;
    }

    private static void validate(StreamingResponse response) throws IOException {
        String contentType = "";
        for (Map.Entry<String, List<String>> entry : response.headers.entrySet()) {
            if (entry.getKey().equalsIgnoreCase("Content-Type") && !entry.getValue().isEmpty()) {
                contentType = entry.getValue().get(0).split(";", 2)[0].trim();
            }
        }
        if (response.statusCode < 200
                || response.statusCode >= 300
                || !contentType.equalsIgnoreCase("text/event-stream")) {
            throw new IOException(
                    "Invalid SSE response: HTTP "
                            + response.statusCode
                            + ", expected text/event-stream");
        }
    }

    /** Returns null at normal EOF; never waits for the entire response body. */
    public SSEEvent readNext() throws IOException {
        synchronized (readLock) {
            return readEvent();
        }
    }

    private SSEEvent readEvent() throws IOException {
        synchronized (this) {
            if (closed) {
                if (closeFailure != null) {
                    throw closeFailure;
                }
                return null;
            }
        }
        try {
            SSEEvent event = parser.next();
            if (event == null) {
                close();
            }
            return event;
        } catch (IOException error) {
            try {
                close();
            } catch (IOException cleanup) {
                error.addSuppressed(cleanup);
            }
            IOException cause = closeFailure;
            if (cause != null && cause != error) {
                cause.addSuppressed(error);
                throw cause;
            }
            throw error;
        }
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public String getLastEventId() {
        return parser.getCursor();
    }

    public Long getRetryDelay() {
        return parser.getRetry();
    }

    public void close() throws IOException {
        synchronized (this) {
            if (closed) {
                return;
            }
            closed = true;
        }
        timer.cancel();
        if (cancellation != null) {
            cancellation.bind(null);
        }
        call.cancel();
        // Cancel wakes the reader. Closing Okio/Apache sources concurrently with
        // an active read is unsafe, so release the response after it leaves.
        synchronized (readLock) {
            response.close();
        }
    }
}
