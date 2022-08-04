package com.lark.oapi.sample.apiall.docxv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.docx.v1.model.CreateDocumentReq;
import com.lark.oapi.service.docx.v1.model.CreateDocumentReqBody;
import com.lark.oapi.service.docx.v1.model.CreateDocumentResp;

// HTTP PATH: /open-apis/docx/v1/documents"
public class CreateDocumentSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateDocumentReq req = CreateDocumentReq.newBuilder()
        .createDocumentReqBody(CreateDocumentReqBody.newBuilder()
            .folderToken("fldcnqquW1svRIYVT2Np6IuLCKd")
            .title("undefined")
            .build())
        .build();

    // 发起请求
    CreateDocumentResp resp = client.docx().document().create(req);

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
