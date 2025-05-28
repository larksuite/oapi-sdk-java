package com.lark.oapi.sample.apiall.cardkitv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.cardkit.v1.model.*;

import java.util.HashMap;

// PUT /open-apis/cardkit/v1/cards/:card_id
public class UpdateCardSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateCardReq req = UpdateCardReq.newBuilder()
                .cardId("7355372766134157313")
                .updateCardReqBody(UpdateCardReqBody.newBuilder()
                        .card(Card.newBuilder().build())
                        .uuid("191857678434")
                        .sequence(1712578784)
                        .build())
                .build();

        // 发起请求
        UpdateCardResp resp = client.cardkit().v1().card().update(req);

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
