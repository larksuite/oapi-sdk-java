package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.LangText;
import com.lark.oapi.service.attendance.v1.model.PatchLeaveAccrualRecordReq;
import com.lark.oapi.service.attendance.v1.model.PatchLeaveAccrualRecordReqBody;
import com.lark.oapi.service.attendance.v1.model.PatchLeaveAccrualRecordResp;

// PATCH /open-apis/attendance/v1/leave_accrual_record/:leave_id
public class PatchLeaveAccrualRecordSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchLeaveAccrualRecordReq req = PatchLeaveAccrualRecordReq.newBuilder()
                .leaveId("1")
                .userIdType("open_id")
                .patchLeaveAccrualRecordReqBody(PatchLeaveAccrualRecordReqBody.newBuilder()
                        .leaveGrantingRecordId("1")
                        .employmentId("1")
                        .leaveTypeId("1")
                        .reason(new LangText[]{})
                        .timeOffset(480)
                        .expirationDate("2020-01-01")
                        .quantity("1")
                        .sectionType(1)
                        .build())
                .build();

        // 发起请求
        PatchLeaveAccrualRecordResp resp = client.attendance().v1().leaveAccrualRecord().patch(req);

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
