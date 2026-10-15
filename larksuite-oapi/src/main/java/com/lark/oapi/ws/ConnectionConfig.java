package com.lark.oapi.ws;

import com.lark.oapi.ws.exception.ClientException;
import com.lark.oapi.okhttp.Request;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Immutable handshake-only configuration. Bootstrap keeps its existing settings.
final class ConnectionConfig {
    private final String host;
    private final Map<String, String> headers;

    ConnectionConfig(String host, Map<String, String> headers) {
        if (host != null) {
            validateHost(host);
        }
        this.host = host;
        Map<String, String> snapshot = new HashMap<>();
        if (headers != null) {
            snapshot.putAll(headers);
        }
        // Pass other header names/values to OkHttp without SDK format checks.
        for (String name : snapshot.keySet()) {
            if (name == null || isReserved(name)) {
                throw new IllegalArgumentException("invalid websocket connection headers");
            }
        }
        this.headers = Collections.unmodifiableMap(snapshot);
    }

    private static boolean isReserved(String name) {
        String lower = name.toLowerCase(Locale.ROOT);
        return lower.equals("host") || lower.equals("connection") || lower.equals("upgrade")
                || lower.startsWith("sec-websocket-");
    }

    private static void validateHost(String host) {
        if (host.trim().isEmpty() || host.contains("/") || host.contains("?")) {
            throw new IllegalArgumentException("invalid websocket connection host");
        }
    }

    String connectionUrl(String endpoint) {
        if (host == null) { return endpoint; }
        try {
            URI uri = new URI(endpoint);
            if (!("ws".equals(uri.getScheme()) || "wss".equals(uri.getScheme()))
                    || uri.getHost() == null || uri.getRawUserInfo() != null || uri.getRawFragment() != null) {
                throw new IllegalArgumentException();
            }
            // Preserve the raw path/query, including escaping and ordering.
            int authorityEnd = endpoint.indexOf("://") + 3 + uri.getRawAuthority().length();
            return uri.getScheme() + "://" + host + endpoint.substring(authorityEnd);
        } catch (Exception e) {
            throw new ClientException(400, "invalid websocket connection endpoint");
        }
    }

    Request handshakeRequest(String endpoint, String userAgent) {
        Request.Builder builder = new Request.Builder().url(connectionUrl(endpoint))
                .header("User-Agent", userAgent);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            builder.header(entry.getKey(), entry.getValue());
        }
        return builder.build();
    }
}
