package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.ConfigJobReq;
import com.lark.oapi.service.hire.v1.model.ConfigJobResp;

// GET /open-apis/hire/v1/jobs/:job_id/config
public class ConfigJobSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ConfigJobReq req = ConfigJobReq.newBuilder()
                .jobId("6960663240925956660")
                .userIdType("user_id")
                .build();

        // 发起请求
        ConfigJobResp resp = client.hire().job().config(req);

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
