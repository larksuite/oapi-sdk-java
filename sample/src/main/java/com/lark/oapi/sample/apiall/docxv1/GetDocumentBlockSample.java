package com.lark.oapi.sample.apiall.docxv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.docx.v1.model.*;

import java.util.HashMap;

// GET /open-apis/docx/v1/documents/:document_id/blocks/:block_id
public class GetDocumentBlockSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetDocumentBlockReq req = GetDocumentBlockReq.newBuilder()
                .documentId("doxcnePuYufKa49ISjhD8Ih0ikh")
                .blockId("doxcnO6UW6wAw2qIcYf4hZpFIth")
                .documentRevisionId(-1)
                .userIdType("user_id")
                .build();

        // 发起请求
        GetDocumentBlockResp resp = client.docx().v1().documentBlock().get(req);

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
