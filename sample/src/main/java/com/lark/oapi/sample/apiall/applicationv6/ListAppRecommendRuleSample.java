package com.lark.oapi.sample.apiall.applicationv6;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.model.*;

import java.util.HashMap;

// GET /open-apis/application/v6/app_recommend_rules
public class ListAppRecommendRuleSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListAppRecommendRuleReq req = ListAppRecommendRuleReq.newBuilder()
                .pageSize(10)
                .pageToken("new-e11ee058b4a8ed2881da11ac7e37c4fc")
                .userIdType("user_id")
                .build();

        // 发起请求
        ListAppRecommendRuleResp resp = client.application().v6().appRecommendRule().list(req);

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
