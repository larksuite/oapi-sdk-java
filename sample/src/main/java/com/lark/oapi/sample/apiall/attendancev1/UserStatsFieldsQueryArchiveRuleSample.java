package com.lark.oapi.sample.apiall.attendancev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.attendance.v1.model.*;
import java.util.HashMap;

// POST /open-apis/attendance/v1/archive_rule/user_stats_fields_query
public class UserStatsFieldsQueryArchiveRuleSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  UserStatsFieldsQueryArchiveRuleReq req = UserStatsFieldsQueryArchiveRuleReq.newBuilder()
			 .employeeType("employee_id")
			.userStatsFieldsQueryArchiveRuleReqBody(UserStatsFieldsQueryArchiveRuleReqBody.newBuilder()
				 .locale("zh")
				 .month("202409")
				 .archiveRuleId("1")
				 .operatorId("ax8ud")
				  .build())
			 .build();

	  // 发起请求
	  UserStatsFieldsQueryArchiveRuleResp resp = client.attendance().v1().archiveRule().userStatsFieldsQuery(req);

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
