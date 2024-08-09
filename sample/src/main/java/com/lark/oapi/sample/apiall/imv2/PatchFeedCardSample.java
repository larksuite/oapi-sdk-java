package com.lark.oapi.sample.apiall.imv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v2.model.*;

import java.util.HashMap;

// PATCH /open-apis/im/v2/feed_cards/:feed_card_id
public class PatchFeedCardSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchFeedCardReq req = PatchFeedCardReq.newBuilder()
                .feedCardId("oc_679eaeb583654bff73fefcc6e6371370")
                .userIdType("open_id")
                .patchFeedCardReqBody(PatchFeedCardReqBody.newBuilder()
                        .timeSensitive(true)
                        .userIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        PatchFeedCardResp resp = client.im().v2().feedCard().patch(req);

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
