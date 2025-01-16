package com.lark.oapi.sample.apiall.cardkitv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.cardkit.v1.model.*;

import java.util.HashMap;

// POST /open-apis/cardkit/v1/cards/:card_id/batch_update
public class BatchUpdateCardSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchUpdateCardReq req = BatchUpdateCardReq.newBuilder()
                .cardId("7355439197428236291")
                .batchUpdateCardReqBody(BatchUpdateCardReqBody.newBuilder()
                        .uuid("191857678434")
                        .sequence(1712578784)
                        .actions("")
                        .build())
                .build();

        // 发起请求
        BatchUpdateCardResp resp = client.cardkit().v1().card().batchUpdate(req);

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
