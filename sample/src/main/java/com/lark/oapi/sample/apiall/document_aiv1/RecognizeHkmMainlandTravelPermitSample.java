package com.lark.oapi.sample.apiall.document_aiv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.document_ai.v1.model.RecognizeHkmMainlandTravelPermitReq;
import com.lark.oapi.service.document_ai.v1.model.RecognizeHkmMainlandTravelPermitReqBody;
import com.lark.oapi.service.document_ai.v1.model.RecognizeHkmMainlandTravelPermitResp;

import java.io.File;

// POST /open-apis/document_ai/v1/hkm_mainland_travel_permit/recognize
public class RecognizeHkmMainlandTravelPermitSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        RecognizeHkmMainlandTravelPermitReq req = RecognizeHkmMainlandTravelPermitReq.newBuilder()
                .recognizeHkmMainlandTravelPermitReqBody(RecognizeHkmMainlandTravelPermitReqBody.newBuilder()
                        .file(file)
                        .build())
                .build();

        // 发起请求
        RecognizeHkmMainlandTravelPermitResp resp = client.documentAi().hkmMainlandTravelPermit().recognize(req);

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
