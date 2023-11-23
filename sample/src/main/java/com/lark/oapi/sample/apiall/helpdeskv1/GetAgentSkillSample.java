package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.GetAgentSkillReq;
import com.lark.oapi.service.helpdesk.v1.model.GetAgentSkillResp;

// GET /open-apis/helpdesk/v1/agent_skills/:agent_skill_id
public class GetAgentSkillSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetAgentSkillReq req = GetAgentSkillReq.newBuilder()
                .agentSkillId("6941215891786825756")
                .build();

        // 发起请求
        GetAgentSkillResp resp = client.helpdesk().v1().agentSkill().get(req);

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
