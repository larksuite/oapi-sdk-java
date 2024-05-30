package com.lark.oapi.sample.apiall.applicationv6;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.application.v6.model.*;
import java.util.HashMap;

// POST /open-apis/application/v6/applications/:app_id/app_usage/overview
public class OverviewApplicationAppUsageSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  OverviewApplicationAppUsageReq req = OverviewApplicationAppUsageReq.newBuilder()
			 .appId("cli_9f115af860f7901b")
			 .departmentIdType("open_department_id")
			.overviewApplicationAppUsageReqBody(OverviewApplicationAppUsageReqBody.newBuilder()
				 .date("2021-07-08")
				 .cycleType(1)
				 .departmentId("od-4e6ac4d14bcd5071a37a39de902c7141")
				 .ability("app")
				  .build())
			 .build();

	  // 发起请求
	  OverviewApplicationAppUsageResp resp = client.application().v6().applicationAppUsage().overview(req);

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
