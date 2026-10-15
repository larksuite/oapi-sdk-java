package com.lark.oapi.ws;

import com.lark.oapi.okhttp.*;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import static org.junit.Assert.*;

public class TestConnectionConfig {
    @Test
    public void hostRewritePreservesRawPathAndQuery() {
        String endpoint = "wss://original.test/a%2Fb?device_id=d&x=%2F&x=2";
        for (String host : new String[]{"example.test", "example.test:8443", "127.0.0.1:80", "[::1]", "[::1]:443"}) {
            ConnectionConfig config = new ConnectionConfig(host, null);
            assertEquals("wss://" + host + "/a%2Fb?device_id=d&x=%2F&x=2", config.connectionUrl(endpoint));
        }
        assertEquals(endpoint, new ConnectionConfig(null, null).connectionUrl(endpoint));
    }

    @Test
    public void invalidConfigurationFailsAtBuild() {
        for (String host : new String[]{"", " ", "https://x", "x/path", "x?q=1"}) {
            assertThrows(IllegalArgumentException.class, () -> new Client.Builder("app", "placeholder").connectionHost(host).build());
        }
        for (String name : new String[]{"Host", "cOnNeCtIoN", "Upgrade", "sEc-WeBsOcKeT-Key"}) {
            Map<String, String> headers = new HashMap<>();
            headers.put(name, "value");
            assertThrows(IllegalArgumentException.class, () -> new Client.Builder("app", "placeholder").connectionHeaders(headers).build());
        }
    }

    @Test
    public void handshakeHeadersUseSnapshotAndIndependentRequests() {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Route", "ws-only");
        ConnectionConfig config = new ConnectionConfig("logical.test", headers);
        headers.put("X-Route", "changed");
        Request first = config.handshakeRequest("wss://original.test/ws?x=%2F", "sdk-test");
        Request second = config.handshakeRequest("wss://original.test/ws?x=%2F", "sdk-test");
        assertEquals("logical.test", first.url().host());
        assertEquals("https", first.url().scheme());
        assertEquals("x=%2F", first.url().encodedQuery());
        assertEquals("ws-only", first.header("X-Route"));
        assertEquals("sdk-test", first.header("User-Agent"));
        assertNotSame(first, second);
        assertEquals(first.headers(), second.headers());
        assertNull(new ConnectionConfig(null, null).handshakeRequest("ws://original.test/ws", "sdk-test").header("X-Route"));
    }

    @Test
    public void existingHttpClientHandlesBothStagesWithIsolatedHeaders() throws Exception {
        AtomicReference<Request> bootstrap = new AtomicReference<>();
        AtomicReference<Request> handshake = new AtomicReference<>();
        CountDownLatch connected = new CountDownLatch(1);
        OkHttpClient transport = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request request = chain.request();
            if ("POST".equals(request.method())) {
                bootstrap.set(request);
                return new Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(200).message("OK")
                        .body(ResponseBody.create(MediaType.parse("application/json"),
                                "{\"code\":0,\"data\":{\"URL\":\"wss://original.test/a%2Fb?device_id=d&service_id=42&x=%2F\"}}"))
                        .build();
            }
            handshake.set(request);
            connected.countDown();
            return new Response.Builder().request(request).protocol(Protocol.HTTP_1_1).code(403).message("Forbidden")
                    .body(ResponseBody.create(MediaType.parse("text/plain"), "rejected")).build();
        }).build();
        Map<String, String> httpHeaders = new HashMap<>();
        httpHeaders.put("X-Bootstrap", "http-only");
        Map<String, String> wsHeaders = new HashMap<>();
        wsHeaders.put("X-Route", "ws-only");
        Client client = new Client.Builder("app", "placeholder").httpClient(transport).autoReconnect(false)
                .headers(httpHeaders).connectionHost("logical.test:8443").connectionHeaders(wsHeaders).build();
        wsHeaders.put("X-Route", "mutated");
        try {
            Method connect = Client.class.getDeclaredMethod("connect");
            connect.setAccessible(true);
            connect.invoke(client);
            assertTrue("handshake not received", connected.await(3, TimeUnit.SECONDS));
            assertEquals("http-only", bootstrap.get().header("X-Bootstrap"));
            assertNull(bootstrap.get().header("X-Route"));
            assertEquals("logical.test", handshake.get().url().host());
            assertEquals(8443, handshake.get().url().port());
            assertEquals("/a%2Fb", handshake.get().url().encodedPath());
            assertEquals("device_id=d&service_id=42&x=%2F", handshake.get().url().encodedQuery());
            assertEquals("ws-only", handshake.get().header("X-Route"));
            assertNull(handshake.get().header("X-Bootstrap"));
        } finally {
            client.close();
            transport.dispatcher().executorService().shutdownNow();
            transport.connectionPool().evictAll();
        }
    }
}
