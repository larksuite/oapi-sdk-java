package com.lark.oapi.sample.apiall.calendarv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.calendar.v4.model.AclScope;
import com.lark.oapi.service.calendar.v4.model.CalendarAcl;
import com.lark.oapi.service.calendar.v4.model.CreateCalendarAclReq;
import com.lark.oapi.service.calendar.v4.model.CreateCalendarAclResp;

// POST /open-apis/calendar/v4/calendars/:calendar_id/acls
public class CreateCalendarAclSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateCalendarAclReq req = CreateCalendarAclReq.newBuilder()
                .calendarId("feishu.cn_xxxxxxxxxx@group.calendar.feishu.cn")
                .userIdType("user_id")
                .calendarAcl(CalendarAcl.newBuilder()
                        .role("unknown")
                        .scope(AclScope.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        CreateCalendarAclResp resp = client.calendar().calendarAcl().create(req);

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
