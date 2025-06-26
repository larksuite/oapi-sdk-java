package com.lark.oapi.sample.apiall.docxv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.docx.v1.model.*;

import java.util.HashMap;

// POST /open-apis/docx/v1/documents/blocks/convert
public class ConvertDocumentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ConvertDocumentReq req = ConvertDocumentReq.newBuilder()
                .userIdType("user_id")
                .convertDocumentReqBody(ConvertDocumentReqBody.newBuilder()
                        .contentType("markdown")
                        .content("")
                        .build())
                .build();

        // 发起请求
        ConvertDocumentResp resp = client.docx().v1().document().convert(req);

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
