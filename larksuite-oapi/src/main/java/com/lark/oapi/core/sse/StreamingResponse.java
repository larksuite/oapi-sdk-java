package com.lark.oapi.core.sse;

import java.io.Closeable;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/** Owns the live HTTP response, including its transport-specific cleanup. */
public final class StreamingResponse implements Closeable {
    public final int statusCode;
    public final Map<String, List<String>> headers;
    public final InputStream body;
    private final Closeable resource;

    public StreamingResponse(
            int statusCode,
            Map<String, List<String>> headers,
            InputStream body,
            Closeable resource) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.body = body;
        this.resource = resource;
    }

    public void close() throws java.io.IOException {
        resource.close();
    }
}
