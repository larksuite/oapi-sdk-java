package com.lark.oapi.sample.apiall.reportv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.report.v1.model.*;

import java.util.HashMap;

// GET /open-apis/report/v1/rules/query
public class QueryRuleSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryRuleReq req = QueryRuleReq.newBuilder()
                .ruleName("工作月报")
                .includeDeleted(0)
                .userIdType("user_id")
                .build();

        // 发起请求
        QueryRuleResp resp = client.report().v1().rule().query(req);

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
