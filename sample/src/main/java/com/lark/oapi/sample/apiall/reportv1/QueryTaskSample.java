package com.lark.oapi.sample.apiall.reportv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.report.v1.model.*;

import java.util.HashMap;

// POST /open-apis/report/v1/tasks/query
public class QueryTaskSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryTaskReq req = QueryTaskReq.newBuilder()
                .userIdType("user_id")
                .queryTaskReqBody(QueryTaskReqBody.newBuilder()
                        .commitStartTime(1622427266)
                        .commitEndTime(1622427266)
                        .ruleId("6894419345318182932")
                        .userId("ou_133f0b6d0f097cf7d7ba00b38fffb110")
                        .pageToken("6895699275733778451")
                        .pageSize(10)
                        .build())
                .build();

        // 发起请求
        QueryTaskResp resp = client.report().v1().task().query(req);

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
