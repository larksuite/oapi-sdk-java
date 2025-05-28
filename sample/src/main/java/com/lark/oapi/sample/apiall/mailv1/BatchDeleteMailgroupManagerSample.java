package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.*;

import java.util.HashMap;

// POST /open-apis/mail/v1/mailgroups/:mailgroup_id/managers/batch_delete
public class BatchDeleteMailgroupManagerSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchDeleteMailgroupManagerReq req = BatchDeleteMailgroupManagerReq.newBuilder()
                .mailgroupId("xxxxxxxxxxxxxxx 或 test_mail_group@xxx.xx")
                .userIdType("open_id")
                .batchDeleteMailgroupManagerReqBody(BatchDeleteMailgroupManagerReqBody.newBuilder()
                        .mailgroupManagerList(new MailgroupManager[]{})
                        .build())
                .build();

        // 发起请求
        BatchDeleteMailgroupManagerResp resp = client.mail().v1().mailgroupManager().batchDelete(req);

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
