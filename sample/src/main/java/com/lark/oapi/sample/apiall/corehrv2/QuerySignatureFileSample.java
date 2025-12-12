package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/signature_files/query
public class QuerySignatureFileSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        QuerySignatureFileReq req = QuerySignatureFileReq.newBuilder()
                .signatureFileId("6891251722631890445")
                .pageSize(0)
                .pageToken("")
                .updateTimeStart("2022-01-01 00:00:00")
                .updateTimeEnd("2022-01-01 00:00:00")
                .userIdType("people_corehr_id")
                .querySignatureFileReqBody(QuerySignatureFileReqBody.newBuilder()
                        .states(new String[]{})
                        .templateIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        QuerySignatureFileResp resp = client.corehr().v2().signatureFile().query(req);

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
