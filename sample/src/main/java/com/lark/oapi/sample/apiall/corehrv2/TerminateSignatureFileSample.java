package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/signature_files/terminate
public class TerminateSignatureFileSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        TerminateSignatureFileReq req = TerminateSignatureFileReq.newBuilder()
                .userIdType("people_corehr_id")
                .terminateSignatureFileReqBody(TerminateSignatureFileReqBody.newBuilder()
                        .ids(new String[]{})
                        .operator("7386593105085988884")
                        .terminateReason("需要重新签署, 因此终止签署的文件")
                        .build())
                .build();

        // 发起请求
        TerminateSignatureFileResp resp = client.corehr().v2().signatureFile().terminate(req);

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
