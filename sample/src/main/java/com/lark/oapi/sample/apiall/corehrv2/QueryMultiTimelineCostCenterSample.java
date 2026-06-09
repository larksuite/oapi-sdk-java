package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/cost_centers/query_multi_timeline
public class QueryMultiTimelineCostCenterSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryMultiTimelineCostCenterReq req = QueryMultiTimelineCostCenterReq.newBuilder()
                .pageSize(100)
                .pageToken("6891251722631890445")
                .userIdType("people_corehr_id")
                .queryMultiTimelineCostCenterReqBody(QueryMultiTimelineCostCenterReqBody.newBuilder()
                        .costCenterIds(new String[]{})
                        .effectiveDateStart("2024-01-01")
                        .effectiveDateEnd("2024-12-31")
                        .fields(new String[]{})
                        .build())
                .build();

        // 发起请求
        QueryMultiTimelineCostCenterResp resp = client.corehr().v2().costCenter().queryMultiTimeline(req);

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
