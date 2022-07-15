package com.lark.oapi.sample.mockevent;

import com.lark.oapi.core.Constants;
import com.lark.oapi.core.utils.OKHttps;
import com.lark.oapi.okhttp.MediaType;
import com.lark.oapi.okhttp.Request;
import com.lark.oapi.okhttp.RequestBody;
import com.lark.oapi.okhttp.Response;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.binary.Hex;

public class MockEventSend {

  public static void mockAppTicketEvent() throws IOException {
    String body = "{\"ts\":\"\",\"uuid\":\"\",\"token\":\"1212121212\",\"type\":\"\",\"event\":{\"app_id\":\"jiaduoappId\",\"type\":\"app_ticket\",\"app_ticket\":\"AppTicketvalue\"}}";

    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }

  public static void mockChallenge() throws IOException {
    String body = "{\"schema\":\"2.0\",\"header\":{\"event_id\":\"f7984f25108f8137722bb63cee927e66\",\"event_type\":\"contact.user.created_v3\",\"app_id\":\"cli_xxxxxxxx\",\"tenant_key\":\"xxxxxxx\",\"create_time\":\"1603977298000000\",\"token\":\"v\"},\"event\":{\"object\":{\"open_id\":\"ou_7dab8a3d3cdcc9da365777c7ad535d62\",\"union_id\":\"on_576833b917gda3d939b9a3c2d53e72c8\",\"user_id\":\"e33ggbyz\",\"name\":\"张三\",\"employee_no\":\"employee_no\"}},\"challenge\":\"1212\",\"type\":\"url_verification\"}";
    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());

  }

  public static void mockPlainTextEvent() throws IOException {

    String body = "{\"schema\":\"2.0\",\"header\":{\"event_id\":\"f7984f25108f8137722bb63cee927e66\",\"event_type\":\"contact.user.created_v3\",\"app_id\":\"cli_xxxxxxxx\",\"tenant_key\":\"xxxxxxx\",\"create_time\":\"1603977298000000\",\"token\":\"v\"},\"event\":{\"object\":{\"open_id\":\"ou_7dab8a3d3cdcc9da365777c7ad535d62\",\"union_id\":\"on_576833b917gda3d939b9a3c2d53e72c8\",\"user_id\":\"e33ggbyz\",\"name\":\"张三\",\"employee_no\":\"employee_no\"}},\"challenge\":\"1212\",\"type\":\"\"}";

    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }


  public static void mockP1MessageReadV1Event() throws IOException {

    String body = "{\"ts\":\"ts\",\"uuid\":\"uuid\",\"token\":\"v\",\"type\":\"type\",\"event\":{\"message_id_list\":[\"ss\",\"dd\"],\"app_id\":\"appid\",\"open_chat_id\":\"openapiid\",\"open_id\":\"openid\",\"tenant_key\":\"tenkey\",\"type\":\"message_read\"}}";

    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }

  private static String calculateSignature(String timestamp, String nonce, String encryptKey,
      String bodyString) throws NoSuchAlgorithmException {
    StringBuilder content = new StringBuilder();
    content.append(timestamp).append(nonce).append(encryptKey).append(bodyString);
    MessageDigest alg = MessageDigest.getInstance("SHA-256");
    String sign = Hex.encodeHexString(alg.digest(content.toString().getBytes()));
    return sign;
  }

  public static void mockEncryptEvent() throws IOException, NoSuchAlgorithmException {
    // http body
    String body = "{\"encrypt\":\"skWvX8Axk7YyrhK3txTfY1JWb20wu1gG60eDMQTVJ15mOLfrpJtJ44x/hYqyvqUMt7I8/QtvhESdPyvNkyK0s01vkoFTkBLwI8By7k64mhnXjkJFxav8ymw3rOEtQsmb6YdTuOEkK1SotRI10yeE23mp4zCZOL2/kc9pe/gUIBHPNRAxrLexsxrarGYub7ZI0mCIN1mcyeq3hYzIrComr6gvIIFcVGYNbT10vJUSo11aw6rQ03xu1PP6vXIbUDOxWtklqi6vgIs34v2GBefe0TXOePP7LK1Li3wVKlD5i9lyagICCCDb23R8pM0jOB1CRMMt05kNRV3ITF6bYra/vtVwaABfczC2uisP6cHPoD06HZyUPUOMwCjQVQOorD4qkwrbbH2c4UIw/Ir0EC2WuIc2vyWbVzkoXXRlUwZljYfchzEpNjKL+RkEE0H4N1m3r4EahyCYIKqvapUD4fAT7cbZlrsFDzP96GFGChXXelwW9PW0zWgeDf1onjIaNx10HY3C/mi7dejRN6eRotZ9XI29VgI/2tXZnRcvwmxCGf/jh5+T42MF8S4gS4oLeIJtw5dc//bgC14TttrwyqbZcFyN4v2yX+0peN+G8F4r/VY=\"}";
    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    // http header
    Map<String, List<String>> map = new HashMap<>();
    map.put(Constants.X_LARK_REQUEST_TIMESTAMP.toLowerCase(), Arrays.asList("timestamp"));
    map.put(Constants.X_LARK_REQUEST_NONCE.toLowerCase(), Arrays.asList("nonce"));
    String signature = calculateSignature("timestamp", "nonce", "1212121212", body);
    map.put(Constants.X_LARK_SIGNATURE.toLowerCase(), Arrays.asList(signature));
    map.put(Constants.HTTP_HEADER_KEY_LOG_ID, Arrays.asList("logidxxxxxxxxxxx"));

    // http builder
    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    for (Map.Entry<String, List<String>> entry : map.entrySet()) {
      String key = entry.getKey();
      entry.getValue().stream().forEach(v -> {
        builder.header(key, v);
      });
    }

    // POST
    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }

  public static void main(String ar[]) throws IOException, NoSuchAlgorithmException {
    // mockAppTicketEvent();
    // mockChallenge();
    // mockPlainTextEvent();
    //mockEncryptEvent();
    mockP1MessageReadV1Event();

  }
}
