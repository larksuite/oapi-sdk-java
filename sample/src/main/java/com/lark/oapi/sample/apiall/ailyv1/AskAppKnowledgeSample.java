package com.lark.oapi.sample.apiall.ailyv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.aily.v1.model.*;

import java.util.HashMap;

// POST /open-apis/aily/v1/apps/:app_id/knowledges/ask
public class AskAppKnowledgeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        AskAppKnowledgeReq req = AskAppKnowledgeReq.newBuilder()
                .appId("spring_5862e4fea8__c")
                .askAppKnowledgeReqBody(AskAppKnowledgeReqBody.newBuilder()
                        .message(AilyKnowledgeMessage.newBuilder().build())
                        .dataAssetIds(new String[]{})
                        .dataAssetTagIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        AskAppKnowledgeResp resp = client.aily().v1().appKnowledge().ask(req);

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
