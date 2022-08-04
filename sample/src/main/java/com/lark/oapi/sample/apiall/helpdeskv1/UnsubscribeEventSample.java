package com.lark.oapi.sample.apiall.helpdeskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.helpdesk.v1.model.Event;
import com.lark.oapi.service.helpdesk.v1.model.UnsubscribeEventReq;
import com.lark.oapi.service.helpdesk.v1.model.UnsubscribeEventReqBody;
import com.lark.oapi.service.helpdesk.v1.model.UnsubscribeEventResp;

// HTTP PATH: /open-apis/helpdesk/v1/events/unsubscribe"
public class UnsubscribeEventSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    UnsubscribeEventReq req = UnsubscribeEventReq.newBuilder()
        .unsubscribeEventReqBody(UnsubscribeEventReqBody.newBuilder()
            .events(new Event[]{})
            .build())
        .build();

    // 发起请求
    UnsubscribeEventResp resp = client.helpdesk().event().unsubscribe(req);

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
