package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.ListInterviewRoundTypeReq;
import com.lark.oapi.service.hire.v1.model.ListInterviewRoundTypeResp;

// GET /open-apis/hire/v1/interview_round_types
public class ListInterviewRoundTypeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListInterviewRoundTypeReq req = ListInterviewRoundTypeReq.newBuilder()
                .processType(1)
                .build();

        // 发起请求
        ListInterviewRoundTypeResp resp = client.hire().v1().interviewRoundType().list(req);

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
