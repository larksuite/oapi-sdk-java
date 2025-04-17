package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.*;

import java.util.HashMap;

// DELETE /open-apis/mail/v1/user_mailboxes/:user_mailbox_id/mail_contacts/:mail_contact_id
public class DeleteUserMailboxMailContactSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        DeleteUserMailboxMailContactReq req = DeleteUserMailboxMailContactReq.newBuilder()
                .userMailboxId("用户邮箱地址 或 输入me代表当前调用接口用户")
                .mailContactId("123")
                .build();

        // 发起请求
        DeleteUserMailboxMailContactResp resp = client.mail().v1().userMailboxMailContact().delete(req);

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
