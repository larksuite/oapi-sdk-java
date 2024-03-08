package com.lark.oapi.sample.apiall.corehrv1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v1.model.*;
import java.util.HashMap;
import com.lark.oapi.service.corehr.v1.model.Enum;

// PATCH /open-apis/corehr/v1/job_levels/:job_level_id
public class PatchJobLevelSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  PatchJobLevelReq req = PatchJobLevelReq.newBuilder()
			 .jobLevelId("1616161616")
			 .clientToken("12454646")
			.jobLevel(JobLevel.newBuilder()
				 .levelOrder(9999)
				 .code("VQzo/BSonp8l6PmcZ+VlDhkd2595LMkhyBAGX6HAlCY=")
				 .name(new I18n[]{})
				 .description(new I18n[]{})
				 .active(true)
				 .customFields(new ObjectFieldData[]{})
				  .build())
			 .build();

	  // 发起请求
	  PatchJobLevelResp resp = client.corehr().v1().jobLevel().patch(req);

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
