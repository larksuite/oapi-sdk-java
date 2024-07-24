package com.lark.oapi.sample.apiall.taskv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v1.model.*;
import java.util.HashMap;

// POST /open-apis/task/v1/tasks/:task_id/batch_delete_collaborator
public class BatchDeleteCollaboratorTaskSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  BatchDeleteCollaboratorTaskReq req = BatchDeleteCollaboratorTaskReq.newBuilder()
			 .taskId("83912691-2e43-47fc-94a4-d512e03984fa")
			 .userIdType("user_id")
			.collaborator(Collaborator.newBuilder()
				 .idList(new String[]{})
				  .build())
			 .build();

	  // 发起请求
	  BatchDeleteCollaboratorTaskResp resp = client.task().v1().task().batchDeleteCollaborator(req);

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
