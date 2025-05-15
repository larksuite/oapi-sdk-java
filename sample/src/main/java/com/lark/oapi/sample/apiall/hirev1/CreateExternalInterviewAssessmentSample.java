package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;
import java.util.HashMap;

// POST /open-apis/hire/v1/external_interview_assessments
public class CreateExternalInterviewAssessmentSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CreateExternalInterviewAssessmentReq req = CreateExternalInterviewAssessmentReq.newBuilder()
			.externalInterviewAssessment(ExternalInterviewAssessment.newBuilder()
				 .externalId("123")
				 .username("shaojiale")
				 .conclusion(1)
				 .assessmentDimensionList(new ExternalInterviewAssessmentDimension[]{})
				 .content("hello world")
				 .externalInterviewId("6986199832494934316")
				  .build())
			 .build();

	  // 发起请求
	  CreateExternalInterviewAssessmentResp resp = client.hire().v1().externalInterviewAssessment().create(req);

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
