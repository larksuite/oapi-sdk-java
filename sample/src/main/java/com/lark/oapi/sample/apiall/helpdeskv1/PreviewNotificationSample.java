package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.PreviewNotificationReq;
import com.lark.oapi.service.helpdesk.v1.model.PreviewNotificationResp;

// POST /open-apis/helpdesk/v1/notifications/:notification_id/preview
public class PreviewNotificationSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    PreviewNotificationReq req = PreviewNotificationReq.newBuilder()
        .notificationId("6985032626234982420")
        .build();

    // 发起请求
    PreviewNotificationResp resp = client.helpdesk().notification().preview(req);

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
