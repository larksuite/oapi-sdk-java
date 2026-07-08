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

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.lark.oapi.okhttp.HttpUrl;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.zip.GZIPInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TestRegisterApp {

    private static HttpUrl captureQRCodeUrl(AppPreset appPreset, String source) throws Exception {
        return captureQRCodeUrl(RegisterAppOptions.newBuilder()
                .source(source)
                .appPreset(appPreset));
    }

    private static HttpUrl captureQRCodeUrl(RegisterAppOptions.Builder optionsBuilder) throws Exception {
        RegistrationTestServer server = new RegistrationTestServer();
        try {
            server.enqueueBegin(
                    200,
                    "{\"device_code\":\"dev_code\",\"verification_uri_complete\":\""
                            + server.baseUrl()
                            + "/verify?foo=bar\",\"interval\":1,\"expire_in\":600}"
            );
            server.enqueuePoll(
                    200,
                    "{\"client_id\":\"cli_123\",\"client_secret\":\"sec_456\","
                            + "\"user_info\":{\"open_id\":\"ou_abc\",\"tenant_brand\":\"feishu\"}}"
            );

            List<QRCodeInfo> qrCodes = new ArrayList<>();
            RegisterApp.register(optionsBuilder
                    .domain(server.baseUrl())
                    .onQRCode(qrCodes::add)
                    .build());

            assertEquals(1, qrCodes.size());
            return HttpUrl.get(qrCodes.get(0).getUrl());
        } finally {
            server.close();
        }
    }

    private static void assertInvalidAppPreset(AppPreset appPreset, String expectedDescription) throws Exception {
        RegistrationTestServer server = new RegistrationTestServer();
        try {
            server.enqueueBegin(
                    200,
                    "{\"device_code\":\"dev_code\",\"verification_uri_complete\":\""
                            + server.baseUrl()
                            + "/verify\",\"interval\":1,\"expire_in\":600}"
            );

            try {
                RegisterApp.register(RegisterAppOptions.newBuilder()
                        .domain(server.baseUrl())
                        .appPreset(appPreset)
                        .onQRCode(info -> {
                        })
                        .build());
                fail("Expected RegisterAppException");
            } catch (RegisterAppException e) {
                assertEquals("invalid_argument", e.getCode());
                assertEquals(expectedDescription, e.getDescription());
            }
        } finally {
            server.close();
        }
    }

    private static void assertInvalidOptions(RegisterAppOptions.Builder optionsBuilder, String expectedDescription)
            throws Exception {
        RegistrationTestServer server = new RegistrationTestServer();
        try {
            server.enqueueBegin(
                    200,
                    "{\"device_code\":\"dev_code\",\"verification_uri_complete\":\""
                            + server.baseUrl()
                            + "/verify\",\"interval\":1,\"expire_in\":600}"
            );

            try {
                RegisterApp.register(optionsBuilder
                        .domain(server.baseUrl())
                        .onQRCode(info -> {
                        })
                        .build());
                fail("Expected RegisterAppException");
            } catch (RegisterAppException e) {
                assertEquals("invalid_argument", e.getCode());
                assertEquals(expectedDescription, e.getDescription());
            }
        } finally {
            server.close();
        }
    }

    private static void assertInvalidOptionsWithoutRequest(RegisterAppOptions.Builder optionsBuilder,
                                                           String expectedDescription) throws Exception {
        try {
            RegisterApp.register(optionsBuilder
                    .onQRCode(info -> {
                    })
                    .build());
            fail("Expected RegisterAppException");
        } catch (RegisterAppException e) {
            assertEquals("invalid_argument", e.getCode());
            assertEquals(expectedDescription, e.getDescription());
        }
    }

    private static JsonElement decodeAddonsParam(HttpUrl url) throws IOException {
        String encoded = url.queryParameter("addons");
        assertNotNull(encoded);
        int paddingLength = (4 - encoded.length() % 4) % 4;
        String padded = encoded + "====".substring(0, paddingLength);
        byte[] compressed = Base64.getUrlDecoder().decode(padded);

        try (GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(compressed));
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[256];
            int read;
            while ((read = gzipInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, read);
            }
            return JsonParser.parseString(outputStream.toString(StandardCharsets.UTF_8.name()));
        }
    }

    private static JsonElement json(String value) {
        return JsonParser.parseString(value);
    }

    @Test
    public void testRegisterAppOmitsAppPresetWhenNotProvided() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(null, null);

        assertEquals("bar", qrUrl.queryParameter("foo"));
        assertEquals("sdk", qrUrl.queryParameter("from"));
        assertEquals("java-sdk", qrUrl.queryParameter("source"));
        assertEquals("sdk", qrUrl.queryParameter("tp"));
        assertTrue(qrUrl.queryParameterValues("avatar").isEmpty());
        assertEquals(null, qrUrl.queryParameter("name"));
        assertEquals(null, qrUrl.queryParameter("desc"));
        assertEquals(null, qrUrl.queryParameter("addons"));
        assertEquals(null, qrUrl.queryParameter("createOnly"));
        assertEquals(null, qrUrl.queryParameter("clientID"));
    }

    @Test
    public void testRegisterAppAcceptsSingleAvatar() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(AppPreset.newBuilder()
                .avatar("https://example.com/a.png")
                .build(), null);

        assertEquals(Arrays.asList("https://example.com/a.png"), qrUrl.queryParameterValues("avatar"));
    }

    @Test
    public void testRegisterAppAcceptsMultipleAvatarsAndPreservesOrder() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(AppPreset.newBuilder()
                .avatars(
                        "https://example.com/a.png",
                        "https://example.com/b.webp",
                        "https://example.com/c.gif"
                )
                .build(), null);

        assertEquals(Arrays.asList(
                "https://example.com/a.png",
                "https://example.com/b.webp",
                "https://example.com/c.gif"
        ), qrUrl.queryParameterValues("avatar"));
    }

    @Test
    public void testRegisterAppAcceptsExactlySixAvatars() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(AppPreset.newBuilder()
                .avatars(
                        "https://example.com/0.png",
                        "https://example.com/1.png",
                        "https://example.com/2.png",
                        "https://example.com/3.png",
                        "https://example.com/4.png",
                        "https://example.com/5.png"
                )
                .build(), null);

        assertEquals(6, qrUrl.queryParameterValues("avatar").size());
        assertEquals("https://example.com/0.png", qrUrl.queryParameterValues("avatar").get(0));
        assertEquals("https://example.com/5.png", qrUrl.queryParameterValues("avatar").get(5));
    }

    @Test
    public void testRegisterAppUrlEncodesNameWithUserPlaceholder() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(AppPreset.newBuilder()
                .name("{user}的应用")
                .build(), null);

        assertEquals("{user}的应用", qrUrl.queryParameter("name"));
        assertTrue(qrUrl.toString().contains("name=%7Buser%7D%E7%9A%84%E5%BA%94%E7%94%A8"));
    }

    @Test
    public void testRegisterAppUrlEncodesDesc() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(AppPreset.newBuilder()
                .desc("由业务平台自动生成")
                .build(), null);

        assertEquals("由业务平台自动生成", qrUrl.queryParameter("desc"));
        assertTrue(qrUrl.toString().contains(
                "desc=%E7%94%B1%E4%B8%9A%E5%8A%A1%E5%B9%B3%E5%8F%B0%E8%87%AA%E5%8A%A8%E7%94%9F%E6%88%90"
        ));
    }

    @Test
    public void testRegisterAppEmitsAllPresetFieldsTogether() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(AppPreset.newBuilder()
                .avatars("https://example.com/a.png", "https://example.com/b.png")
                .name("MyApp")
                .desc("demo")
                .build(), null);

        assertEquals(Arrays.asList(
                "https://example.com/a.png",
                "https://example.com/b.png"
        ), qrUrl.queryParameterValues("avatar"));
        assertEquals("MyApp", qrUrl.queryParameter("name"));
        assertEquals("demo", qrUrl.queryParameter("desc"));
    }

    @Test
    public void testRegisterAppAppPresetDoesNotInterfereWithSource() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(AppPreset.newBuilder()
                .name("X")
                .build(), "lark-cli");

        assertEquals("java-sdk/lark-cli", qrUrl.queryParameter("source"));
        assertEquals("X", qrUrl.queryParameter("name"));
        assertEquals("sdk", qrUrl.queryParameter("from"));
        assertEquals("sdk", qrUrl.queryParameter("tp"));
    }

    @Test
    public void testRegisterAppRejectsEmptyAvatarList() throws Exception {
        assertInvalidAppPreset(AppPreset.newBuilder()
                        .avatars(Collections.<String>emptyList())
                        .build(),
                "appPreset.avatar must contain at least 1 URL");
    }

    @Test
    public void testRegisterAppRejectsMoreThanSixAvatars() throws Exception {
        assertInvalidAppPreset(AppPreset.newBuilder()
                        .avatars(
                                "https://example.com/0.png",
                                "https://example.com/1.png",
                                "https://example.com/2.png",
                                "https://example.com/3.png",
                                "https://example.com/4.png",
                                "https://example.com/5.png",
                                "https://example.com/6.png"
                        )
                        .build(),
                "appPreset.avatar supports at most 6 URLs, got 7");
    }

    @Test
    public void testRegisterAppRejectsEmptyAvatarString() throws Exception {
        assertInvalidAppPreset(AppPreset.newBuilder()
                        .avatar("")
                        .build(),
                "appPreset.avatar[0] must be a non-empty string");
    }

    @Test
    public void testRegisterAppRejectsEmptyAvatarEntryWithIndex() throws Exception {
        assertInvalidAppPreset(AppPreset.newBuilder()
                        .avatars("https://example.com/a.png", "")
                        .build(),
                "appPreset.avatar[1] must be a non-empty string");
    }

    @Test
    public void testRegisterAppRejectsNullAvatarEntryWithIndex() throws Exception {
        assertInvalidAppPreset(AppPreset.newBuilder()
                        .avatars(Arrays.asList("https://example.com/a.png", null))
                        .build(),
                "appPreset.avatar[1] must be a non-empty string");
    }

    @Test
    public void testRegisterAppEncodesAddonsIntoUrlSafeParam() throws Exception {
        AppAddons addons = AppAddons.newBuilder()
                .tenantScopes("im:message:send_as_bot")
                .userScopes("calendar:calendar:read")
                .tenantEvents("im.message.receive_v1")
                .userEvents("calendar.calendar.event.changed_v4")
                .callbacks("card.action.trigger")
                .build();

        HttpUrl qrUrl = captureQRCodeUrl(RegisterAppOptions.newBuilder()
                .addons(addons));

        assertTrue(qrUrl.queryParameter("addons").matches("^[A-Za-z0-9_-]+$"));
        assertEquals(json("{"
                        + "\"scopes\":{"
                        + "\"tenant\":[\"im:message:send_as_bot\"],"
                        + "\"user\":[\"calendar:calendar:read\"]"
                        + "},"
                        + "\"events\":{\"items\":{"
                        + "\"tenant\":[\"im.message.receive_v1\"],"
                        + "\"user\":[\"calendar.calendar.event.changed_v4\"]"
                        + "}},"
                        + "\"callbacks\":{\"items\":[\"card.action.trigger\"]}"
                        + "}"),
                decodeAddonsParam(qrUrl));
    }

    @Test
    public void testRegisterAppAddonsCoexistsWithPresetAndCreateOnly() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(RegisterAppOptions.newBuilder()
                .addons(AppAddons.newBuilder()
                        .tenantScopes("im:message:send_as_bot")
                        .build())
                .appPreset(AppPreset.newBuilder()
                        .name("MyApp")
                        .build())
                .createOnly(true));

        assertEquals(json("{\"scopes\":{\"tenant\":[\"im:message:send_as_bot\"]}}"),
                decodeAddonsParam(qrUrl));
        assertEquals("MyApp", qrUrl.queryParameter("name"));
        assertEquals("true", qrUrl.queryParameter("createOnly"));
    }

    @Test
    public void testRegisterAppRejectsEmptyAddons() throws Exception {
        assertInvalidOptions(RegisterAppOptions.newBuilder()
                        .addons(AppAddons.newBuilder().build()),
                "addons must contain at least one scope, event or callback, or set preset to false");
    }

    @Test
    public void testRegisterAppRejectsEmptyAddonsItemWithIndex() throws Exception {
        assertInvalidOptions(RegisterAppOptions.newBuilder()
                        .addons(AppAddons.newBuilder()
                                .callbacks("card.action.trigger", "")
                                .build()),
                "addons.callbacks.items[1] must be a non-empty string");
    }

    @Test
    public void testRegisterAppEncodesPresetFalseAddonsWithoutIncrementalItems() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(RegisterAppOptions.newBuilder()
                .addons(AppAddons.newBuilder()
                        .preset(false)
                        .build()));

        assertEquals(json("{\"preset\":false}"), decodeAddonsParam(qrUrl));
    }

    @Test
    public void testRegisterAppEncodesPresetFalseAlongsideIncrementalItems() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(RegisterAppOptions.newBuilder()
                .addons(AppAddons.newBuilder()
                        .preset(false)
                        .tenantScopes("im:message:send_as_bot")
                        .build()));

        assertEquals(json("{"
                        + "\"preset\":false,"
                        + "\"scopes\":{\"tenant\":[\"im:message:send_as_bot\"]}"
                        + "}"),
                decodeAddonsParam(qrUrl));
    }

    @Test
    public void testRegisterAppEncodesPresetTrueVerbatim() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(RegisterAppOptions.newBuilder()
                .addons(AppAddons.newBuilder()
                        .preset(true)
                        .tenantScopes("im:message:send_as_bot")
                        .build()));

        assertEquals(json("{"
                        + "\"preset\":true,"
                        + "\"scopes\":{\"tenant\":[\"im:message:send_as_bot\"]}"
                        + "}"),
                decodeAddonsParam(qrUrl));
    }

    @Test
    public void testRegisterAppOmitsPresetKeyWhenNotConfigured() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(RegisterAppOptions.newBuilder()
                .addons(AppAddons.newBuilder()
                        .tenantScopes("im:message:send_as_bot")
                        .build()));

        JsonElement decoded = decodeAddonsParam(qrUrl);
        assertFalse(decoded.getAsJsonObject().has("preset"));
        assertEquals(json("{\"scopes\":{\"tenant\":[\"im:message:send_as_bot\"]}}"), decoded);
    }

    @Test
    public void testRegisterAppRejectsPresetTrueWithoutIncrementalItems() throws Exception {
        assertInvalidOptions(RegisterAppOptions.newBuilder()
                        .addons(AppAddons.newBuilder()
                                .preset(true)
                                .build()),
                "addons must contain at least one scope, event or callback, or set preset to false");
    }

    @Test
    public void testRegisterAppRejectsEmptyScopeStringEvenWithPresetFalse() throws Exception {
        assertInvalidOptions(RegisterAppOptions.newBuilder()
                        .addons(AppAddons.newBuilder()
                                .preset(false)
                                .tenantScopes("")
                                .build()),
                "addons.scopes.tenant[0] must be a non-empty string");
    }

    @Test
    public void testAppAddonsPresetGetterMirrorsBuilderState() {
        assertNull(AppAddons.newBuilder().build().getPreset());
        assertEquals(Boolean.FALSE, AppAddons.newBuilder().preset(false).build().getPreset());
        assertEquals(Boolean.TRUE, AppAddons.newBuilder().preset(true).build().getPreset());
    }

    @Test
    public void testRegisterAppSetsClientIdFromAppId() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(RegisterAppOptions.newBuilder()
                .appId("cli_a1b2c3"));

        assertEquals("cli_a1b2c3", qrUrl.queryParameter("clientID"));
    }

    @Test
    public void testRegisterAppCombinesAppIdWithAddons() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(RegisterAppOptions.newBuilder()
                .appId("cli_a1b2c3")
                .addons(AppAddons.newBuilder()
                        .tenantScopes("drive:drive.metadata:readonly")
                        .build()));

        assertEquals("cli_a1b2c3", qrUrl.queryParameter("clientID"));
        assertEquals(json("{\"scopes\":{\"tenant\":[\"drive:drive.metadata:readonly\"]}}"),
                decodeAddonsParam(qrUrl));
    }

    @Test
    public void testRegisterAppRejectsEmptyAppId() throws Exception {
        assertInvalidOptionsWithoutRequest(RegisterAppOptions.newBuilder()
                        .appId(""),
                "appId must be a non-empty string");
    }

    @Test
    public void testRegisterAppSetsCreateOnlyWhenEnabled() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(RegisterAppOptions.newBuilder()
                .createOnly(true));

        assertEquals("true", qrUrl.queryParameter("createOnly"));
    }

    @Test
    public void testRegisterAppOmitsCreateOnlyWhenDisabled() throws Exception {
        HttpUrl qrUrl = captureQRCodeUrl(RegisterAppOptions.newBuilder()
                .createOnly(false));

        assertEquals(null, qrUrl.queryParameter("createOnly"));
    }

    @Test
    public void testRegisterAppEndToEndWithAppPreset() throws Exception {
        RegistrationTestServer server = new RegistrationTestServer();
        try {
            server.enqueueBegin(
                    200,
                    "{\"device_code\":\"dev_code\",\"verification_uri_complete\":\""
                            + server.baseUrl()
                            + "/verify?foo=bar\",\"interval\":1,\"expire_in\":600}"
            );
            server.enqueuePoll(
                    200,
                    "{\"client_id\":\"cli_123\",\"client_secret\":\"sec_456\","
                            + "\"user_info\":{\"open_id\":\"ou_abc\",\"tenant_brand\":\"feishu\"}}"
            );

            List<QRCodeInfo> qrCodes = new ArrayList<>();
            RegisterAppResult result = RegisterApp.register(RegisterAppOptions.newBuilder()
                    .domain(server.baseUrl())
                    .appPreset(AppPreset.newBuilder()
                            .avatars("https://example.com/a.png", "https://example.com/b.webp")
                            .name("{user}的应用")
                            .desc("由业务平台自动生成")
                            .build())
                    .onQRCode(qrCodes::add)
                    .build());

            assertEquals("cli_123", result.getClientId());
            assertEquals("sec_456", result.getClientSecret());
            assertNotNull(result.getUserInfo());
            assertEquals("ou_abc", result.getUserInfo().getOpenId());
            assertEquals("feishu", result.getUserInfo().getTenantBrand());
            assertEquals(1, qrCodes.size());

            HttpUrl qrUrl = HttpUrl.get(qrCodes.get(0).getUrl());
            assertEquals("bar", qrUrl.queryParameter("foo"));
            assertEquals("sdk", qrUrl.queryParameter("from"));
            assertEquals("java-sdk", qrUrl.queryParameter("source"));
            assertEquals("sdk", qrUrl.queryParameter("tp"));
            assertEquals(Arrays.asList(
                    "https://example.com/a.png",
                    "https://example.com/b.webp"
            ), qrUrl.queryParameterValues("avatar"));
            assertEquals("{user}的应用", qrUrl.queryParameter("name"));
            assertEquals("由业务平台自动生成", qrUrl.queryParameter("desc"));
        } finally {
            server.close();
        }
    }

    @Test
    public void testRegisterAppEndToEndWithAppPresetAndLarkSwitch() throws Exception {
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
                    .appPreset(AppPreset.newBuilder()
                            .avatar("https://example.com/a.png")
                            .name("MyApp")
                            .build())
                    .onQRCode(qrCodes::add)
                    .onStatusChange(info -> statuses.add(info.getStatus()))
                    .build());

            assertEquals("cli_123", result.getClientId());
            assertEquals("sec_456", result.getClientSecret());
            assertEquals(Arrays.asList(StatusChangeInfo.DOMAIN_SWITCHED), statuses);
            assertEquals(1, qrCodes.size());

            HttpUrl qrUrl = HttpUrl.get(qrCodes.get(0).getUrl());
            assertEquals("java-sdk/cli-tool", qrUrl.queryParameter("source"));
            assertEquals(Arrays.asList("https://example.com/a.png"), qrUrl.queryParameterValues("avatar"));
            assertEquals("MyApp", qrUrl.queryParameter("name"));
        } finally {
            feishuServer.close();
            larkServer.close();
        }
    }

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
