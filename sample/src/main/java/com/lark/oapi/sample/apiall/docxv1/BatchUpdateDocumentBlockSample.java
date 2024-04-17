package com.lark.oapi.sample.apiall.docxv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.docx.v1.model.BatchUpdateDocumentBlockReq;
import com.lark.oapi.service.docx.v1.model.BatchUpdateDocumentBlockReqBody;
import com.lark.oapi.service.docx.v1.model.BatchUpdateDocumentBlockResp;
import com.lark.oapi.service.docx.v1.model.UpdateBlockRequest;

// PATCH /open-apis/docx/v1/documents/:document_id/blocks/batch_update
public class BatchUpdateDocumentBlockSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchUpdateDocumentBlockReq req = BatchUpdateDocumentBlockReq.newBuilder()
                .documentId("doxcnePuYufKa49ISjhD8Ih0ikh")
                .documentRevisionId(-1)
                .clientToken("0e2633a3-aa1a-4171-af9e-0768ff863566")
                .userIdType("user_id")
                .batchUpdateDocumentBlockReqBody(BatchUpdateDocumentBlockReqBody.newBuilder()
                        .requests(new UpdateBlockRequest[]{})
                        .build())
                .build();

        // 发起请求
        BatchUpdateDocumentBlockResp resp = client.docx().v1().documentBlock().batchUpdate(req);

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
