package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.CreatePublicMailboxReq;
import com.lark.oapi.service.mail.v1.model.CreatePublicMailboxResp;
import com.lark.oapi.service.mail.v1.model.PublicMailbox;

// POST /open-apis/mail/v1/public_mailboxes
public class CreatePublicMailboxSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreatePublicMailboxReq req = CreatePublicMailboxReq.newBuilder()
                .publicMailbox(PublicMailbox.newBuilder()
                        .email("test_public_mailbox@xxx.xx")
                        .name("test public mailbox")
                        .geo("cn")
                        .build())
                .build();

        // 发起请求
        CreatePublicMailboxResp resp = client.mail().publicMailbox().create(req);

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
