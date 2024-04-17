package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.InputAttachment;
import com.lark.oapi.service.task.v2.model.UploadAttachmentReq;
import com.lark.oapi.service.task.v2.model.UploadAttachmentResp;

import java.io.File;

// POST /open-apis/task/v2/attachments/upload
public class UploadAttachmentSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        File file = new File("filepath");
        UploadAttachmentReq req = UploadAttachmentReq.newBuilder()
                .userIdType("open_id")
                .inputAttachment(InputAttachment.newBuilder()
                        .resourceType("task")
                        .resourceId("fe96108d-b004-4a47-b2f8-6886e758b3a5")
                        .file(file)
                        .build())
                .build();

        // 发起请求
        UploadAttachmentResp resp = client.task().v2().attachment().upload(req);

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
