package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.DeleteAttachmentReq;
import com.lark.oapi.service.task.v2.model.DeleteAttachmentResp;

// DELETE /open-apis/task/v2/attachments/:attachment_guid
public class DeleteAttachmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteAttachmentReq req = DeleteAttachmentReq.newBuilder()
                .attachmentGuid("b59aa7a3-e98c-4830-8273-cbb29f89b837")
                .build();

        // 发起请求
        DeleteAttachmentResp resp = client.task().v2().attachment().delete(req);

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
