package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// GET /open-apis/corehr/v2/companies/query_recent_change
public class QueryRecentChangeCompanySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryRecentChangeCompanyReq req = QueryRecentChangeCompanyReq.newBuilder()
                .pageSize(100)
                .pageToken("6891251722631890445")
                .startDate("2024-01-01 00:00:00")
                .endDate("2024-04-01 00:00:00")
                .build();

        // 发起请求
        QueryRecentChangeCompanyResp resp = client.corehr().v2().company().queryRecentChange(req);

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
