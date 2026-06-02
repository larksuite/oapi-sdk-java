package com.lark.oapi.sample.apiall.performancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.performance.v1.model.*;

import java.util.HashMap;

// POST /open-apis/performance/v1/review_datas/query
public class QueryReviewDataSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryReviewDataReq req = QueryReviewDataReq.newBuilder()
                .userIdType("open_id")
                .queryReviewDataReqBody(QueryReviewDataReqBody.newBuilder()
                        .startTime("1430425599999")
                        .endTime("1630425599999")
                        .stageTypes(new String[]{})
                        .stageProgress(new Integer[]{})
                        .semesterIdList(new String[]{})
                        .revieweeUserIdList(new String[]{})
                        .updatedLaterThan("1630425599999")
                        .build())
                .build();

        // 发起请求
        QueryReviewDataResp resp = client.performance().v1().reviewData().query(req);

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
