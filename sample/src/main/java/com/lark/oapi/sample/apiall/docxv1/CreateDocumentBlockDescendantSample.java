package com.lark.oapi.sample.apiall.docxv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.docx.v1.model.*;

import java.util.HashMap;

// POST /open-apis/docx/v1/documents/:document_id/blocks/:block_id/descendant
public class CreateDocumentBlockDescendantSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateDocumentBlockDescendantReq req = CreateDocumentBlockDescendantReq.newBuilder()
                .documentId("Ew13dgs8BoZSetxd0CNbr0h3c8e")
                .blockId("Ew13dgs8BoZSetxd0CNbr0h3c8e")
                .documentRevisionId(-1)
                .clientToken("8aac2291-bc9e-4b12-a162-b3cf15bb06bd")
                .userIdType("user_id")
                .createDocumentBlockDescendantReqBody(CreateDocumentBlockDescendantReqBody.newBuilder()
                        .childrenId(new String[]{})
                        .index(-1)
                        .descendants(new Block[]{})
                        .build())
                .build();

        // 发起请求
        CreateDocumentBlockDescendantResp resp = client.docx().v1().documentBlockDescendant().create(req);

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
