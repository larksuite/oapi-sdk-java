package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;

import java.util.HashMap;

import com.lark.oapi.service.corehr.v2.model.Enum;

// GET /open-apis/corehr/v2/signature_files/list_by_biz_id
public class ListByBizIdSignatureFileSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListByBizIdSignatureFileReq req = ListByBizIdSignatureFileReq.newBuilder()
                .bizProcessId("129b83f5-c023-4e85-b2c7-80ce777e57fd")
                .bizType("OpenAPI")
                .userIdType("people_corehr_id")
                .selectSignUrl(false)
                .build();

        // 发起请求
        ListByBizIdSignatureFileResp resp = client.corehr().v2().signatureFile().listByBizId(req);

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
