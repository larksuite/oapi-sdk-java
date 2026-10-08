package com.lark.oapi.core.sse;

import static org.junit.Assert.*;

import com.lark.oapi.core.httpclient.*;
import com.lark.oapi.core.request.RawRequest;
import com.lark.oapi.okhttp.OkHttpClient;
import com.sun.net.httpserver.HttpServer;

import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;

public class TestSSE {
    @Test
    public void framing() throws Exception {
        String input =
                "\ufeff: hello\r\n"
                        + "id: cursor\r\n\r\n"
                        + "event: delta\n"
                        + "data: 中文\n"
                        + "data: second\n"
                        + "id:\n"
                        + "retry: 1000\n\n"
                        + "data: incomplete";
        SSEParser parser =
                new SSEParser(
                        new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)),
                        1024,
                        "old");
        SSEEvent event = parser.next();
        assertEquals("delta", event.getEvent());
        assertEquals("中文\nsecond", event.getData());
        assertEquals("", event.getId());
        assertEquals("", parser.getCursor());
        assertEquals(Long.valueOf(1000), parser.getRetry());
        assertNull(parser.next());
    }

    @Test
    public void boundedEvent() throws Exception {
        SSEParser parser =
                new SSEParser(
                        new ByteArrayInputStream(
                                "data: too long without newline".getBytes(StandardCharsets.UTF_8)),
                        8,
                        "");
        try {
            parser.next();
            fail("expected event limit");
        } catch (IOException expected) {
            assertTrue(expected.getMessage().contains("maxEventBytes"));
        }
    }

    @Test
    public void okHttpImmediateDeliveryAndCancel() throws Exception {
        for (int attempt = 0; attempt < 20; attempt++) {
            exercise(new OkHttpTransport(new OkHttpClient()), false);
        }
    }

    @Test
    public void closeWaitsForCancelledReader() throws Exception {
        CountDownLatch entered = new CountDownLatch(1);
        CountDownLatch cancelled = new CountDownLatch(1);
        CountDownLatch exited = new CountDownLatch(1);
        InputStream body =
                new InputStream() {
                    public int read() throws IOException {
                        entered.countDown();
                        try {
                            if (!cancelled.await(1, TimeUnit.SECONDS)) {
                                throw new IOException("reader was not cancelled");
                            }
                            return -1;
                        } catch (InterruptedException error) {
                            Thread.currentThread().interrupt();
                            throw new IOException(error);
                        } finally {
                            exited.countDown();
                        }
                    }
                };
        StreamingResponse response =
                new StreamingResponse(
                        200,
                        java.util.Collections.singletonMap(
                                "Content-Type",
                                java.util.Collections.singletonList("text/event-stream")),
                        body,
                        () -> assertEquals("closed during a read", 0, exited.getCount()));
        StreamingCall call =
                new StreamingCall() {
                    public StreamingResponse execute() {
                        return response;
                    }

                    public void cancel() {
                        cancelled.countDown();
                    }
                };
        ExecutorService reader = Executors.newSingleThreadExecutor();
        try (SSEStream stream = SSEStream.open(call, new SSEOptions())) {
            Future<SSEEvent> pending = reader.submit(stream::readNext);
            assertTrue(entered.await(1, TimeUnit.SECONDS));
            stream.close();
            assertNull(pending.get(1, TimeUnit.SECONDS));
        } finally {
            reader.shutdownNow();
            assertTrue(reader.awaitTermination(1, TimeUnit.SECONDS));
        }
    }

    @Test
    public void apacheImmediateDeliveryAndCancel() throws Exception {
        try (org.apache.http.impl.client.CloseableHttpClient client =
                HttpClients.custom().disableAutomaticRetries().build()) {
            exercise(ApacheHttpClientTransport.newBuilder().httpclient(client).build(), false);
        }
    }

    @Test
    public void okHttpIdleTimeout() throws Exception {
        exercise(new OkHttpTransport(new OkHttpClient()), true);
    }

    @Test
    public void apacheIdleTimeout() throws Exception {
        try (org.apache.http.impl.client.CloseableHttpClient client =
                HttpClients.custom().disableAutomaticRetries().build()) {
            exercise(ApacheHttpClientTransport.newBuilder().httpclient(client).build(), true);
        }
    }

    @Test
    public void oldCustomTransportIsCompatible() throws Exception {
        com.lark.oapi.core.Config config = new com.lark.oapi.core.Config();
        config.setHttpTransport(
                request -> {
                    throw new AssertionError("must not send buffered request");
                });
        try {
            com.lark.oapi.core.Transport.sendSSE(
                    config,
                    null,
                    "GET",
                    "/events",
                    java.util.Collections.singleton(com.lark.oapi.core.token.AccessTokenType.None),
                    null);
            fail("expected capability error");
        } catch (UnsupportedOperationException expected) {
            assertTrue(expected.getMessage().contains("streaming"));
        }
    }

    @Test
    public void openingDeadlineCancelsCall() throws Exception {
        CountDownLatch cancelled = new CountDownLatch(1);
        StreamingCall call =
                new StreamingCall() {
                    public StreamingResponse execute() throws Exception {
                        assertTrue(cancelled.await(1, TimeUnit.SECONDS));
                        throw new IOException("cancelled");
                    }

                    public void cancel() {
                        cancelled.countDown();
                    }
                };
        try {
            SSEStream.open(call, new SSEOptions().openTimeoutMillis(20));
            fail("expected cancellation");
        } catch (IOException expected) {
            assertEquals("cancelled", expected.getMessage());
        }
    }

    private void exercise(IStreamingHttpTransport transport, boolean idle) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        CountDownLatch release = new CountDownLatch(1);
        ExecutorService readers = Executors.newSingleThreadExecutor();
        server.createContext(
                "/events",
                exchange -> {
                    try {
                        exchange.getResponseHeaders()
                                .set("Content-Type", "text/event-stream; charset=utf-8");
                        exchange.sendResponseHeaders(200, 0);
                        exchange.getResponseBody()
                                .write(
                                        "id: first\ndata: first\n\n"
                                                .getBytes(StandardCharsets.UTF_8));
                        exchange.getResponseBody().flush();
                        release.await(5, TimeUnit.SECONDS);
                    } catch (InterruptedException error) {
                        Thread.currentThread().interrupt();
                    } finally {
                        exchange.close();
                    }
                });
        server.start();
        try {
            RawRequest raw = new RawRequest();
            raw.setReqUrl("http://127.0.0.1:" + server.getAddress().getPort() + "/events");
            raw.setHttpMethod("GET");
            SSECancellation cancel = new SSECancellation();
            SSEOptions options =
                    new SSEOptions().cancellation(cancel).idleReadTimeoutMillis(idle ? 50 : 1000);
            try (SSEStream stream =
                    SSEStream.open(transport.createStreamingCall(raw, options), options)) {
                assertEquals(
                        "first",
                        readers.submit(stream::readNext).get(1, TimeUnit.SECONDS).getData());
                assertEquals("first", stream.getLastEventId());
                Future<SSEEvent> pending = readers.submit(stream::readNext);
                if (!idle) {
                    cancel.cancel();
                }
                try {
                    assertNull(pending.get(1, TimeUnit.SECONDS));
                } catch (ExecutionException expected) {
                    assertTrue(expected.getCause() instanceof IOException);
                }
            }
        } finally {
            release.countDown();
            server.stop(0);
            readers.shutdownNow();
            assertTrue(readers.awaitTermination(2, TimeUnit.SECONDS));
        }
    }
}
