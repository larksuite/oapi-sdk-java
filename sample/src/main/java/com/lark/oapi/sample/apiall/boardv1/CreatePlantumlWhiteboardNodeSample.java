package com.lark.oapi.sample.apiall.boardv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.board.v1.model.*;

import java.util.HashMap;

// POST /open-apis/board/v1/whiteboards/:whiteboard_id/nodes/plantuml
public class CreatePlantumlWhiteboardNodeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreatePlantumlWhiteboardNodeReq req = CreatePlantumlWhiteboardNodeReq.newBuilder()
                .whiteboardId("VF5Bwo7Z5icC0bk8EWbb57Vbckh")
                .createPlantumlWhiteboardNodeReqBody(CreatePlantumlWhiteboardNodeReqBody.newBuilder()
                        .plantUmlCode("")
                        .styleType(1)
                        .syntaxType(0)
                        .diagramType(0)
                        .overwrite(false)
                        .parseMode(0)
                        .build())
                .build();

        // 发起请求
        CreatePlantumlWhiteboardNodeResp resp = client.board().v1().whiteboardNode().createPlantuml(req);

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
