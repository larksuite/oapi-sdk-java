package com.lark.oapi.sample.apiall.calendarv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.calendar.v4.model.SearchCalendarReq;
import com.lark.oapi.service.calendar.v4.model.SearchCalendarReqBody;
import com.lark.oapi.service.calendar.v4.model.SearchCalendarResp;

// POST /open-apis/calendar/v4/calendars/search
public class SearchCalendarSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SearchCalendarReq req = SearchCalendarReq.newBuilder()
                .pageToken("10")
                .pageSize(20)
                .searchCalendarReqBody(SearchCalendarReqBody.newBuilder()
                        .query("query words")
                        .build())
                .build();

        // 发起请求
        SearchCalendarResp resp = client.calendar().v4().calendar().search(req);

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
