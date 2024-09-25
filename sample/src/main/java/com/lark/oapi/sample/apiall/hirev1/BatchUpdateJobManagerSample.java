package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.BatchUpdateJobManagerReq;
import com.lark.oapi.service.hire.v1.model.BatchUpdateJobManagerReqBody;
import com.lark.oapi.service.hire.v1.model.BatchUpdateJobManagerResp;

// POST /open-apis/hire/v1/jobs/:job_id/managers/batch_update
public class BatchUpdateJobManagerSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchUpdateJobManagerReq req = BatchUpdateJobManagerReq.newBuilder()
                .jobId("7096318853365369132")
                .userIdType("open_id")
                .batchUpdateJobManagerReqBody(BatchUpdateJobManagerReqBody.newBuilder()
                        .recruiterId("ou_e6139117c300506837def50545420c6a")
                        .assistantIdList(new String[]{})
                        .hiringManagerIdList(new String[]{})
                        .updateOptionList(new Integer[]{})
                        .creatorId("ou_efk39117c300506837def50545420c6a")
                        .build())
                .build();

        // 发起请求
        BatchUpdateJobManagerResp resp = client.hire().v1().jobManager().batchUpdate(req);

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
