package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;
import java.util.HashMap;

// GET /open-apis/hire/v1/applications/:application_id/interviews
public class ListApplicationInterviewSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListApplicationInterviewReq req = ListApplicationInterviewReq.newBuilder()
			 .applicationId("6960663240925956555")
			 .pageSize(10)
			 .pageToken("xx")
			 .userIdType("open_id")
			 .jobLevelIdType("people_admin_job_level_id")
			 .build();

	  // 发起请求
	  ListApplicationInterviewResp resp = client.hire().v1().applicationInterview().list(req);

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
