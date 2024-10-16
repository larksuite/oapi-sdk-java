package com.lark.oapi.sample.apiall.acsv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.acs.v1.model.*;

import java.util.HashMap;

// GET /open-apis/acs/v1/rule_external
public class GetRuleExternalSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetRuleExternalReq req = GetRuleExternalReq.newBuilder()
                .deviceId("7296700518380863767")
                .userIdType("user_id")
                .build();

        // 发起请求
        GetRuleExternalResp resp = client.acs().v1().ruleExternal().get(req);

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
