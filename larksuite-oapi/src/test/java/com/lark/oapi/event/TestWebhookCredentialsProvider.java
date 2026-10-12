package com.lark.oapi.event;

import com.lark.oapi.core.Constants;
import com.lark.oapi.core.request.EventReq;
import com.lark.oapi.core.response.EventResp;
import com.lark.oapi.event.cardcallback.P2CardActionTriggerHandler;
import com.lark.oapi.event.cardcallback.model.P2CardActionTrigger;
import com.lark.oapi.event.cardcallback.model.P2CardActionTriggerResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import static org.junit.Assert.*;

public class TestWebhookCredentialsProvider {
  private String payload(String token) {
    return "{\"schema\":\"2.0\",\"header\":{\"event_type\":\"audit.test\",\"token\":\"" + token + "\"},\"event\":{}}";
  }

  private EventReq request(String body) {
    EventReq req = new EventReq();
    req.setHttpPath("/provider-test");
    req.setHeaders(new HashMap<>());
    req.setBody(body.getBytes(StandardCharsets.UTF_8));
    return req;
  }

  private EventDispatcher dispatcher(WebhookCredentialsProvider provider, AtomicInteger hits) {
    return EventDispatcher.newBuilder("static-token", "").webhookCredentialsProvider(provider)
        .onCustomizedEvent("audit.test", new CustomEventHandler() {
          @Override public void handle(EventReq req) { hits.incrementAndGet(); }
        }).build();
  }

  @Test public void readsOnceAndRotatesBetweenRequests() throws Throwable {
    AtomicInteger reads = new AtomicInteger();
    AtomicInteger hits = new AtomicInteger();
    AtomicReference<WebhookCredentials> current = new AtomicReference<>(new WebhookCredentials("", "first"));
    EventDispatcher dispatcher = dispatcher(() -> { reads.incrementAndGet(); return current.get(); }, hits);
    assertEquals(0, reads.get());
    assertEquals(200, dispatcher.handle(request(payload("first"))).getStatusCode());
    current.set(new WebhookCredentials("", "second"));
    assertEquals(200, dispatcher.handle(request(payload("second"))).getStatusCode());
    assertEquals(2, reads.get());
    assertEquals(2, hits.get());
    dispatcher.doWithoutValidation(payload("ignored").getBytes(StandardCharsets.UTF_8));
    assertEquals(2, reads.get());
    assertEquals(3, hits.get());
  }

  @Test public void challengeAndCallbackReadOnce() throws Throwable {
    AtomicInteger reads = new AtomicInteger();
    AtomicInteger hits = new AtomicInteger();
    EventDispatcher dispatcher = EventDispatcher.newBuilder("static-token", "")
        .webhookCredentialsProvider(() -> { reads.incrementAndGet(); return new WebhookCredentials("", "dynamic"); })
        .onP2CardActionTrigger(new P2CardActionTriggerHandler() {
          @Override public P2CardActionTriggerResponse handle(P2CardActionTrigger event) {
            hits.incrementAndGet(); return new P2CardActionTriggerResponse();
          }
        }).build();
    assertEquals(200, dispatcher.handle(request("{\"type\":\"url_verification\",\"token\":\"dynamic\",\"challenge\":\"fixture\"}")).getStatusCode());
    assertEquals(1, reads.get());
    assertEquals(200, dispatcher.handle(request(payload("dynamic").replace("audit.test", "card.action.trigger"))).getStatusCode());
    assertEquals(2, reads.get());
    assertEquals(1, hits.get());
  }

  @Test public void failuresAreSanitizedAndNeverFallback() throws Throwable {
    Logger logger = (Logger) LoggerFactory.getLogger(EventDispatcher.class);
    ListAppender<ILoggingEvent> logs = new ListAppender<>();
    logs.start();
    logger.addAppender(logs);
    try {
    for (WebhookCredentialsProvider provider : new WebhookCredentialsProvider[]{
        () -> { throw new IllegalStateException("SECRET-provider-text"); },
        () -> { throw new AssertionError("SECRET-provider-text"); },
        () -> null, () -> new WebhookCredentials(null, ""),
        () -> new WebhookCredentials("", null)}) {
      AtomicInteger hits = new AtomicInteger();
      EventResp response = dispatcher(provider, hits).handle(request(payload("static-token")));
      assertEquals(500, response.getStatusCode());
      assertEquals(0, hits.get());
      String body = new String(response.getBody(), StandardCharsets.UTF_8);
      assertTrue(body.contains("webhook credentials provider failed"));
      assertFalse(body.contains("SECRET"));
    }
    for (ILoggingEvent entry : logs.list) {
      assertFalse(entry.getFormattedMessage().contains("SECRET"));
      if (entry.getThrowableProxy() != null) {
        assertFalse(entry.getThrowableProxy().getMessage().contains("SECRET"));
        assertNull(entry.getThrowableProxy().getCause());
      }
    }
    } finally {
      logger.detachAppender(logs);
      logs.stop();
    }
  }

  @Test public void successfulEmptyUsesStaticEmptyBehavior() throws Throwable {
    AtomicInteger hits = new AtomicInteger();
    EventDispatcher dynamic = dispatcher(() -> new WebhookCredentials("", ""), hits);
    EventDispatcher empty = EventDispatcher.newBuilder("", "").build();
    assertEquals(200, dynamic.handle(request(payload("ignored"))).getStatusCode());
    for (String token : new String[]{"", "wrong"}) {
      String body = "{\"type\":\"url_verification\",\"token\":\"" + token + "\",\"challenge\":\"fixture\"}";
      assertEquals(empty.handle(request(body)).getStatusCode(), dynamic.handle(request(body)).getStatusCode());
    }
    assertEquals(1, hits.get());
  }

  @Test public void encryptedRequestUsesOneKeySnapshot() throws Throwable {
    String key = "encryption-fixture";
    byte[] iv = new byte[16];
    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(MessageDigest.getInstance("SHA-256").digest(key.getBytes(StandardCharsets.UTF_8)), "AES"), new IvParameterSpec(iv));
    byte[] encrypted = cipher.doFinal(payload("ignored").getBytes(StandardCharsets.UTF_8));
    byte[] wire = new byte[16 + encrypted.length];
    System.arraycopy(encrypted, 0, wire, 16, encrypted.length);
    String body = "{\"encrypt\":\"" + Base64.getEncoder().encodeToString(wire) + "\"}";
    AtomicInteger reads = new AtomicInteger();
    AtomicInteger hits = new AtomicInteger();
    EventDispatcher dispatcher = dispatcher(() -> new WebhookCredentials(reads.incrementAndGet() == 1 ? key : "wrong-key", ""), hits);
    EventReq req = request(body);
    req.getHeaders().put(Constants.X_LARK_REQUEST_TIMESTAMP.toLowerCase(), Arrays.asList("timestamp"));
    req.getHeaders().put(Constants.X_LARK_REQUEST_NONCE.toLowerCase(), Arrays.asList("nonce"));
    req.getHeaders().put(Constants.X_LARK_SIGNATURE.toLowerCase(), Arrays.asList(dispatcher.calculateSignature("timestamp", "nonce", key, body)));
    assertEquals(200, dispatcher.handle(req).getStatusCode());
    assertEquals(1, reads.get());
    assertEquals(1, hits.get());
  }

  @Test public void concurrentRequestsKeepIndependentSnapshots() throws Exception {
    ThreadLocal<String> token = new ThreadLocal<>();
    CyclicBarrier barrier = new CyclicBarrier(2);
    AtomicInteger reads = new AtomicInteger();
    AtomicInteger hits = new AtomicInteger();
    EventDispatcher dispatcher = dispatcher(() -> {
      WebhookCredentials credentials = new WebhookCredentials("", token.get());
      reads.incrementAndGet();
      barrier.await(5, TimeUnit.SECONDS);
      return credentials;
    }, hits);
    ExecutorService executor = Executors.newFixedThreadPool(2);
    try {
      Future<Integer> first = executor.submit(() -> process(dispatcher, token, "first"));
      Future<Integer> second = executor.submit(() -> process(dispatcher, token, "second"));
      assertEquals(Integer.valueOf(200), first.get(10, TimeUnit.SECONDS));
      assertEquals(Integer.valueOf(200), second.get(10, TimeUnit.SECONDS));
      assertEquals(2, reads.get());
      assertEquals(2, hits.get());
    } finally {
      executor.shutdownNow();
      assertTrue(executor.awaitTermination(5, TimeUnit.SECONDS));
    }
  }

  @Test public void staticProcessingPreservesPublicHelperOverrides() throws Throwable {
    AtomicInteger parses = new AtomicInteger();
    AtomicInteger decrypts = new AtomicInteger();
    EventDispatcher dispatcher = new EventDispatcher(EventDispatcher.newBuilder("", "")) {
      @Override public String parseReq(EventReq req) {
        parses.incrementAndGet();
        return new String(req.getBody(), StandardCharsets.UTF_8);
      }
      @Override public String decryptEvent(String body) {
        decrypts.incrementAndGet();
        return body;
      }
    };
    assertEquals(200, dispatcher.handle(request("{\"type\":\"url_verification\",\"token\":\"\",\"challenge\":\"fixture\"}")).getStatusCode());
    assertEquals(1, parses.get());
    assertEquals(1, decrypts.get());
  }

  @Test public void providerInterruptionRejectsAndPreservesInterrupt() throws Throwable {
    AtomicInteger hits = new AtomicInteger();
    try {
      EventDispatcher dispatcher = dispatcher(() -> { throw new InterruptedException("SECRET-provider-text"); }, hits);
      assertEquals(500, dispatcher.handle(request(payload("static-token"))).getStatusCode());
      assertEquals(0, hits.get());
      assertTrue(Thread.currentThread().isInterrupted());
    } finally {
      Thread.interrupted();
    }
  }

  private int process(EventDispatcher dispatcher, ThreadLocal<String> token, String value) throws Exception {
    token.set(value);
    try {
      return dispatcher.handle(request(payload(value))).getStatusCode();
    } catch (Throwable exception) {
      throw new Exception("test request failed", exception);
    } finally {
      token.remove();
    }
  }
}
