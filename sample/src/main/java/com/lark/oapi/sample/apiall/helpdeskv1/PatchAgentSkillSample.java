package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.AgentSkill;
import com.lark.oapi.service.helpdesk.v1.model.PatchAgentSkillReq;
import com.lark.oapi.service.helpdesk.v1.model.PatchAgentSkillReqBody;
import com.lark.oapi.service.helpdesk.v1.model.PatchAgentSkillResp;

// HTTP PATH: /open-apis/helpdesk/v1/agent_skills/:agent_skill_id"
public class PatchAgentSkillSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    PatchAgentSkillReq req = PatchAgentSkillReq.newBuilder()
        .agentSkillId("")
        .patchAgentSkillReqBody(PatchAgentSkillReqBody.newBuilder()
            .agentSkill(AgentSkill.newBuilder().build())
            .build())
        .build();

    // 发起请求
    PatchAgentSkillResp resp = client.helpdesk().agentSkill().patch(req);

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
