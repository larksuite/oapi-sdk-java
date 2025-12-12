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
                .sendUserMailboxMessageReqBody(SendUserMailboxMessageReqBody.newBuilder()
                        .subject("邮件标题")
                        .to(new MailAddress[]{})
                        .raw("U3ViamVjdDogSGVsbG8hCkZyb206ICJtaWtlIiA8bWlrZUBtaWtlLmNvbT4KTWltZS1WZXJzaW9uOiAxLjAKQ29udGVudC1UeXBlOiBtdWx0aXBhcnQvYWx0ZXJuYXRpdmU7CiBib3VuZGFyeT1iMjhmYTIyNGExZWU2ZDY3ZjE3OTViNGUxZDEwM2Q3MTBlNzM5ZWVmYjFmZjlmOWQ4NWI4M2NlOTRmMTEKRGF0ZTogV2VkLCAyMyBKdWwgMjAyNSAxNTo0NDoxOCArMDgwMApNZXNzYWdlLUlkOiA8bW9ja3V1aWRtZXNzYWdlX2lkQGxhcmsuY29tPgpUbzogImphY2siIDxqYWNrQGphY2suY29tPgoKLS1iMjhmYTIyNGExZWU2ZDY3ZjE3OTViNGUxZDEwM2Q3MTBlNzM5ZWVmYjFmZjlmOWQ4NWI4M2NlOTRmMTEKQ29udGVudC1UcmFuc2Zlci1FbmNvZGluZzogN2JpdApDb250ZW50LVR5cGU6IHRleHQvcGxhaW47IGNoYXJzZXQ9VVRGLTgKCldlbGNvbWUgdG8gTGFyayBtYWlsIQotLWIyOGZhMjI0YTFlZTZkNjdmMTc5NWI0ZTFkMTAzZDcxMGU3MzllZWZiMWZmOWY5ZDg1YjgzY2U5NGYxMQo=")
                        .cc(new MailAddress[]{})
                        .bcc(new MailAddress[]{})
                        .bodyHtml("xxxx")
                        .bodyPlainText("xxxx")
                        .attachments(new Attachment[]{})
                        .dedupeKey("abc-ddd-eee-fff-ggg")
                        .headFrom(MailAddress.newBuilder().build())
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
