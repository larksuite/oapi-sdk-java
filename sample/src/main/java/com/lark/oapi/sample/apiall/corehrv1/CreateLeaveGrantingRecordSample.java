package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.CreateLeaveGrantingRecordReq;
import com.lark.oapi.service.corehr.v1.model.CreateLeaveGrantingRecordReqBody;
import com.lark.oapi.service.corehr.v1.model.CreateLeaveGrantingRecordResp;
import com.lark.oapi.service.corehr.v1.model.I18n;

// POST /open-apis/corehr/v1/leave_granting_records
public class CreateLeaveGrantingRecordSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateLeaveGrantingRecordReq req = CreateLeaveGrantingRecordReq.newBuilder()
                .userIdType("open_id")
                .createLeaveGrantingRecordReqBody(CreateLeaveGrantingRecordReqBody.newBuilder()
                        .leaveTypeId("7111688079785723436")
                        .employmentId("6982509313466189342")
                        .grantingQuantity("0.5")
                        .grantingUnit(1)
                        .effectiveDate("2022-01-01")
                        .reason(new I18n[]{})
                        .externalId("111")
                        .build())
                .build();

        // 发起请求
        CreateLeaveGrantingRecordResp resp = client.corehr().leaveGrantingRecord().create(req);

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
