package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.FollowUp;
import com.lark.oapi.service.im.v1.model.PushFollowUpMessageReq;
import com.lark.oapi.service.im.v1.model.PushFollowUpMessageReqBody;
import com.lark.oapi.service.im.v1.model.PushFollowUpMessageResp;

// POST /open-apis/im/v1/messages/:message_id/push_follow_up
public class PushFollowUpMessageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PushFollowUpMessageReq req = PushFollowUpMessageReq.newBuilder()
                .messageId("om_3210a18894e206715a4359115f4cf2f5")
                .pushFollowUpMessageReqBody(PushFollowUpMessageReqBody.newBuilder()
                        .followUps(new FollowUp[]{})
                        .build())
                .build();

        // 发起请求
        PushFollowUpMessageResp resp = client.im().v1().message().pushFollowUp(req);

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
