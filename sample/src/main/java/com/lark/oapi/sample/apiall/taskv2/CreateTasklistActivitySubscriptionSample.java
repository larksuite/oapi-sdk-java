package com.lark.oapi.sample.apiall.taskv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.task.v2.model.*;
import java.util.HashMap;

// POST /open-apis/task/v2/tasklists/:tasklist_guid/activity_subscriptions
public class CreateTasklistActivitySubscriptionSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateTasklistActivitySubscriptionReq req = CreateTasklistActivitySubscriptionReq.newBuilder()
			 .tasklistGuid("d19e3a2a-edc0-4e4e-b7cc-950e162b53ae")
			 .userIdType("open_id")
			.tasklistActivitySubscription(TasklistActivitySubscription.newBuilder()
				 .name("我的订阅")
				 .subscribers(new Member[]{})
				 .includeKeys(new Integer[]{})
				 .disabled(false)
				  .build())
			 .build();

	  // 发起请求
	  CreateTasklistActivitySubscriptionResp resp = client.task().v2().tasklistActivitySubscription().create(req);

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
