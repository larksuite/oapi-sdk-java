package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.GetLeaveEmployExpireRecordReq;
import com.lark.oapi.service.attendance.v1.model.GetLeaveEmployExpireRecordReqBody;
import com.lark.oapi.service.attendance.v1.model.GetLeaveEmployExpireRecordResp;

// GET /open-apis/attendance/v1/leave_employ_expire_records/:leave_id
public class GetLeaveEmployExpireRecordSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetLeaveEmployExpireRecordReq req = GetLeaveEmployExpireRecordReq.newBuilder()
                .leaveId("1")
                .userIdType("open_id")
                .getLeaveEmployExpireRecordReqBody(GetLeaveEmployExpireRecordReqBody.newBuilder()
                        .employmentId("1")
                        .leaveTypeId("1")
                        .startExpirationDate("2023-04-10")
                        .endExpirationDate("2023-05-10")
                        .timeOffset(480)
                        .build())
                .build();

        // 发起请求
        GetLeaveEmployExpireRecordResp resp = client.attendance().leaveEmployExpireRecord().get(req);

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
