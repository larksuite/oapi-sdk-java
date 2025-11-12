package com.lark.oapi.sample.apiall.boardv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.board.v1.model.*;

import java.util.HashMap;

// POST /open-apis/board/v1/whiteboards/:whiteboard_id/update_theme
public class UpdateThemeWhiteboardSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateThemeWhiteboardReq req = UpdateThemeWhiteboardReq.newBuilder()
                .whiteboardId("KRy1wHU6dhmdWIbgkSIbqikMcQc")
                .updateThemeWhiteboardReqBody(UpdateThemeWhiteboardReqBody.newBuilder()
                        .theme("classic")
                        .build())
                .build();

        // 发起请求
        UpdateThemeWhiteboardResp resp = client.board().v1().whiteboard().updateTheme(req);

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
