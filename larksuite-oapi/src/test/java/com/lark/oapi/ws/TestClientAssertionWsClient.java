package com.lark.oapi.ws;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lark.oapi.core.Constants;
import com.lark.oapi.core.auth.ClientAssertionToken;
import com.lark.oapi.core.auth.TargetInfo;
import com.lark.oapi.ws.exception.ClientException;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpServer;
import org.junit.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestClientAssertionWsClient {

    @Test
    public void providerBootstrapBodyIncludesRequiredEmptyAppSecret() throws Exception {
        CapturingServer server = CapturingServer.start(Constant.GEN_ENDPOINT_URI, 200, okBody());
        AtomicReference<String> audRef = new AtomicReference<>();
        try {
            Client client = new Client.Builder("cli_a", "")
                    .domain(server.domain())
                    .clientAssertionProvider(aud -> {
                        audRef.set(aud);
                        return new ClientAssertionToken("client-assertion");
                    })
                    .build();

            assertEquals("wss://example.test/callback?device_id=device&service_id=42", invokeGetConnUrl(client));
            JsonObject body = server.requestBody();
            assertEquals("cli_a", body.get("AppID").getAsString());
            assertEquals("", body.get("AppSecret").getAsString());
            assertEquals("client-assertion", body.get("ClientAssertion").getAsString());
            assertEquals("127.0.0.1:" + server.port(), audRef.get());
        } finally {
            server.stop();
        }
    }

    @Test
    public void appSecretBootstrapBodyIncludesEmptyClientAssertion() throws Exception {
        CapturingServer server = CapturingServer.start(Constant.GEN_ENDPOINT_URI, 200, okBody());
        try {
            Client client = new Client.Builder("cli_a", "app-secret")
                    .domain(server.domain())
                    .build();

            invokeGetConnUrl(client);
            JsonObject body = server.requestBody();
            assertEquals("cli_a", body.get("AppID").getAsString());
            assertEquals("app-secret", body.get("AppSecret").getAsString());
            assertEquals("", body.get("ClientAssertion").getAsString());
        } finally {
            server.stop();
        }
    }

    @Test
    public void targetInfoUsesProxyUrlAndTargetServiceHeaderWinsConflict() throws Exception {
        CapturingServer proxy = CapturingServer.start("/proxy" + Constant.GEN_ENDPOINT_URI, 200, okBody());
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put(Constants.HEADER_X_TARGET_SERVICE, "user-value");
            Client client = new Client.Builder("cli_a", "")
                    .domain("https://open.feishu.cn")
                    .headers(headers)
                    .clientAssertionProvider(aud -> new ClientAssertionToken(
                            "client-assertion",
                            new TargetInfo(proxy.domain(), "/proxy")))
                    .build();

            invokeGetConnUrl(client);

            assertEquals("open.feishu.cn", proxy.headers().getFirst(Constants.HEADER_X_TARGET_SERVICE));
            assertEquals("/proxy" + Constant.GEN_ENDPOINT_URI, proxy.path());
        } finally {
            proxy.stop();
        }
    }

    @Test
    public void emptyAssertionFailsWith7101() throws Exception {
        Client client = new Client.Builder("cli_a", "")
                .domain("https://open.feishu.cn")
                .clientAssertionProvider(aud -> new ClientAssertionToken(""))
                .build();

        try {
            invokeGetConnUrl(client);
        } catch (ClientException e) {
            assertTrue(e.toString().contains("7101"));
            return;
        }
        throw new AssertionError("expected ClientException");
    }

    @Test
    public void providerRetrieveFailureIsWrappedWith7102() throws Exception {
        Client client = new Client.Builder("cli_a", "")
                .domain("https://open.feishu.cn")
                .clientAssertionProvider(aud -> {
                    throw new IllegalStateException("kms down");
                })
                .build();

        try {
            invokeGetConnUrl(client);
        } catch (ClientException e) {
            assertTrue(e.toString().contains("7102"));
            assertTrue(e.getMessage().contains("kms down"));
            return;
        }
        throw new AssertionError("expected ClientException");
    }

    @Test
    public void missingCredentialsFailsWith7104() throws Exception {
        Client client = new Client.Builder("cli_a", "")
                .domain("https://open.feishu.cn")
                .build();

        try {
            invokeGetConnUrl(client);
        } catch (ClientException e) {
            assertTrue(e.toString().contains("7104"));
            return;
        }
        throw new AssertionError("expected ClientException");
    }

    @Test
    public void non200BootstrapUsesServerMessage() throws Exception {
        CapturingServer server = CapturingServer.start(Constant.GEN_ENDPOINT_URI, 503, "{\"msg\":\"target service unavailable\"}");
        try {
            Client client = new Client.Builder("cli_a", "app-secret")
                    .domain(server.domain())
                    .build();

            try {
                invokeGetConnUrl(client);
            } catch (RuntimeException e) {
                assertTrue(e.getMessage().contains("target service unavailable"));
                return;
            }
            throw new AssertionError("expected RuntimeException");
        } finally {
            server.stop();
        }
    }

    @Test
    public void customHeadersArePreserved() throws Exception {
        CapturingServer server = CapturingServer.start(Constant.GEN_ENDPOINT_URI, 200, okBody());
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("x-tt-env", "boe");
            headers.put("User-Agent", "custom-agent");
            Client client = new Client.Builder("cli_a", "app-secret")
                    .domain(server.domain())
                    .headers(headers)
                    .header("x-use-ppe", "1")
                    .build();

            invokeGetConnUrl(client);

            assertEquals("boe", server.headers().getFirst("x-tt-env"));
            assertEquals("1", server.headers().getFirst("x-use-ppe"));
            assertEquals("zh", server.headers().getFirst("locale"));
            assertEquals("custom-agent", server.headers().getFirst("User-Agent"));
        } finally {
            server.stop();
        }
    }

    private static String invokeGetConnUrl(Client client) throws Exception {
        Method method = Client.class.getDeclaredMethod("getConnUrl");
        method.setAccessible(true);
        try {
            return (String) method.invoke(client);
        } catch (ReflectiveOperationException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                throw (IOException) cause;
            }
            if (cause instanceof RuntimeException) {
                throw (RuntimeException) cause;
            }
            throw e;
        }
    }

    private static String okBody() {
        return "{\"code\":0,\"data\":{\"URL\":\"wss://example.test/callback?device_id=device&service_id=42\"}}";
    }

    private static class CapturingServer {
        private final HttpServer server;
        private final AtomicReference<String> body = new AtomicReference<>();
        private final AtomicReference<Headers> headers = new AtomicReference<>();
        private final AtomicReference<String> path = new AtomicReference<>();

        private CapturingServer(HttpServer server) {
            this.server = server;
        }

        private static CapturingServer start(String path, int statusCode, String responseBody) throws IOException {
            HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
            CapturingServer capturingServer = new CapturingServer(server);
            server.createContext(path, exchange -> {
                capturingServer.path.set(exchange.getRequestURI().getPath());
                capturingServer.headers.set(exchange.getRequestHeaders());
                ByteArrayOutputStream requestBuffer = new ByteArrayOutputStream();
                byte[] requestChunk = new byte[1024];
                int read;
                while ((read = exchange.getRequestBody().read(requestChunk)) != -1) {
                    requestBuffer.write(requestChunk, 0, read);
                }
                capturingServer.body.set(new String(requestBuffer.toByteArray(), StandardCharsets.UTF_8));
                byte[] response = responseBody.getBytes(StandardCharsets.UTF_8);
                exchange.sendResponseHeaders(statusCode, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
            });
            server.start();
            return capturingServer;
        }

        private int port() {
            return server.getAddress().getPort();
        }

        private String domain() {
            return "http://127.0.0.1:" + port();
        }

        private JsonObject requestBody() {
            return JsonParser.parseString(body.get()).getAsJsonObject();
        }

        private Headers headers() {
            return headers.get();
        }

        private String path() {
            return path.get();
        }

        private void stop() {
            server.stop(0);
        }
    }
}
