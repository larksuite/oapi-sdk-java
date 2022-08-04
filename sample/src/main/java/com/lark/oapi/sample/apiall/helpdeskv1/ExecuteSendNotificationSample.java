package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.ExecuteSendNotificationReq;
import com.lark.oapi.service.helpdesk.v1.model.ExecuteSendNotificationReqBody;
import com.lark.oapi.service.helpdesk.v1.model.ExecuteSendNotificationResp;

// HTTP PATH: /open-apis/helpdesk/v1/notifications/:notification_id/execute_send"
public class ExecuteSendNotificationSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    ExecuteSendNotificationReq req = ExecuteSendNotificationReq.newBuilder()
        .notificationId("6985032626234982420")
        .executeSendNotificationReqBody(ExecuteSendNotificationReqBody.newBuilder()
            .sendAt("1624326025000")
            .build())
        .build();

    // 发起请求
    ExecuteSendNotificationResp resp = client.helpdesk().notification().executeSend(req);

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
