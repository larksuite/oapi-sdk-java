package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/workforce_plan_detail_row/batchDelete
public class BatchDeleteWorkforcePlanDetailRowSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchDeleteWorkforcePlanDetailRowReq req = BatchDeleteWorkforcePlanDetailRowReq.newBuilder()
                .workforcePlanDetailReq(WorkforcePlanDetailReq.newBuilder()
                        .workforcePlanId("7430330781544564268")
                        .items(new WorkforcePlanDetailRow[]{})
                        .build())
                .build();

        // 发起请求
        BatchDeleteWorkforcePlanDetailRowResp resp = client.corehr().v2().workforcePlanDetailRow().batchDelete(req);

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
