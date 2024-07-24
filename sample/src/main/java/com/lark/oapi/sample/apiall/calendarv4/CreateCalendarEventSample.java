package com.lark.oapi.sample.apiall.calendarv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.calendar.v4.model.*;
import java.util.HashMap;

// POST /open-apis/calendar/v4/calendars/:calendar_id/events
public class CreateCalendarEventSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateCalendarEventReq req = CreateCalendarEventReq.newBuilder()
			 .calendarId("feishu.cn_xxxxxxxxxx@group.calendar.feishu.cn")
			 .idempotencyKey("25fdf41b-8c80-2ce1-e94c-de8b5e7aa7e6")
			 .userIdType("user_id")
			.calendarEvent(CalendarEvent.newBuilder()
				 .summary("日程标题")
				 .description("日程描述")
				 .needNotification(false)
				 .startTime(TimeInfo.newBuilder().build())
				 .endTime(TimeInfo.newBuilder().build())
				 .vchat(Vchat.newBuilder().build())
				 .visibility("default")
				 .attendeeAbility("none")
				 .freeBusyStatus("busy")
				 .location(EventLocation.newBuilder().build())
				 .color(0)
				 .reminders(new Reminder[]{})
				 .recurrence("FREQ=DAILY;INTERVAL=1")
				 .schemas(new Schema[]{})
				 .attachments(new Attachment[]{})
				  .build())
			 .build();

	  // 发起请求
	  CreateCalendarEventResp resp = client.calendar().v4().calendarEvent().create(req);

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
