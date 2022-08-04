package com.lark.oapi.sample.apiall.contactv3;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.contact.v3.model.MemberBelongGroupReq;
import com.lark.oapi.service.contact.v3.model.MemberBelongGroupResp;

// HTTP PATH: /open-apis/contact/v3/group/member_belong"
public class MemberBelongGroupSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    MemberBelongGroupReq req = MemberBelongGroupReq.newBuilder()
        .memberId("")
        .memberIdType("open_id")
        .groupType(1)
        .pageSize(500)
        .pageToken("")
        .build();

    // 发起请求
    MemberBelongGroupResp resp = client.contact().group().memberBelong(req);

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
