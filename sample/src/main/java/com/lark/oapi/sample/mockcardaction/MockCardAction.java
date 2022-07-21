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

package com.lark.oapi.sample.mockcardaction;

import com.lark.oapi.card.model.Action;
import com.lark.oapi.card.model.CardAction;
import com.lark.oapi.core.Constants;
import com.lark.oapi.core.utils.Jsons;
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

public class MockCardAction {

  public static String calculateSignature(String timestamp, String nonce, String token,
      String bodyString) throws NoSuchAlgorithmException {
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
    String s = timestamp + nonce + token + bodyString;
    byte[] digest = messageDigest.digest(s.getBytes(StandardCharsets.UTF_8));
    StringBuilder sb = new StringBuilder();
    for (byte b : digest) {
      sb.append(String.format("%02X", b));
    }
    return sb.toString().toLowerCase();
  }

  private static void mockChallenge() throws IOException, NoSuchAlgorithmException {
    // body
    CardAction cardAction = new CardAction();
    cardAction.setOpenId("ou_sdfimx9948345");
    cardAction.setUserId("ou_sdfimx9948343");
    cardAction.setToken("v");
    cardAction.setChallenge("1221");
    cardAction.setType(Constants.URL_VERIFICATION);
    String bodyStr = Jsons.LONG_TO_STR.toJson(cardAction);

    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , bodyStr.getBytes(StandardCharsets.UTF_8));

    // http req builder
    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/card")
        .method("POST", requestBody);

    // header
    Map<String, List<String>> map = new HashMap<>();
    map.put(Constants.X_LARK_REQUEST_TIMESTAMP.toLowerCase(), Arrays.asList("timestamp"));
    map.put(Constants.X_LARK_REQUEST_NONCE.toLowerCase(), Arrays.asList("nonce"));
    String signature = calculateSignature("timestamp", "nonce", "v", bodyStr);
    map.put(Constants.X_LARK_SIGNATURE.toLowerCase(), Arrays.asList(signature));
    map.put(Constants.HTTP_HEADER_KEY_LOG_ID, Arrays.asList("logidxxxxxxxxxxx"));
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

  private static void mockCallBack() throws IOException, NoSuchAlgorithmException {
    // body
    CardAction cardAction = new CardAction();
    cardAction.setOpenId("ou_sdfimx9948345");
    cardAction.setUserId("ou_sdfimx9948343");
    cardAction.setToken("v");
    cardAction.setChallenge("1221");

    Action action = new Action();
    Map<String, Object> value = new HashMap<>();
    value.put("key1", "vaue1");
    value.put("key2", "vaue2");
    value.put("key3", "vaue3");
    action.setValue(value);
    cardAction.setAction(action);
    String bodyStr = Jsons.LONG_TO_STR.toJson(cardAction);

    RequestBody requestBody = RequestBody.create(MediaType.parse(Constants.JSON_CONTENT_TYPE)
        , bodyStr.getBytes(StandardCharsets.UTF_8));

    // http req builder
    Request.Builder builder = new Request.Builder().url("http://127.0.0.1:9999/webhook/card")
        .method("POST", requestBody);

    // header
    Map<String, List<String>> map = new HashMap<>();
    map.put(Constants.X_LARK_REQUEST_TIMESTAMP.toLowerCase(), Arrays.asList("timestamp"));
    map.put(Constants.X_LARK_REQUEST_NONCE.toLowerCase(), Arrays.asList("nonce"));
    String signature = calculateSignature("timestamp", "nonce", "v", bodyStr);
    map.put(Constants.X_LARK_SIGNATURE.toLowerCase(), Arrays.asList(signature));
    map.put(Constants.HTTP_HEADER_KEY_LOG_ID, Arrays.asList("logidxxxxxxxxxxx"));
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

  public static void main(String arg[]) throws NoSuchAlgorithmException, IOException {
    // mockChallenge();
    mockCallBack();
  }
}
