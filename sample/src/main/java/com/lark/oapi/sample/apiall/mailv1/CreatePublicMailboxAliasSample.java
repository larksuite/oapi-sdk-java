package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.CreatePublicMailboxAliasReq;
import com.lark.oapi.service.mail.v1.model.CreatePublicMailboxAliasResp;
import com.lark.oapi.service.mail.v1.model.EmailAlias;

// POST /open-apis/mail/v1/public_mailboxes/:public_mailbox_id/aliases
public class CreatePublicMailboxAliasSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreatePublicMailboxAliasReq req = CreatePublicMailboxAliasReq.newBuilder()
                .publicMailboxId("xxxxxx 或 xxx@xx.xxx")
                .emailAlias(EmailAlias.newBuilder()
                        .emailAlias("email_alias@xxx.xx")
                        .build())
                .build();

        // 发起请求
        CreatePublicMailboxAliasResp resp = client.mail().v1().publicMailboxAlias().create(req);

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
