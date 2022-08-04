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
import com.lark.oapi.core.cache.LocalCache;
import com.lark.oapi.core.enums.AppType;
import com.lark.oapi.core.enums.BaseUrlEnum;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.block.v2.model.CreateEntityReq;
import com.lark.oapi.service.block.v2.model.CreateEntityReqBody;
import com.lark.oapi.service.block.v2.model.CreateEntityResp;
import java.util.concurrent.TimeUnit;

public class BlockSample {

  public static void main(String arg[]) throws Exception {
    String appId = System.getenv().get("APP_ID");
    String appSecret = System.getenv().get("APP_SECRET");

    // 构建client
    Client client = Client.newBuilder(appId, appSecret)
        .appType(AppType.SELF_BUILT) // 设置app类型，默认为自建
        .openBaseUrl(BaseUrlEnum.FeiShu) // 设置域名，默认为飞书
        .helpDeskCredential("helpDeskId", "helpDeskSecret") // 服务台应用才需要设置
        .tokenCache(LocalCache.getInstance()) // 设置token缓存，默认为内存缓存
        .requestTimeout(3, TimeUnit.SECONDS) // 设置httpclient 超时时间，默认永不超时
        .logReqAtDebug(true)
        .build();

    CreateEntityResp resp = client.block().entity()
        .create(CreateEntityReq.newBuilder()
            .createEntityReqBody(CreateEntityReqBody.newBuilder()
                .title("title")
                .blockTypeId("blk_614c1c952f800014b27f87d6")
                .sourceData(
                    "{\"project_key\":\"617b62edfeaa112cb4a55117\",\"block_type\":\"view\",\"work_item_type\":\"620e2873a1fcfdd1e7a42eb3\",\"story_id\":0,\"view_id\":\"tfj7p4fng\",\"biz_id\":\"tfj7p4fng\",\"block_show_mode\":0,\"timestamp\":1650788824}")
                .sourceMeta("meta")
                .version("1234")
                .build())
            .build());

    if (!resp.success()) {
      System.out.println(String.format("code:%d,msg:%s,err:%s"
          , resp.getCode(), resp.getMsg(), Jsons.DEFAULT.toJson(resp.getError())));
      return;
    }

    System.out.println(Jsons.DEFAULT.toJson(resp));


  }
}
