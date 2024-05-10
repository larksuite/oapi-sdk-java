package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.*;

import java.util.HashMap;

// POST /open-apis/attendance/v1/user_daily_shifts/batch_create
public class BatchCreateUserDailyShiftSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchCreateUserDailyShiftReq req = BatchCreateUserDailyShiftReq.newBuilder()
                .employeeType("employee_id")
                .batchCreateUserDailyShiftReqBody(BatchCreateUserDailyShiftReqBody.newBuilder()
                        .userDailyShifts(new UserDailyShift[]{})
                        .operatorId("dd31248a")
                        .build())
                .build();

        // 发起请求
        BatchCreateUserDailyShiftResp resp = client.attendance().v1().userDailyShift().batchCreate(req);

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
