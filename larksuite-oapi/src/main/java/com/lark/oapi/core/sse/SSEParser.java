package com.lark.oapi.core.sse;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/** Bounded incremental framing; no knowledge of OpenAPI response models. */
final class SSEParser {
    private final InputStream input;
    private final int limit;
    private int size;
    private boolean first = true;
    private boolean skipLf;
    private final List<String> data = new ArrayList<>();
    private String event = "";
    private String id;
    private volatile String cursor;
    private volatile Long retry;

    SSEParser(InputStream input, int limit, String cursor) {
        this.input = new BufferedInputStream(input, 4096);
        this.limit = limit;
        this.cursor = cursor;
    }

    String getCursor() {
        return cursor;
    }

    Long getRetry() {
        return retry;
    }

    private String readLine() throws IOException {
        ByteArrayOutputStream line = new ByteArrayOutputStream();
        while (true) {
            int value = input.read();
            if (value < 0) {
                return null;
            }
            if (skipLf) {
                skipLf = false;
                if (value == '\n') {
                    continue;
                }
            }
            if (++size > limit) {
                throw new IOException("SSE event exceeds maxEventBytes");
            }
            if (value == '\r' || value == '\n') {
                skipLf = value == '\r';
                String text = new String(line.toByteArray(), StandardCharsets.UTF_8);
                if (first) {
                    first = false;
                    if (text.startsWith("\ufeff")) {
                        text = text.substring(1);
                    }
                }
                return text;
            }
            line.write(value);
        }
    }

    SSEEvent next() throws IOException {
        String line;
        while ((line = readLine()) != null) {
            if (line.isEmpty()) {
                SSEEvent result = finish();
                if (result != null) {
                    return result;
                }
            } else {
                consume(line);
            }
        }
        return null; // An unterminated event is deliberately discarded at EOF.
    }

    private void consume(String line) {
        if (line.startsWith(":")) {
            return;
        }
        int colon = line.indexOf(':');
        String key = colon < 0 ? line : line.substring(0, colon);
        String value = colon < 0 ? "" : line.substring(colon + 1);
        if (value.startsWith(" ")) {
            value = value.substring(1);
        }
        switch (key) {
            case "data":
                data.add(value);
                break;
            case "event":
                event = value;
                break;
            case "id":
                if (value.indexOf('\0') < 0) {
                    id = value;
                }
                break;
            case "retry":
                if (value.matches("[0-9]{1,19}")) {
                    try {
                        retry = Long.parseLong(value);
                    } catch (NumberFormatException ignored) {
                        /* Out of range is invalid protocol advice. */
                    }
                }
                break;
            default:
                break;
        }
    }

    private SSEEvent finish() {
        if (id != null) {
            cursor = id;
        }
        SSEEvent result =
                data.isEmpty()
                        ? null
                        : new SSEEvent(
                                event.isEmpty() ? "message" : event, String.join("\n", data), id);
        data.clear();
        event = "";
        id = null;
        size = 0;
        return result;
    }
}
