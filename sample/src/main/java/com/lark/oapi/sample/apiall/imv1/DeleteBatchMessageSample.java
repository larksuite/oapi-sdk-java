package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.DeleteBatchMessageReq;
import com.lark.oapi.service.im.v1.model.DeleteBatchMessageResp;

// DELETE /open-apis/im/v1/batch_messages/:batch_message_id
public class DeleteBatchMessageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteBatchMessageReq req = DeleteBatchMessageReq.newBuilder()
                .batchMessageId("bm-dc13264520392913993dd051dba21dcf")
                .build();

        // 发起请求
        DeleteBatchMessageResp resp = client.im().batchMessage().delete(req);

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
