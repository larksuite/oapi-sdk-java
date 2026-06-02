package com.lark.oapi.sample.apiall.security_and_compliancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.security_and_compliance.v1.model.*;

import java.util.HashMap;

// GET /open-apis/security_and_compliance/v1/user_migrations/:user_id
public class GetUserMigrationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetUserMigrationReq req = GetUserMigrationReq.newBuilder()
                .userId("")
                .userIdType("user_id")
                .build();

        // 发起请求
        GetUserMigrationResp resp = client.securityAndCompliance().v1().userMigration().get(req);

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
