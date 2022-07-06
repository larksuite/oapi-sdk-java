package com.larksuite.oapi.sample.rawapi;

import com.larksuite.oapi.Client;
import com.larksuite.oapi.core.enums.AppType;
import com.larksuite.oapi.core.response.RawResponse;
import com.larksuite.oapi.core.token.AccessTokenType;
import com.larksuite.oapi.core.utils.Jsons;

import java.util.HashMap;
import java.util.Map;

/**
 * 原生http 调用方式
 */
public class RawApiCall {
    public static void main(String arg[]) throws Exception {
        String appId = System.getenv().get("APP_ID");
        String appSecret = System.getenv().get("APP_SECRET");

        // 构建client
        Client client = Client.newBuilder(appId, appSecret)
                .appType(AppType.SELF_BUILT) // 设置app类型，默认为自建
                .logReqRespInfoAtDebugLevel(true)
                .build();

        // 构建http body
        Map<String, Object> body = new HashMap<>();
        body.put("receive_id", "ou_c245b0a7dff2725cfa2fb104f8b48b9d");
        body.put("content", "{\"text\":\"<at user_id=\\\"ou_155184d1e73cbfb8973e5a9e698e74f2\\\">Tom</at> test content\"}");
        body.put("msg_type", "text");

        // 发起请求
        RawResponse resp = client.post("https://open.feishu.cn/open-apis/im/v1/messages?receive_id_type=open_id"
                , body
                , AccessTokenType.Tenant);

        // 处理结果
        System.out.println(Jsons.LONG_TO_STR_GSON.toJson(resp));
        System.out.println(resp.getRequestID());
    }
}
