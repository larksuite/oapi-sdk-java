package com.lark.oapi.event;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lark.oapi.core.request.EventReq;
import com.lark.oapi.core.response.EventResp;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Base64;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import com.lark.oapi.core.Constants;
import com.lark.oapi.event.cardcallback.P2CardActionTriggerHandler;
import com.lark.oapi.event.cardcallback.model.P2CardActionTrigger;
import com.lark.oapi.event.cardcallback.model.P2CardActionTriggerResponse;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestWebhookVerificationToken {
    private String payload(String schema, String token) {
        JsonObject body = new JsonObject();
        JsonObject event = new JsonObject();
        JsonObject target = body;
        if ("v2".equals(schema)) {
            body.addProperty("schema", "2.0");
            target = new JsonObject();
            target.addProperty("event_type", "audit.test");
            body.add("header", target);
            body.add("event", event);
        } else if ("challenge".equals(schema)) {
            body.addProperty("type", "url_verification");
            body.addProperty("challenge", "fixture");
        } else {
            body.addProperty("uuid", "audit-id");
            body.addProperty("type", "event_callback");
            event.addProperty("type", "audit.test");
            body.add("event", event);
        }
        if (token != null) { target.add("token", new JsonParser().parse(token)); }
        return body.toString();
    }

    private EventReq request(String body) {
        EventReq req = new EventReq();
        req.setHttpPath("/audit");
        req.setHeaders(new HashMap<>());
        req.setBody(body.getBytes(StandardCharsets.UTF_8));
        return req;
    }

    private EventDispatcher dispatcher(String token, final int[] hits) {
        return EventDispatcher.newBuilder(token, "").onCustomizedEvent("audit.test", new CustomEventHandler() {
            @Override public void handle(EventReq req) { hits[0]++; }
        }).build();
    }

    @Test public void verifiesPlaintextTokensBeforeDispatch() throws Throwable {
        String[] tokens = {"\"audit-fixture\"", "\"wrong\"", null, "null", "\"\"", "123", "{}", "[]"};
        for (String schema : new String[]{"v1", "v2", "challenge"}) {
            for (String token : tokens) {
                int[] hits = {0};
                EventResp resp = dispatcher("audit-fixture", hits).handle(request(payload(schema, token)));
                boolean allowed = "\"audit-fixture\"".equals(token);
                assertEquals(schema + " authentication outcome", allowed, resp.getStatusCode() == 200);
                assertEquals(schema + " handler calls", allowed && !"challenge".equals(schema) ? 1 : 0, hits[0]);
            }
        }
    }

    @Test public void preservesEmptyConfiguration() throws Throwable {
        for (String configured : new String[]{null, ""}) {
            for (String schema : new String[]{"v1", "v2", "challenge"}) {
                for (String token : new String[]{null, "null", "\"\"", "\"wrong\""}) {
                    int[] hits = {0};
                    EventResp resp = dispatcher(configured, hits).handle(request(payload(schema, token)));
                    boolean allowed = !"challenge".equals(schema) || ("".equals(configured) && "\"\"".equals(token));
                    assertEquals("legacy authentication outcome", allowed, resp.getStatusCode() == 200);
                    assertEquals("legacy handler calls", allowed && !"challenge".equals(schema) ? 1 : 0, hits[0]);
                }
            }
        }
    }

    @Test public void rejectsNumericTokenEvenWhenConfigurationLooksNumeric() throws Throwable {
        int[] hits = {0};
        EventResp resp = dispatcher("123", hits).handle(request(payload("v2", "123")));
        assertTrue(resp.getStatusCode() != 200);
        assertEquals(0, hits[0]);
    }

    @Test public void trustedDispatchDoesNotRequireWebhookToken() throws Throwable {
        int[] hits = {0};
        dispatcher("", hits).doWithoutValidation(payload("v2", null).getBytes(StandardCharsets.UTF_8));
        assertEquals(1, hits[0]);
    }
    @Test public void encryptedWebhookPreservesSignatureValidation() throws Throwable {
        String key = "encryption-fixture";
        byte[] iv = new byte[16];
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(MessageDigest.getInstance("SHA-256").digest(key.getBytes(StandardCharsets.UTF_8)), "AES"), new IvParameterSpec(iv));
        byte[] encrypted = cipher.doFinal(payload("v2", null).getBytes(StandardCharsets.UTF_8));
        byte[] wire = new byte[iv.length + encrypted.length];
        System.arraycopy(iv, 0, wire, 0, iv.length);
        System.arraycopy(encrypted, 0, wire, iv.length, encrypted.length);
        JsonObject envelope = new JsonObject();
        envelope.addProperty("encrypt", Base64.getEncoder().encodeToString(wire));
        for (boolean valid : new boolean[]{true, false}) {
            final int[] hits = {0};
            EventDispatcher dispatcher = EventDispatcher.newBuilder("", key).onCustomizedEvent("audit.test", new CustomEventHandler() {
                @Override public void handle(EventReq req) { hits[0]++; }
            }).build();
            EventReq req = request(envelope.toString());
            req.getHeaders().put(Constants.X_LARK_REQUEST_TIMESTAMP.toLowerCase(), Arrays.asList("timestamp"));
            req.getHeaders().put(Constants.X_LARK_REQUEST_NONCE.toLowerCase(), Arrays.asList("nonce"));
            req.getHeaders().put(Constants.X_LARK_SIGNATURE.toLowerCase(), Arrays.asList(valid ? dispatcher.calculateSignature("timestamp", "nonce", key, envelope.toString()) : "wrong"));
            EventResp resp = dispatcher.handle(req);
            assertEquals(valid, resp.getStatusCode() == 200);
            assertEquals(valid ? 1 : 0, hits[0]);
        }
    }

    @Test public void v2DoesNotFallBackToTopLevelToken() throws Throwable {
        int[] hits = {0};
        JsonObject body = new JsonParser().parse(payload("v2", null)).getAsJsonObject();
        body.addProperty("token", "audit-fixture");
        EventResp resp = dispatcher("audit-fixture", hits).handle(request(body.toString()));
        assertTrue(resp.getStatusCode() != 200);
        assertEquals(0, hits[0]);
    }

    @Test public void callbacksVerifyTokenBeforeHandler() throws Throwable {
        for (boolean valid : new boolean[]{true, false}) {
            final int[] hits = {0};
            EventDispatcher dispatcher = EventDispatcher.newBuilder("audit-fixture", "").onP2CardActionTrigger(new P2CardActionTriggerHandler() {
                @Override public P2CardActionTriggerResponse handle(P2CardActionTrigger event) { hits[0]++; return new P2CardActionTriggerResponse(); }
            }).build();
            JsonObject body = new JsonParser().parse(payload("v2", valid ? "\"audit-fixture\"" : "\"wrong\"")).getAsJsonObject();
            body.getAsJsonObject("header").addProperty("event_type", "card.action.trigger");
            EventResp resp = dispatcher.handle(request(body.toString()));
            assertEquals(valid, resp.getStatusCode() == 200);
            assertEquals(valid ? 1 : 0, hits[0]);
        }
    }

}
