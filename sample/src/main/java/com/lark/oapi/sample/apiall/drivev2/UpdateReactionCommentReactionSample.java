package com.lark.oapi.sample.apiall.drivev2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v2.model.*;

import java.util.HashMap;

// POST /open-apis/drive/v2/files/:file_token/comments/reaction
public class UpdateReactionCommentReactionSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        UpdateReactionCommentReactionReq req = UpdateReactionCommentReactionReq.newBuilder()
                .fileToken("ppHV2Xepq2BQk3K79FTB")
                .fileType("docx")
                .updateReactionCommentReactionReqBody(UpdateReactionCommentReactionReqBody.newBuilder()
                        .action("add/delete")
                        .replyId("1234567890")
                        .reactionType("like")
                        .build())
                .build();

        // 发起请求
        UpdateReactionCommentReactionResp resp = client.drive().v2().commentReaction().updateReaction(req);

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
