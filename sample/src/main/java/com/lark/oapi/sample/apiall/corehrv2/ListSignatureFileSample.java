package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// GET /open-apis/corehr/v2/signature_files
public class ListSignatureFileSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListSignatureFileReq req = ListSignatureFileReq.newBuilder()
                .signatureFileId("6891251722631890445")
                .pageSize(0)
                .pageToken("")
                .states("sign_finished,terminated")
                .updateTimeStart("2022-01-01 00:00:00")
                .updateTimeEnd("2022-01-01 00:00:00")
                .userIdType("people_corehr_id")
                .templateIds("7282756156156560940,6282751234556561278")
                .build();

        // 发起请求
        ListSignatureFileResp resp = client.corehr().v2().signatureFile().list(req);

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
