package com.lark.oapi.sample.apiall.calendarv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.calendar.v4.model.*;

import java.util.HashMap;

// DELETE /open-apis/calendar/v4/timeoff_events/:timeoff_event_id
public class DeleteTimeoffEventSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteTimeoffEventReq req = DeleteTimeoffEventReq.newBuilder()
                .timeoffEventId("timeoff:XXXXXX-XXXX-0917-1623-aa493d591a39")
                .build();

        // 发起请求
        DeleteTimeoffEventResp resp = client.calendar().v4().timeoffEvent().delete(req);

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
