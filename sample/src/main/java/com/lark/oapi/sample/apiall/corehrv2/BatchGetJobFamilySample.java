package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.BatchGetJobFamilyReq;
import com.lark.oapi.service.corehr.v2.model.BatchGetJobFamilyReqBody;
import com.lark.oapi.service.corehr.v2.model.BatchGetJobFamilyResp;

// POST /open-apis/corehr/v2/job_families/batch_get
public class BatchGetJobFamilySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchGetJobFamilyReq req = BatchGetJobFamilyReq.newBuilder()
                .batchGetJobFamilyReqBody(BatchGetJobFamilyReqBody.newBuilder()
                        .jobFamilyIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        BatchGetJobFamilyResp resp = client.corehr().v2().jobFamily().batchGet(req);

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