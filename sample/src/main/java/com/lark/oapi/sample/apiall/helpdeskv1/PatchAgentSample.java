package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.PatchAgentReq;
import com.lark.oapi.service.helpdesk.v1.model.PatchAgentReqBody;
import com.lark.oapi.service.helpdesk.v1.model.PatchAgentResp;

// PATCH /open-apis/helpdesk/v1/agents/:agent_id
public class PatchAgentSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    PatchAgentReq req = PatchAgentReq.newBuilder()
        .agentId("ou_14777d82ffef0f707de5a8c7ff2c5ebe")
        .patchAgentReqBody(PatchAgentReqBody.newBuilder()
            .status(0)
            .build())
        .build();

    // 发起请求
    PatchAgentResp resp = client.helpdesk().agent().patch(req);

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
