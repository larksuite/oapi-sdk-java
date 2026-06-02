package com.lark.oapi.sample.apiall.boardv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.board.v1.model.*;

import java.util.HashMap;

// DELETE /open-apis/board/v1/whiteboards/:whiteboard_id/nodes/batch_delete
public class BatchDeleteWhiteboardNodeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchDeleteWhiteboardNodeReq req = BatchDeleteWhiteboardNodeReq.newBuilder()
                .whiteboardId("Ru8nwrWFOhEmaFbEU2VbPRsHcxb")
                .clientToken("fe599b60-450f-46ff-b2ef-9f6675625b97")
                .batchDeleteWhiteboardNodeReqBody(BatchDeleteWhiteboardNodeReqBody.newBuilder()
                        .ids(new String[]{})
                        .build())
                .build();

        // 发起请求
        BatchDeleteWhiteboardNodeResp resp = client.board().v1().whiteboardNode().batchDelete(req);

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
