package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.AddGroupMemberReq;
import com.lark.oapi.service.contact.v3.model.AddGroupMemberReqBody;
import com.lark.oapi.service.contact.v3.model.AddGroupMemberResp;

// HTTP PATH: /open-apis/contact/v3/group/:group_id/member/add"
public class AddGroupMemberSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    AddGroupMemberReq req = AddGroupMemberReq.newBuilder()
        .groupId("")
        .addGroupMemberReqBody(AddGroupMemberReqBody.newBuilder()
            .memberType("user")
            .memberIdType("open_id")
            .memberId("")
            .build())
        .build();

    // 发起请求
    AddGroupMemberResp resp = client.contact().groupMember().add(req);

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
