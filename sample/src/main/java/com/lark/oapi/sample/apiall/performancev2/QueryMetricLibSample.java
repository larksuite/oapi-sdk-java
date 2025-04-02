package com.lark.oapi.sample.apiall.performancev2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.performance.v2.model.*;

import java.util.HashMap;

// POST /open-apis/performance/v2/metric_libs/query
public class QueryMetricLibSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryMetricLibReq req = QueryMetricLibReq.newBuilder()
                .userIdType("open_id")
                .pageToken("")
                .pageSize(20)
                .queryMetricLibReqBody(QueryMetricLibReqBody.newBuilder()
                        .isActive(false)
                        .tagIds(new String[]{})
                        .typeIds(new String[]{})
                        .rangeOfAvailability("admins_and_reviewees")
                        .scoringSettingType("score_manually")
                        .build())
                .build();

        // 发起请求
        QueryMetricLibResp resp = client.performance().v2().metricLib().query(req);

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
