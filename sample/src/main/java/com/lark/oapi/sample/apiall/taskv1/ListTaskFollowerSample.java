package com.lark.oapi.sample.apiall.taskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v1.model.ListTaskFollowerReq;
import com.lark.oapi.service.task.v1.model.ListTaskFollowerResp;

// GET /open-apis/task/v1/tasks/:task_id/followers
public class ListTaskFollowerSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    ListTaskFollowerReq req = ListTaskFollowerReq.newBuilder()
        .taskId("0d38e26e-190a-49e9-93a2-35067763ed1f")
        .pageSize(10)
        .pageToken("「上次返回的page_token」")
        .userIdType("user_id")
        .build();

    // 发起请求
    ListTaskFollowerResp resp = client.task().taskFollower().list(req);

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
