package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;
import java.util.HashMap;

// POST /open-apis/hire/v1/jobs/:job_id/update_config
public class UpdateConfigJobSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  UpdateConfigJobReq req = UpdateConfigJobReq.newBuilder()
			 .jobId("6960663240925956660")
			 .userIdType("user_id")
			.jobConfig(JobConfig.newBuilder()
				 .offerApplySchemaId("6960663240925956573")
				 .offerProcessConf("6960663240925956572")
				 .recommendedEvaluatorIdList(new String[]{})
				 .updateOptionList(new Integer[]{})
				 .assessmentTemplateBizId("6960663240925956571")
				 .interviewRoundConfList(new JobConfigInterviewRoundConf[]{})
				 .jrIdList(new String[]{})
				 .interviewRegistrationSchemaId("6930815272790114324")
				 .onboardRegistrationSchemaId("6930815272790114324")
				 .interviewRoundTypeConfList(new JobConfigRoundType[]{})
				 .relatedJobIdList(new String[]{})
				 .interviewAppointmentConfig(InterviewAppointmentConfig.newBuilder().build())
				  .build())
			 .build();

	  // 发起请求
	  UpdateConfigJobResp resp = client.hire().v1().job().updateConfig(req);

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
