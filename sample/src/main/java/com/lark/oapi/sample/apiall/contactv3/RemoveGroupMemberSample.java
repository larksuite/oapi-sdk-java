package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.RemoveGroupMemberReq;
import com.lark.oapi.service.contact.v3.model.RemoveGroupMemberReqBody;
import com.lark.oapi.service.contact.v3.model.RemoveGroupMemberResp;

// HTTP PATH: /open-apis/contact/v3/group/:group_id/member/remove"
public class RemoveGroupMemberSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    RemoveGroupMemberReq req = RemoveGroupMemberReq.newBuilder()
        .groupId("")
        .removeGroupMemberReqBody(RemoveGroupMemberReqBody.newBuilder()
            .memberType("user")
            .memberId("")
            .memberIdType("open_id")
            .build())
        .build();

    // 发起请求
    RemoveGroupMemberResp resp = client.contact().groupMember().remove(req);

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
