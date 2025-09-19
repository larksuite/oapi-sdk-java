package com.lark.oapi.sample.apiall.calendarv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.calendar.v4.model.*;

import java.util.HashMap;

// POST /open-apis/calendar/v4/freebusy/batch
public class BatchFreebusySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchFreebusyReq req = BatchFreebusyReq.newBuilder()
                .userIdType("user_id")
                .batchFreebusyReqBody(BatchFreebusyReqBody.newBuilder()
                        .timeMin("2020-10-28T12:00:00+08:00")
                        .timeMax("2020-10-28T12:00:00+08:00")
                        .userIds(new String[]{})
                        .includeExternalCalendar(true)
                        .onlyBusy(true)
                        .build())
                .build();

        // 发起请求
        BatchFreebusyResp resp = client.calendar().v4().freebusy().batch(req);

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
