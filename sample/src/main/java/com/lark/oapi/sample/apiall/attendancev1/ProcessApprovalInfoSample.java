package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.ProcessApprovalInfoReq;
import com.lark.oapi.service.attendance.v1.model.ProcessApprovalInfoReqBody;
import com.lark.oapi.service.attendance.v1.model.ProcessApprovalInfoResp;

// POST /open-apis/attendance/v1/approval_infos/process
public class ProcessApprovalInfoSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ProcessApprovalInfoReq req = ProcessApprovalInfoReq.newBuilder()
                .processApprovalInfoReqBody(ProcessApprovalInfoReqBody.newBuilder()
                        .approvalId("6737202939523236113")
                        .approvalType("remedy")
                        .status(4)
                        .build())
                .build();

        // 发起请求
        ProcessApprovalInfoResp resp = client.attendance().v1().approvalInfo().process(req);

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
