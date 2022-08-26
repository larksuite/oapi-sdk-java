package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.GetMailgroupPermissionMemberReq;
import com.lark.oapi.service.mail.v1.model.GetMailgroupPermissionMemberResp;

// GET /open-apis/mail/v1/mailgroups/:mailgroup_id/permission_members/:permission_member_id
public class GetMailgroupPermissionMemberSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    GetMailgroupPermissionMemberReq req = GetMailgroupPermissionMemberReq.newBuilder()
        .mailgroupId("xxxxxxxxxxxxxxx 或 test_mail_group@xxx.xx")
        .permissionMemberId("xxxxxxxxxxxxxxx")
        .userIdType("user_id")
        .departmentIdType("open_department_id")
        .build();

    // 发起请求
    GetMailgroupPermissionMemberResp resp = client.mail().mailgroupPermissionMember().get(req);

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
