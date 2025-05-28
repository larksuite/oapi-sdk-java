package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/job_changes
public class CreateJobChangeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateJobChangeReq req = CreateJobChangeReq.newBuilder()
                .userIdType("open_id")
                .departmentIdType("people_corehr_department_id")
                .createJobChangeReqBody(CreateJobChangeReqBody.newBuilder()
                        .transferMode(2)
                        .employmentId("ou_a294793e8fa21529f2a60e3e9de45520")
                        .transferTypeUniqueIdentifier("internal_transfer")
                        .flowId("people_6963913041981490725_6983885526583627531")
                        .effectiveDate("2022-03-01")
                        .transferInfo(CreateTransferInfo.newBuilder().build())
                        .transferKey("transfer_3627531")
                        .initiatorId("ou_a294793e8fa21529f2a60e3e9de45520")
                        .transferReasonUniqueIdentifier("involuntary_transfer")
                        .build())
                .build();

        // 发起请求
        CreateJobChangeResp resp = client.corehr().v2().jobChange().create(req);

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
