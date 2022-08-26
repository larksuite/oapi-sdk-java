package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.CreateFolderFileReq;
import com.lark.oapi.service.drive.v1.model.CreateFolderFileReqBody;
import com.lark.oapi.service.drive.v1.model.CreateFolderFileResp;

// POST /open-apis/drive/v1/files/create_folder
public class CreateFolderFileSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateFolderFileReq req = CreateFolderFileReq.newBuilder()
        .createFolderFileReqBody(CreateFolderFileReqBody.newBuilder()
            .name("New Folder")
            .folderToken("fldbcO1UuPz8VwnpPx5a92abcef")
            .build())
        .build();

    // 发起请求
    CreateFolderFileResp resp = client.drive().file().createFolder(req);

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
