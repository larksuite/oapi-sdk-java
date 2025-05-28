package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v1.model.Enum;

// POST /open-apis/corehr/v1/leaves/work_calendar_date
public class WorkCalendarDateLeaveSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        WorkCalendarDateLeaveReq req = WorkCalendarDateLeaveReq.newBuilder()
                .calendarDateByDateFilter(CalendarDateByDateFilter.newBuilder()
                        .wkCalendarIds(new String[]{})
                        .dates(new String[]{})
                        .beginDate("")
                        .endDate("")
                        .offset(0)
                        .limit(10)
                        .ids(new String[]{})
                        .build())
                .build();

        // 发起请求
        WorkCalendarDateLeaveResp resp = client.corehr().v1().leave().workCalendarDate(req);

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
