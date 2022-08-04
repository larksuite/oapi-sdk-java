package com.lark.oapi.sample.apiall.taskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v1.model.UncompleteTaskReq;
import com.lark.oapi.service.task.v1.model.UncompleteTaskResp;

// HTTP PATH: /open-apis/task/v1/tasks/:task_id/uncomplete"
public class UncompleteTaskSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    UncompleteTaskReq req = UncompleteTaskReq.newBuilder()
        .taskId("bb54ab99-d360-434f-bcaa-a4cc4c05840e")
        .build();

    // 发起请求
    UncompleteTaskResp resp = client.task().task().uncomplete(req);

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
