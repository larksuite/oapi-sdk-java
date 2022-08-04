package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.CreateInstanceCommentReq;
import com.lark.oapi.service.approval.v4.model.CreateInstanceCommentResp;

// HTTP PATH: /open-apis/approval/v4/instances/:instance_id/comments"
public class CreateInstanceCommentSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateInstanceCommentReq req = CreateInstanceCommentReq.newBuilder()
        .instanceId("")
        .userIdType("open_id")
        .userId("")
        .build();

    // 发起请求
    CreateInstanceCommentResp resp = client.approval().instanceComment().create(req);

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
