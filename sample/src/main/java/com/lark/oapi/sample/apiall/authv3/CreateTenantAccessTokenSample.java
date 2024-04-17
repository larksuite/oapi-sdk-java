package com.lark.oapi.sample.apiall.authv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.auth.v3.model.CreateTenantAccessTokenReq;
import com.lark.oapi.service.auth.v3.model.CreateTenantAccessTokenReqBody;
import com.lark.oapi.service.auth.v3.model.CreateTenantAccessTokenResp;

// POST /open-apis/auth/v3/tenant_access_token
public class CreateTenantAccessTokenSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateTenantAccessTokenReq req = CreateTenantAccessTokenReq.newBuilder()
                .createTenantAccessTokenReqBody(CreateTenantAccessTokenReqBody.newBuilder()
                        .appAccessToken("a-32bd8551db2f081cbfd26293f27516390b9feb04")
                        .tenantKey("73658811060f175d")
                        .build())
                .build();

        // 发起请求
        CreateTenantAccessTokenResp resp = client.auth().v3().tenantAccessToken().create(req);

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
