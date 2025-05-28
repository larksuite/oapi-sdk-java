package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;

import java.util.HashMap;

// POST /open-apis/hire/v1/talents/batch_get_id
public class BatchGetIdTalentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchGetIdTalentReq req = BatchGetIdTalentReq.newBuilder()
                .batchGetIdTalentReqBody(BatchGetIdTalentReqBody.newBuilder()
                        .mobileCode("86")
                        .mobileNumberList(new String[]{})
                        .emailList(new String[]{})
                        .identificationType(1)
                        .identificationNumberList(new String[]{})
                        .build())
                .build();

        // 发起请求
        BatchGetIdTalentResp resp = client.hire().v1().talent().batchGetId(req);

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
