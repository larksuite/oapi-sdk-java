package com.lark.oapi.sample.apiall.security_and_compliancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.security_and_compliance.v1.model.*;

import java.util.HashMap;

// POST /open-apis/security_and_compliance/v1/user_migrations/search
public class SearchUserMigrationSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchUserMigrationReq req = SearchUserMigrationReq.newBuilder()
                .userIdType("user_id")
                .searchUserMigrationReqBody(SearchUserMigrationReqBody.newBuilder()
                        .userIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        SearchUserMigrationResp resp = client.securityAndCompliance().v1().userMigration().search(req);

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
