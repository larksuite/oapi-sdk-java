package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.UploadAllMediaReq;
import com.lark.oapi.service.drive.v1.model.UploadAllMediaReqBody;
import com.lark.oapi.service.drive.v1.model.UploadAllMediaResp;
import java.io.File;

// HTTP PATH: /open-apis/drive/v1/medias/upload_all"
public class UploadAllMediaSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    File file = new File("filepath");
    UploadAllMediaReq req = UploadAllMediaReq.newBuilder()
        .uploadAllMediaReqBody(UploadAllMediaReqBody.newBuilder()
            .fileName("")
            .parentType("doc_image")
            .parentNode("")
            .size(0)
            .checksum("")
            .extra("")
            .file(file)
            .build())
        .build();

    // 发起请求
    UploadAllMediaResp resp = client.drive().media().uploadAll(req);

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
