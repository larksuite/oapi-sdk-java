package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.SimplelistGroupMemberReq;
import com.lark.oapi.service.contact.v3.model.SimplelistGroupMemberResp;

// HTTP PATH: /open-apis/contact/v3/group/:group_id/member/simplelist"
public class SimplelistGroupMemberSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    SimplelistGroupMemberReq req = SimplelistGroupMemberReq.newBuilder()
        .groupId("")
        .pageSize(50)
        .pageToken("")
        .memberIdType("open_id")
        .memberType("user")
        .build();

    // 发起请求
    SimplelistGroupMemberResp resp = client.contact().groupMember().simplelist(req);

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
