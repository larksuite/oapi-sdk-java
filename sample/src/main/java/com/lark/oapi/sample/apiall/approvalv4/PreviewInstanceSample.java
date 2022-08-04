package com.lark.oapi.sample.apiall.approvalv4;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.approval.v4.model.PreviewInstanceReq;
import com.lark.oapi.service.approval.v4.model.PreviewInstanceReqBody;
import com.lark.oapi.service.approval.v4.model.PreviewInstanceResp;

// HTTP PATH: /open-apis/approval/v4/instances/preview"
public class PreviewInstanceSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    PreviewInstanceReq req = PreviewInstanceReq.newBuilder()
        .userIdType("open_id")
        .previewInstanceReqBody(PreviewInstanceReqBody.newBuilder()
            .userId("")
            .approvalCode("")
            .departmentId("")
            .form("")
            .instanceCode("")
            .locale("zh-CN: 中文 en-US: 英文")
            .taskId("")
            .build())
        .build();

    // 发起请求
    PreviewInstanceResp resp = client.approval().instance().preview(req);

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
