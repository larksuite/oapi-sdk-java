package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.CalendarByScopeLeaveReq;
import com.lark.oapi.service.corehr.v1.model.CalendarByScopeLeaveResp;

// GET /open-apis/corehr/v1/leaves/calendar_by_scope
public class CalendarByScopeLeaveSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CalendarByScopeLeaveReq req = CalendarByScopeLeaveReq.newBuilder()
                .wkDepartmentId("")
                .wkCountryRegionId("")
                .wkEmployeeTypeId("")
                .wkWorkLocationId("")
                .wkWorkingHoursTypeId("")
                .wkJobFamilyId("")
                .wkCompanyId("")
                .build();

        // 发起请求
        CalendarByScopeLeaveResp resp = client.corehr().v1().leave().calendarByScope(req);

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
