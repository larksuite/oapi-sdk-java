package com.lark.oapi.sample.apiall.cardkitv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.cardkit.v1.model.*;

import java.util.HashMap;

// PATCH /open-apis/cardkit/v1/cards/:card_id/settings
public class SettingsCardSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SettingsCardReq req = SettingsCardReq.newBuilder()
                .cardId("7355372766134157313")
                .settingsCardReqBody(SettingsCardReqBody.newBuilder()
                        .settings("")
                        .uuid("191857678434")
                        .sequence(1712578784)
                        .build())
                .build();

        // 发起请求
        SettingsCardResp resp = client.cardkit().v1().card().settings(req);

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
