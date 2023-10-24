package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;
import java.util.HashMap;

// GET /open-apis/corehr/v1/job_datas
public class ListJobDataSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  ListJobDataReq req = ListJobDataReq.newBuilder()
			 .pageToken("6994718879515739656")
			 .pageSize("100")
			 .employmentId("7072306364927985196")
			 .jobDataIdList(new String[]{})
			 .departmentId("6887868781834536462")
			 .jobId("6893014062142064135")
			 .getAllVersion(false)
			 .userIdType("people_corehr_id")
			 .departmentIdType("people_corehr_department_id")
			 .build();

	  // 发起请求
	  ListJobDataResp resp = client.corehr().jobData().list(req);

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
