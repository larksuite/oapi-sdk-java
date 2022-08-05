package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.Member;
import com.lark.oapi.service.drive.v1.model.UpdatePermissionMemberReq;
import com.lark.oapi.service.drive.v1.model.UpdatePermissionMemberResp;

// HTTP PATH: /open-apis/drive/v1/permissions/:token/members/:member_id"
public class UpdatePermissionMemberSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    UpdatePermissionMemberReq req = UpdatePermissionMemberReq.newBuilder()
        .token("")
        .memberId("")
        .needNotification(false)
        .type("doc")
        .member(Member.newBuilder()
            .memberType("openid")
            .perm("view")
            .build())
        .build();

    // 发起请求
    UpdatePermissionMemberResp resp = client.drive().permissionMember().update(req);

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
