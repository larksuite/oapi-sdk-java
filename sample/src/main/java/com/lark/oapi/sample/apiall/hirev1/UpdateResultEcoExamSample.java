package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

// POST /open-apis/hire/v1/eco_exams/:exam_id/update_result
public class UpdateResultEcoExamSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateResultEcoExamReq req = UpdateResultEcoExamReq.newBuilder()
                .examId("7178536692385679677")
                .ecoExamResult(EcoExamResult.newBuilder()
                        .result("60.5")
                        .resultTime("1658676234053")
                        .reportList(new EcoExamResultReport[]{})
                        .detailList(new EcoExamResultDetail[]{})
                        .build())
                .build();

        // 发起请求
        UpdateResultEcoExamResp resp = client.hire().v1().ecoExam().updateResult(req);

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
