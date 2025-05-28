package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.*;

import java.util.HashMap;

// POST /open-apis/mail/v1/user_mailboxes/:user_mailbox_id/rules
public class CreateUserMailboxRuleSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        CreateUserMailboxRuleReq req = CreateUserMailboxRuleReq.newBuilder()
                .userMailboxId("user@xxx.xx 或 me")
                .rule(Rule.newBuilder()
                        .condition(RuleCondition.newBuilder().build())
                        .action(RuleAction.newBuilder().build())
                        .ignoreTheRestOfRules(false)
                        .name("将李三的邮件标记为垃圾邮件")
                        .isEnable(false)
                        .build())
                .build();

        // 发起请求
        CreateUserMailboxRuleResp resp = client.mail().v1().userMailboxRule().create(req);

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
