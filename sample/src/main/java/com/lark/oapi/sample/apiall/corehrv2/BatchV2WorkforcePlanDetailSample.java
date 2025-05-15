package com.lark.oapi.sample.apiall.corehrv2;

import com.lark.oapi.Client;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.service.corehr.v2.model.*;
import java.util.HashMap;
import com.lark.oapi.service.corehr.v2.model.Enum;

// POST /open-apis/corehr/v2/workforce_plan_details/batch_v2
public class BatchV2WorkforcePlanDetailSample{

  public static void main(String arg[]) throws Exception {
	  // 构建client
	  Client client = Client.newBuilder("appId", "appSecret").build();

	  // 创建请求对象
	  BatchV2WorkforcePlanDetailReq req = BatchV2WorkforcePlanDetailReq.newBuilder()
			 .pageToken("")
			 .pageSize(100)
			.batchV2WorkforcePlanDetailReqBody(BatchV2WorkforcePlanDetailReqBody.newBuilder()
				 .workforcePlanId("781234834512")
				 .isCentralizedReportingProject(false)
				 .centralizedReportingProjectId("7140964208476371111")
				 .dimensionIdInDatas(new DimensionIdInData[]{})
				  .build())
			 .build();

	  // 发起请求
	  BatchV2WorkforcePlanDetailResp resp = client.corehr().v2().workforcePlanDetail().batchV2(req);

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
