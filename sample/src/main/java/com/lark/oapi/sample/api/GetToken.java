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

package com.lark.oapi.sample.api;

import com.lark.oapi.Client;
import com.lark.oapi.core.enums.AppType;
import com.lark.oapi.core.request.MarketplaceAppAccessTokenReq;
import com.lark.oapi.core.request.MarketplaceTenantAccessTokenReq;
import com.lark.oapi.core.request.SelfBuiltAppAccessTokenReq;
import com.lark.oapi.core.request.SelfBuiltTenantAccessTokenReq;
import com.lark.oapi.core.response.AppAccessTokenResp;
import com.lark.oapi.core.response.TenantAccessTokenResp;
import com.lark.oapi.core.utils.Jsons;

/**
 * 原生http 调用方式
 */
public class GetToken {

  public static void getAppAccessTokenBySelfBuiltApp() throws Exception {
    String appId = System.getenv().get("APP_ID");
    String appSecret = System.getenv().get("APP_SECRET");

    // 构建client
    Client client = Client.newBuilder(appId, appSecret)
        .appType(AppType.SELF_BUILT) // 设置app类型，默认为自建
        .logReqAtDebug(true)
        .build();

    // 发起请求
    AppAccessTokenResp resp = client.getAppAccessTokenBySelfBuiltApp(
        SelfBuiltAppAccessTokenReq.newBuilder()
            .appSecret(appSecret)
            .appId(appId)
            .build());

    // 处理结果
    System.out.println(Jsons.LONG_TO_STR.toJson(resp));
    System.out.println(resp.getRequestId());
  }

  public static void getTenantAccessTokenBySelfBuiltApp() throws Exception {
    String appId = System.getenv().get("APP_ID");
    String appSecret = System.getenv().get("APP_SECRET");

    // 构建client
    Client client = Client.newBuilder(appId, appSecret)
        .appType(AppType.SELF_BUILT) // 设置app类型，默认为自建
        .logReqAtDebug(true)
        .build();

    // 发起请求
    TenantAccessTokenResp resp = client.getTenantAccessTokenBySelfBuiltApp(
        SelfBuiltTenantAccessTokenReq.newBuilder()
            .appSecret(appSecret)
            .appId(appId)
            .build());

    // 处理结果
    System.out.println(Jsons.LONG_TO_STR.toJson(resp));
    System.out.println(resp.getRequestId());
  }


  public static void getAppAccessTokenByMarketplaceApp() throws Exception {
    String appId = System.getenv().get("APP_ID");
    String appSecret = System.getenv().get("APP_SECRET");

    // 构建client
    Client client = Client.newBuilder(appId, appSecret)
        .appType(AppType.SELF_BUILT) // 设置app类型，默认为自建
        .logReqAtDebug(true)
        .build();

    // 发起请求
    AppAccessTokenResp resp = client.getAppAccessTokenByMarketplaceApp(
        MarketplaceAppAccessTokenReq.newBuilder()
            .appSecret(appSecret)
            .appId(appId)
            .appTicket("appticket")
            .build());

    // 处理结果
    System.out.println(Jsons.LONG_TO_STR.toJson(resp));
    System.out.println(resp.getRequestId());
  }


  public static void getTenantAccessTokenByMarketplaceApp() throws Exception {
    String appId = System.getenv().get("APP_ID");
    String appSecret = System.getenv().get("APP_SECRET");

    // 构建client
    Client client = Client.newBuilder(appId, appSecret)
        .appType(AppType.SELF_BUILT) // 设置app类型，默认为自建
        .logReqAtDebug(true)
        .build();

    // 发起请求
    TenantAccessTokenResp resp = client.getTenantAccessTokenByMarketplaceApp(
        MarketplaceTenantAccessTokenReq.newBuilder()
            .appAccessToken("appaccesstoken")
            .tenantKey("tenantkey")
            .build());

    // 处理结果
    System.out.println(Jsons.LONG_TO_STR.toJson(resp));
    System.out.println(resp.getRequestId());
  }

  public static void main(String arg[]) throws Exception {
    getTenantAccessTokenBySelfBuiltApp();
  }
}
