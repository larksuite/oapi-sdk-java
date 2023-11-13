package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.DeleteInstanceCommentReq;
import com.lark.oapi.service.approval.v4.model.DeleteInstanceCommentResp;

// DELETE /open-apis/approval/v4/instances/:instance_id/comments/:comment_id
public class DeleteInstanceCommentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteInstanceCommentReq req = DeleteInstanceCommentReq.newBuilder()
                .instanceId("6A123516-FB88-470D-A428-9AF58B71B3C0")
                .commentId("7081516627711606803")
                .userIdType("user_id")
                .userId("ou_806a18fb5bdf525e38ba219733bdbd73")
                .build();

        // 发起请求
        DeleteInstanceCommentResp resp = client.approval().instanceComment().delete(req);

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
