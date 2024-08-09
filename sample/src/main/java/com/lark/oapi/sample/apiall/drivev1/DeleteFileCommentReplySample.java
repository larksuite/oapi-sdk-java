package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.*;

import java.util.HashMap;

// DELETE /open-apis/drive/v1/files/:file_token/comments/:comment_id/replies/:reply_id
public class DeleteFileCommentReplySample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteFileCommentReplyReq req = DeleteFileCommentReplyReq.newBuilder()
                .fileToken("doccnHh7U87HOFpii5u5G*****")
                .commentId("6916106822734578184")
                .replyId("6916106822734594568")
                .fileType("doc")
                .build();

        // 发起请求
        DeleteFileCommentReplyResp resp = client.drive().v1().fileCommentReply().delete(req);

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
