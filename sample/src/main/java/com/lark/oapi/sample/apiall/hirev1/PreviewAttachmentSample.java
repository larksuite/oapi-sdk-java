package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.PreviewAttachmentReq;
import com.lark.oapi.service.hire.v1.model.PreviewAttachmentResp;

// GET /open-apis/hire/v1/attachments/:attachment_id/preview
public class PreviewAttachmentSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    PreviewAttachmentReq req = PreviewAttachmentReq.newBuilder()
        .attachmentId("11111")
        .build();

    // 发起请求
    PreviewAttachmentResp resp = client.hire().attachment().preview(req);

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
