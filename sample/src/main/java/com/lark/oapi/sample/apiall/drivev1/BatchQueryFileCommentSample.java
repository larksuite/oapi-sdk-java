package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.BatchQueryFileCommentReq;
import com.lark.oapi.service.drive.v1.model.BatchQueryFileCommentReqBody;
import com.lark.oapi.service.drive.v1.model.BatchQueryFileCommentResp;

// POST /open-apis/drive/v1/files/:file_token/comments/batch_query
public class BatchQueryFileCommentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchQueryFileCommentReq req = BatchQueryFileCommentReq.newBuilder()
                .fileToken("doxbcdl03Vsxhm7Qmnj110abcef")
                .fileType("doc;docx;sheet;file")
                .userIdType("user_id")
                .batchQueryFileCommentReqBody(BatchQueryFileCommentReqBody.newBuilder()
                        .commentIds(new String[]{})
                        .build())
                .build();

        // 发起请求
        BatchQueryFileCommentResp resp = client.drive().fileComment().batchQuery(req);

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
