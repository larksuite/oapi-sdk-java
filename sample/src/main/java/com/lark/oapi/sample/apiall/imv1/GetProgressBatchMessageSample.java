package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.GetProgressBatchMessageReq;
import com.lark.oapi.service.im.v1.model.GetProgressBatchMessageResp;

// GET /open-apis/im/v1/batch_messages/:batch_message_id/get_progress
public class GetProgressBatchMessageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetProgressBatchMessageReq req = GetProgressBatchMessageReq.newBuilder()
                .batchMessageId("bm-0b3d5d1b2df7c6d5dbd1abe2c91e2217")
                .build();

        // 发起请求
        GetProgressBatchMessageResp resp = client.im().batchMessage().getProgress(req);

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
