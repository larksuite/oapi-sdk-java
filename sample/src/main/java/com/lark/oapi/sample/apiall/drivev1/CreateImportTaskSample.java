package com.lark.oapi.sample.apiall.drivev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.drive.v1.model.CreateImportTaskReq;
import com.lark.oapi.service.drive.v1.model.CreateImportTaskResp;
import com.lark.oapi.service.drive.v1.model.ImportTask;
import com.lark.oapi.service.drive.v1.model.ImportTaskMountPoint;

// POST /open-apis/drive/v1/import_tasks
public class CreateImportTaskSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateImportTaskReq req = CreateImportTaskReq.newBuilder()
        .importTask(ImportTask.newBuilder()
            .fileExtension("")
            .fileToken("")
            .type("")
            .fileName("")
            .point(ImportTaskMountPoint.newBuilder().build())
            .build())
        .build();

    // 发起请求
    CreateImportTaskResp resp = client.drive().importTask().create(req);

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
