package com.lark.oapi.sample.apiall.imv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v2.model.CreateAppFeedCardReq;
import com.lark.oapi.service.im.v2.model.CreateAppFeedCardReqBody;
import com.lark.oapi.service.im.v2.model.CreateAppFeedCardResp;
import com.lark.oapi.service.im.v2.model.OpenAppFeedCard;

// POST /open-apis/im/v2/app_feed_card
public class CreateAppFeedCardSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateAppFeedCardReq req = CreateAppFeedCardReq.newBuilder()
                .userIdType("open_id")
                .createAppFeedCardReqBody(CreateAppFeedCardReqBody.newBuilder()
                        .appFeedCard(OpenAppFeedCard.newBuilder().build())
                        .userIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        CreateAppFeedCardResp resp = client.im().v2().appFeedCard().create(req);

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