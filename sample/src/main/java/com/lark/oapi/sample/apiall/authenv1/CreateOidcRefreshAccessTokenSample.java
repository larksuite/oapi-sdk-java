package com.lark.oapi.sample.apiall.authenv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.authen.v1.model.CreateOidcRefreshAccessTokenReq;
import com.lark.oapi.service.authen.v1.model.CreateOidcRefreshAccessTokenReqBody;
import com.lark.oapi.service.authen.v1.model.CreateOidcRefreshAccessTokenResp;

// POST /open-apis/authen/v1/oidc/refresh_access_token
public class CreateOidcRefreshAccessTokenSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateOidcRefreshAccessTokenReq req = CreateOidcRefreshAccessTokenReq.newBuilder()
                .createOidcRefreshAccessTokenReqBody(CreateOidcRefreshAccessTokenReqBody.newBuilder()
                        .grantType("refresh_token")
                        .refreshToken("ur-oQ0mMq6MCcueAv0pwx2fQQhxqv__CbLu6G8ySFwafeKww2Def2BJdOkW3.9gCFM.LBQgFri901QaqeuL")
                        .build())
                .build();

        // 发起请求
        CreateOidcRefreshAccessTokenResp resp = client.authen().v1().oidcRefreshAccessToken().create(req);

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
