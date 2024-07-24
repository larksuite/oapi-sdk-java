package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.*;
import java.util.HashMap;

// GET /open-apis/task/v2/tasklists/:tasklist_guid/tasks
public class TasksTasklistSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  TasksTasklistReq req = TasksTasklistReq.newBuilder()
			 .tasklistGuid("d300a75f-c56a-4be9-80d1-e47653028ceb")
			 .pageSize(50)
			 .pageToken("aWQ9NzEwMjMzMjMxMDE=")
			 .completed(true)
			 .createdFrom("1675742789470")
			 .createdTo("1675742789470")
			 .userIdType("open_id")
			 .build();

	  // 发起请求
	  TasksTasklistResp resp = client.task().v2().tasklist().tasks(req);

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
