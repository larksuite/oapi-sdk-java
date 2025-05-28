package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.*;

import java.util.HashMap;

// GET /open-apis/mail/v1/user_mailboxes/:user_mailbox_id/messages/get_by_card
public class GetByCardUserMailboxMessageSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        GetByCardUserMailboxMessageReq req = GetByCardUserMailboxMessageReq.newBuilder()
                .userMailboxId("user@xxx.xx 或 me")
                .cardId("512ca581-6059-4449-8150-5522e6641d32")
                .ownerId("1234567890")
                .userIdType("open_id")
                .build();

        // 发起请求
        GetByCardUserMailboxMessageResp resp = client.mail().v1().userMailboxMessage().getByCard(req);

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
