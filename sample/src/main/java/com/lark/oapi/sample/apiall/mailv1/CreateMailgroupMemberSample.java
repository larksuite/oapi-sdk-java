package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.CreateMailgroupMemberReq;
import com.lark.oapi.service.mail.v1.model.CreateMailgroupMemberResp;
import com.lark.oapi.service.mail.v1.model.MailgroupMember;

// HTTP PATH: /open-apis/mail/v1/mailgroups/:mailgroup_id/members"
public class CreateMailgroupMemberSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateMailgroupMemberReq req = CreateMailgroupMemberReq.newBuilder()
        .mailgroupId("xxxxxxxxxxxxxxx or test_mail_group@xxx.xx")
        .userIdType("user_id")
        .departmentIdType("department_id")
        .mailgroupMember(MailgroupMember.newBuilder()
            .email("test_memeber@xxx.xx")
            .userId("xxxxxxxxxx")
            .departmentId("xxxxxxxxxx")
            .type("USER")
            .build())
        .build();

    // 发起请求
    CreateMailgroupMemberResp resp = client.mail().mailgroupMember().create(req);

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
