package com.lark.oapi.ws;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpServer;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;

public class TestClient {

    @Test
    public void getConnUrlShouldSendCustomHeaders() throws Exception {
        AtomicReference<Headers> requestHeaders = new AtomicReference<>();
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.createContext(Constant.GEN_ENDPOINT_URI, exchange -> {
            requestHeaders.set(exchange.getRequestHeaders());
            byte[] body = "{\"code\":0,\"data\":{\"URL\":\"wss://example.test/callback?device_id=device&service_id=42\"}}"
                    .getBytes(StandardCharsets.UTF_8);
            exchange.sendResponseHeaders(200, body.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(body);
            }
        });
        server.start();

        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("x-tt-env", "boe");
            headers.put("locale", "en");
            headers.put("User-Agent", "custom-agent");

            Client client = new Client.Builder("app_id", "app_secret")
                    .domain("http://127.0.0.1:" + server.getAddress().getPort())
                    .headers(headers)
                    .header("x-use-ppe", "1")
                    .build();

            assertEquals(
                    "wss://example.test/callback?device_id=device&service_id=42",
                    invokeGetConnUrl(client));
            assertEquals("boe", requestHeaders.get().getFirst("x-tt-env"));
            assertEquals("1", requestHeaders.get().getFirst("x-use-ppe"));
            assertEquals("zh", requestHeaders.get().getFirst("locale"));
            assertEquals("custom-agent", requestHeaders.get().getFirst("User-Agent"));
        } finally {
            server.stop(0);
        }
    }

    private String invokeGetConnUrl(Client client) throws Exception {
        Method method = Client.class.getDeclaredMethod("getConnUrl");
        method.setAccessible(true);
        try {
            return (String) method.invoke(client);
        } catch (ReflectiveOperationException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                throw (IOException) cause;
            }
            throw e;
        }
    }
}
