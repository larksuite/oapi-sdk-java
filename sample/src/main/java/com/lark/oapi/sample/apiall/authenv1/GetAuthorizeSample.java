package com.lark.oapi.sample.apiall.authenv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.authen.v1.model.GetAuthorizeReq;
import com.lark.oapi.service.authen.v1.model.GetAuthorizeResp;

// GET /open-apis/authen/v1/authorize
public class GetAuthorizeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetAuthorizeReq req = GetAuthorizeReq.newBuilder()
                .appId("cli_9dff7f6ae02ad104")
                .redirectUri("https%3A%2F%2F127.0.0.1%2Fmock")
                .scope("contact:contact bitable:app:readonly")
                .state("RANDOMSTATE")
                .build();

        // 发起请求
        GetAuthorizeResp resp = client.authen().authorize().get(req);

        // 处理服务端错误
        if (!resp.success()) {
            System.out.println(String.format("code:%s,msg:%s,reqId:%s"
                    , resp.getCode(), resp.getMsg(), resp.getRequestId()));
            return;
        }

        // 业务数据处理
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
    }
}
