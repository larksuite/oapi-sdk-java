package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.Mailgroup;
import com.lark.oapi.service.mail.v1.model.PatchMailgroupReq;
import com.lark.oapi.service.mail.v1.model.PatchMailgroupResp;

// PATCH /open-apis/mail/v1/mailgroups/:mailgroup_id
public class PatchMailgroupSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    PatchMailgroupReq req = PatchMailgroupReq.newBuilder()
        .mailgroupId("xxxxxxxxxxxxxxx 或 test_mail_group@xxx.xx")
        .mailgroup(Mailgroup.newBuilder()
            .email("test_mail_group@xxx.xx")
            .name("test mail group")
            .description("mail group for testing")
            .whoCanSendMail("ALL_INTERNAL_USERS")
            .build())
        .build();

    // 发起请求
    PatchMailgroupResp resp = client.mail().mailgroup().patch(req);

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
