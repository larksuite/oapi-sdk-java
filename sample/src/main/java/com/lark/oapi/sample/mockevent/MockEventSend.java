/*
 * MIT License
 *
 * Copyright (c) 2022 Lark Technologies Pte. Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice, shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

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


  public static void mockP1MessageReceivedV1Event() throws IOException {

    String body = "{\"ts\":\"\",\"uuid\":\"\",\"token\":\"v\",\"type\":\"\",\"event\":{\"type\":\"message\",\"app_id\":\"appid\",\"tenant_key\":\"tenantkey\",\"root_id\":\"1212\",\"parent_id\":\"11\",\"open_chat_id\":\"123\",\"chat_type\":\"public\",\"msg_type\":\"text\",\"open_id\":\"1221\",\"employee_id\":\"sdsd\",\"union_id\":\"sdsd\",\"open_message_id\":\"2wwd\",\"text\":\"hello jiaduo\",\"title\":\"title\"}}";

    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }

  public static void mockPUserChangedV1Event() throws IOException {

    String body = "{\"ts\":\"\",\"uuid\":\"\",\"token\":\"v\",\"type\":\"\",\"event\":{\"type\":\"user_update\",\"app_id\":\"cli_xxx\",\"tenant_key\":\"xx\",\"open_id\":\"xx\",\"employee_id\":\"xx\",\"union_id\":\"xx\"}}";

    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }


  public static void mockP1UserStatusChangedV1Event() throws IOException {

    String body = "{\"ts\":\"\",\"uuid\":\"\",\"token\":\"v\",\"type\":\"\",\"event\":{\"type\":\"user_status_change\",\"app_id\":\"cli_xxx\",\"tenant_key\":\"xx\",\"open_id\":\"xx\",\"employee_id\":\"xx\",\"union_id\":\"xx\",\"before_status\":{\"is_active\":false,\"is_frozen\":false,\"is_resigned\":false},\"current_status\":{\"is_active\":true,\"is_frozen\":false,\"is_resigned\":false},\"change_time\":\"2020-02-21 16:28:48\"}}";

    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }


  public static void mockP1DeptChangedV1Event() throws IOException {

    String body = "{\"ts\":\"\",\"uuid\":\"\",\"token\":\"v\",\"type\":\"\",\"event\":{\"type\":\"dept_delete\",\"app_id\":\"cli_xxx\",\"tenant_key\":\"xx\",\"open_id\":\"xx\",\"open_department_id\":\"sssss\"}}";
    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }


  public static void mockP1ScopeChangedV1Event() throws IOException {

    String body = "{\"ts\":\"t\",\"uuid\":\"u\",\"token\":\"v\",\"type\":\"type\",\"event\":{\"type\":\"contact_scope_change\",\"app_id\":\"cli_xxx\",\"tenant_key\":\"xx\"}}";
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


  public static void mockP2pChatCreateV1Event() throws IOException {

    String body = "{\"ts\":\"ts\",\"uuid\":\"uid\",\"token\":\"v\",\"type\":\"\",\"event\":{\"app_id\":\"xxx\",\"chat_id\":\"chatid\",\"operator\":{\"open_id\":\"oi\",\"user_id\":\"ui\"},\"tenant_key\":\"tk\",\"type\":\"p2p_chat_create\",\"user\":{\"open_id\":\"oi\",\"user_id\":\"ui\",\"name\":\"jiaduo\"}}}";
    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }

  public static void mockThirdMeetingRoomChangedEventV1() throws IOException {

    String body = "{\"ts\":\"ts\",\"uuid\":\"uid\",\"token\":\"v\",\"type\":\"\",\"event\":{\"app_id\":\"xxx\",\"tenant_key\":\"tk\",\"type\":\"leave_approvalV2\",\"instance_code\":\"code\",\"user_id\":\"userid\",\"open_id\":\"openid\",\"origin_instance_code\":\"origincode\",\"start_time\":1564590532,\"end_time\":1564590533,\"leave_feeding_arrive_late\":1,\"leave_feeding_leave_early\":2,\"leave_feeding_rest_daily\":3,\"leave_name\":\"JIADUO\",\"leave_unit\":\"day\",\"leave_start_time\":\"2019-10-01 00:00:00\",\"leave_end_time\":\"2019-10-01 00:00:00\",\"leave_detail\":[\"2019-10-01 00:00:00\",\"2019-10-02 00:00:00\"],\"leave_range\":[\"2019-10-01 00:00:00\",\"2019-10-02 00:00:00\"],\"leave_interval\":86400,\"leave_reason\":\"abc\",\"i18n_resources\":[{\"locale\":\"en_us\",\"is_default\":true,\"texts\":{\"@i18n@123456\":\"Holiday\"}}]}}";

    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }


  public static void mockP1LeaveApprovalEventV1() throws IOException {

    String body = "{\"ts\":\"ts\",\"uuid\":\"uid\",\"token\":\"v\",\"type\":\"\",\"event\":{\"app_id\":\"xxx\",\"tenant_key\":\"tk\",\"type\":\"third_party_meeting_room_event_updated\",\"event_time\":\"1594979647635\",\"uid\":\"bff6b51f\",\"start\":{\"time_stamp\":\"1553853600000\"},\"end\":{\"time_stamp\":\"1553860800000\"},\"meeting_rooms\":[{\"open_id\":\"oi1\"},{\"open_id\":\"oi2\"}],\"organizer\":{\"open_id\":\"oi\",\"user_id\":\"ui\"}}}";
    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }


  public static void mockP1WorkApprovalEventV1() throws IOException {

    String body = "{\"ts\":\"ts\",\"uuid\":\"uid\",\"token\":\"v\",\"type\":\"\",\"event\":{\"app_id\":\"xxx\",\"tenant_key\":\"tk\",\"type\":\"work_approval\",\"instance_code\":\"code\",\"employee_id\":\"id\",\"open_id\":\"openid\",\"start_time\":1564590532,\"end_time\":1564590533,\"work_type\":\"ss\",\"work_start_time\":\"2018-12-01 12:00:00\",\"work_end_time\":\"2018-12-03 12:00:00\",\"work_interval\":1000,\"work_reason\":\"reason\"}}";
    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }


  public static void mockP1ShiftApprovalEventV1() throws IOException {

    String body = "{\"ts\":\"ts\",\"uuid\":\"uid\",\"token\":\"v\",\"type\":\"\",\"event\":{\"app_id\":\"xxx\",\"tenant_key\":\"tk\",\"type\":\"shift_approval\",\"instance_code\":\"code\",\"employee_id\":\"id\",\"open_id\":\"openid\",\"start_time\":1564590532,\"end_time\":1564590533,\"shift_time\":\"2018-12-01 12:00:00\",\"return_time\":\"2018-12-01 12:00:00\",\"shift_reason\":\"reason\"}}";
    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }


  public static void mockP1RemedyApprovalEventV1() throws IOException {

    String body = "{\"ts\":\"ts\",\"uuid\":\"uid\",\"token\":\"v\",\"type\":\"\",\"event\":{\"app_id\":\"xxx\",\"tenant_key\":\"tk\",\"type\":\"remedy_approval\",\"instance_code\":\"code\",\"employee_id\":\"id\",\"open_id\":\"openid\",\"start_time\":1564590532,\"end_time\":1564590533,\"remedy_time\":\"11110\",\"remedy_reason\":\"reason\"}}";
    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }

  public static void mockP1TripApprovalEventV1() throws IOException {

    String body = "{\"ts\":\"ts\",\"uuid\":\"uid\",\"token\":\"v\",\"type\":\"\",\"event\":{\"app_id\":\"xxx\",\"tenant_key\":\"tk\",\"type\":\"trip_approval\",\"instance_code\":\"code\",\"employee_id\":\"id\",\"open_id\":\"openid\",\"start_time\":1564590532,\"end_time\":1564590533,\"schedules\":[{\"trip_start_time\":\"2018-12-01 12:00:00\",\"trip_end_time\":\"2018-12-02 12:00:00\",\"trip_interval\":3600,\"departure\":\"xxx\",\"destination\":\"x\",\"transportation\":\"xxxx\",\"trip_type\":\"单程\",\"remark\":\"备注\"}],\"trip_interval\":12121,\"trip_reason\":\"reason\",\"trip_peers\":[\"a\",\"b\"]}}";
    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }


  public static void mockP1OutApprovalEventV1() throws IOException {

    String body = "{\"ts\":\"ts\",\"uuid\":\"uid\",\"token\":\"v\",\"type\":\"\",\"event\":{\"app_id\":\"xxx\",\"i18n_resources\":[{\"is_default\":true,\"locale\":\"en_us\",\"texts\":{\"k1\":\"v1\",\"k2\":\"v2\"}}],\"instance_code\":\"code\",\"out_image\":\"image\",\"out_interval\":1000,\"out_name\":\"name\",\"out_reason\":\"事由\",\"out_start_time\":\"2020-05-15 15:00:00\",\"out_end_time\":\"2020-05-16 15:00:00\",\"out_unit\":\"HOUR\",\"start_time\":1564590532,\"end_time\":1564590533,\"tenant_key\":\"tk\",\"type\":\"out_approval\",\"open_id\":\"openid\"}}";
    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }


  public static void mockP1AppOpenEventV1() throws IOException {

    String body = "{\"ts\":\"ts\",\"uuid\":\"uid\",\"token\":\"v\",\"type\":\"\",\"event\":{\"app_id\":\"xxx\",\"tenant_key\":\"tk\",\"type\":\"app_open\",\"applicants\":[{\"open_id\":\"o1\"},{\"open_id\":\"o2\"}],\"installer\":{\"open_id\":\"o1\"},\"installer_employee\":{\"open_id\":\"o1\"}}}";
    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }


  public static void mockP1AppStatusChangedEventV1() throws IOException {

    String body = "{\"ts\":\"ts\",\"uuid\":\"uid\",\"token\":\"v\",\"type\":\"\",\"event\":{\"app_id\":\"xxx\",\"tenant_key\":\"tk\",\"type\":\"app_status_change\",\"status\":\"start_by_tenant\",\"operator\":{\"open_id\":\"o1\",\"user_id\":\"ui\",\"union_id\":\"ui\"}}}";
    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }

  public static void mockP1OrderPaidEventV1() throws IOException {

    String body = "{\"ts\":\"ts\",\"uuid\":\"uid\",\"token\":\"v\",\"type\":\"type\",\"event\":{\"type\":\"order_paid\",\"app_id\":\"xxx\",\"order_id\":\"54323223\",\"price_plan_id\":\"price_12121\",\"price_plan_type\":\"per_seat_per_month\",\"buy_count\":1,\"seats\":20,\"create_time\":\"time\",\"pay_time\":\"paytime\",\"buy_type\":\"buy\",\"src_order_id\":\"23233\",\"order_pay_price\":10000,\"tenant_key\":\"tk\"}}";
    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }

  public static void mockAppUninstalledEventV1() throws IOException {

    String body = "{\"ts\":\"ts\",\"uuid\":\"uid\",\"token\":\"v\",\"type\":\"\",\"event\":{\"app_id\":\"xxx\",\"tenant_key\":\"tk\",\"type\":\"app_uninstalled\"}}";
    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , body.getBytes(StandardCharsets.UTF_8));

    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/event")
        .method("POST", requestBody);
    builder.header(Constants.HTTP_HEADER_KEY_LOG_ID, "logidxxxxxxxxx");

    Response resp = OKHttps.defaultClient.newCall(builder.build()).execute();
    System.out.println(resp.code());
    System.out.println(resp.body().string());
  }

  public static void main(String ar[]) throws IOException, NoSuchAlgorithmException {
    // mockAppTicketEvent();
    // mockChallenge();
    // mockPlainTextEvent();
    // mockEncryptEvent();
    // mockChallenge();
    mockAppUninstalledEventV1();

  }
}
