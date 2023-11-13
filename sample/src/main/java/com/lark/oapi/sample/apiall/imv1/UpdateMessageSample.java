package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.UpdateMessageReq;
import com.lark.oapi.service.im.v1.model.UpdateMessageReqBody;
import com.lark.oapi.service.im.v1.model.UpdateMessageResp;

// PUT /open-apis/im/v1/messages/:message_id
public class UpdateMessageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateMessageReq req = UpdateMessageReq.newBuilder()
                .messageId("om_dc13264520392913993dd051dba21dcf")
                .updateMessageReqBody(UpdateMessageReqBody.newBuilder()
                        .msgType("text")
                        .content("")
                        .build())
                .build();

        // 发起请求
        UpdateMessageResp resp = client.im().message().update(req);

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
