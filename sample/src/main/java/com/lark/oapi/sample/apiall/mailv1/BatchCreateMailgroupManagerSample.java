package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.BatchCreateMailgroupManagerReq;
import com.lark.oapi.service.mail.v1.model.BatchCreateMailgroupManagerReqBody;
import com.lark.oapi.service.mail.v1.model.BatchCreateMailgroupManagerResp;
import com.lark.oapi.service.mail.v1.model.MailgroupManager;

// POST /open-apis/mail/v1/mailgroups/:mailgroup_id/managers/batch_create
public class BatchCreateMailgroupManagerSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchCreateMailgroupManagerReq req = BatchCreateMailgroupManagerReq.newBuilder()
                .mailgroupId("xxxxxx 或 test_mail_group@xx.xx")
                .userIdType("open_id")
                .batchCreateMailgroupManagerReqBody(BatchCreateMailgroupManagerReqBody.newBuilder()
                        .mailgroupManagerList(new MailgroupManager[]{})
                        .build())
                .build();

        // 发起请求
        BatchCreateMailgroupManagerResp resp = client.mail().mailgroupManager().batchCreate(req);

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
