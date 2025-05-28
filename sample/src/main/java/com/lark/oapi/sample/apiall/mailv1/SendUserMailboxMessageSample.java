package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.*;

import java.util.HashMap;

// POST /open-apis/mail/v1/user_mailboxes/:user_mailbox_id/messages/send
public class SendUserMailboxMessageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SendUserMailboxMessageReq req = SendUserMailboxMessageReq.newBuilder()
                .userMailboxId("user@xxx.xx 或 me")
                .message(Message.newBuilder()
                        .raw("Q29udGVudC1UeXBlOiB0ZXh0L3BsYWluOyBjaGFyc2V0PSJ1cy1hc2NpaSIKTUlNRS1WZXJzaW9uOiAxLjAKQ29udGVudC1UcmFuc2Zlci1FbmNvZGluZzogN2JpdAp0bzogdG9AeHh4Lnh4CmZyb206IHNlbmRlckB4eHgueHgKc3ViamVjdDogdGhpcyBpcyBhIHN1YmplY3QKCnRoaXMgaXMgdGhlIG1lc3NhZ2UgYm9keS4=")
                        .subject("邮件标题")
                        .to(new MailAddress[]{})
                        .cc(new MailAddress[]{})
                        .bcc(new MailAddress[]{})
                        .headFrom(MailAddress.newBuilder().build())
                        .bodyHtml("xxxx")
                        .bodyPlainText("xxxxx")
                        .attachments(new Attachment[]{})
                        .threadId("tfuh9N4WnzU6jdDw=")
                        .build())
                .build();

        // 发起请求
        SendUserMailboxMessageResp resp = client.mail().v1().userMailboxMessage().send(req);

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
