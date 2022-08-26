package com.lark.oapi.sample.apiall.taskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v1.model.Comment;
import com.lark.oapi.service.task.v1.model.CreateTaskCommentReq;
import com.lark.oapi.service.task.v1.model.CreateTaskCommentResp;

// POST /open-apis/task/v1/tasks/:task_id/comments
public class CreateTaskCommentSample {

  public static void main(String arg[]) throws Exception {
    // 构建client
    Client client = Client.newBuilder("appId", "appSecret").build();

    // 创建请求对象
    CreateTaskCommentReq req = CreateTaskCommentReq.newBuilder()
        .taskId("83912691-2e43-47fc-94a4-d512e03984fa")
        .comment(Comment.newBuilder()
            .content("举杯邀明月，对影成三人")
            .parentId("6937231762296684564")
            .id("6937231762296684564")
            .createMilliTime("1657075055135")
            .richContent("举杯邀明月，对影成三人<at id=7058204817822318612></at>")
            .build())
        .build();

    // 发起请求
    CreateTaskCommentResp resp = client.task().taskComment().create(req);

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
