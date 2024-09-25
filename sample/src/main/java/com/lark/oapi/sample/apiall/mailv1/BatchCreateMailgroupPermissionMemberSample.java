package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.BatchCreateMailgroupPermissionMemberReq;
import com.lark.oapi.service.mail.v1.model.BatchCreateMailgroupPermissionMemberReqBody;
import com.lark.oapi.service.mail.v1.model.BatchCreateMailgroupPermissionMemberResp;
import com.lark.oapi.service.mail.v1.model.MailgroupPermissionMember;

// POST /open-apis/mail/v1/mailgroups/:mailgroup_id/permission_members/batch_create
public class BatchCreateMailgroupPermissionMemberSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        BatchCreateMailgroupPermissionMemberReq req = BatchCreateMailgroupPermissionMemberReq.newBuilder()
                .mailgroupId("xxxxxxxxxxxxxxx or test_mail_group@xxx.xx")
                .userIdType("open_id")
                .departmentIdType("open_department_id")
                .batchCreateMailgroupPermissionMemberReqBody(BatchCreateMailgroupPermissionMemberReqBody.newBuilder()
                        .items(new MailgroupPermissionMember[]{})
                        .build())
                .build();

        // 发起请求
        BatchCreateMailgroupPermissionMemberResp resp = client.mail().v1().mailgroupPermissionMember().batchCreate(req);

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
