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
import com.lark.oapi.core.enums.BaseUrlEnum;
import com.lark.oapi.core.httpclient.OkHttpTransport;
import com.lark.oapi.okhttp.OkHttpClient;
import java.util.concurrent.TimeUnit;

public class ClientSample {

  public static void useCustomOkHttpClient() {
    Client client = Client.newBuilder("appId", "appSecret")
        .httpTransport(new OkHttpTransport(new OkHttpClient().newBuilder()
            .callTimeout(3L, TimeUnit.SECONDS)
            .build())) // 自定义传输层
        .build();
  }

  public static void useCustomApacheHttpClient() {
    Client client = Client.newBuilder("appId", "appSecret")
        .httpTransport(new OkHttpTransport(new OkHttpClient().newBuilder()
            .callTimeout(3L, TimeUnit.SECONDS)
            .build())) // 自定义传输层
        .marketplaceApp() // 设置 app 类型为商店应用
        .openBaseUrl(BaseUrlEnum.FeiShu) // 设置域名，默认为飞书
        .helpDeskCredential("helpDeskId", "helpDeskSecret") // 服务台应用才需要设置
        .requestTimeout(3, TimeUnit.SECONDS) // 设置httpclient 超时时间，默认永不超时
        .disableTokenCache() // 禁用token管理，禁用后需要开发者自己传递token
        .logReqAtDebug(true) // 在 debug 模式下会打印 http 请求和响应的 headers,body 等信息。
        .build();
  }

  public static void main(String arg[]) {

  }
}
