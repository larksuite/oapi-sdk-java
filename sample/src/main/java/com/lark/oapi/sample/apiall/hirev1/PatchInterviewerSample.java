package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.Interviewer;
import com.lark.oapi.service.hire.v1.model.PatchInterviewerReq;
import com.lark.oapi.service.hire.v1.model.PatchInterviewerReqBody;
import com.lark.oapi.service.hire.v1.model.PatchInterviewerResp;

// PATCH /open-apis/hire/v1/interviewers/:interviewer_id
public class PatchInterviewerSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        PatchInterviewerReq req = PatchInterviewerReq.newBuilder()
                .interviewerId("ou_7dab8a3d3cdcc9da365777c7ad535d62")
                .userIdType("user_id")
                .patchInterviewerReqBody(PatchInterviewerReqBody.newBuilder()
                        .interviewer(Interviewer.newBuilder().build())
                        .build())
                .build();

        // 发起请求
        PatchInterviewerResp resp = client.hire().v1().interviewer().patch(req);

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
