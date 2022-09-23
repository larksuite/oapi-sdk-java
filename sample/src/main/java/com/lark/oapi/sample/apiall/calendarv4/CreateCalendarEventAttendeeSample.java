package com.lark.oapi.sample.apiall.calendarv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.calendar.v4.model.*;
import java.util.HashMap;

// POST /open-apis/calendar/v4/calendars/:calendar_id/events/:event_id/attendees
public class CreateCalendarEventAttendeeSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateCalendarEventAttendeeReq req = CreateCalendarEventAttendeeReq.newBuilder()
			 .calendarId("feishu.cn_xxxxxxxxxx@group.calendar.feishu.cn")
			 .eventId("xxxxxxxxx_0")
			 .userIdType("user_id")
			.createCalendarEventAttendeeReqBody(CreateCalendarEventAttendeeReqBody.newBuilder()
				 .attendees(new CalendarEventAttendee[]{})
				 .needNotification(false)
				 .instanceStartTimeAdmin("1647320400")
				 .isEnableAdmin(false)
				  .build())
			 .build();

	  // 发起请求
	  CreateCalendarEventAttendeeResp resp = client.calendar().calendarEventAttendee().create(req);

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
