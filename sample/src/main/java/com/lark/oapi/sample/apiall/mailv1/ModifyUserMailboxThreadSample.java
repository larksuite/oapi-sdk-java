package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.*;

import java.util.HashMap;

// POST /open-apis/mail/v1/user_mailboxes/:user_mailbox_id/threads/:thread_id/modify
public class ModifyUserMailboxThreadSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ModifyUserMailboxThreadReq req = ModifyUserMailboxThreadReq.newBuilder()
                .userMailboxId("me")
                .threadId("th_xxxxxxxxxxxx")
                .modifyUserMailboxThreadReqBody(ModifyUserMailboxThreadReqBody.newBuilder()
                        .addLabelIds(new String[]{})
                        .removeLabelIds(new String[]{})
                        .addFolder("INBOX")
                        .build())
                .build();

        // 发起请求
        ModifyUserMailboxThreadResp resp = client.mail().v1().userMailboxThread().modify(req);

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
