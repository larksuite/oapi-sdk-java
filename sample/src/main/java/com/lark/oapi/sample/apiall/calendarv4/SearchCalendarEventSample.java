package com.lark.oapi.sample.apiall.calendarv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.calendar.v4.model.EventSearchFilter;
import com.lark.oapi.service.calendar.v4.model.SearchCalendarEventReq;
import com.lark.oapi.service.calendar.v4.model.SearchCalendarEventReqBody;
import com.lark.oapi.service.calendar.v4.model.SearchCalendarEventResp;

// POST /open-apis/calendar/v4/calendars/:calendar_id/events/search
public class SearchCalendarEventSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    SearchCalendarEventReq req = SearchCalendarEventReq.newBuilder()
        .calendarId("feishu.cn_xxxxxxxxxx@group.calendar.feishu.cn")
        .userIdType("user_id")
        .pageToken("xxxxx")
        .pageSize(20)
        .searchCalendarEventReqBody(SearchCalendarEventReqBody.newBuilder()
            .query("query words")
            .filter(EventSearchFilter.newBuilder().build())
            .build())
        .build();

    // 发起请求
    SearchCalendarEventResp resp = client.calendar().calendarEvent().search(req);

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
