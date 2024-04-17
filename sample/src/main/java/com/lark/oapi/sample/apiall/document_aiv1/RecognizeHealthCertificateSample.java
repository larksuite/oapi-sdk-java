package com.lark.oapi.sample.apiall.document_aiv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.document_ai.v1.model.RecognizeHealthCertificateReq;
import com.lark.oapi.service.document_ai.v1.model.RecognizeHealthCertificateReqBody;
import com.lark.oapi.service.document_ai.v1.model.RecognizeHealthCertificateResp;

import java.io.File;

// POST /open-apis/document_ai/v1/health_certificate/recognize
public class RecognizeHealthCertificateSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        RecognizeHealthCertificateReq req = RecognizeHealthCertificateReq.newBuilder()
                .recognizeHealthCertificateReqBody(RecognizeHealthCertificateReqBody.newBuilder()
                        .file(file)
                        .build())
                .build();

        // 发起请求
        RecognizeHealthCertificateResp resp = client.documentAi().v1().healthCertificate().recognize(req);

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
