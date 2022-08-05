package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.CreateMailgroupAliasReq;
import com.lark.oapi.service.mail.v1.model.CreateMailgroupAliasResp;
import com.lark.oapi.service.mail.v1.model.EmailAlias;

// HTTP PATH: /open-apis/mail/v1/mailgroups/:mailgroup_id/aliases"
public class CreateMailgroupAliasSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateMailgroupAliasReq req = CreateMailgroupAliasReq.newBuilder()
        .mailgroupId("")
        .emailAlias(EmailAlias.newBuilder()
            .emailAlias("email_alias@xxx.xx")
            .build())
        .build();

    // 发起请求
    CreateMailgroupAliasResp resp = client.mail().mailgroupAlias().create(req);

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
