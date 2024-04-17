package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.CreateMessageReactionReq;
import com.lark.oapi.service.im.v1.model.CreateMessageReactionReqBody;
import com.lark.oapi.service.im.v1.model.CreateMessageReactionResp;
import com.lark.oapi.service.im.v1.model.Emoji;

// POST /open-apis/im/v1/messages/:message_id/reactions
public class CreateMessageReactionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateMessageReactionReq req = CreateMessageReactionReq.newBuilder()
                .messageId("om_a8f2294b************a1a38afaac9d")
                .createMessageReactionReqBody(CreateMessageReactionReqBody.newBuilder()
                        .reactionType(Emoji.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        CreateMessageReactionResp resp = client.im().v1().messageReaction().create(req);

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
