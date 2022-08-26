package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.UploadFileReq;
import com.lark.oapi.service.attendance.v1.model.UploadFileReqBody;
import com.lark.oapi.service.attendance.v1.model.UploadFileResp;
import java.io.File;

// POST /open-apis/attendance/v1/files/upload
public class UploadFileSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    File file = new File("filepath");
    UploadFileReq req = UploadFileReq.newBuilder()
        .fileName("人脸照片.jpg")
        .uploadFileReqBody(UploadFileReqBody.newBuilder()
            .file(file)
            .build())
        .build();

    // 发起请求
    UploadFileResp resp = client.attendance().file().upload(req);

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
