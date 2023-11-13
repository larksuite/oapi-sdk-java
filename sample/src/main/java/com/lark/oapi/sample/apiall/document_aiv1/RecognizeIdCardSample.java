package com.lark.oapi.sample.apiall.document_aiv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.document_ai.v1.model.RecognizeIdCardReq;
import com.lark.oapi.service.document_ai.v1.model.RecognizeIdCardReqBody;
import com.lark.oapi.service.document_ai.v1.model.RecognizeIdCardResp;

import java.io.File;

// POST /open-apis/document_ai/v1/id_card/recognize
public class RecognizeIdCardSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        RecognizeIdCardReq req = RecognizeIdCardReq.newBuilder()
                .recognizeIdCardReqBody(RecognizeIdCardReqBody.newBuilder()
                        .file(file)
                        .build())
                .build();

        // 发起请求
        RecognizeIdCardResp resp = client.documentAi().idCard().recognize(req);

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
