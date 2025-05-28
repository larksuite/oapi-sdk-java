package com.lark.oapi.sample.apiall.performancev2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.performance.v2.model.*;

import java.util.HashMap;

// POST /open-apis/performance/v2/review_datas/query
public class QueryReviewDataSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryReviewDataReq req = QueryReviewDataReq.newBuilder()
                .userIdType("open_id")
                .queryReviewDataReqBody(QueryReviewDataReqBody.newBuilder()
                        .semesterIds(new String[]{})
                        .revieweeUserIds(new String[]{})
                        .stageTypes(new String[]{})
                        .reviewStageRoles(new String[]{})
                        .stageIds(new String[]{})
                        .needLeaderReviewDataSource(false)
                        .updatedLaterThan("1630425599999")
                        .stageProgresses(new Integer[]{})
                        .build())
                .build();

        // 发起请求
        QueryReviewDataResp resp = client.performance().v2().reviewData().query(req);

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
