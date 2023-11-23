package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.GetProcessReq;
import com.lark.oapi.service.corehr.v2.model.GetProcessResp;

// GET /open-apis/corehr/v2/processes/:process_id
public class GetProcessSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetProcessReq req = GetProcessReq.newBuilder()
                .processId("7278949005675988535")
                .userIdType("open_id")
                .build();

        // 发起请求
        GetProcessResp resp = client.corehr().v2().process().get(req);

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
