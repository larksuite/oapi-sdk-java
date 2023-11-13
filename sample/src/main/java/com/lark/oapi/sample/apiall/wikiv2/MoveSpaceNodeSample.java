package com.lark.oapi.sample.apiall.wikiv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.wiki.v2.model.MoveSpaceNodeReq;
import com.lark.oapi.service.wiki.v2.model.MoveSpaceNodeReqBody;
import com.lark.oapi.service.wiki.v2.model.MoveSpaceNodeResp;

// POST /open-apis/wiki/v2/spaces/:space_id/nodes/:node_token/move
public class MoveSpaceNodeSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        MoveSpaceNodeReq req = MoveSpaceNodeReq.newBuilder()
                .spaceId("7008061636015512345")
                .nodeToken("wikbcd6ydSUyOEzbdlt1BfpA5Yc")
                .moveSpaceNodeReqBody(MoveSpaceNodeReqBody.newBuilder()
                        .targetParentToken("wikbcd6ydSUyOEzbdlt1BfpA5Yc")
                        .targetSpaceId("7008061636015512345")
                        .build())
                .build();

        // 发起请求
        MoveSpaceNodeResp resp = client.wiki().spaceNode().move(req);

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
