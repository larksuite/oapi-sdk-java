package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.AgentScheduleUpdateInfo;
import com.lark.oapi.service.helpdesk.v1.model.PatchAgentSchedulesReq;
import com.lark.oapi.service.helpdesk.v1.model.PatchAgentSchedulesReqBody;
import com.lark.oapi.service.helpdesk.v1.model.PatchAgentSchedulesResp;

// PATCH /open-apis/helpdesk/v1/agents/:agent_id/schedules
public class PatchAgentSchedulesSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    PatchAgentSchedulesReq req = PatchAgentSchedulesReq.newBuilder()
        .agentId("123456")
        .patchAgentSchedulesReqBody(PatchAgentSchedulesReqBody.newBuilder()
            .agentSchedule(AgentScheduleUpdateInfo.newBuilder().build())
            .build())
        .build();

    // 发起请求
    PatchAgentSchedulesResp resp = client.helpdesk().agentSchedules().patch(req);

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
