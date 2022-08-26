package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.AgentSkillRule;
import com.lark.oapi.service.helpdesk.v1.model.CreateAgentSkillReq;
import com.lark.oapi.service.helpdesk.v1.model.CreateAgentSkillReqBody;
import com.lark.oapi.service.helpdesk.v1.model.CreateAgentSkillResp;

// POST /open-apis/helpdesk/v1/agent_skills
public class CreateAgentSkillSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateAgentSkillReq req = CreateAgentSkillReq.newBuilder()
        .createAgentSkillReqBody(CreateAgentSkillReqBody.newBuilder()
            .name("test-skill")
            .rules(new AgentSkillRule[]{})
            .agentIds(new String[]{})
            .build())
        .build();

    // 发起请求
    CreateAgentSkillResp resp = client.helpdesk().agentSkill().create(req);

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
