package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.*;

import java.util.HashMap;

// POST /open-apis/drive/v1/files/:file_token/comments/:comment_id/replies
public class CreateFileCommentReplySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateFileCommentReplyReq req = CreateFileCommentReplyReq.newBuilder()
                .fileToken("TLLKdcpDro9ijQxA33ycNMabcef")
                .commentId("69161068xxxxx512356")
                .fileType("doc")
                .userIdType("user_id")
                .createFileCommentReplyReqBody(CreateFileCommentReplyReqBody.newBuilder()
                        .content(ReplyContent.newBuilder().build())
                        .extra("")
                        .build())
                .build();

        // 发起请求
        CreateFileCommentReplyResp resp = client.drive().v1().fileCommentReply().create(req);

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
