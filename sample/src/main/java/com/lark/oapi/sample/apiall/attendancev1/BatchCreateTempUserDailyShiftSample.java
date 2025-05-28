package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.*;

import java.util.HashMap;

// POST /open-apis/attendance/v1/user_daily_shifts/batch_create_temp
public class BatchCreateTempUserDailyShiftSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchCreateTempUserDailyShiftReq req = BatchCreateTempUserDailyShiftReq.newBuilder()
                .employeeType("employee_id")
                .batchCreateTempUserDailyShiftReqBody(BatchCreateTempUserDailyShiftReqBody.newBuilder()
                        .userTmpDailyShifts(new UserTmpDailyShift[]{})
                        .operatorId("dd31248a")
                        .build())
                .build();

        // 发起请求
        BatchCreateTempUserDailyShiftResp resp = client.attendance().v1().userDailyShift().batchCreateTemp(req);

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
