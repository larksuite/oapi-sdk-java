package com.lark.oapi.sample.apiall.imv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.im.v1.model.*;

import java.util.HashMap;

// POST /open-apis/im/v1/messages/reactions/batch_query
public class BatchQueryMessageReactionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchQueryMessageReactionReq req = BatchQueryMessageReactionReq.newBuilder()
                .userIdType("open_id")
                .batchQueryMessageReactionReqBody(BatchQueryMessageReactionReqBody.newBuilder()
                        .queries(new MessageQuery[]{})
                        .pageSizePerMessage(10)
                        .reactionType("LAUGH")
                        .build())
                .build();

        // 发起请求
        BatchQueryMessageReactionResp resp = client.im().v1().messageReaction().batchQuery(req);

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
