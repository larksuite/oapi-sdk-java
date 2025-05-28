package com.lark.oapi.sample.apiall.compensationv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.compensation.v1.model.*;

import java.util.HashMap;

// POST /open-apis/compensation/v1/archives/query
public class QueryArchiveSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QueryArchiveReq req = QueryArchiveReq.newBuilder()
                .pageSize(100)
                .pageToken("231432433")
                .userIdType("open_id")
                .queryArchiveReqBody(QueryArchiveReqBody.newBuilder()
                        .userIdList(new String[]{})
                        .tidList(new String[]{})
                        .effectiveStartDate("2022-05-10")
                        .effectiveEndDate("2023-05-15")
                        .build())
                .build();

        // 发起请求
        QueryArchiveResp resp = client.compensation().v1().archive().query(req);

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
