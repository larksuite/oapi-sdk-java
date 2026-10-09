package com.lark.oapi.sample.apiall.agentv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.agent.v1.model.*;

// PATCH /open-apis/agent/v1/sessions/:session_id
public class ModifySessionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ModifySessionReq req =
                ModifySessionReq.newBuilder()
                        .sessionId("7442600000000000001")
                        .modifySessionReqBody(
                                ModifySessionReqBody.newBuilder().name("新的会话名称").build())
                        .build();

        // 发起请求
        ModifySessionResp resp = client.agent().v1().session().modify(req);

        // 处理服务端错误
        if (!resp.success()) {
            System.out.println(
                    String.format(
                            "code:%s,msg:%s,reqId:%s",
                            resp.getCode(), resp.getMsg(), resp.getRequestId()));
            return;
        }

        // 业务数据处理
        System.out.println(Jsons.DEFAULT.toJson(resp.getData()));
    }
}
