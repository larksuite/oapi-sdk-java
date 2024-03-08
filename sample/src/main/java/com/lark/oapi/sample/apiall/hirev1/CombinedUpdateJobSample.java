package com.lark.oapi.sample.apiall.hirev1;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.hire.v1.model.*;
import java.util.HashMap;

// POST /open-apis/hire/v1/jobs/:job_id/combined_update
public class CombinedUpdateJobSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  CombinedUpdateJobReq req = CombinedUpdateJobReq.newBuilder()
			 .jobId("6960663240925956660")
			 .userIdType("open_id")
			 .departmentIdType("open_department_id")
			 .jobLevelIdType("people_admin_job_level_id")
			 .jobFamilyIdType("people_admin_job_category_id")
			.combinedJob(CombinedJob.newBuilder()
				 .id("6960663240925956576")
				 .experience(1)
				 .expiryTime(0)
				 .customizedDataList(new CombinedJobObjectValueMap[]{})
				 .minLevelId("6960663240925956547")
				 .minSalary(1000)
				 .title("后端研发")
				 .jobManagers(JobManager.newBuilder().build())
				 .jobProcessId("6960663240925956554")
				 .subjectId("6960663240925956555")
				 .jobFunctionId("6960663240925956555")
				 .departmentId("6960663240925956549")
				 .headCount(100)
				 .isNeverExpired(false)
				 .maxSalary(2000)
				 .requirement("熟悉后端研发")
				 .description("后端研发岗位描述")
				 .highlightList(new String[]{})
				 .jobTypeId("6960663240925956551")
				 .maxLevelId("6960663240925956548")
				 .requiredDegree(20)
				 .jobCategoryId("6960663240925956550")
				 .addressIdList(new String[]{})
				 .jobAttribute(1)
				 .expiryTimestamp("1622484739955")
				 .targetMajorIdList(new String[]{})
				  .build())
			 .build();

	  // 发起请求
	  CombinedUpdateJobResp resp = client.hire().v1().job().combinedUpdate(req);

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
