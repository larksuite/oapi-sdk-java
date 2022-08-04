package com.lark.oapi.sample.apiall.mailv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.mail.v1.model.DeleteMailgroupPermissionMemberReq;
import com.lark.oapi.service.mail.v1.model.DeleteMailgroupPermissionMemberResp;

// HTTP PATH: /open-apis/mail/v1/mailgroups/:mailgroup_id/permission_members/:permission_member_id"
public class DeleteMailgroupPermissionMemberSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    DeleteMailgroupPermissionMemberReq req = DeleteMailgroupPermissionMemberReq.newBuilder()
        .mailgroupId("xxxxxxxxxxxxxxx or test_mail_group@xxx.xx")
        .permissionMemberId("xxxxxxxxxxxxxxx")
        .build();

    // 发起请求
    DeleteMailgroupPermissionMemberResp resp = client.mail().mailgroupPermissionMember()
        .delete(req);

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
