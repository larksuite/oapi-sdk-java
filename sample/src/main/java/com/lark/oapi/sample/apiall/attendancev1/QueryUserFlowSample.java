package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.*;
import java.util.HashMap;

// POST /open-apis/attendance/v1/user_flows/query
public class QueryUserFlowSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  QueryUserFlowReq req = QueryUserFlowReq.newBuilder()
			 .employeeType("employee_id")
			 .includeTerminatedUser(true)
			.queryUserFlowReqBody(QueryUserFlowReqBody.newBuilder()
				 .userIds(new String[]{})
				 .checkTimeFrom("1566641088")
				 .checkTimeTo("1566641088")
				  .build())
			 .build();

	  // 发起请求
	  QueryUserFlowResp resp = client.attendance().v1().userFlow().query(req);

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
