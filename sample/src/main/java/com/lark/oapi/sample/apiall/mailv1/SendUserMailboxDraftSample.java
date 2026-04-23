package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.*;

import java.util.HashMap;

// POST /open-apis/mail/v1/user_mailboxes/:user_mailbox_id/drafts/:draft_id/send
public class SendUserMailboxDraftSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        SendUserMailboxDraftReq req = SendUserMailboxDraftReq.newBuilder()
                .userMailboxId("aba@aac.com")
                .draftId("268dce11-85f7-427d-8756-6be3abc850fd")
                .sendUserMailboxDraftReqBody(SendUserMailboxDraftReqBody.newBuilder()
                        .sendTime("1720000000")
                        .build())
                .build();

        // 发起请求
        SendUserMailboxDraftResp resp = client.mail().v1().userMailboxDraft().send(req);

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
