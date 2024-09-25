package com.lark.oapi.sample.apiall.ailyv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.aily.v1.model.ListAilySessionAilyMessageReq;
import com.lark.oapi.service.aily.v1.model.ListAilySessionAilyMessageResp;

// GET /open-apis/aily/v1/sessions/:aily_session_id/messages
public class ListAilySessionAilyMessageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListAilySessionAilyMessageReq req = ListAilySessionAilyMessageReq.newBuilder()
                .ailySessionId("session_4dfunz7sp1g8m")
                .pageSize(0)
                .pageToken("")
                .runId("run_4dfrxvctjqzzj")
                .withPartialMessage(false)
                .build();

        // 发起请求
        ListAilySessionAilyMessageResp resp = client.aily().v1().ailySessionAilyMessage().list(req);

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
