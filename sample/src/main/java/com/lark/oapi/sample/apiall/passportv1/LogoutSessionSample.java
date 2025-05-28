package com.lark.oapi.sample.apiall.passportv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.passport.v1.model.*;

import java.util.HashMap;

// POST /open-apis/passport/v1/sessions/logout
public class LogoutSessionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        LogoutSessionReq req = LogoutSessionReq.newBuilder()
                .userIdType("open_id")
                .logoutSessionReqBody(LogoutSessionReqBody.newBuilder()
                        .idpCredentialId("1")
                        .logoutType(1)
                        .terminalType(new Integer[]{})
                        .userId("1")
                        .logoutReason(0)
                        .sid("AAAAAAAAAANll6nQoIAAFA==")
                        .build())
                .build();

        // 发起请求
        LogoutSessionResp resp = client.passport().v1().session().logout(req);

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
