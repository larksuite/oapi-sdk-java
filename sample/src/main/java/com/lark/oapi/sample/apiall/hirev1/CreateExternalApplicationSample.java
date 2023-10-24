package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;
import java.util.HashMap;

// POST /open-apis/hire/v1/external_applications
public class CreateExternalApplicationSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateExternalApplicationReq req = CreateExternalApplicationReq.newBuilder()
			.externalApplication(ExternalApplication.newBuilder()
				 .externalId("123")
				 .jobRecruitmentType(1)
				 .jobTitle("高级Java")
				 .resumeSource("lagou")
				 .stage("1")
				 .talentId("6960663240925956459")
				 .terminationReason("不合适")
				 .deliveryType(1)
				 .terminationType("health")
				  .build())
			 .build();

	  // 发起请求
	  CreateExternalApplicationResp resp = client.hire().externalApplication().create(req);

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
