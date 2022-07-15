package com.lark.oapi.sample.api;

import com.lark.oapi.Client;
import com.lark.oapi.core.cache.LocalCache;
import com.lark.oapi.core.enums.AppType;
import com.lark.oapi.core.enums.BaseUrlEnum;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.tenant.v2.model.QueryTenantResp;
import java.util.concurrent.TimeUnit;

public class TenantSample {

  public static void getTenant(Client client) throws Exception {
    QueryTenantResp resp = client.tenant().tenant().query();
    System.out.println(Jsons.LONG_TO_STR.toJson(resp));
  }

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
        //.disableTokenCache() // 禁用token管理，则需要开发者自己传递token
        .logReqRespInfoAtDebugLevel(true)
        .build();

    getTenant(client);
  }
}
