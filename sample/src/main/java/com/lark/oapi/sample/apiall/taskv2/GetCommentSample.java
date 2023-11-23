package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.GetCommentReq;
import com.lark.oapi.service.task.v2.model.GetCommentResp;

// GET /open-apis/task/v2/comments/:comment_id
public class GetCommentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetCommentReq req = GetCommentReq.newBuilder()
                .commentId("7198104824246747156")
                .userIdType("open_id")
                .build();

        // 发起请求
        GetCommentResp resp = client.task().v2().comment().get(req);

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
