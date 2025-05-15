package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;
import java.util.HashMap;
import com.lark.oapi.service.corehr.v2.model.Enum;

// PATCH /open-apis/corehr/v2/probation/assessments/:assessment_id
public class PatchProbationAssessmentSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  PatchProbationAssessmentReq req = PatchProbationAssessmentReq.newBuilder()
			 .assessmentId("7140964208476371331")
			 .clientToken("6822122262122064111")
			.assessmentForCreate(AssessmentForCreate.newBuilder()
				 .assessmentStatus("completed")
				 .assessmentResult("approved")
				 .assessmentScore(99.9)
				 .assessmentGrade("grade_a")
				 .assessmentComment("超出预期")
				 .assessmentDetail("暂无示例")
				 .isFinalAsssessment(false)
				  .build())
			 .build();

	  // 发起请求
	  PatchProbationAssessmentResp resp = client.corehr().v2().probationAssessment().patch(req);

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
