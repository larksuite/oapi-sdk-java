package com.lark.oapi.sample.apiall.imv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v2.model.*;

import java.util.HashMap;

// PATCH /open-apis/im/v2/feed_cards/bot_time_sentive
public class BotTimeSentiveFeedCardSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BotTimeSentiveFeedCardReq req = BotTimeSentiveFeedCardReq.newBuilder()
                .userIdType("open_id")
                .botTimeSentiveFeedCardReqBody(BotTimeSentiveFeedCardReqBody.newBuilder()
                        .timeSensitive(true)
                        .userIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        BotTimeSentiveFeedCardResp resp = client.im().v2().feedCard().botTimeSentive(req);

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
