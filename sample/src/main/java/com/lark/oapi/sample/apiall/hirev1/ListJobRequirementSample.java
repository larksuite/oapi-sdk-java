package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;
import java.util.HashMap;

// GET /open-apis/hire/v1/job_requirements
public class ListJobRequirementSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListJobRequirementReq req = ListJobRequirementReq.newBuilder()
			 .pageToken("1231231987")
			 .pageSize(1)
			 .jobId("6001")
			 .createTimeBegin("1658980233000")
			 .createTimeEnd("1658980233000")
			 .updateTimeBegin("1658980233000")
			 .updateTimeEnd("1658980233000")
			 .userIdType("open_id")
			 .departmentIdType("open_department_id")
			 .build();

	  // 发起请求
	  ListJobRequirementResp resp = client.hire().jobRequirement().list(req);

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
