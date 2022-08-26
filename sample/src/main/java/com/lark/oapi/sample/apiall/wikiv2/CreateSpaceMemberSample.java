package com.lark.oapi.sample.apiall.wikiv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.wiki.v2.model.CreateSpaceMemberReq;
import com.lark.oapi.service.wiki.v2.model.CreateSpaceMemberResp;
import com.lark.oapi.service.wiki.v2.model.Member;

// POST /open-apis/wiki/v2/spaces/:space_id/members
public class CreateSpaceMemberSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateSpaceMemberReq req = CreateSpaceMemberReq.newBuilder()
        .spaceId("1565676577122621")
        .needNotification(false)
        .member(Member.newBuilder()
            .memberType("")
            .memberId("")
            .memberRole("")
            .build())
        .build();

    // 发起请求
    CreateSpaceMemberResp resp = client.wiki().spaceMember().create(req);

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
