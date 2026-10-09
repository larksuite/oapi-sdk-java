package com.lark.oapi.sample.apiall.agentv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.agent.v1.model.*;

// POST /open-apis/agent/v1/sessions
public class CreateSessionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateSessionReq req =
                CreateSessionReq.newBuilder()
                        .createSessionReqBody(
                                CreateSessionReqBody.newBuilder()
                                        .uuid("0f3c9d2e-6b1a-4f7e-9c21-3d8a5e7b1c01")
                                        .name("员工调研分析报告")
                                        .initialEvents(new Event[] {})
                                        .build())
                        .build();

        // 发起请求
        CreateSessionResp resp = client.agent().v1().session().create(req);

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
