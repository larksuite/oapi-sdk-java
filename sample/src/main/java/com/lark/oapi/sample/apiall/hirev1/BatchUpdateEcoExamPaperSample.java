package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.BatchUpdateEcoExamPaperReq;
import com.lark.oapi.service.hire.v1.model.BatchUpdateEcoExamPaperResp;
import com.lark.oapi.service.hire.v1.model.EcoExamPaper;
import com.lark.oapi.service.hire.v1.model.EcoExamPaperData;

// PATCH /open-apis/hire/v1/eco_exam_papers/batch_update
public class BatchUpdateEcoExamPaperSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchUpdateEcoExamPaperReq req = BatchUpdateEcoExamPaperReq.newBuilder()
                .ecoExamPaper(EcoExamPaper.newBuilder()
                        .accountId("7147998241542539527")
                        .paperList(new EcoExamPaperData[]{})
                        .build())
                .build();

        // 发起请求
        BatchUpdateEcoExamPaperResp resp = client.hire().ecoExamPaper().batchUpdate(req);

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
