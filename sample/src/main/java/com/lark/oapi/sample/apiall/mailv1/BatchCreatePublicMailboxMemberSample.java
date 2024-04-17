package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.BatchCreatePublicMailboxMemberReq;
import com.lark.oapi.service.mail.v1.model.BatchCreatePublicMailboxMemberReqBody;
import com.lark.oapi.service.mail.v1.model.BatchCreatePublicMailboxMemberResp;
import com.lark.oapi.service.mail.v1.model.PublicMailboxMember;

// POST /open-apis/mail/v1/public_mailboxes/:public_mailbox_id/members/batch_create
public class BatchCreatePublicMailboxMemberSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchCreatePublicMailboxMemberReq req = BatchCreatePublicMailboxMemberReq.newBuilder()
                .publicMailboxId("xxxxxxxxxxxxxxx or test_public_mailbox@xxx.xx")
                .userIdType("user_id")
                .batchCreatePublicMailboxMemberReqBody(BatchCreatePublicMailboxMemberReqBody.newBuilder()
                        .items(new PublicMailboxMember[]{})
                        .build())
                .build();

        // 发起请求
        BatchCreatePublicMailboxMemberResp resp = client.mail().v1().publicMailboxMember().batchCreate(req);

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
