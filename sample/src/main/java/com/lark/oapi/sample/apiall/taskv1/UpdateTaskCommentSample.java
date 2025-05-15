package com.lark.oapi.sample.apiall.taskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v1.model.*;
import java.util.HashMap;

// PUT /open-apis/task/v1/tasks/:task_id/comments/:comment_id
public class UpdateTaskCommentSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  UpdateTaskCommentReq req = UpdateTaskCommentReq.newBuilder()
			 .taskId("83912691-2e43-47fc-94a4-d512e03984fa")
			 .commentId("6937231762296684564")
			 .userIdType("user_id")
			.updateTaskCommentReqBody(UpdateTaskCommentReqBody.newBuilder()
				 .content("飞流直下三千尺，疑是银河落九天")
				 .richContent("飞流直下三千尺，疑是银河落九天<at id=7058204817822318612></at>")
				  .build())
			 .build();

	  // 发起请求
	  UpdateTaskCommentResp resp = client.task().v1().taskComment().update(req);

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
