package com.lark.oapi.sample.apiall.calendarv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.calendar.v4.model.Calendar;
import com.lark.oapi.service.calendar.v4.model.CreateCalendarReq;
import com.lark.oapi.service.calendar.v4.model.CreateCalendarResp;

// POST /open-apis/calendar/v4/calendars
public class CreateCalendarSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateCalendarReq req = CreateCalendarReq.newBuilder()
                .calendar(Calendar.newBuilder()
                        .summary("summary")
                        .description("description")
                        .permissions("private")
                        .color(11034625)
                        .summaryAlias("xxx")
                        .build())
                .build();

        // 发起请求
        CreateCalendarResp resp = client.calendar().v4().calendar().create(req);

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
