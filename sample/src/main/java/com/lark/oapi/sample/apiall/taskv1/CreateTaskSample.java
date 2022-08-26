package com.lark.oapi.sample.apiall.taskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v1.model.CreateTaskReq;
import com.lark.oapi.service.task.v1.model.CreateTaskResp;
import com.lark.oapi.service.task.v1.model.Due;
import com.lark.oapi.service.task.v1.model.Origin;
import com.lark.oapi.service.task.v1.model.Task;

// POST /open-apis/task/v1/tasks
public class CreateTaskSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateTaskReq req = CreateTaskReq.newBuilder()
        .userIdType("user_id")
        .task(Task.newBuilder()
            .summary("每天喝八杯水，保持身心愉悦")
            .description("多吃水果，多运动，健康生活，快乐工作。")
            .extra("dGVzdA==")
            .due(Due.newBuilder().build())
            .origin(Origin.newBuilder().build())
            .canEdit(false)
            .custom("")
            .collaboratorIds(new String[]{})
            .followerIds(new String[]{})
            .repeatRule("FREQ=WEEKLY;INTERVAL=1;BYDAY=MO,TU,WE,TH,FR")
            .richSummary("每天喝八杯水，保持身心愉悦[飞书开放平台](https://open.feishu.cn/)")
            .richDescription("多吃水果，多运动，健康生活，快乐工作。[飞书开放平台](https://open.feishu.cn/)")
            .build())
        .build();

    // 发起请求
    CreateTaskResp resp = client.task().task().create(req);

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
