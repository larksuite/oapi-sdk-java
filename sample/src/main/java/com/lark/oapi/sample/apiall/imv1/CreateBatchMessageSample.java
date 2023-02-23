package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.BatchMessageReq;
import com.lark.oapi.service.im.v1.model.BatchMessageResp;

// POST /message/v4/batch_send
public class CreateBatchMessageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchMessageReq req = BatchMessageReq.newBuilder()
                .messageType("text")
                .content("{ \"text\": \"要发送的文本消息\" }")
                .unionIds(new String[] {"on_cad4860e7af114fb4ff6c5d496d1dd76", "on_gdcq860e7af114fb4ff6c5d496dabcet"})
                .uuid("a0d69e20-1dd1-458b-k525-dfeca4015204")
                .build();

        // 发起请求
        BatchMessageResp resp = client.im().batchMessage().batchSendMessage(req);

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
