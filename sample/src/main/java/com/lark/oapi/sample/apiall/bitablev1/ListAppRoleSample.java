package com.lark.oapi.sample.apiall.bitablev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.bitable.v1.model.*;

import java.util.HashMap;

// GET /open-apis/bitable/v1/apps/:app_token/roles
public class ListAppRoleSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListAppRoleReq req = ListAppRoleReq.newBuilder()
                .appToken("appbcbWCzen6D8dezhoCH2RpMAh")
                .pageSize(10)
                .pageToken("roljRpwIUt")
                .build();

        // 发起请求
        ListAppRoleResp resp = client.bitable().v1().appRole().list(req);

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
