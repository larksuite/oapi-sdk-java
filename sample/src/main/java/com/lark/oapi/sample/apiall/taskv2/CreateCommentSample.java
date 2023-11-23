package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.CreateCommentReq;
import com.lark.oapi.service.task.v2.model.CreateCommentResp;
import com.lark.oapi.service.task.v2.model.InputComment;

// POST /open-apis/task/v2/comments
public class CreateCommentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateCommentReq req = CreateCommentReq.newBuilder()
                .userIdType("open_id")
                .inputComment(InputComment.newBuilder()
                        .content("这是一条评论。")
                        .replyToCommentId("6937231762296684564")
                        .resourceType("task")
                        .resourceId("ccb55625-95d2-2e80-655f-0e40bf67953f")
                        .build())
                .build();

        // 发起请求
        CreateCommentResp resp = client.task().v2().comment().create(req);

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
