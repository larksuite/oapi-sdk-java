package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.*;

import java.util.HashMap;

// DELETE /open-apis/mail/v1/mailgroups/:mailgroup_id/members/batch_delete
public class BatchDeleteMailgroupMemberSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchDeleteMailgroupMemberReq req = BatchDeleteMailgroupMemberReq.newBuilder()
                .mailgroupId("xxxxxxxxxxxxxxx or test_mail_group@xxx.xx")
                .batchDeleteMailgroupMemberReqBody(BatchDeleteMailgroupMemberReqBody.newBuilder()
                        .memberIdList(new String[]{})
                        .build())
                .build();

        // 发起请求
        BatchDeleteMailgroupMemberResp resp = client.mail().v1().mailgroupMember().batchDelete(req);

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
