package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.ForwardMessageReq;
import com.lark.oapi.service.im.v1.model.ForwardMessageReqBody;
import com.lark.oapi.service.im.v1.model.ForwardMessageResp;

// POST /open-apis/im/v1/messages/:message_id/forward
public class ForwardMessageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ForwardMessageReq req = ForwardMessageReq.newBuilder()
                .messageId("om_dc13264520392913993dd051dba21dcf")
                .receiveIdType("open_id")
                .uuid("b13g2t38-1jd2-458b-8djf-dtbca5104204")
                .forwardMessageReqBody(ForwardMessageReqBody.newBuilder()
                        .receiveId("oc_a0553eda9014c201e6969b478895c230")
                        .build())
                .build();

        // 发起请求
        ForwardMessageResp resp = client.im().message().forward(req);

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
