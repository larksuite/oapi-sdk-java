package com.lark.oapi.sample.apiall.apaasv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.apaas.v1.model.*;
import java.util.HashMap;

// POST /open-apis/apaas/v1/user_task/query
public class QueryUserTaskSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  QueryUserTaskReq req = QueryUserTaskReq.newBuilder()
			.queryUserTaskReqBody(QueryUserTaskReqBody.newBuilder()
				 .type("pending")
				 .source("assignMe")
				 .limit("10")
				 .offset("0")
				 .startTime("1730208758000")
				 .endTime("1730208758000")
				 .apiIds(new String[]{})
				 .kunlunUserId("1234")
				  .build())
			 .build();

	  // 发起请求
	  QueryUserTaskResp resp = client.apaas().v1().userTask().query(req);

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
