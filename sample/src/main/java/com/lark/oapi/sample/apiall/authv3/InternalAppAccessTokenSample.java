package com.lark.oapi.sample.apiall.authv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.auth.v3.model.InternalAppAccessTokenReq;
import com.lark.oapi.service.auth.v3.model.InternalAppAccessTokenReqBody;
import com.lark.oapi.service.auth.v3.model.InternalAppAccessTokenResp;

// POST /open-apis/auth/v3/app_access_token/internal
public class InternalAppAccessTokenSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        InternalAppAccessTokenReq req = InternalAppAccessTokenReq.newBuilder()
                .internalAppAccessTokenReqBody(InternalAppAccessTokenReqBody.newBuilder()
                        .appId("cli_hsjeriogfkd93jf84")
                        .appSecret("jdsfslkjdg8e73hdf9237enbd")
                        .build())
                .build();

        // 发起请求
        InternalAppAccessTokenResp resp = client.auth().appAccessToken().internal(req);

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
