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

package com.lark.oapi.sample.rawapi;

import com.lark.oapi.Client;
import com.lark.oapi.core.enums.AppType;
import com.lark.oapi.core.response.RawResponse;
import com.lark.oapi.core.token.AccessTokenType;
import com.lark.oapi.core.utils.Jsons;
import java.util.HashMap;
import java.util.Map;

/**
 * 原生http 调用方式
 */
public class RawApiCall {

  public static void sendMsg() throws Exception {
    String appId = System.getenv().get("APP_ID");
    String appSecret = System.getenv().get("APP_SECRET");

    // 构建client
    Client client = Client.newBuilder(appId, appSecret)
        .appType(AppType.SELF_BUILT) // 设置app类型，默认为自建
        .logReqAtDebug(true)
        .build();

    // 构建http body
    Map<String, Object> body = new HashMap<>();
    body.put("receive_id", "ou_c245b0a7dff2725cfa2fb104f8b48b9d");
    body.put("content",
        "{\"text\":\"<at user_id=\\\"ou_155184d1e73cbfb8973e5a9e698e74f2\\\">Tom</at> test content\"}");
    body.put("msg_type", "text");

    // 发起请求
    RawResponse resp = client.post(
        "https://open.feishu.cn/open-apis/im/v1/messages?receive_id_type=open_id"
        , body
        , AccessTokenType.Tenant);

    // 处理结果
    System.out.println(resp.getStatusCode());
    System.out.println(Jsons.LONG_TO_STR.toJson(resp.getHeaders()));
    System.out.println(new String(resp.getBody()));
    System.out.println(resp.getRequestID());
  }


  public static void getTenantToken() throws Exception {
    String appId = System.getenv().get("APP_ID");
    String appSecret = System.getenv().get("APP_SECRET");

    // 构建client
    Client client = Client.newBuilder(appId, appSecret)
        .appType(AppType.SELF_BUILT) // 设置app类型，默认为自建
        .logReqAtDebug(true)
        .build();

    // 发起请求
    Map<String, Object> body = new HashMap<>();
    body.put("app_id", appId);
    body.put("app_secret", appSecret);
    RawResponse resp = client.post(
        "https://open.feishu.cn/open-apis/auth/v3/tenant_access_token/internal"
        , body
        , AccessTokenType.None);

    // 处理结果
    System.out.println(resp.getStatusCode());
    System.out.println(Jsons.LONG_TO_STR.toJson(resp.getHeaders()));
    System.out.println(new String(resp.getBody()));
    System.out.println(resp.getRequestID());
  }

  public static void main(String arg[]) throws Exception {
    getTenantToken();
  }
}
