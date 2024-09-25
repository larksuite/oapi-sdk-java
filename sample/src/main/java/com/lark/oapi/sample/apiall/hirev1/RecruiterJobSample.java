package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.RecruiterJobReq;
import com.lark.oapi.service.hire.v1.model.RecruiterJobResp;

// GET /open-apis/hire/v1/jobs/:job_id/recruiter
public class RecruiterJobSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        RecruiterJobReq req = RecruiterJobReq.newBuilder()
                .jobId("6960663240925956555")
                .userIdType("user_id")
                .build();

        // 发起请求
        RecruiterJobResp resp = client.hire().v1().job().recruiter(req);

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
