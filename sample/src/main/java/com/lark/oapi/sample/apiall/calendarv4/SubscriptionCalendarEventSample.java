package com.lark.oapi.sample.apiall.calendarv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.calendar.v4.model.SubscriptionCalendarEventReq;
import com.lark.oapi.service.calendar.v4.model.SubscriptionCalendarEventResp;

// HTTP PATH: /open-apis/calendar/v4/calendars/:calendar_id/events/subscription"
public class SubscriptionCalendarEventSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    SubscriptionCalendarEventReq req = SubscriptionCalendarEventReq.newBuilder()
        .calendarId("")
        .build();

    // 发起请求
    SubscriptionCalendarEventResp resp = client.calendar().calendarEvent().subscription(req);

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
