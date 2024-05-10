package com.lark.oapi.sample.apiall.imv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v2.model.*;

import java.util.HashMap;

// PUT /open-apis/im/v2/chat_button
public class UpdateChatButtonSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateChatButtonReq req = UpdateChatButtonReq.newBuilder()
                .userIdType("open_id")
                .updateChatButtonReqBody(UpdateChatButtonReqBody.newBuilder()
                        .userIds(new String[]{})
                        .chatId("oc_a0553eda9014c201e6969b478895c230")
                        .buttons(OpenAppFeedCardButtons.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        UpdateChatButtonResp resp = client.im().v2().chatButton().update(req);

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
