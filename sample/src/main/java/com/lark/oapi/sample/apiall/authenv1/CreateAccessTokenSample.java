package com.lark.oapi.sample.apiall.authenv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.authen.v1.model.CreateAccessTokenReq;
import com.lark.oapi.service.authen.v1.model.CreateAccessTokenReqBody;
import com.lark.oapi.service.authen.v1.model.CreateAccessTokenResp;

// POST /open-apis/authen/v1/access_token
public class CreateAccessTokenSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateAccessTokenReq req = CreateAccessTokenReq.newBuilder()
                .createAccessTokenReqBody(CreateAccessTokenReqBody.newBuilder()
                        .grantType("authorization_code")
                        .code("xMSldislSkdK")
                        .build())
                .build();

        // 发起请求
        CreateAccessTokenResp resp = client.authen().v1().accessToken().create(req);

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
