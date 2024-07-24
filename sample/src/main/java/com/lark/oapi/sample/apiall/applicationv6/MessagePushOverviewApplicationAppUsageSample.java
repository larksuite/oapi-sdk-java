package com.lark.oapi.sample.apiall.applicationv6;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.model.*;
import java.util.HashMap;

// POST /open-apis/application/v6/applications/:app_id/app_usage/message_push_overview
public class MessagePushOverviewApplicationAppUsageSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  MessagePushOverviewApplicationAppUsageReq req = MessagePushOverviewApplicationAppUsageReq.newBuilder()
			 .appId("cli_9f115af860f7901b")
			 .departmentIdType("open_department_id")
			.messagePushOverviewApplicationAppUsageReqBody(MessagePushOverviewApplicationAppUsageReqBody.newBuilder()
				 .date("2021-07-08")
				 .cycleType(1)
				 .departmentId("od-4e6ac4d14bcd5071a37a39de902c7141")
				  .build())
			 .build();

	  // 发起请求
	  MessagePushOverviewApplicationAppUsageResp resp = client.application().v6().applicationAppUsage().messagePushOverview(req);

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
