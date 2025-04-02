package com.lark.oapi.sample.apiall.performancev2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.performance.v2.model.*;

import java.util.HashMap;

// POST /open-apis/performance/v2/reviewees/query
public class QueryRevieweeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryRevieweeReq req = QueryRevieweeReq.newBuilder()
                .userIdType("open_id")
                .pageToken("")
                .pageSize(20)
                .queryRevieweeReqBody(QueryRevieweeReqBody.newBuilder()
                        .semesterId("6992035450862224940")
                        .userIds(new String[]{})
                        .activityIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        QueryRevieweeResp resp = client.performance().v2().reviewee().query(req);

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
