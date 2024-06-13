package com.lark.oapi.sample.apiall.searchv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.search.v2.model.*;

import java.util.HashMap;

// POST /open-apis/search/v2/message
public class CreateMessageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateMessageReq req = CreateMessageReq.newBuilder()
                .userIdType("user_id")
                .pageSize(20)
                .pageToken("")
                .createMessageReqBody(CreateMessageReqBody.newBuilder()
                        .query("测试消息")
                        .fromIds(new String[]{})
                        .chatIds(new String[]{})
                        .messageType("file")
                        .atChatterIds(new String[]{})
                        .fromType("bot")
                        .chatType("group_chat")
                        .startTime("1609296809")
                        .endTime("1609296809")
                        .build())
                .build();

        // 发起请求
        CreateMessageResp resp = client.search().v2().message().create(req);

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
