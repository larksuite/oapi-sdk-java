package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.GetInterviewRecordReq;
import com.lark.oapi.service.hire.v1.model.GetInterviewRecordResp;

// GET /open-apis/hire/v1/interview_records/:interview_record_id
public class GetInterviewRecordSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetInterviewRecordReq req = GetInterviewRecordReq.newBuilder()
                .interviewRecordId("1618209327096")
                .userIdType("open_id")
                .build();

        // 发起请求
        GetInterviewRecordResp resp = client.hire().v1().interviewRecord().get(req);

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
