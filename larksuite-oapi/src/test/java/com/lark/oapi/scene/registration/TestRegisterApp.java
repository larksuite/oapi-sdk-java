/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.lark.oapi.scene.registration;

import com.lark.oapi.okhttp.HttpUrl;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TestRegisterApp {

    @Test
    public void testRegisterAppSuccessWithLarkSwitch() throws Exception {
        RegistrationTestServer feishuServer = new RegistrationTestServer();
        RegistrationTestServer larkServer = new RegistrationTestServer();
        try {
            feishuServer.enqueueBegin(
                    200,
                    "{\"device_code\":\"dev_code\",\"verification_uri_complete\":\""
                            + feishuServer.baseUrl()
                            + "/verify?foo=bar\",\"interval\":1,\"expire_in\":600}"
            );
            feishuServer.enqueuePoll(
                    400,
                    "{\"user_info\":{\"tenant_brand\":\"lark\"},\"error\":\"authorization_pending\"}"
            );
            larkServer.enqueuePoll(
                    200,
                    "{\"client_id\":\"cli_123\",\"client_secret\":\"sec_456\","
                            + "\"user_info\":{\"open_id\":\"ou_abc\",\"tenant_brand\":\"lark\"}}"
            );

            List<QRCodeInfo> qrCodes = new ArrayList<>();
            List<String> statuses = new ArrayList<>();

            RegisterAppResult result = RegisterApp.register(RegisterAppOptions.newBuilder()
                    .domain(feishuServer.baseUrl())
                    .larkDomain(larkServer.baseUrl())
                    .source("cli-tool")
                    .onQRCode(qrCodes::add)
                    .onStatusChange(info -> statuses.add(info.getStatus()))
                    .build());

            assertEquals("cli_123", result.getClientId());
            assertEquals("sec_456", result.getClientSecret());
            assertNotNull(result.getUserInfo());
            assertEquals("ou_abc", result.getUserInfo().getOpenId());
            assertEquals("lark", result.getUserInfo().getTenantBrand());

            assertEquals(1, qrCodes.size());
            HttpUrl qrUrl = HttpUrl.get(qrCodes.get(0).getUrl());
            assertEquals("bar", qrUrl.queryParameter("foo"));
            assertEquals("sdk", qrUrl.queryParameter("from"));
            assertEquals("java-sdk/cli-tool", qrUrl.queryParameter("source"));
            assertEquals("sdk", qrUrl.queryParameter("tp"));

            assertEquals(Arrays.asList(StatusChangeInfo.DOMAIN_SWITCHED), statuses);

            assertEquals("begin", feishuServer.beginRequests().get(0).get("action"));
            assertEquals("PersonalAgent", feishuServer.beginRequests().get(0).get("archetype"));
            assertEquals("client_secret", feishuServer.beginRequests().get(0).get("auth_method"));
            assertEquals("open_id", feishuServer.beginRequests().get(0).get("request_user_info"));

            assertEquals("poll", feishuServer.pollRequests().get(0).get("action"));
            assertEquals("dev_code", feishuServer.pollRequests().get(0).get("device_code"));
            assertEquals("poll", larkServer.pollRequests().get(0).get("action"));
            assertEquals("dev_code", larkServer.pollRequests().get(0).get("device_code"));
        } finally {
            feishuServer.close();
            larkServer.close();
        }
    }

    @Test
    public void testRegisterAppThrowsAccessDenied() throws Exception {
        RegistrationTestServer server = new RegistrationTestServer();
        try {
            server.enqueueBegin(
                    200,
                    "{\"device_code\":\"dev_code\",\"verification_uri_complete\":\""
                            + server.baseUrl()
                            + "/verify\",\"interval\":1,\"expire_in\":600}"
            );
            server.enqueuePoll(400, "{\"error\":\"access_denied\",\"error_description\":\"User denied\"}");

            try {
                RegisterApp.register(RegisterAppOptions.newBuilder()
                        .domain(server.baseUrl())
                        .onQRCode(info -> {
                        })
                        .build());
                fail("Expected AccessDeniedException");
            } catch (AccessDeniedException e) {
                assertEquals("access_denied", e.getCode());
                assertEquals("User denied", e.getDescription());
            }
        } finally {
            server.close();
        }
    }

    @Test
    public void testRegisterAppThrowsInvalidResponseWhenErrorMissing() throws Exception {
        RegistrationTestServer server = new RegistrationTestServer();
        try {
            server.enqueueBegin(
                    200,
                    "{\"device_code\":\"dev_code\",\"verification_uri_complete\":\""
                            + server.baseUrl()
                            + "/verify\",\"interval\":1,\"expire_in\":600}"
            );
            server.enqueuePoll(200, "{}");

            try {
                RegisterApp.register(RegisterAppOptions.newBuilder()
                        .domain(server.baseUrl())
                        .onQRCode(info -> {
                        })
                        .build());
                fail("Expected RegisterAppException");
            } catch (RegisterAppException e) {
                assertEquals("invalid_response", e.getCode());
                assertEquals("missing client credentials", e.getDescription());
            }
        } finally {
            server.close();
        }
    }

    @Test
    public void testRegisterAppThrowsAbortWhenThreadInterrupted() throws Exception {
        Thread.currentThread().interrupt();
        try {
            try {
                RegisterApp.register(RegisterAppOptions.newBuilder()
                        .onQRCode(info -> {
                        })
                        .build());
                fail("Expected RegisterAppException");
            } catch (RegisterAppException e) {
                assertEquals("abort", e.getCode());
                assertEquals("Registration was aborted", e.getDescription());
            }
        } finally {
            Thread.interrupted();
        }
    }

    private static class RegistrationTestServer {
        private final HttpServer server;
        private final Queue<QueuedResponse> beginResponses = new ConcurrentLinkedQueue<>();
        private final Queue<QueuedResponse> pollResponses = new ConcurrentLinkedQueue<>();
        private final List<Map<String, String>> beginRequests = new ArrayList<>();
        private final List<Map<String, String>> pollRequests = new ArrayList<>();

        RegistrationTestServer() throws IOException {
            this.server = HttpServer.create(new InetSocketAddress(0), 0);
            this.server.createContext("/oauth/v1/app/registration", new RegistrationHandler());
            this.server.start();
        }

        String baseUrl() {
            return "http://127.0.0.1:" + server.getAddress().getPort();
        }

        void enqueueBegin(int statusCode, String body) {
            beginResponses.add(new QueuedResponse(statusCode, body));
        }

        void enqueuePoll(int statusCode, String body) {
            pollResponses.add(new QueuedResponse(statusCode, body));
        }

        List<Map<String, String>> beginRequests() {
            return beginRequests;
        }

        List<Map<String, String>> pollRequests() {
            return pollRequests;
        }

        void close() {
            server.stop(0);
        }

        private class RegistrationHandler implements HttpHandler {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String body = readBody(exchange.getRequestBody());
                Map<String, String> form = parseForm(body);
                String action = form.get("action");
                QueuedResponse response;

                if ("begin".equals(action)) {
                    beginRequests.add(form);
                    response = beginResponses.poll();
                } else if ("poll".equals(action)) {
                    pollRequests.add(form);
                    response = pollResponses.poll();
                } else {
                    response = new QueuedResponse(400, "{\"error\":\"invalid_action\"}");
                }

                if (response == null) {
                    response = new QueuedResponse(500, "{\"error\":\"missing_fixture\"}");
                }

                byte[] bytes = response.body.getBytes(StandardCharsets.UTF_8);
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(response.statusCode, bytes.length);
                try (OutputStream outputStream = exchange.getResponseBody()) {
                    outputStream.write(bytes);
                }
            }
        }

        private static String readBody(InputStream inputStream) throws IOException {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[256];
            int read;
            while ((read = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, read);
            }
            return outputStream.toString(StandardCharsets.UTF_8.name());
        }

        private static Map<String, String> parseForm(String formBody) throws IOException {
            Map<String, String> result = new LinkedHashMap<>();
            if (formBody == null || formBody.isEmpty()) {
                return result;
            }
            String[] pairs = formBody.split("&");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=", 2);
                String key = URLDecoder.decode(keyValue[0], StandardCharsets.UTF_8.name());
                String value = keyValue.length > 1
                        ? URLDecoder.decode(keyValue[1], StandardCharsets.UTF_8.name())
                        : "";
                result.put(key, value);
            }
            return result;
        }
    }

    private static class QueuedResponse {
        private final int statusCode;
        private final String body;

        private QueuedResponse(int statusCode, String body) {
            this.statusCode = statusCode;
            this.body = body;
        }
    }
}
