package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.ListMailgroupMemberReq;
import com.lark.oapi.service.mail.v1.model.ListMailgroupMemberResp;

// GET /open-apis/mail/v1/mailgroups/:mailgroup_id/members
public class ListMailgroupMemberSample {

    public static void main(String arg[]) throws Exception {
        // 构建client
        Client client = Client.newBuilder("appId", "appSecret").build();

        // 创建请求对象
        ListMailgroupMemberReq req = ListMailgroupMemberReq.newBuilder()
                .mailgroupId("xxxxxxxxxxxxxxx or test_mail_group@xxx.xx")
                .userIdType("user_id")
                .departmentIdType("open_department_id")
                .pageToken("xxx")
                .pageSize(20)
                .build();

        // 发起请求
        ListMailgroupMemberResp resp = client.mail().v1().mailgroupMember().list(req);

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
