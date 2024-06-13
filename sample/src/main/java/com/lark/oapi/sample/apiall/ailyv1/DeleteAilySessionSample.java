package com.lark.oapi.sample.apiall.ailyv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.aily.v1.model.*;

import java.util.HashMap;

// DELETE /open-apis/aily/v1/sessions/:aily_session_id
public class DeleteAilySessionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteAilySessionReq req = DeleteAilySessionReq.newBuilder()
                .ailySessionId("session_4dfunz7sp1g8m")
                .build();

        // 发起请求
        DeleteAilySessionResp resp = client.aily().v1().ailySession().delete(req);

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
