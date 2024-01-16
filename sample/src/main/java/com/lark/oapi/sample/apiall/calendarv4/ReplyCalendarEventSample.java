package com.lark.oapi.sample.apiall.calendarv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.calendar.v4.model.ReplyCalendarEventReq;
import com.lark.oapi.service.calendar.v4.model.ReplyCalendarEventReqBody;
import com.lark.oapi.service.calendar.v4.model.ReplyCalendarEventResp;

// POST /open-apis/calendar/v4/calendars/:calendar_id/events/:event_id/reply
public class ReplyCalendarEventSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ReplyCalendarEventReq req = ReplyCalendarEventReq.newBuilder()
                .calendarId("feishu.cn_HF9U2MbibE8PPpjro6xjqa@group.calendar.feishu.cn")
                .eventId("75d28f9b-e35c-4230-8a83-4a661497db54_0")
                .replyCalendarEventReqBody(ReplyCalendarEventReqBody.newBuilder()
                        .rsvpStatus("accept")
                        .build())
                .build();

        // 发起请求
        ReplyCalendarEventResp resp = client.calendar().v4().calendarEvent().reply(req);

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
