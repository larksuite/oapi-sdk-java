package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/talent_operation_logs/search
public class SearchTalentOperationLogSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchTalentOperationLogReq req = SearchTalentOperationLogReq.newBuilder()
                .pageToken("eyJvZmZzZXQiOjEwLCJ0aW1lc3RhbXAiOjE2Mjc1NTUyMjM2NzIsImlkIjpudWxsfQ==")
                .pageSize(10)
                .userIdType("open_id")
                .searchTalentOperationLogReqBody(SearchTalentOperationLogReqBody.newBuilder()
                        .jobIdList(new String[]{})
                        .operatorIdList(new String[]{})
                        .operationList(new Integer[]{})
                        .build())
                .build();

        // 发起请求
        SearchTalentOperationLogResp resp = client.hire().v1().talentOperationLog().search(req);

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
